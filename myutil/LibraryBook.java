/* Chapter 7 Library Overdue Checker
 * Step 1 LibraryBook class
 * File: LibraryBook.java
 */
package myutil;

import java.util.*;

class LibraryBook {
    // ---------------------------------------------------------
    // Data Members
    // ---------------------------------------------------------
    private static final double CHARGE_PER_DAY = 0.50;
    private static final double MAX_CHARGE = 50.00;
    private static final String DEFAULT_TITLE = "Title unknown";
    private GregorianCalendar dueDate;
    private String title;
    private double chargePerDay;
    private double maximumCharge;
    // ---------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------
    public LibraryBook(GregorianCalendar dueDate) {
        this(dueDate, CHARGE_PER_DAY, MAX_CHARGE, DEFAULT_TITLE);
    }
    public LibraryBook(GregorianCalendar dueDate, double chargePerDay) {
        this(dueDate, chargePerDay, MAX_CHARGE, DEFAULT_TITLE);
    }
    public LibraryBook(GregorianCalendar dueDate, double chargePerDay, double maximumCharge) {
        this(dueDate, chargePerDay, maximumCharge, DEFAULT_TITLE);
    }
    public LibraryBook(GregorianCalendar dueDate, double chargePerDay, double maximumCharge, String title) {
        setDueDate(dueDate);
        setChargePerDay(chargePerDay);
        setMaximumCharge(maximumCharge);
        setTitle(title);
    }
    // ---------------------------------------------------------
    // Main method
    // ---------------------------------------------------------
    public static void main(String[] args) {
        GregorianCalendar dueDate;
        LibraryBook book1, book2, book3, book4;

        dueDate = new GregorianCalendar(2023, Calendar.DECEMBER, 30);
        book1 = new LibraryBook(dueDate);

        dueDate = new GregorianCalendar(2023, Calendar.APRIL, 13);
        book2 = new LibraryBook(dueDate, 0.75);
        book2.setTitle("Introduction to OOP with java by C. Thomas Wu");

        dueDate = new GregorianCalendar(2023, Calendar.MAY, 1);
        book3 = new LibraryBook(dueDate, 1.00, 100.00);
        book3.setTitle("Java for smarties");

        dueDate = new GregorianCalendar(2023, Calendar.SEPTEMBER, 14);
        book4 = new LibraryBook(dueDate, 1.50, 230.00, "Me and My Java");

        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
        System.out.println(book4.toString());

    }
    // ---------------------------------------------------------
    // Instance Methods
    // ---------------------------------------------------------
    public GregorianCalendar getDueDate() {
        return dueDate;
    }
    public double getChargePerDay() {
        return chargePerDay;
    }
    public double getMaximumCharge() {
        return maximumCharge;
    }
    public String getTitle() {
        return title;
    }
    public void setDueDate(GregorianCalendar dueDate) {
        this.dueDate = dueDate;
    }
    public void setChargePerDay(double chargePerDay) {
        this.chargePerDay = chargePerDay;
    }
    public void setMaximumCharge(double maximumCharge) {
        this.maximumCharge = maximumCharge;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String toString() {
        return String.format("%-30s $%5.2f $%7.2f %4$tm/%4$td/%4$ty", 
        getTitle(), getChargePerDay(), getMaximumCharge(), getDueDate());
    }
}