package com.db4odoc.f1.Library_2.modules;

import java.util.List;

public class Organization extends Subject {
    List<Serial> serialList;


    public Organization(String name, List<Monograph> monographList) {
        super(name, monographList);
    }

    public List<Serial> getSerialList() {
        return serialList;
    }

    public void setSerialList(List<Serial> serialList) {
        this.serialList = serialList;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public List<Monograph> getMonographList() {
        return super.getMonographList();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setMonographList(List<Monograph> monographList) {
        super.setMonographList(monographList);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "serialList=" + serialList +
                ", name='" + name + '\'' +
                ", monographList=" + monographList +
                '}';
    }
}
