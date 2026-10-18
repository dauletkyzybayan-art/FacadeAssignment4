public class PaymentProcessor {
    private int balance;
    private int paidAmount;

    public PaymentProcessor(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        balance = initialBalance;
    }

    public boolean pay(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        paidAmount += amount;
        return true;
    }

    public void refund(int amount) {
        if (amount <= 0 || amount > paidAmount) {
            throw new IllegalArgumentException("Invalid refund amount");
        }

        paidAmount -= amount;
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}