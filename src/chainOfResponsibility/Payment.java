package chainOfResponsibility;

public class Payment {
    private Double amount;
    private String location;
    private String typeOfPayment;

    public Payment(Double amount, String location, String typeOfPayment) {
        this.amount = amount;
        this.location = location;
        this.typeOfPayment = typeOfPayment;
    }

    public Double getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }
}
