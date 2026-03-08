package chainOfResponsibility;

public class BalanceCheck extends CheckPayment {
    private Account account;
    public BalanceCheck(Account account) {
        this.account = account;
    }

    public boolean check(Payment payment) {
        if (account.getAmount() < payment.getAmount()) {
            System.out.println("Payment declined: insufficient funds");
            return false;
        }

        if (next != null) {
            next.check(payment);
        }

        return true;
    }
}
