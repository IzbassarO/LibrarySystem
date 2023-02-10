package LibrarySystem.entities.user.userMethods;

import LibrarySystem.entities.user.User;

import java.util.List;

public interface UserRepositoryInter {
    boolean createUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
}
