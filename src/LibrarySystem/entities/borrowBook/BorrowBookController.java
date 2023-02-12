package LibrarySystem.entities.borrowBook;

import LibrarySystem.entities.user.User;
import LibrarySystem.entities.book.Book;

public class BorrowBookController {
    private final BorrowBookRepositoryInter repo;

    public BorrowBookController(BorrowBookRepositoryInter repo) {
        this.repo = repo;
    }


    public String borrowBook(int id, int isbn) {
        User user = repo.getUser(id);
        Book book = repo.getBook(isbn);

        user.addBook(book.getTitleOfBook());

        boolean created1 = repo.updateBook1(book);
        boolean created2 = repo.updateUser1(user);

        return (created1 && created2 ? "Book was added!" : "Adding book failed!");
    }
}
