import adapter.PaymentAPI;
import adapter.PaymentAdapter;
import adapter.PaymentProcessor;
import builder.User;
import decorator.*;

public class Main {
    public static void main(String[] args) {
        //builder
        User user = new User.Builder("mylogin")
                .name("Aless")
                .surname("Smith")
                .age(30)
                .email("streetroad36@mail.com")
                .password("1337666")
                .build();

        System.out.println(user);

        // decorator
        Drink coffee = new RomDecorator(new Coffee());
        Drink tea = new MilkDecorator(new SugarDecorator(new Tea()));

        System.out.println(coffee.getDescription() + " " + coffee.getPrice());
        System.out.println(tea.getDescription() + " " + tea.getPrice());

        // adapter
        PaymentAPI oldPayment = new PaymentAPI();
        PaymentProcessor payment = new PaymentAdapter(oldPayment);
        payment.pay("SBP", 130.00);
    }
}
