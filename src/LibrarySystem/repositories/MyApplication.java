package LibrarySystem.repositories;

import LibrarySystem.entities.book.BookMethods.BookController;
import LibrarySystem.entities.borrowBook.BorrowBookController;
import LibrarySystem.entities.user.userMethods.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final UserController controller1;
    private final BookController controller2;
    private final BorrowBookController controller3;
    private final Scanner scanner;

    public MyApplication(UserController controller1, BookController controller2, BorrowBookController controller3) {
        this.controller1 = controller1;
        this.controller2 = controller2;
        this.controller3 = controller3;
        scanner = new Scanner(System.in);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while(flag) {
            System.out.println("Hello, here the following available function: ");
            System.out.println("""
                            \t0) To stop program;
                            \t1) Get all users;
                            \t2) Get user by id;
                            \t3) Create user;
                            \t4) Get all books;
                            \t5) Get book by isbn;
                            \t6) Add book;
                            \t7) To give the certain book to the certain user;
                            \t8) To return a book back to the library from user.
                            """);

            System.out.print("Choose function you wanna choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch(choice) {
                    case 1 -> getAllUsersMenu();
                    case 2 -> getUserByIdMenu();
                    case 3 -> createUserMenu();
                    case 4 -> getAllBooksMenu();
                    case 5 -> getBookByIsbnMenu();
                    case 6 -> addBookMenu();
                    case 7 -> borrowBookMenu();
//                    case 8 -> returnBookMenu();
                    case 0 -> flag = false;
                    default -> System.out.println("Enter from 1-6!!!");
                }
            }
            catch (InputMismatchException q) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("****************************");
        }
    }

    public void getAllUsersMenu() {
        String response = controller1.getAllUsers();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller1.getUser(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter id(4 digits), name(only one word), group(student, staff):");

        int id;
        String name;
        String group;

        while(true) {
            id = scanner.nextInt();
            name = scanner.next();
            group = scanner.next();

            if ((id < 10000 && id > 999) && (group.equals("student") || group.equals("staff"))) {break;}

            System.out.println("Incorrect input :(");
        }

        String response = controller1.createUser(id, name, group, null);
        System.out.println(response);
    }

    public void getAllBooksMenu() {
        String response = controller2.getAllBooks();
        System.out.println(response);
    }

    public void getBookByIsbnMenu() {
        System.out.println("Please enter isbn");

        int isbn = scanner.nextInt();
        String response = controller2.getBook(isbn);
        System.out.println(response);
    }

    public void addBookMenu() {
        System.out.println("Please enter isbn(5 digits), title(use '_' instead of space), author(use '_' instead of space), quantity:");

        int isbn;
        String title;
        String author;
        int quantity;

        while(true) {
            isbn = scanner.nextInt();
            title = scanner.next();
            author = scanner.next();
            quantity = scanner.nextInt();

            if((isbn < 100000 && isbn > 9999)) {
                break;
            }

            System.out.println("Incorrect input :(");
        }

        String response = controller2.addBook(isbn, title, author, quantity);
        System.out.println(response);
    }

    public void borrowBookMenu() {
        int id;

        int isbn;

        while(true) {
            System.out.println("Enter id of student:");
            id = scanner.nextInt();

            System.out.println("Enter isbn of book:");
            isbn = scanner.nextInt();

            if(id < 10000 && id > 999 && isbn < 100000 && isbn > 9999) {break;}

            System.out.println("Incorrect input :(");
            System.out.print("Continue?(yes/no): ");

            String cancel = scanner.next();
            if(cancel.equals("no")) {break;}
        }

        String response = controller3.borrowBook(id, isbn);
        System.out.println(response);
    }
}