package strategy;

public class Courier implements DeliveryStrategy{
    private String name;

    public Courier(String name) {
        this.name = name;
    }

    @Override
    public String deliver(Parcel parcel) {
        return "Your parcel " + parcel.getId() + " is delievered to: " + parcel.getAddress() + " by courier " + name;
    }
}
