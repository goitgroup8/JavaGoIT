package bookingsystem.dao;

import bookingsystem.model.User;

import java.util.LinkedList;
import java.util.List;

public class UserDAOImpl extends AbstractDAOImpl  {
    List<User> users = new LinkedList<User>();

    UserDAOImpl() {
        users.add(new User(1,"Artur1", "Kovalchuk1"));
        users.add(new User(2,"Artur2", "Kovalchuk2"));
        users.add(new User(3,"Artur3", "Kovalchuk3"));
        users.add(new User(4,"Artur4", "Kovalchuk4"));
        users.add(new User(5,"Artur5", "Kovalchuk5"));
    }
}
