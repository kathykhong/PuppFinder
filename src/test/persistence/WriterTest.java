package persistence;

import model.DogBreed;
import model.WishList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    public static final String TEST_FILE_WISH_LIST= "./data/testWriteWishList.txt";
    private Writer testWriter;
    private WishList wishList;

    @BeforeEach
    public void setUp() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE_WISH_LIST));
        DogBreed dogBreed1 = new DogBreed("German Pinscher", 0, "medium", 1,
                1, 0, 1, 0, 1);
        DogBreed dogBreed2 = new DogBreed("Gordon Setter", 1, "large", 1,
                1, 0, 1, 1, 1);
        wishList = new WishList();
        wishList.add(dogBreed1);
        wishList.add(dogBreed2);

    }

    @Test
    public void testWriteWishList() {
        //saving wish list to file
        for (int i = 0; i < wishList.size(); i++) {
            testWriter.write(wishList.get(i));
        }
        testWriter.close();

    //verify that wish list have expected components
        try {
            WishList wishList = Reader.readWishList(new File(TEST_FILE_WISH_LIST));
            DogBreed dogBreed1 = wishList.get(0);
            checkDogBreed1Getter(dogBreed1);
            DogBreed dogBreed2 = wishList.get(1);
            checkDogBreed2Getter(dogBreed2);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


    private void checkDogBreed2Getter(DogBreed dogBreed2) {
        assertEquals(dogBreed2.getName(), "Gordon Setter");
        assertEquals(dogBreed2.getFluff(), 1);
        assertEquals(dogBreed2.getSize(), "large");
        assertEquals(dogBreed2.getEnergetic(), 1);
        assertEquals(dogBreed2.getShedALot(), 1);
        assertEquals(dogBreed2.getDogFriendly(), 0);
        assertEquals(dogBreed2.getKidFriendly(), 1);
        assertEquals(dogBreed2.getStrangerFriendly(), 1);
        assertEquals(dogBreed2.getIntelligence(), 1);
    }

    private void checkDogBreed1Getter(DogBreed dogBreed1) {
        assertEquals(dogBreed1.getName(), "German Pinscher");
        assertEquals(dogBreed1.getFluff(), 0);
        assertEquals(dogBreed1.getSize(), "medium");
        assertEquals(dogBreed1.getEnergetic(), 1);
        assertEquals(dogBreed1.getShedALot(), 1);
        assertEquals(dogBreed1.getDogFriendly(), 0);
        assertEquals(dogBreed1.getKidFriendly(), 1);
        assertEquals(dogBreed1.getStrangerFriendly(), 0);
        assertEquals(dogBreed1.getIntelligence(), 1);
    }

}
