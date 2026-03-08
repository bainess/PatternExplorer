import adapter.PaymentAPI;
import adapter.PaymentAdapter;
import adapter.PaymentProcessor;
import builder.User;
import chainOfResponsibility.*;
import decorator.*;
import proxy.*;
import strategy.*;

public class Main {
    public static void main(String[] args) {
        //builder
        System.out.println("BUILDER");
        User user = new User.Builder("mylogin")
                .name("Aless")
                .surname("Smith")
                .age(30)
                .email("streetroad36@mail.com")
                .password("1337666")
                .role(Role.AUDIENCE)
                .location("Moscow")
                .build();

        System.out.println(user);
        System.out.println();

        // decorator
        System.out.println("DECORATOR");
        Drink coffee = new RomDecorator(new Coffee());
        Drink tea = new MilkDecorator(new SugarDecorator(new Tea()));

        System.out.println(coffee.getDescription() + " " + coffee.getPrice());
        System.out.println(tea.getDescription() + " " + tea.getPrice());
        System.out.println();

        //proxy
        System.out.println("PROXY");
        Film film = new Film(1, "New film 1");
        FilmServiceInt service = new FilmServiceProxy(user);
        service.saveFilm(film);

        service.getFilm(1L);
        user.setRole(Role.ADMIN);
        System.out.println("user " + user.getLogin() + " get film: " + service.getFilm(1L).getTitle());
        System.out.println();

        //strategy
        System.out.println("STRATEGY");
        Parcel parcel = new Parcel(123L, "New City, Old street, 76");
        DeliveryStrategy deliveryCourier = new Courier("John Doe");
        DeliveryStrategy delieveryPost = new Post(486923);
        DeliveryStrategy deliveryPickUp = new PickUp("hks862wcD");
        System.out.println(deliveryPickUp.deliver(parcel));
        System.out.println(deliveryCourier.deliver(parcel));
        System.out.println(delieveryPost.deliver(parcel));
        System.out.println();

        //chain of responsibility
        System.out.println("CHAIN OF RESPONSIBILITY");
        Account account = new Account.Builder().id(1L).user(user).amount(400.00).build();
        CheckPayment locationCheck = new LocationCheck(account);
        LimitCheck limitCheck = new LimitCheck(500.00);
        CheckPayment balanceCheck = new BalanceCheck(account);
        locationCheck.setNext(limitCheck);
        limitCheck.setNext(balanceCheck);
        limitCheck.setNext(balanceCheck);

        Payment pay = new Payment(200.00, "Oslo", "Card");
        Payment pay2 = new Payment(450.00, "Moscow", "SBP");
        Payment pay3 = new Payment(600.00, "Moscow", "SBP");
        Payment pay4 = new Payment(200.00, "Moscow", "SBP");

        locationCheck.check(pay);
        locationCheck.check(pay2);
        locationCheck.check(pay3);
        locationCheck.check(pay4);
        System.out.println();

        // adapter
        System.out.println("ADAPTER");
        PaymentAPI oldPayment = new PaymentAPI();
        PaymentProcessor payment = new PaymentAdapter(oldPayment, locationCheck);
        payment.pay(pay4);
        payment.pay(pay);
        payment.pay(pay3);
        payment.pay(pay2);
        System.out.println();

    }
}
