package LibrarySystem.entities.book;

public class Book {

    private Integer IdOfBook;
    private String titleOfBook;
    private String authorOfBook;
    private Integer quantityOfBook;

    public Book(Integer idOfBook, String titleOfBook, String authorOfBook, Integer quantityOfBook) {
        this.IdOfBook = idOfBook;
        this.titleOfBook = titleOfBook;
        this.authorOfBook = authorOfBook;
        this.quantityOfBook = quantityOfBook;
    }

    public Book(String titleOfBook, String authorOfBook, Integer quantityOfBook) {
        this.titleOfBook = titleOfBook;
        this.authorOfBook = authorOfBook;
        this.quantityOfBook = quantityOfBook;
    }

    public Book(){}

    @Override
    public String toString() {
        return "\n" + IdOfBook + ' ' + titleOfBook + ' ' + authorOfBook + " " + quantityOfBook;
    }

    public Integer getIdOfBook() {
        return IdOfBook;
    }

    public void setIdOfBook(Integer idOfBook) {
        IdOfBook = idOfBook;
    }

    public String getTitleOfBook() {
        return titleOfBook;
    }

    public void setTitleOfBook(String titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public Integer getQuantityOfBook() {
        return quantityOfBook;
    }

    public void setQuantityOfBook(Integer quantityOfBook) {
        this.quantityOfBook = quantityOfBook;
    }

}