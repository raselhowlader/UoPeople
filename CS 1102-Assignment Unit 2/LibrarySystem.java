import java.util.*;

// Book class to store book details
class Book {
    String title;
    String author;
    int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title.toLowerCase();
        this.author = author;
        this.quantity = quantity;
    }
}

public class LibrarySystem {

    static Scanner scanner = new Scanner(System.in);

    // HashMap to store books
    static HashMap<String, Book> library = new HashMap<>();

    public static void main(String[] args) {

        int choice = 0;

        // Main menu loop
        do {
            System.out.println("\n===== Library System =====");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Input validation
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    // Add or update book
    public static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().toLowerCase();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        System.out.print("Enter quantity: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid quantity!");
            scanner.next();
            return;
        }

        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0!");
            return;
        }

        if (library.containsKey(title)) {
            library.get(title).quantity += quantity;
            System.out.println("Book updated successfully.");
        } else {
            library.put(title, new Book(title, author, quantity));
            System.out.println("Book added successfully.");
        }
    }

    // Borrow book
    public static void borrowBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().toLowerCase();

        if (!library.containsKey(title)) {
            System.out.println("Book not found!");
            return;
        }

        System.out.print("Enter quantity: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input!");
            scanner.next();
            return;
        }

        int quantity = scanner.nextInt();
        scanner.nextLine();

        Book book = library.get(title);

        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
        } else if (book.quantity >= quantity) {
            book.quantity -= quantity;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Not enough books available!");
        }
    }

    // Return book
    public static void returnBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().toLowerCase();

        if (!library.containsKey(title)) {
            System.out.println("Book not in system!");
            return;
        }

        System.out.print("Enter quantity: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input!");
            scanner.next();
            return;
        }

        int quantity = scanner.nextInt();
        scanner.nextLine();

        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
        } else {
            library.get(title).quantity += quantity;
            System.out.println("Book returned successfully.");
        }
    }
}