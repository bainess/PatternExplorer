package strategy;

public class PickUp implements DeliveryStrategy{
    private String lockerCode;

    public PickUp(String lockerCode) {
        this.lockerCode = lockerCode;
    }

    @Override
    public String deliver(Parcel parcel) {
        return "Your parcel " + parcel.getId() + " could be taken by code " + lockerCode;
    }
}
