package LibrarySystem.entities.borrowBook;

import LibrarySystem.data.interfaces.IDB;
import LibrarySystem.entities.book.Book;
import LibrarySystem.entities.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowBookRepository implements BorrowBookRepositoryInter{
    private final IDB db;

    public BorrowBookRepository(IDB db) {
        this.db = db;
    }

    public boolean updateUser1(User user) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE users SET books = ? WHERE id = ?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.toStringBooks());

            st.setInt(2, user.getID());

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

    public boolean updateBook1(Book book) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "UPDATE books SET quantity = ? WHERE isbn = ?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, book.changeQuantityOfBook());

            st.setInt(2, book.getIdOfBook());

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

    public User getUser(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("group"),
                        rs.getString("books"));

                return user;
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
}
