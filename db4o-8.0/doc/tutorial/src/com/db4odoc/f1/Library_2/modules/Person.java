package com.db4odoc.f1.Library_2.modules;

import java.util.List;

public class Person extends Subject {
    private List<Serial> serialList;
    private Account account;


    public Person(String name, List<Monograph> monographList) {
        super(name, monographList);
    }

    public List<Serial> getSerialList() {
        return serialList;
    }

    public void setSerialList(List<Serial> serialList) {
        this.serialList = serialList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        return "Person{" +
                "serialList=" + serialList +
                ", account=" + account.isValid() +
                ", name='" + name + '\'' +
                ", monographList=" + monographList +
                '}';
    }
}
