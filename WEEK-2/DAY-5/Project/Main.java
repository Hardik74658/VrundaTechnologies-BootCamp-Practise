import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Catalog catalog = new Catalog();
    public static Scanner input = new Scanner(System.in);
    public static Scanner forother = new Scanner(System.in);
    // Book book3 = new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction");

    public static void addBook() {
        // Scanner input = new Scanner(System.in);
        System.out.println("Enter Title Of The Book : ");
        String title = input.nextLine();
        System.out.println("Enter Author Of The Book : ");
        String author = input.nextLine();
        System.out.println("Enter Genre Of The Book : ");
        String genre = input.nextLine();
        Book newBook = new Book(title, author, genre);
        catalog.addBook(newBook);
    }

    public static void removeBook() {
        // Scanner input = new Scanner(System.in);
        System.out.println("Enter Book Full Title : ");
        String title = input.nextLine();
        System.out.println("Is This The Book That You Want To Remove : ");
        Book book = catalog.searchBooks(title).get(0);
        System.out.println(book.toString());
        System.out.println("Enter (true/false) : ");
        Boolean doRemove = forother.nextBoolean();
        if (doRemove == true) {
            catalog.removeBook(book);
        } else {
            System.out.println("None Of The Book Is Removed.");
        }
    }

    public static void borrrowBook() {
        // Scanner input = new Scanner(System.in);
        System.out.println("Enter Book Full Title : ");
        String title = input.nextLine();
        System.out.println("Is This The Book That You Want To Borrow : ");
        Book book = catalog.searchBooks(title).get(0);
        System.out.println(book.toString());
        System.out.println("Enter (true/false) : ");
        Boolean doRemove = forother.nextBoolean();
        if (doRemove == true) {
            System.out.println("Enter Your Full Name : ");
            System.out.flush();
            String name = input.nextLine();
            Borrower borrower = new Borrower(name);
            System.out.println("For How many days You Want To Borrow : ");
            Integer days = input.nextInt();
            borrower.borrowBook(book, LocalDate.now().plusDays(days));
        }
    }

    // Return Book Is Not Working
    public static void returnBook() {
        Integer Returned = 0;
        Scanner input = new Scanner(System.in);
        // System.out.flush();
        System.out.println("Enter Book Full Title : ");
        String title = input.nextLine();
        System.out.println("Is This The Book That You Want To Return : ");
        Book book = catalog.searchBooks(title).get(0);
        System.out.println(book.toString());
        System.out.println("Enter (true/false) : ");
        Boolean doRemove = forother.nextBoolean();
        if (doRemove == true) {
            // System.out.flush();
            System.out.println("Enter Your Full Name : ");
            String name = input.nextLine();
            Borrower borrower = new Borrower(name);
            for (BorrowedBook borrowedBook : borrower.getBorrowedBooks()) {
                if (borrowedBook.getBorrower().equals(borrower) && borrowedBook.getBook().equals(book)) {
                    Returned = 1;
                    borrower.returnBook(borrowedBook);
                }
            }
            if (Returned == 0) {
                System.out.println("There Is No Book Named " + title + " Remaining Borrowed By You.");
            }
        }

    }

    public static void searchBook() {
        // Scanner input = new Scanner(System.in);
        Integer isFound = 0;
        System.out.println("Enter What You Wnat To Search : ");
        String searchTerm = input.nextLine();
        System.out.println("\nSearching for books with keyword \"" + searchTerm + "\":");
        for (Book book : catalog.searchBooks(searchTerm)) {
            isFound = 1;
            System.out.println(book);
        }
        if (isFound == 0) {
            System.out.println("There Are No Book Containing KwyWord \"" + searchTerm + "\".");
        }
    }

    public static void getAllBooks() {
        Integer books = 0;
        for (Book book : catalog.getAllBooks()) {
            books++;
            System.out.println(book.toString());
        }
        if (books == 0) {
            System.out.println("There Are No Books Available. ");
        } else {
            System.out.println(books + " Books Found.");
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("Atomic Habits", "xyz", "abc");
        Book book2 = new Book("How To Win Friends And Influence People", "xyz", "abc");
        catalog.addBook(book1);
        catalog.addBook(book2);
        // Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1--Add Book");
            System.out.println("2--Remove Book");
            System.out.println("3--Borrow Book");
            System.out.println("4--Return Book");
            System.out.println("5--Search Book");
            System.out.println("6--View All Book");
            System.out.println("7--Exit");
            System.out.println("Enter Your Choice : ");
            choice = forother.nextInt();
            System.out.flush();
            switch (choice) {
                case 1:
                    System.out.flush();
                    addBook();
                    break;
                case 2:
                    System.out.flush();
                    removeBook();
                    break;
                case 3:
                    System.out.flush();
                    borrrowBook();
                    break;
                // Return Book Is Not Working
                case 4:
                    System.out.flush();
                    returnBook();
                    break;
                case 5:
                    System.out.flush();
                    searchBook();
                    break;
                case 6:
                    System.out.flush();
                    getAllBooks();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid Choice");

            }
        }
    }

}