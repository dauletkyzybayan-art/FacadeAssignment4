public class Main {
    public static void main(String[] args) {
        OrderFacade shop = new OrderFacade(10, 20000, false);

        String result = shop.placeOrder(3, "Bayan", "Astana, Abay 10");

        System.out.println(result);
        System.out.println("Available stock: " + shop.getAvailableStock());
        System.out.println("Balance: " + shop.getBalance());
    }
}