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

        while(true) {
            System.out.println("Hello, here the following available function: ");
            System.out.println("\t1) Get all users;\n" +
                    "\t2) Get user by id;\n" +
                    "\t3) Create user;\n" +
                    "\t4) Get all books;\n" +
                    "\t5) Get book by isbn;\n" +
                    "\t6) Add book;\n" +
                    "\t7) To give the certain book to the certain user;\n" +
                    "\t8) To return a book back to the library from user.\n");

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
                    case 8 -> returnBookMenu();
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
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter name");
        String name = scanner.nextLine();

        System.out.println("Please enter group(student,stuff)");
        String group = scanner.next();

        String response = controller1.createUser(id, name, group, "null");
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
        System.out.println("Please enter isbn");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter title");
        String title = scanner.nextLine();

        System.out.println("Please enter author");
        String author = scanner.nextLine();

        System.out.println("Please enter quantity");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        String response = controller2.addBook(isbn, title, author, quantity);
        System.out.println(response);
    }

    public void borrowBookMenu() {
        System.out.println("Enter your id");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter isbn of book, which you want to take");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        String response = controller3.borrowBook(id, isbn);
        if(response.equals(null)) {
            System.out.println("Reject confirmed");
            return;
        }
        System.out.println(response);
    }

    private void returnBookMenu() {
        System.out.println("Enter your id");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter isbn of book, which you want to return");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        String response = controller3.returnBook(id, isbn);
        System.out.println(response);
    }
}