package adapter;

public interface PaymentProcessor {
    void pay(String typeOfPayment, double amount);
}
