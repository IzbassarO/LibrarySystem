package LibrarySystem.repositories;

import LibrarySystem.data.interfaces.IDB;
import LibrarySystem.data.PostgresDB;
import LibrarySystem.entities.user.userMethods.*;
import LibrarySystem.entities.book.BookMethods.*;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();

        UserRepositoryInter repo1 = new UserRepository(db);
        UserController controller1 = new UserController(repo1);

        BookRepositoryInter repo2 = new BookRepository(db);
        BookController controller2 = new BookController(repo2);

        MyApplication app = new MyApplication(controller1, controller2);

        app.start();
    }
}