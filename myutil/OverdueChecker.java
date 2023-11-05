/*
 * Chapter 7 Library Overdue Checker
 * Step 3 Implement the main controller
 */
package myutil;

import java.util.*;

class OverdueChecker {
    // ----------------------------------------------------------------
    // Data Members
    // ----------------------------------------------------------------
    public static enum Response {YES, NO};
    public static final String DATE_SEPARATOR = "/";
    private Scanner scanner;
    private BookTracker bookTracker;

    // ----------------------------------------------------------------
    // Constructor
    // ----------------------------------------------------------------
    public OverdueChecker() {
        scanner = new Scanner(System.in);
        scanner.useDelimiter(System.lineSeparator());
        bookTracker = new BookTracker();
    }

    // ----------------------------------------------------------------
    // Main Method
    // ----------------------------------------------------------------

    public static void main(String[] args) {
        OverdueChecker odc = new OverdueChecker();
        odc.start();
    }

    // ----------------------------------------------------------------
    // Public Methods
    // ----------------------------------------------------------------
    public void start() {
        GregorianCalendar returnDate;
        List<LibraryBook> table;
        double charge;
        Response response;

        inputBooks();

        table = bookTracker.getList();
        System.out.println(table);

        System.out.println("Now check the overdue charges: ");

        // try different return dates
        do {
            returnDate = readDate("\nReturn Date: ");
            charge = bookTracker.getCharge(returnDate);
            displayTotalCharge(charge);
            response = prompt("\n Run again (yes/no) ");
        } while (response == Response.YES);
    }

    // ----------------------------------------------------------------
    // Private Methods
    // ----------------------------------------------------------------
    private LibraryBook createBook(String title, 
                                double chargePerDay, 
                                double maxCharge, 
                                GregorianCalendar dueDate) {
        if (dueDate == null) {
            dueDate = new GregorianCalendar();  // set today as due date
        }
        LibraryBook libraryBook = new LibraryBook(dueDate);
        if (title.length() > 0) {
            libraryBook.setTitle(title);
        }
        if (chargePerDay > 0.0) {
            libraryBook.setChargePerDay(chargePerDay);
        }
        if (maxCharge > 0.0) {
            libraryBook.setMaximumCharge(maxCharge);
        }
        return libraryBook;
    }

    private void display(String text) {
        System.out.print(text);
    }

    private void displayTotalCharge(double charge) {
        System.out.format("\nTOTAL CHARGE:\t $%8.2f", charge);
    }
    private void inputBooks() {
        GregorianCalendar dueDate;
        double chargePerDay, maxCharge;
        String title;
        LibraryBook book;

        while (isContinue()) {
            title = readString("Title: ");
            chargePerDay = readDouble("Charge per day: ");
            maxCharge = readDouble("Maximum charge: ");
            dueDate = readDate("Due date: ");

            book = createBook(title, chargePerDay, maxCharge, dueDate);

            bookTracker.add(book);
        }
    }

    private Response prompt(String question) {
        String input;
        Response response = Response.NO;

        System.out.print(question + " (Yes - y; No - n): ");

        input = scanner.next();

        if (input.equals("y") || input.equals("Y")) {
            response = Response.YES;
        }

        return response;
    }

    private boolean isContinue() {
        Response response = prompt("\nMore books to enter (y/n)? ");
        return (response == Response.YES);
    }

    private String readString(String message) {
        display(message);
        return scanner.next();
    }

    private double readDouble(String message) {
        display(message);
        return scanner.nextDouble();
    }

    private GregorianCalendar readDate(String message) {
        GregorianCalendar cal;
        String yearStr, monthStr, dayStr, line;
        int sep1, sep2;

        display(message);
        line = scanner.next();

        if (line.length() == 0) {
            cal = null;
        } else {
            sep1 = line.indexOf(DATE_SEPARATOR);
            sep2 = line.lastIndexOf(DATE_SEPARATOR);

            monthStr = line.substring(0, sep1);
            dayStr = line.substring(sep1+1, sep2);
            yearStr = line.substring(sep2+1, line.length());

            cal = new GregorianCalendar(Integer.parseInt(yearStr), 
                                    Integer.parseInt(monthStr)-1, 
                                    Integer.parseInt(dayStr));
        }
        return cal;
    }
}