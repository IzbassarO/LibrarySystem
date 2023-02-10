package LibrarySystem.entities.book.BookMethods;

import LibrarySystem.data.interfaces.IDB;
import LibrarySystem.entities.book.Book;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookRepository implements BookRepositoryInter {

    private final IDB db;

    public BookRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addBook(Book book) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO books VALUES (?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, book.getIdOfBook());

            st.setString(2, book.getTitleOfBook());

            st.setString(3, book.getAuthorOfBook());

            st.setInt(4, book.getQuantityOfBook());

            st.execute();

            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Book getBook(int isbn) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM books WHERE isbn=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, isbn);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("quantity"));

                return book;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM books";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("quantity"));

                books.add(book);
            }

            return books;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }
}

