package bookingsystem.dao;


import java.util.List;
import bookingsystem.model.User;

public interface UserDAO {
    User saveUser(User u);

    void deleteUser(User u);

    void deleteAllFromList(List<User> userList);

    void saveAllFromList(List<User> userList);

    List<User> getAll();

    void deleteUserById(long id);

    User findUserById(long id);
}

