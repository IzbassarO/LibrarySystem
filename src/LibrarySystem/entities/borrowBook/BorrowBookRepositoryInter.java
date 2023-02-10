package LibrarySystem.entities.borrowBook;

import LibrarySystem.entities.user.User;
import LibrarySystem.entities.book.Book;

public interface BorrowBookRepositoryInter {
    User borrowBook(int id);

    Book takeBook(int isbn);

    void changeBook(Book book);

    void changeUser(User user);

    User returnBook(int id);

    Book giveBook(int isbn);

    void changeBook2(Book book);

    void changeUser2(User user);
}
