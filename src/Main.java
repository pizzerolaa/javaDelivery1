/* funcion main, en la cual se corre la aplicacion y se implementan los servicios. se crea el menu, etc */

import models.*;
import services.*;
import exceptions.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BookServ bookServ = new BookServ();
    private static PatronServ patronServ = new PatronServ();
    private static BorrowServ borrowServ = new BorrowServ();

    public static void main(String[] args) {
        initialize();
        
        boolean running = true;
        while (running) {
            mainMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {
                    case 1:
                        bookManagement();
                        break;
                    case 2:
                        patronManagement();
                        break;
                    case 3:
                        borrowManagement();
                        break;
                    case 4:
                        searchMenu();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void initialize() {
        bookServ.addBook(new Book("El código Da Vinci", "Dan Brown", "9780385513227", 2));
        bookServ.addBook(new Book("El alquimista", "Paulo Coelho", "9780062511409", 1));
        bookServ.addBook(new Book("El principito", "Antoine de Saint-Exupéry", "9780156013925", 3));

        patronServ.registerPatron(new Patron("Fernando Antonio", "1", "615-113-0359"));
        patronServ.registerPatron(new Patron("Santos Arellano", "2", "555-233-1344"));
        patronServ.registerPatron(new Patron("Sadrac Aramburo", "3", "667-865-2341"));

        Book book1 = bookServ.findBook("9780385513227");
        Book book2 = bookServ.findBook("9780062511409");
        Patron patron1 = patronServ.findPatron(1);
        Patron patron2 = patronServ.findPatron(2);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);

        if (book1 != null && patron1 != null) {
            borrowServ.borrowBook(book1, patron1, formattedDate);
        }
        if (book2 != null && patron2 != null) {
            borrowServ.borrowBook(book2, patron2, formattedDate);
        }
    }

    // menu principal
    private static void mainMenu() {
        System.out.println("\n====== Library 'Team 21' Management System ======");
        System.out.println("1. Book Management");
        System.out.println("2. Patron Management");
        System.out.println("3. Borrow Management");
        System.out.println("4. Search");
        System.out.println("5. Exit");
    }

    // menu de gestion de los libros
    private static void bookManagement() {
        System.out.println("\n====== Book Management ======");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Display Books");
        System.out.println("4. Edit Book");
        System.out.println("5. Back to Main Menu");

        int option = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (option) {
                case 1:
                    System.out.println("Enter book title, author, ISBN, and quantity:");
                    bookServ.addBook(new Book(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt()));
                    break;
                case 2:
                    System.out.println("Enter ISBN of book to remove:");
                    bookServ.removeBook(scanner.nextLine());
                    break;
                case 3:
                    bookServ.displayBooks();
                    break;
                case 4:
                    System.out.println("Enter ISBN of book to edit, then enter new title, author, ISBN, and quantity:");
                    bookServ.editBook(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt());
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // menu de gestion de los miembros
    private static void patronManagement() {
        System.out.println("\n====== Patron Management ======");
        System.out.println("1. Register Patron");
        System.out.println("2. Remove Patron");
        System.out.println("3. View Patrons");
        System.out.println("4. Edit Patron");
        System.out.println("5. Back to Main Menu");

        int option = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (option) {
                case 1:
                    System.out.println("Enter name, ID, and contact of patron:");
                    patronServ.registerPatron(new Patron(scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
                    break;
                case 2:
                    System.out.println("Enter ID of patron to remove:");
                    patronServ.removePatron(scanner.nextInt());
                    break;
                case 3:
                    patronServ.viewPatrons();
                    break;
                case 4:
                    System.out.println("Enter ID of patron to edit, then enter new name and contact:");
                    patronServ.editPatron(scanner.nextInt(), scanner.nextLine(), scanner.nextLine());
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // menu de gestion de los prestamos de libros
    private static void borrowManagement() {
        System.out.println("\n====== Borrow Management ======");
        System.out.println("1. Borrow Book");
        System.out.println("2. Return Book");
        System.out.println("3. View All Borrowed Books");
        System.out.println("4. Books per Patron");
        System.out.println("5. Back to Main Menu");

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);

        int option = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (option) {
                case 1:
                    System.out.println("Enter ISBN of the book:");
                    Book book = bookServ.findBook(scanner.nextLine());
                    System.out.println("Enter ID of the patron:");
                    Patron patron = patronServ.findPatron(scanner.nextInt());
                    scanner.nextLine();
                    if (book != null && patron != null) {
                        borrowServ.borrowBook(book, patron, formattedDate);
                    } else {
                        System.out.println("Invalid book ISBN or patron ID.");
                    }
                    break;
                case 2:
                    System.out.println("Enter ISBN of the book:");
                    Book book1 = bookServ.findBook(scanner.nextLine());
                    System.out.println("Enter ID of the patron:");
                    Patron patron1 = patronServ.findPatron(scanner.nextInt());
                    scanner.nextLine();
                    if (book1 != null && patron1 != null) {
                        borrowServ.returnBook(book1, patron1);
                    } else {
                        System.out.println("Invalid book ISBN or patron ID.");
                    }
                    break;
                case 3:
                    borrowServ.viewBorrows();
                    break;
                case 4:
                    System.out.println("Enter ID of the patron:");
                    Patron patron2 = patronServ.findPatron(scanner.nextInt());
                    scanner.nextLine();
                    borrowServ.booksPerPatron(patron2);
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // buscar libros o miembros
    private static void searchMenu() {
        System.out.println("\n====== Search ======");
        System.out.println("1. Search Books");
        System.out.println("2. Search Patrons");
        System.out.println("3. Back to Main Menu");

        int option = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (option) {
                case 1:
                    System.out.println("Enter book ISBN:");
                    bookServ.searchBook(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Enter patron ID:");
                    patronServ.searchPatron(scanner.nextInt());
                    break;
                case 3:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}