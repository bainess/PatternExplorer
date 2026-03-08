package chainOfResponsibility;

import builder.User;

public class Account {
    private Long id;
    private User user;
    private Double amount;

    public Account(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.amount = builder.amount;
    }

    public Double getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }

    public static class Builder {
        private Long id;
        private User user;
        private Double amount;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
