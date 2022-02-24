package com.example.narmeen;

public class Item {
    private String description;
    private int resid; //image id to be loaded

    public Item(String description, int resid) {
        this.description = description;
        this.resid = resid;

    }
    public Item() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", resid=" + resid +
                '}';
    }
}