package chainOfResponsibility;

public class LimitCheck extends CheckPayment {
    private Double limit;

    public LimitCheck(Double limit) {
        this.limit = limit;
    }

    public boolean check(Payment payment) {
        if (payment.getAmount() > limit) {
            System.out.println("Payment declined: limit exceeded");
            return false;
        }
        if (next != null) {
            next.check(payment);
        }

        return true;
    }


}
