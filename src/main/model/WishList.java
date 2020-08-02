package model;

import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;

//* Class represents a list of dog breeds the user likes or wishes to have

public class WishList implements Saveable {

    private ArrayList<DogBreed> myList;

    public WishList() {
        this.myList = new ArrayList<>();
    }


    //MODIFIES: this
    //EFFECTS: adds db to the wish list
    public void add(DogBreed db) {
        myList.add(db);
    }

    //EFFECTS: returns the size of the wish list
    public Integer size() {
        return myList.size();
    }

    //EFFECTS: returns true if the wish list is empty, other wise returns false
    public boolean isEmpty() {
        return myList.isEmpty();
    }

    //REQUIRES: wishList cannot be empty
    //EFFECTS: returns db at the given index in the wish list
    public DogBreed get(int index) {
        return myList.get(index);
    }

    //EFFECTS: returns true if the given db is in the wish list
    public Boolean contains(DogBreed db) {
        return myList.contains(db);
    }


    @Override
    public void save(PrintWriter printWriter) {

    }
}
