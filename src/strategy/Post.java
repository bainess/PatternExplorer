package strategy;

public class Post implements DeliveryStrategy{
    private Integer index;

    public Post(Integer index) {
        this.index = index;
    }

    @Override
    public String deliver(Parcel parcel) {
        return "Your parcel " + parcel.getId() + " is delivered to post " + index;
    }
}
