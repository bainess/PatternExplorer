package chainOfResponsibility;

import builder.User;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Manager {
    private List<Manager> managers;
    private AccessLevel accessLevel = AccessLevel.ADMINISTER;

    public Admin(User.Builder builder) {
        super(builder);
        managers = new ArrayList<>();
    }
}
