package model;

import java.util.ArrayList;
import java.util.Iterator;

public class DogBreedSet {
    private ArrayList<DogBreed> data;


    public DogBreedSet() {
        this.data = new ArrayList<DogBreed>();
    }

    public void filterFluffy() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getFluff() == 0) {
                iter.remove();
            }
        }
    }


    public void filterNonFluffy() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getFluff() == 1) {
                iter.remove();
            }
        }
    }


    public void filterSmall() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getSize() != "small") {
                iter.remove();
            }
        }
    }

    public void filterMedium() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getSize() != "medium") {
                iter.remove();
            }
        }
    }

    public void filterLarge() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getSize() != "large") {
                iter.remove();
            }
        }
    }

    public void filterEnergetic() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getEnergetic() == 0) {
                iter.remove();
            }
        }
    }

    public void filterNonEnergetic() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getEnergetic() == 1) {
                iter.remove();
            }
        }
    }

    public void filterShedALot() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getShedALot() == 0) {
                iter.remove();
            }
        }
    }

    public void filterShedALittle() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getShedALot() == 1) {
                iter.remove();
            }
        }
    }

    public void filterDogFriendly() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getDogFriendly() == 0) {
                iter.remove();
            }
        }
    }

    public void filterNotDogFriendly() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getDogFriendly() == 1) {
                iter.remove();
            }
        }
    }

    public void filterKidFriendly() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getKidFriendly() == 0) {
                iter.remove();
            }
        }
    }

    public void filterNotKidFriendly() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getKidFriendly() == 1) {
                iter.remove();
            }
        }
    }

    public void filterStrangerFriendly() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getStrangerFriendly() == 0) {
                iter.remove();
            }
        }
    }

    public void filterNotStrangerFriendly() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getStrangerFriendly() == 1) {
                iter.remove();
            }
        }
    }


    public void filterIntelligent() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getIntelligence() == 0) {
                iter.remove();
            }
        }
    }

    public void filterNotIntelligent() {
        Iterator<DogBreed> iter = data.iterator();
        while (iter.hasNext()) {
            DogBreed db = iter.next();
            if (db.getIntelligence() == 1) {
                iter.remove();
            }
        }
    }

    public void remove(DogBreed db) {
        data.remove(db);
    }

    public void add(DogBreed db) {
        data.add(db);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Integer size() {
        return data.size();
    }

    public DogBreed get(int index) {
        return data.get(index);
    }

}
