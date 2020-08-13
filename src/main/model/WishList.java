package model;


//* Class represents a list of dog breeds the user likes or wishes to have

public class WishList extends DogCollection {

    public WishList() {
        super();
    }

    //MODIFIES: this
    //EFFECTS: removes the given dog breed in the wish list
    public void remove(DogBreed db) {
        data.remove(db);

    }


}



