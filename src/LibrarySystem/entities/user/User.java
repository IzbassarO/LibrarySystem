package LibrarySystem.entities.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private Integer ID;

    private String name;

    private String group;

    private String books;

    private List<String> arrayBooks;

    //constructor
    public User(Integer ID, String name, String group, String books) {
        this.ID = ID;
        this.name = name;
        this.group = group;
        this.books = books;
        if(books != null) {this.arrayBooks = new ArrayList<>(Arrays.asList(books.split(" ")));}
        else {this.arrayBooks = new ArrayList<>();}
    }

    public User(String name, String group) {
        this.name = name;
        this.group = group;
    }
    public User(){}
    //constructor

    //toString
    @Override
    public String toString() {
        return "\n" + ID + " " + name + " " + group + " " + books;
    }

    public void addBook(String title) {
        this.arrayBooks.add(title);
    }

    public String toStringBooks() {
        switch (arrayBooks.size()) {
            case 1 -> {
                return arrayBooks.get(0);
            }
            case 2 -> {
                return arrayBooks.get(0) + " " + arrayBooks.get(1);
            }
            case 3 -> {
                return arrayBooks.get(0) + " " + arrayBooks.get(1) + " " + arrayBooks.get(2);
            }
            default -> {
                return "no books";
            }
        }
    }
    //toString

    //getters and setters
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    //getters and setters
}
