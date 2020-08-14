package model;

import java.util.ArrayList;

//Class represents a generic dog collection
//contains all the common methods between DogBreedSet and WishList

public abstract class DogCollection {
    protected ArrayList<DogBreed> data;

    protected DogCollection() {
        this.data = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds db to the dog collection
    public void add(DogBreed db) {
        if (!data.contains(db)) {
            data.add(db);
        }
    }

    //EFFECTS: returns true if the dog collection is empty, otherwise returns false
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //EFFECTS: returns true if the given db is in the dog collection
    public Boolean contains(DogBreed db) {
        return data.contains(db);
    }

    //EFFECTS: returns the size of the dog collection
    public Integer size() {
        return data.size();
    }

    //EFFECTS: returns the dog breed at the given index
    public DogBreed get(int index) {
        return data.get(index);
    }
}