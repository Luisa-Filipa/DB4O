package com.db4odoc.f1.Library_2.modules;

import java.util.Date;
import java.util.List;

public class Copy {
    private String callNumber;
    private Date aquisition_date;
    private String location;

    private Item item;

    private Borrow borrows;

    public Copy(String callNumber, Date aquisition_date, String location, Item item, Borrow borrows) {
        this.callNumber = callNumber;
        this.aquisition_date = aquisition_date;
        this.location = location;
        this.item = item;
        this.borrows = borrows;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public Date getAquisition_date() {
        return aquisition_date;
    }

    public void setAquisition_date(Date aquisition_date) {
        this.aquisition_date = aquisition_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Borrow getBorrows() {
        return borrows;
    }

    public void setBorrows(Borrow borrows) {
        this.borrows = borrows;
    }

    @Override
    public String toString() {
        return "Copy{" +
                "callNumber='" + callNumber + '\'' +
                ", aquisition_date=" + aquisition_date +
                ", location='" + location + '\'' +
                ", item=" + item +
                ", borrows=" + borrows +
                '}';
    }
}
