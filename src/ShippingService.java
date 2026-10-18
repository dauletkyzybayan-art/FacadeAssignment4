import java.util.HashMap;
import java.util.Map;

public class ShippingService {
    private final Map<String, String> deliveries = new HashMap<>();
    private final boolean deliveryAvailable;
    private int nextDeliveryNumber = 1;

    public ShippingService(boolean deliveryAvailable) {
        this.deliveryAvailable = deliveryAvailable;
    }

    public void validateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address is required");
        }
    }

    public String arrangeDelivery(String address) {
        validateAddress(address);

        if (!deliveryAvailable) {
            throw new IllegalStateException("Delivery service is unavailable");
        }

        String deliveryId = "DEL-" + nextDeliveryNumber;
        deliveries.put(deliveryId, address);
        nextDeliveryNumber++;

        return deliveryId;
    }

    public String getDeliveryAddress(String deliveryId) {
        return deliveries.get(deliveryId);
    }
}