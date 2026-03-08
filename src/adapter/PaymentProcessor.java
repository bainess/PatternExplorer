package adapter;

import chainOfResponsibility.Payment;

public interface PaymentProcessor {
    void pay(Payment payment);
}
