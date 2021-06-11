package com.db4odoc.f1.Library_2.modules;

import java.util.Date;
import java.util.List;

public class Serial extends SerialItem {

    private String title;
    private Person editor;
    private Organization publisher;

    public Serial(List<Copy> copies, Integer number, String volume, Date date, String title, Person editor, Organization publisher) {
        super(copies, number, volume, date);
        this.title = title;
        this.editor = editor;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Person getEditor() {
        return editor;
    }

    public void setEditor(Person editor) {
        this.editor = editor;
    }

    public Organization getPublisher() {
        return publisher;
    }

    public void setPublisher(Organization publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Serial{" +
                "title='" + title + '\'' +
                ", editor=" + editor.getName() +
                ", publisher=" + publisher.getName() +
                '}';
    }
}
