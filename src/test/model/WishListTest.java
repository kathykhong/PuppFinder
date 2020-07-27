package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WishListTest {
    private WishList testWishList;
    private DogBreed testDogBreed1;
    private DogBreed testDogBreed2;
    private DogBreed testDogBreed3;

    @BeforeEach
    public void setUp() {
        testWishList = new WishList();
        testDogBreed1 = new DogBreed("Test Dog 1", 1, "small", 1, 1,
                1, 1,1,1);
        testDogBreed2 = new DogBreed("Test Dog 2", 1, "medium", 0, 0,
                0, 0,0,0);
        testDogBreed3 = new DogBreed("Test Dog 3", 1, "small", 0, 0,
                1, 0,1,1);
    }

    @Test
    public void testAdd() {
        assertTrue(testWishList.isEmpty());
        testWishList.add(testDogBreed1);
        assertEquals(testWishList.size(), 1);
        assertTrue(testWishList.contains(testDogBreed1));

        testWishList.add(testDogBreed2);
        testWishList.add(testDogBreed3);
        assertEquals(testWishList.size(), 3);
        assertTrue(testWishList.contains(testDogBreed2));
        assertTrue(testWishList.contains(testDogBreed3));
    }
}
