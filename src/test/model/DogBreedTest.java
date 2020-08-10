package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

//test class for Dog Breed

public class DogBreedTest {
     private DogBreed testDogBreed;

     @BeforeEach
    public void  setUp() {
         testDogBreed =  new DogBreed("Test Dog Breed", 1, "medium", 0, 1, 0, 0, 1,
                 1, new ImageIcon("./data/spanishMastiff.jpg"), new File("./data/spanishMastiff.txt"));
     }

     @Test
    public void testGetters() {
         assertEquals(testDogBreed.getName(), "Test Dog Breed");
         assertEquals(testDogBreed.getFluff(), 1);
         assertEquals(testDogBreed.getSize(), "medium");
         assertEquals(testDogBreed.getShedALot(), 1);
         assertEquals(testDogBreed.getDogFriendly(), 0);
         assertEquals(testDogBreed.getKidFriendly(), 0);
         assertEquals(testDogBreed.getStrangerFriendly(), 1);
         assertEquals(testDogBreed.getIntelligence(), 1);
         assertEquals(testDogBreed. getImageFile().toString(), "./data/spanishMastiff.jpg");
         assertEquals(testDogBreed.getTextInfo().toString(),"./data/spanishMastiff.txt");


     }
}
