package com.data.app;

import java.util.LinkedList;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.Collections;
import java.util.Comparator;
public class SortMountains {
    private LinkedList<Mountain> mountainsList = new LinkedList<Mountain>();
    private transient static final Logger LOGGER = Logger.getLogger(SortMountains.class.getName()); 

    class NameComparator implements Comparator<Mountain> {
        @Override 
        public int compare(Mountain one, Mountain two) {
            return one.getName().compareTo(two.getName());
        }
    }

    class HeightComparator implements Comparator<Mountain> {
        @Override 
        public int compare(Mountain one, Mountain two) {
            return (two.getHeight() - one.getHeight());
        }
    }

    public void initList() {
        Mountain one = new Mountain("Everest", 10000);
        Mountain two = new Mountain("Kilimanjaro", 122000);
        mountainsList.add(one);
        mountainsList.add(two);
    }
    public void go() {
        initList();
        Collections.sort(mountainsList, new NameComparator());
        System.out.println("Ordered By Name: ".concat(mountainsList.toString()));

        Collections.sort(mountainsList, new HeightComparator());
        System.out.println("Ordered By Height: ".concat(mountainsList.toString()));
    }
}

class Mountain {
    private String name; 
    private int height;

    public Mountain(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override 
    public String toString() {
        return new StringBuilder()
            .append("Name: ".concat(name))
            .append("Height: ".concat(String.valueOf(height)))
            .toString();
    }
}

