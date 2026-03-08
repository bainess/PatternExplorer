package adapter;

import chainOfResponsibility.CheckPayment;
import chainOfResponsibility.Payment;

public class PaymentAdapter implements PaymentProcessor{
    private final PaymentAPI paymentAPI;
    private final CheckPayment checkPayment;

    public PaymentAdapter(PaymentAPI paymentAPI, CheckPayment checkPayment) {
        this.paymentAPI = paymentAPI;
        this.checkPayment = checkPayment;
    }

    @Override
    public void pay(Payment payment) {
        if (checkPayment.check(payment)) { return;};

        if (payment.getTypeOfPayment().equalsIgnoreCase("card")) {
            paymentAPI.payByCard(payment.getAmount());
        } else if (payment.getTypeOfPayment().equalsIgnoreCase("sbp")) {
            paymentAPI.payBySbp(payment.getAmount());
        } else {
            throw new IllegalArgumentException("Unknown payment system");
        }
    }
}
