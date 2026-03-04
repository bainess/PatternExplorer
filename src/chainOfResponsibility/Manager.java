package chainOfResponsibility;

import builder.User;

public class Manager extends User {
    private String department;
    private AccessLevel accessLelvel = AccessLevel.MANAGE;

    public Manager(Builder builder) {
        super(builder);
    }
}
