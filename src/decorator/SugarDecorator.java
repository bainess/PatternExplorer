package decorator;

public class SugarDecorator extends DrinkDecorator{

    public SugarDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", sugar";
    }

    @Override
    public int getPrice() {
        return drink.getPrice() + 25;
    }
}
