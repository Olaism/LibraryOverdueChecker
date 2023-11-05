package myutil;

import java.util.*;


class MainTest {

    public static void main(String[] args) {
        // create 20 LibraryBook objects
        BookTracker bookTracker = new BookTracker();

        GregorianCalendar dueDate, returnDate;
        LibraryBook book;

        returnDate = new GregorianCalendar(2023, Calendar.SEPTEMBER, 14);

        // check the error condition
        System.out.println("Error: no book added. Return code - " + bookTracker.getCharge(returnDate));
        System.out.println("Output for empty list book - " + bookTracker.getList());

        // Add 20 books
        System.out.println("Adding 20 books...");
        for (int i=0; i < 20; i++) {
            dueDate = new GregorianCalendar(2023, Calendar.MARCH, i+1);
            book = new LibraryBook(dueDate);
            book.setTitle("Book number " + (i+1));
            bookTracker.add(book);
        }

        System.out.println("Total Charge: " + bookTracker.getCharge(returnDate));
        System.out.println("List: \n" + bookTracker.getList());
    }
}