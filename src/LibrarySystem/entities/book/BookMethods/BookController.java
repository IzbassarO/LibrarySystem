package LibrarySystem.entities.book.BookMethods;

import LibrarySystem.entities.book.Book;

import java.util.List;

public class BookController {
    private final BookRepositoryInter repo;

    public BookController(BookRepositoryInter repo) {
        this.repo = repo;
    }

    public String addBook(int isbn, String title, String author, int quantity) {
        Book book = new Book(isbn, title, author, quantity);

        if(!getBook(isbn).equals("Book was not found!")) return "This isbn already exist!";

        boolean created = repo.addBook(book);

        return (created ? "Book was added!": "Adding book failed!");
    }

    public String getBook(int isbn) {
        Book book = repo.getBook(isbn);

        return (book == null ? "Book was not found!" : book.toString());
    }
           
    public String getAllBooks() {
        List<Book> books = repo.getAllBooks();

        return books.toString().substring(1, books.toString().length() - 1);
    }
}


