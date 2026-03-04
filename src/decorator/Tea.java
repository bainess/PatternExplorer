package decorator;

public class Tea implements Drink{

    @Override
    public String getDescription() {
        return "black tea";
    }

    @Override
    public int getPrice() {
        return 250;
    }
}
