package com.db4odoc.f1.Library_2.modules;

import java.util.List;

public class Monograph extends Item {

    protected Subject subject;
    protected Integer pages;

    public Monograph(List<Copy> copies, Subject subject, Integer pages) {
        super(copies);
        this.subject = subject;
        this.pages = pages;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public List<Copy> getCopies() {
        return super.getCopies();
    }

    @Override
    public void setCopies(List<Copy> copies) {
        super.setCopies(copies);
    }
}
