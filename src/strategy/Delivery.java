package strategy;

public class Delivery implements DeliveryStrategy{

    private DeliveryStrategy deliveryStrategy;

    public Delivery(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    @Override
    public String deliver(Parcel parcel) {
        return deliveryStrategy.deliver(parcel);
    }
}
