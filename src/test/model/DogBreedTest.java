package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DogBreedTest {
     private DogBreed testDogBreed;

     @BeforeEach
    public void  setUp() {
         testDogBreed =  new DogBreed("American Eskimo", 1, "medium", 1,
                 1, 1, 1, 1, 1);
     }

     @Test
    public void testGetters() {

     }
}
