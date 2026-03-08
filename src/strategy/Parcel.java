package strategy;

public class Parcel {
    private Long id;
    private String address;

    public Parcel(Long id, String address) {
        this.id = id;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }
}
