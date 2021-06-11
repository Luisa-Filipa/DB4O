package com.db4odoc.f1.Library_2.modules;

import java.util.List;

public class Book extends Monograph{

    private String IBAN;

    public Book(List<Copy> copies, Subject subject, Integer pages, String IBAN) {
        super(copies, subject, pages);
        this.IBAN = IBAN;
    }


    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public Subject getSubject() {
        return super.getSubject();
    }

    @Override
    public Integer getPages() {
        return super.getPages();
    }

    @Override
    public List<Copy> getCopies() {
        return super.getCopies();
    }

    @Override
    public void setSubject(Subject subject) {
        super.setSubject(subject);
    }

    @Override
    public void setPages(Integer pages) {
        super.setPages(pages);
    }

    @Override
    public void setCopies(List<Copy> copies) {
        super.setCopies(copies);
    }

    @Override
    public String toString() {
        return "Book{" +
                "IBAN='" + IBAN + '\'' +
                ", copies=" + copies.size() +
                ", subject=" + subject.getName() +
                ", pages=" + pages +
                '}';
    }
}
