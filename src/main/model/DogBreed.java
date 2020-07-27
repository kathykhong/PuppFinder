package model;

//* Class represents a dog breed that contains a name and a variety of characteristics
//including fluff, size, level of energy, dog-friendliness, kid-friendliness,
//stranger-friendliness, level of shedding, and intelligence

public class DogBreed {
    private String name;
    private int fluff;
    private String size;
    private int energetic;
    private int dogFriendly;
    private int kidFriendly;
    private int strangerFriendly;
    private int intelligence;
    private int shedALot;

    //EFFECTS : constructs DogBreed with given name and numerous characteristics
    public DogBreed(String name,
                    Integer fluff,
                    String size,
                    Integer energetic,
                    Integer shedALot,
                    Integer dogFriendly,
                    Integer kidFriendly,
                    Integer strangerFriendly,
                    Integer intelligence) {
        this.name = name;
        this.fluff = fluff;
        this.size = size;
        this.dogFriendly = dogFriendly;
        this.kidFriendly = kidFriendly;
        this.strangerFriendly = strangerFriendly;
        this.shedALot = shedALot;
        this.intelligence = intelligence;
        this.energetic = energetic;

    }

    //GETTERS:
    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public Integer getFluff() {
        return fluff;
    }

    public Integer getDogFriendly() {
        return dogFriendly;
    }

    public Integer getStrangerFriendly() {
        return strangerFriendly;
    }

    public Integer getKidFriendly() {
        return kidFriendly;
    }

    public Integer getEnergetic() {
        return energetic;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public Integer getShedALot() {
        return shedALot;
    }

}

