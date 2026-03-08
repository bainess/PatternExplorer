import adapter.PaymentAPI;
import adapter.PaymentAdapter;
import adapter.PaymentProcessor;
import builder.User;
import decorator.*;
import proxy.*;
import strategy.*;

public class Main {
    public static void main(String[] args) {
        //builder
        User user = new User.Builder("mylogin")
                .name("Aless")
                .surname("Smith")
                .age(30)
                .email("streetroad36@mail.com")
                .password("1337666")
                .role(Role.AUDIENCE)
                .build();

        System.out.println(user);
        System.out.println();

        // decorator
        Drink coffee = new RomDecorator(new Coffee());
        Drink tea = new MilkDecorator(new SugarDecorator(new Tea()));

        System.out.println(coffee.getDescription() + " " + coffee.getPrice());
        System.out.println(tea.getDescription() + " " + tea.getPrice());
        System.out.println();

        // adapter
        PaymentAPI oldPayment = new PaymentAPI();
        PaymentProcessor payment = new PaymentAdapter(oldPayment);
        payment.pay("SBP", 130.00);
        System.out.println();

        //proxy
        Film film = new Film(1, "New film 1");
        FilmServiceInt service = new FilmServiceProxy(user);
        service.saveFilm(film);

        service.getFilm(1L);
        user.setRole(Role.ADMIN);
        System.out.println("user " + user.getLogin() + " get film: " + service.getFilm(1L).getTitle());
        System.out.println();

        //strategy
        Parcel parcel = new Parcel(123L, "New City, Old street, 76");
        DeliveryStrategy deliveryCourier = new Courier("John Doe");
        DeliveryStrategy delieveryPost = new Post(486923);
        DeliveryStrategy deliveryPickUp = new PickUp("hks862wcD");
        System.out.println(deliveryPickUp.deliver(parcel));
        System.out.println(deliveryCourier.deliver(parcel));
        System.out.println(delieveryPost.deliver(parcel));
    }
}
