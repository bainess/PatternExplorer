package decorator;

public class MilkDecorator extends DrinkDecorator {

    public MilkDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", milk";
    }

    @Override
    public int getPrice() {
        return drink.getPrice() + 50;
    }
}
