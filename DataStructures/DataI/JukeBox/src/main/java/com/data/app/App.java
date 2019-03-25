package com.data.app;

import java.util.TreeSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        ArrayList<? extends Object> objs = dogs;
    }

    public void go() {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix your Body");
        Book b3 = new Book("Finding Emo");

        TreeSet<Book> tree = new TreeSet<Book>();
        tree.add(b1); 
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
       
    }

    public void goMap() {
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("Kathy", 42);
        scores.put("Bert", 342);
        scores.put("Skyler", 420);
    

        System.out.println(scores);
        System.out.println(scores.get("Bert"));
    }

    public <T extends Animal> void takeAnimals(ArrayList<T> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.name);
            
        }
    }

}

class Book implements Comparable<Book>{
    String title;

    public Book(String t) {
        title = t;
    }

    @Override 
    public int compareTo(Book book) {
        return title.compareTo(book.title);
    }

    @Override 
    public String toString() {
        return new StringBuilder()
            .append("Tittle - ")
            .append(title)
            .toString();
    }
}


class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() { System.out.println(name.concat(" is eating"));}
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
    void bark() { System.out.println(name.concat(" it's barking"));}
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    void mow() { System.out.println(name.concat(" it's maouwing"));}
}
