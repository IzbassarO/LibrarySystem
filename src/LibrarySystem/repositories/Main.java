package LibrarySystem.repositories;

import LibrarySystem.data.interfaces.IDB;
import LibrarySystem.data.PostgresDB;
import LibrarySystem.entities.borrowBook.BorrowBookController;
import LibrarySystem.entities.borrowBook.BorrowBookRepository;
import LibrarySystem.entities.borrowBook.BorrowBookRepositoryInter;
import LibrarySystem.entities.user.userMethods.UserController;
import LibrarySystem.entities.user.userMethods.UserRepository;
import LibrarySystem.entities.user.userMethods.UserRepositoryInter;
import LibrarySystem.entities.book.BookMethods.BookController;
import LibrarySystem.entities.book.BookMethods.BookRepository;
import LibrarySystem.entities.book.BookMethods.BookRepositoryInter;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        //testing testing
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