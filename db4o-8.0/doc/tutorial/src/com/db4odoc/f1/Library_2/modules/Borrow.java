package com.db4odoc.f1.Library_2.modules;

import java.util.Date;

public class Borrow {

    private Date borrowed;
    private Date returned;

    private Copy copy;

    private Account account;

    public Borrow(Date borrowed, Date returned, Copy copy, Account account) {
        this.borrowed = borrowed;
        this.returned = returned;
        this.copy = copy;
        this.account = account;
    }

    public Date getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Date borrowed) {
        this.borrowed = borrowed;
    }

    public Date getReturned() {
        return returned;
    }

    public void setReturned(Date returned) {
        this.returned = returned;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowed=" + borrowed +
                ", returned=" + returned +
                ", copy=" + copy +
                ", account=" + account +
                '}';
    }
}
