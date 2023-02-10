package LibrarySystem.entities.book.BookMethods;

import LibrarySystem.entities.book.Book;

import java.util.List;

public interface BookRepositoryInter {
    boolean addBook(Book book);

    Book getBook(int isbn);

    List<Book> getAllBooks();

}
