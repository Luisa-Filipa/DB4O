package com.db4odoc.f1.Library_2.modules;

import java.util.List;

public class AcademicMonograph extends Monograph{

    public AcademicMonograph(List<Copy> copies, Subject subject, Integer pages) {
        super(copies, subject, pages);
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
}