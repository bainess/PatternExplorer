package chainOfResponsibility;

public abstract class CheckPayment {
        protected CheckPayment next;

        public void setNext(CheckPayment next) {
                this.next = next;
        }

        public abstract boolean check(Payment payment);
}
