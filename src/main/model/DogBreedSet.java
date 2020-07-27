package model;

import java.util.ArrayList;

//*Class represents a set of dog breeds- most likely will be used to narrow down
//user characteristic preferences


public class DogBreedSet {
    private ArrayList<DogBreed> data;


    public DogBreedSet() {
        this.data = new ArrayList<>();
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

    //EFFECTS: returns true if the given db is in the dog breed set
    public Boolean contains(DogBreed db) {
        return data.contains(db);
    }

    //EFFECTS: returns the size of the dog breed set
    public Integer size() {
        return data.size();
    }

    //EFFECTS: returns the dog breed at the given index
    public DogBreed get(int index) {
        return data.get(index);
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

    //EFFECTS: returns true if the dog breed set contains only fluffy dogs
    public boolean containsFluffyOnly() {
        int fluffyCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getFluff() == 1) {
                    fluffyCount = fluffyCount + 1;
                }
            }
            return fluffyCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only non -fluffy dogs
    public boolean containsNonFluffyOnly() {
        int nonFluffyCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getFluff() == 0) {
                    nonFluffyCount = nonFluffyCount + 1;
                }
            }
            return nonFluffyCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only small dogs
    public boolean containsSmallOnly() {
        int smallCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getSize().equals("small")) {
                    smallCount = smallCount + 1;
                }
            }
            return smallCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only medium dogs
    public boolean containsMediumOnly() {
        int mediumCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getSize().equals("medium")) {
                    mediumCount = mediumCount + 1;
                }
            }
            return mediumCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only large dogs
    public boolean containsLargeOnly() {
        int largeCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getSize().equals("large")) {
                    largeCount = largeCount + 1;
                }
            }
            return largeCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only energetic dogs
    public boolean containsEnergeticOnly() {
        int energeticCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getEnergetic() == 1) {
                    energeticCount = energeticCount + 1;
                }
            }
            return energeticCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only non-energetic dogs
    public boolean containsNonEnergeticOnly() {
        int nonEnergeticCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getEnergetic() == 0) {
                    nonEnergeticCount = nonEnergeticCount + 1;
                }
            }
            return nonEnergeticCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only dogs that shed a lot
    public boolean containsShedALotOnly() {
        int shedALotCount  = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getShedALot() == 1) {
                    shedALotCount = shedALotCount + 1;
                }
            }
            return shedALotCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only dogs that shed a little
    public boolean containsShedALittleOnly() {
        int shedALittleCount  = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getShedALot() == 0) {
                    shedALittleCount = shedALittleCount + 1;
                }
            }
            return shedALittleCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only DogFriendly dogs
    public boolean containsDogFriendlyOnly() {
        int dogFriendlyCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getDogFriendly() == 1) {
                    dogFriendlyCount = dogFriendlyCount + 1;
                }
            }
            return dogFriendlyCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only non Dog-Friendly dogs
    public boolean containsNonDogFriendlyOnly() {
        int nonDogFriendlyCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getDogFriendly() == 0) {
                    nonDogFriendlyCount = nonDogFriendlyCount + 1;
                }
            }
            return nonDogFriendlyCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only Kid-Friendly dogs
    public boolean containsKidFriendlyOnly() {
        int kidFriendlyCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getKidFriendly() == 1) {
                    kidFriendlyCount = kidFriendlyCount + 1;
                }
            }
            return kidFriendlyCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only non Kid-Friendly dogs
    public boolean containsNonKidFriendlyOnly() {
        int nonKidFriendlyCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getKidFriendly() == 0) {
                    nonKidFriendlyCount = nonKidFriendlyCount + 1;
                }
            }
            return nonKidFriendlyCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only Stranger-Friendly dogs
    public boolean containsStrangerFriendlyOnly() {
        int strangerFriendlyCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getStrangerFriendly() == 1) {
                    strangerFriendlyCount = strangerFriendlyCount + 1;
                }
            }
            return strangerFriendlyCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only non Stranger-Friendly dogs
    public boolean containsNonStrangerFriendlyOnly() {
        int nonStrangerFriendlyCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getStrangerFriendly() == 0) {
                    nonStrangerFriendlyCount = nonStrangerFriendlyCount + 1;
                }
            }
            return nonStrangerFriendlyCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only intelligent dogs
    public boolean containsIntelligentOnly() {
        int intelligentCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getIntelligence() == 1) {
                    intelligentCount = intelligentCount + 1;
                }
            }
            return intelligentCount == data.size();
        }
    }

    //EFFECTS: returns true if the dog breed set contains only non-intelligent dogs
    public boolean containsNonIntelligentOnly() {
        int nonIntelligentCount = 0;
        if (data.size() == 0) {
            return false;
        } else {
            for (DogBreed datum : data) {
                if (datum.getIntelligence() == 0) {
                    nonIntelligentCount = nonIntelligentCount + 1;
                }
            }
            return nonIntelligentCount == data.size();
        }
    }
}
