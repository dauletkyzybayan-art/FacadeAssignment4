public class OrderFacade {
    private static final int UNIT_PRICE = 2000;

    private final InventoryService inventory;
    private final PaymentProcessor payment;
    private final ShippingService shipping;
    private final NotificationService notifications;

    public OrderFacade(int initialStock, int initialBalance,
                       boolean deliveryAvailable) {
        inventory = new InventoryService(initialStock);
        payment = new PaymentProcessor(initialBalance);
        shipping = new ShippingService(deliveryAvailable);
        notifications = new NotificationService();
    }

    public String placeOrder(int quantity, String customerName, String address) {
        int totalPrice;

        try {
            notifications.validateCustomerName(customerName);
            shipping.validateAddress(address);

            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }

            totalPrice = Math.multiplyExact(quantity, UNIT_PRICE);
        } catch (IllegalArgumentException | ArithmeticException exception) {
            return "Order rejected: invalid name, address, or quantity.";
        }

        if (!inventory.reserveStock(quantity)) {
            return "Order rejected: not enough stock.";
        }

        if (!payment.pay(totalPrice)) {
            inventory.releaseStock(quantity);
            return "Payment declined. Reserved stock was released.";
        }

        String deliveryId;

        try {
            deliveryId = shipping.arrangeDelivery(address);
        } catch (IllegalStateException exception) {
            payment.refund(totalPrice);
            inventory.releaseStock(quantity);
            return "Delivery failed. Money and stock were returned.";
        }

        inventory.completeSale(quantity);
        return notifications.sendConfirmation(customerName, deliveryId);
    }

    public int getAvailableStock() {
        return inventory.getAvailableStock();
    }

    public int getBalance() {
        return payment.getBalance();
    }
}