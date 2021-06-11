package com.db4odoc.f1.Library_2.modules;

import java.util.List;

public class Subject {
    protected String name;
    protected List<Monograph> monographList;

    public Subject(String name, List<Monograph> monographList) {
        this.name = name;
        this.monographList = monographList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Monograph> getMonographList() {
        return monographList;
    }

    public void setMonographList(List<Monograph> monographList) {
        this.monographList = monographList;
    }
}
