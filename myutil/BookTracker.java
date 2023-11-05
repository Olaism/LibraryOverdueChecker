/*
 * Chapter 7 Library Overdue Checker
 * Step 2 - A stud class to represent the Booktracker
 */

package myutil;

import java.util.*;

public class BookTracker {
    // ---------------------------------------------------------------
    // Data members
    // ---------------------------------------------------------------
    private List<LibraryBook> bookList;

    // ---------------------------------------------------------------
    // Constructor
    // ---------------------------------------------------------------
    public BookTracker() {
        bookList = new ArrayList<>();
    }

    public void add(LibraryBook book) {
        bookList.add(book);
    }

    public double getCharge() { // stud method
        return 2.00;
    }
    public double getCharge(GregorianCalendar returnDate) { // stud method
        return 1.00;
    }
    public List<LibraryBook> getList() {
        return bookList;
    }
    public String toString() { // stud method
        return "A string";
    }
}