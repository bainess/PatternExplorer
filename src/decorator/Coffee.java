package decorator;

public class Coffee implements Drink {

    @Override
    public String getDescription() {
        return "black coffee";
    }

    @Override
    public int getPrice() {
        return 480;
    }
}
