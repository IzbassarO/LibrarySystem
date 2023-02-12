package LibrarySystem.entities.borrowBook;

import LibrarySystem.entities.user.User;
import LibrarySystem.entities.book.Book;

public interface BorrowBookRepositoryInter {
    boolean updateUser1(User user);

    boolean updateBook1(Book book);

//    boolean updateUser2(User user);
//
//    boolean updateBook2(Book book);

    User getUser(int id);

    Book getBook(int isbn);
}
