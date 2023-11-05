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
    private static final double MILLISEC_TO_DAY = 1.0 / 1000 / 60 / 60 / 24;
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
    public double computeCharge(GregorianCalendar returnDate) {
        double charge = 0.0;

        long dueTime = dueDate.getTimeInMillis();
        long returnTime = returnDate.getTimeInMillis();

        long diff = returnTime - dueTime;
        if (diff > 0) {
            charge = chargePerDay * diff * MILLISEC_TO_DAY;
            if (charge > maximumCharge) {
                charge = maximumCharge;
            }
        }
        return charge;
    }
    public String toString() {
        return String.format("%-30s $%5.2f $%7.2f %4$tm/%4$td/%4$ty", 
        getTitle(), getChargePerDay(), getMaximumCharge(), getDueDate());
    }
}