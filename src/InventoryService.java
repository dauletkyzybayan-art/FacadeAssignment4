public class InventoryService {
    private int availableStock;
    private int reservedStock;

    public InventoryService(int initialStock) {
        if (initialStock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        availableStock = initialStock;
    }

    public boolean reserveStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > availableStock) {
            return false;
        }

        availableStock -= quantity;
        reservedStock += quantity;
        return true;
    }

    public void releaseStock(int quantity) {
        if (quantity <= 0 || quantity > reservedStock) {
            throw new IllegalArgumentException("Invalid release quantity");
        }

        reservedStock -= quantity;
        availableStock += quantity;
    }

    public void completeSale(int quantity) {
        if (quantity <= 0 || quantity > reservedStock) {
            throw new IllegalArgumentException("Invalid sale quantity");
        }

        reservedStock -= quantity;
    }

    public int getAvailableStock() {
        return availableStock;
    }
}
