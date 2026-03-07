package adapter;

public class PaymentAPI {
    public void payByCard(double value) {
        System.out.println("Paid by card: " + value);
    }

    public void payBySbp(double value) {
        System.out.println("Paid by SBP: " + value);
    }
}
