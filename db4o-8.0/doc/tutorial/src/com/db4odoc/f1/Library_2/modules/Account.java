package com.db4odoc.f1.Library_2.modules;

import java.util.Date;
import java.util.List;

public class Account {
    private Date opened;
    private boolean valid;
    private String accountType;

    private List<Borrow> borrows;

    private Person person;

    public Account(Date opened, boolean valid, String accountType, List<Borrow> borrows, Person person) {
        this.opened = opened;
        this.valid = valid;
        this.accountType = accountType;
        this.borrows = borrows;
        this.person = person;
    }

    public Date getOpened() {
        return opened;
    }

    public void setOpened(Date opened) {
        this.opened = opened;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Account{" +
                "opened=" + opened +
                ", valid=" + valid +
                ", accountType='" + accountType + '\'' +
                ", borrows=" + borrows +
                ", person=" + person +
                '}';
    }
}
