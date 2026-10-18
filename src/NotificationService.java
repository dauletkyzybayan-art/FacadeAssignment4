import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<String> notifications = new ArrayList<>();

    public void validateCustomerName(String customerName) {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name is required");
        }
    }

    public String sendConfirmation(String customerName, String deliveryId) {
        validateCustomerName(customerName);

        if (deliveryId == null || deliveryId.isBlank()) {
            throw new IllegalArgumentException("Delivery ID is required");
        }

        String message = customerName + ", your order is confirmed. "
                + "Delivery ID: " + deliveryId;

        notifications.add(message);
        return message;
    }

    public int getNotificationCount() {
        return notifications.size();
    }
}