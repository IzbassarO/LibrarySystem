package LibrarySystem.entities.user;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private Integer ID;

    private String name;

    private String group;

    private ArrayList<String> borrowedBooks;
    private String borrowedBooks2;

    //constructor
    public User(Integer ID, String name, String group, String borrowedBooks2) {
        this.ID = ID;
        this.name = name;
        this.group = group;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooks2 = borrowedBooks2;
        borrowedBooks.add(borrowedBooks2);
    }

    public User(String name, String group) {
        this.name = name;
        this.group = group;
        this.borrowedBooks = new ArrayList<>();
    }
    public User(){
        this.borrowedBooks = new ArrayList<>();
    }
    //constructor

    //methods

    public void takeBook(String title){
        borrowedBooks.add(title);
    }

    public void giveBook(String title) {
        for (int i = 0; i < borrowedBooks.size(); i++) {
            if(borrowedBooks.get(i).equals(title)) {
                borrowedBooks.remove(title);
                return;
            }
        }
    }

    //methods

    //toString
    @Override
    public String toString() {
//        for(int i = 0; i < borrowedBooks.size(); i++) {
//            borrowedBooks2 += borrowedBooks.indexOf(i) + "; ";
//        }
//      borrowedBooks2 = borrowedBooks.toString().substring(1, borrowedBooks.toString().length() - 1);
        if(borrowedBooks.size() == 0) {
            return "";
        }

        borrowedBooks2 = Arrays.toString(borrowedBooks.toArray()).replace("[", "").replace("]", "");
        return "\n" + ID + " " + name + " " + group + " " + borrowedBooks2;
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

    public String getBorrowedBooks() {
        return borrowedBooks.toString();
    }
    //getters and setters
}
