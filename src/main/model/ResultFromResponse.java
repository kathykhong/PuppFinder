package model;

import java.util.ArrayList;

public class ResultFromResponse {

    private ArrayList<DogBreed> result;

    public ResultFromResponse() {
        this.result = new ArrayList<DogBreed>();
    }

    //MODIFIES:this
    //EFFECTS
    public void addDogBreed(DogBreed dogBreed) {
        result.add(dogBreed);
    }


}
