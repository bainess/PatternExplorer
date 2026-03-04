package decorator;

public class RomDecorator extends DrinkDecorator{

    public RomDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", rom";
    }

    @Override
    public int getPrice() {
        return drink.getPrice() + 75;
    }
}
