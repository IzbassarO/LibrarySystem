package LibrarySystem.repositories;

import LibrarySystem.data.interfaces.IDB;
import LibrarySystem.data.PostgresDB;
import LibrarySystem.entities.user.userMethods.*;
import LibrarySystem.entities.book.BookMethods.*;
import LibrarySystem.entities.borrowBook.*;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();

        UserRepositoryInter repo1 = new UserRepository(db);
        UserController controller1 = new UserController(repo1);

        BookRepositoryInter repo2 = new BookRepository(db);
        BookController controller2 = new BookController(repo2);

        BorrowBookRepositoryInter repo3 = new BorrowBookRepository(db);
        BorrowBookController controller3 = new BorrowBookController(repo3);

        MyApplication app = new MyApplication(controller1, controller2, controller3);

        app.start();
    }
}