package persistence;

import model.DogBreed;
import model.DogBreedSet;
import model.WishList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//***Test code source: TellerApp
//https://github.students.cs.ubc.ca/CPSC210/TellerApp.git

public class ReaderTest {
    private Reader testReader;

    @BeforeEach
    public void setUp() {
        testReader = new Reader();
    }

    @Test
    public void testParseDogBreedFromWishList() {
        try {
            WishList testWishList = Reader.readWishList(new File("./data/testReadWishList.txt"));

            DogBreed dogBreed1 = testWishList.get(0);
            checkDogBreed1Getter(dogBreed1);
            DogBreed dogBreed2 = testWishList.get(1);
            checkDogBreed2Getter(dogBreed2);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testParseDogBreedFromDogBreedSet() {
        try {
            DogBreedSet dbSet = Reader.readDogBreadSet(new File ("./data/testReadDogBreeds.txt"));
            DogBreed dogBreed3 = dbSet.get(0);
            checkDogBreed3Getter(dogBreed3);
            DogBreed dogBreed4 = dbSet.get(1);
            checkDogBreed4Getter(dogBreed4);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testIOExceptionWishListFile (){
        try {
            Reader.readWishList(new File("./path/does/not/exist/testReadWishList.txt"));
            fail("Exception expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    public void testIOExceptionDogBreedFile (){
        try {
            Reader.readDogBreadSet(new File("./path/does/not/exist/testDogBreeds.txt"));
            fail("Exception expected");
        } catch (IOException e) {
            // expected
        }
    }


    private void checkDogBreed4Getter(DogBreed dogBreed4) {
        assertEquals(dogBreed4.getName(), "Pomeranian");
        assertEquals(dogBreed4.getFluff(), 1);
        assertEquals(dogBreed4.getSize(), "small");
        assertEquals(dogBreed4.getEnergetic(), 1);
        assertEquals(dogBreed4.getShedALot(), 1);
        assertEquals(dogBreed4.getDogFriendly(), 0);
        assertEquals(dogBreed4.getKidFriendly(), 0);
        assertEquals(dogBreed4.getStrangerFriendly(), 1);
        assertEquals(dogBreed4.getIntelligence(), 1);
    }

    private void checkDogBreed3Getter(DogBreed dogBreed3) {
        assertEquals(dogBreed3.getName(), "Pekingnese");
        assertEquals(dogBreed3.getFluff(), 1);
        assertEquals(dogBreed3.getSize(), "small");
        assertEquals(dogBreed3.getEnergetic(), 0);
        assertEquals(dogBreed3.getShedALot(), 0);
        assertEquals(dogBreed3.getDogFriendly(), 0);
        assertEquals(dogBreed3.getKidFriendly(), 0);
        assertEquals(dogBreed3.getStrangerFriendly(), 0);
        assertEquals(dogBreed3.getIntelligence(), 1);
    }

    private void checkDogBreed2Getter(DogBreed dogBreed2) {
        assertEquals(dogBreed2.getName(), "Bearded Collie");
        assertEquals(dogBreed2.getFluff(), 1);
        assertEquals(dogBreed2.getSize(), "large");
        assertEquals(dogBreed2.getEnergetic(), 1);
        assertEquals(dogBreed2.getShedALot(), 1);
        assertEquals(dogBreed2.getDogFriendly(), 1);
        assertEquals(dogBreed2.getKidFriendly(), 1);
        assertEquals(dogBreed2.getStrangerFriendly(), 1);
        assertEquals(dogBreed2.getIntelligence(), 1);
    }

    private void checkDogBreed1Getter(DogBreed dogBreed1) {
        assertEquals(dogBreed1.getName(), "Yorkshire Terrier");
        assertEquals(dogBreed1.getFluff(), 1);
        assertEquals(dogBreed1.getSize(), "small");
        assertEquals(dogBreed1.getEnergetic(), 1);
        assertEquals(dogBreed1.getShedALot(), 0);
        assertEquals(dogBreed1.getDogFriendly(), 1);
        assertEquals(dogBreed1.getKidFriendly(), 1);
        assertEquals(dogBreed1.getStrangerFriendly(), 0);
        assertEquals(dogBreed1.getIntelligence(), 1);
    }


}
