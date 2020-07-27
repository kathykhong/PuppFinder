package model;

import java.util.ArrayList;

public class WishList {

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

    //EFFECTS: returns db at the given index in the wish list
    public DogBreed get(int index) {
        return myList.get(index);
    }




}
