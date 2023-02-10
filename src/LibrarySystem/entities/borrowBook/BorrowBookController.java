package LibrarySystem.entities.borrowBook;

import LibrarySystem.entities.user.User;
import LibrarySystem.entities.book.Book;

import java.util.Scanner;

public class BorrowBookController {

    private final BorrowBookRepositoryInter repo;
    public BorrowBookController(BorrowBookRepositoryInter repo) {
        this.repo = repo;
    }

    public String borrowBook(int id, int isbn) {
        User user = repo.borrowBook(id);
        Book book = repo.takeBook(isbn);

        System.out.println("Did " + user.getName() + " want take " + book.getTitleOfBook() + "?(yes/no)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if(answer.equals("yes")) {
            user.takeBook(book.getTitleOfBook());

            repo.changeBook(book);
            repo.changeUser(user);

            return "book was taken!!!";
        }

        return null;
    }

    public String returnBook(int id, int isbn) {
        User user = repo.returnBook(id);
        Book book = repo.giveBook(isbn);

        user.giveBook(book.getTitleOfBook());

        repo.changeBook2(book);
        repo.changeUser2(user);

        return "book was returned!!!";
    }
}
