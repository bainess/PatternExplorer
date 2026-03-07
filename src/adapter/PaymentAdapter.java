package adapter;

public class PaymentAdapter implements PaymentProcessor{
    private PaymentAPI paymentAPI;

    public PaymentAdapter(PaymentAPI paymentAPI) {
        this.paymentAPI = paymentAPI;
    }

    @Override
    public void pay(String typeOfPayment, double amount) {
        if (typeOfPayment.toLowerCase().equals("card")) {
            paymentAPI.payByCard(amount);
        } else if (typeOfPayment.toLowerCase().equals("sbp")) {
            paymentAPI.payBySbp(amount);
        } else {
            throw new IllegalArgumentException("Unknown payment system");
        }
    }
}
