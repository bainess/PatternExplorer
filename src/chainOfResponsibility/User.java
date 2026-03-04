package chainOfResponsibility;

public class User {
    private String name;
    private String surname;
    private int age;
    private String email;
    private String login;
    private String password;
    private AccessLevel accessLevel = AccessLevel.SHOP;

    protected User(Builder<?> builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.email = builder.email;
        this.login = builder.login;
        this.password = builder.password;
    }

    public static class Builder<T extends Builder<T>> {
        private String login;
        private String name;
        private String surname;
        private int age;
        private String email;
        private String password;

        public Builder(String login) {
            this.login = login;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ".\nSurname: " + surname + ".\nLogin: " +
                login + ".\nAge: " + age + ".\nEmail: " + email + ".\nPassword: " + password;
    }
}
