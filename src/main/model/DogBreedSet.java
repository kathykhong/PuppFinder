package model;

import java.util.ArrayList;


public class DogBreedSet {
    private ArrayList<DogBreed> data;


    public DogBreedSet() {
        this.data = new ArrayList<>();
    }


    //MODIFIES: this
    //EFFECTS: removes all the non-fully dog breeds
    public void filterFluffy() {
        data.removeIf(db -> db.getFluff() == 0);
    }

    //MODIFIES: this
    //EFFECTS: removes all the fluffy dog breeds
    public void filterNonFluffy() {
        data.removeIf(db -> db.getFluff() == 1);
    }

    //MODIFIES: this
    //EFFECTS: removes all the large or medium dog breeds
    public void filterSmall() {
        data.removeIf(db -> !db.getSize().equals("small"));
    }

    //MODIFIES: this
    //EFFECTS: removes all the small or large  dog breeds
    public void filterMedium() {
        data.removeIf(db -> !db.getSize().equals("medium"));
    }

    //MODIFIES: this
    //EFFECTS: removes all the small or medium dog breeds
    public void filterLarge() {
        data.removeIf(db -> !db.getSize().equals("large"));
    }

    //MODIFIES: this
    //EFFECTS: removes all the calm dog breeds
    public void filterEnergetic() {
        data.removeIf(db -> db.getEnergetic() == 0);
    }

    //MODIFIES: this
    //EFFECTS: removes all the energetic dog breeds
    public void filterNonEnergetic() {
        data.removeIf(db -> db.getEnergetic() == 1);
    }

    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that shed very little
    public void filterShedALot() {
        data.removeIf(db -> db.getShedALot() == 0);
    }

    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that shed a lot
    public void filterShedALittle() {
        data.removeIf(db -> db.getShedALot() == 1);
    }

    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that are not dog-friendly
    public void filterDogFriendly() {
        data.removeIf(db -> db.getDogFriendly() == 0);
    }

    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that are dog-friendly
    public void filterNotDogFriendly() {
        data.removeIf(db -> db.getDogFriendly() == 1);
    }

    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that are not kid-friendly
    public void filterKidFriendly() {
        data.removeIf(db -> db.getKidFriendly() == 0);
    }

    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that are kid-friendly
    public void filterNotKidFriendly() {
        data.removeIf(db -> db.getKidFriendly() == 1);
    }

    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that are not stranger-friendly
    public void filterStrangerFriendly() {
        data.removeIf(db -> db.getStrangerFriendly() == 0);
    }

    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that are stranger-friendly
    public void filterNotStrangerFriendly() {
        data.removeIf(db -> db.getStrangerFriendly() == 1);
    }


    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that are not intelligent
    public void filterIntelligent() {
        data.removeIf(db -> db.getIntelligence() == 0);
    }

    //MODIFIES: this
    //EFFECTS: removes all the dog breeds that are intelligent
    public void filterNotIntelligent() {
        data.removeIf(db -> db.getIntelligence() == 1);
    }

    //MODIFIES: this
    //EFFECTS: adds db to this
    public void add(DogBreed db) {
        data.add(db);
    }

    //EFFECTS: returns true if the dog breed set is empty, other wise returns false
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //EFFECTS: returns the size of the dog breed set
    public Integer size() {
        return data.size();
    }

    //EFFECTS: returns the dog breed at the given index
    public DogBreed get(int index) {
        return data.get(index);
    }

}
