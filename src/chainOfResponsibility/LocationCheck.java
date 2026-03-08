package chainOfResponsibility;

import builder.User;

public class LocationCheck extends CheckPayment {
    private Account account;

    public LocationCheck(Account account) {
        this.account = account;
    }

    public boolean check(Payment payment) {
        if (! account.getUser().getLocation().equals(payment.getLocation())) {
            System.out.println("Payment declined: Payment location does not match user's location");
            return false;
        }

        if (next != null) {
            next.check(payment);
        }

        return true;
    }
}
