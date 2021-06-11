package com.db4odoc.f1.Library_2.modules;

import java.util.List;

public class Item {
    protected List<Copy> copies;

    public Item(List<Copy> copies) {
        this.copies = copies;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

}
