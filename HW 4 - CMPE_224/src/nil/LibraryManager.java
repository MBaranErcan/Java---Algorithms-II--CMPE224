package nil;

import java.util.*;

public class LibraryManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the log file: ");
        String logFile = scanner.nextLine();

        // Create a priority queue for books
        PriorityQueue<Book> bookQueue = new PriorityQueue<>((b1, b2) -> b1.getQuantity() - b2.getQuantity());

        // Create a map to store customer information for a specific day
        HashMap<Integer, PriorityQueue<Customer>> customerMap = new HashMap<>();

        String[] lines = logFile.split("\n");
        int lineIndex = 0;

        // Read book information
        while (lineIndex < lines.length && !lines[lineIndex].equals("*DAY INFO*")) {
            String[] bookInfo = lines[lineIndex].split(",");
            String author = bookInfo[0];
            String title = bookInfo[1];
            int quantity = Integer.parseInt(bookInfo[2]);
            Book book = new Book(author, title, quantity);
            bookQueue.add(book);
            lineIndex++;
        }

        lineIndex++; // Skip the "*DAY INFO*" line

        // Read day information
        ArrayList<Integer> days = new ArrayList<>();
        while (lineIndex < lines.length && !lines[lineIndex].equals("**CUSTOMER INFO**")) {
            int day = Integer.parseInt(lines[lineIndex]);
            days.add(day);
            lineIndex++;
        }

        lineIndex++; // Skip the "**CUSTOMER INFO**" line

        // Read customer information
        while (lineIndex < lines.length) {
            String[] customerInfo = lines[lineIndex].split(",");
            int registrationYear = Integer.parseInt(customerInfo[0]);
            String customerID = customerInfo[1];
            int reservationStart = Integer.parseInt(customerInfo[2]);
            int reservationDays = Integer.parseInt(customerInfo[3]);
            String bookTitle = customerInfo[4];
            Customer customer = new Customer(registrationYear, customerID, reservationStart, reservationDays, bookTitle);

            PriorityQueue<Customer> customers = customerMap.getOrDefault(reservationStart, new PriorityQueue<>((c1, c2) -> {
                if (c1.getRegistrationYear() != c2.getRegistrationYear()) {
                    return c1.getRegistrationYear() - c2.getRegistrationYear();
                } else {
                    return c1.getCustomerID().compareTo(c2.getCustomerID());
                }
            }));

            customers.add(customer);
            customerMap.put(reservationStart, customers);
            lineIndex++;
        }

        // Print the list of waiting customers for each day
        for (int day : days) {
            System.out.println("Day " + day + ":");
            PriorityQueue<Customer> customers = customerMap.getOrDefault(day, new PriorityQueue<>());
            PriorityQueue<Book> availableBooks = new PriorityQueue<>(bookQueue);

            while (!customers.isEmpty()) {
                Customer customer = customers.poll();
                Book book = findAvailableBook(availableBooks, customer.getBookTitle());
                if (book != null) {
                    availableBooks.remove(book);
                    book.decreaseQuantity();
                    System.out.println("Customer ID: " + customer.getCustomerID() + ", Book: " + customer.getBookTitle());
                }
            }

            System.out.println();
        }
    }

    private static Book findAvailableBook(PriorityQueue<Book> books, String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle) && book.getQuantity() > 0) {
                return book;
            }
        }
        return null;
    }
}