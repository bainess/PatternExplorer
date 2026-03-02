public class Main {
    public static void main(String[] args) {
    User user = new User.Builder("mylogin")
            .name("Aless")
            .surname("Smith")
            .age(30)
            .email("streetroad36@mail.com")
            .password("1337666")
            .build();

    System.out.println(user);
    }
}
