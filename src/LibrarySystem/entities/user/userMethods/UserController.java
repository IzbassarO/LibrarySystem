package LibrarySystem.entities.user.userMethods;

import LibrarySystem.entities.user.User;

import java.util.List;

public class UserController {
    private final UserRepositoryInter repo;

    public UserController(UserRepositoryInter repo) {
        this.repo = repo;
    }

    public String createUser(int id, String name, String group, String borrowedBooks) {

        User user = repo.getUser(id);

        if (user != null) {
            return "User with this id already exists";
        } else {
            user = new User(id, name, group, borrowedBooks);

            boolean created = repo.createUser(user);

            return (created ? "User was created!" : "User creation was failed!");
        }
    }


    public String getUser(int id) {
        User user = repo.getUser(id);

        return (user == null ? "User was not found!" : user.toString());
    }

    public String getAllUsers() {
        List<User> users = repo.getAllUsers();

        return users.toString().substring(1, users.toString().length() - 1);
    }
}

