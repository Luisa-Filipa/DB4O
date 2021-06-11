package com.db4odoc.f1.Library_2.modules;

import java.util.Date;
import java.util.List;

public class SerialItem extends Item {

    protected Integer number;
    protected String volume;
    protected Date date;

    public SerialItem(List<Copy> copies, Integer number, String volume, Date date) {
        super(copies);
        this.number = number;
        this.volume = volume;
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
