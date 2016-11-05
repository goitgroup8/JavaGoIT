package bookingsystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDAO implements AbstractDAO<User> {

    List<User> users = new LinkedList<User>();

    UserDAO() {
        users.add(new User(1,"Artur1", "Kovalchuk1"));
        users.add(new User(2,"Artur2", "Kovalchuk2"));
        users.add(new User(3,"Artur3", "Kovalchuk3"));
        users.add(new User(4,"Artur4", "Kovalchuk4"));
        users.add(new User(5,"Artur5", "Kovalchuk5"));
    }

    @Override
    public User save(User user) {
        this.users.add(user);
        return user;    }

    @Override
    public void delete(User user) {
        this.users.remove(user);
    }

    @Override
    public void deleteAll(List<User> users) {
        this.users.removeAll(users);
    }

    @Override
    public void saveAll(List<User> users) {
        this.users.addAll(users);
    }

    @Override
    public List<User> getAlll() {
        return this.users;
    }

    @Override
    public void deleteById(long id) {
        this.users.remove(id);
    }

    @Override
    public User findById(int id) {
        return this.users.get(id);
    }
}
