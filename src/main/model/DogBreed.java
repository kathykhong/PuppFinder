package model;


import java.awt.*;
import java.io.File;


public class DogBreed {
    private String name;
    private int fluff;
    private String size;
    private int energetic;
    private int noisy;
    private int dogFriendly;
    private int kidFriendly;
    private int strangerFriendly;
    private int intelligence;
    private int shedALot;
    private File briefDescription;
    private Image picture;
    private int liked;

    //EFFECTS : constructs DogBreed with given name, characteristics, description, picture and like status
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
        briefDescription = null;
        picture = null;
        liked = 0;
    }

    //GETTERS;
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

    public Integer getNoisy() {
        return noisy;
    }

    public Integer getShedALot() {
        return shedALot;
    }

    public Image getPicture() {
        return picture;
    }

    public File getBriefDescription() {
        return briefDescription;
    }

    public Integer isLiked() {
        return liked;
    }

    //SETTERS

    public void setBriefDescription(File briefDescription) {
        this.briefDescription = briefDescription;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }

    public void like() {
        this.liked = 1;
    }





}

