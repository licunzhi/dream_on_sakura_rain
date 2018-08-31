package com.sakura.creationalPatterns.PrototypePattern.Animal;

public abstract class Animal implements Cloneable{

    private String id;

    protected String type;

    public abstract void animal();

    public String getType(){
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
