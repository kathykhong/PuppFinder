package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

//test class for WishList

public class WishListTest {
    private WishList testWishList;
    private DogBreed testDogBreed1;
    private DogBreed testDogBreed2;
    private DogBreed testDogBreed3;

    @BeforeEach
    public void setUp() {
        testWishList = new WishList();
        testDogBreed1 = new DogBreed("Test Dog 1", 1, "small", 1, 1, 1, 1, 1, 1,
                new ImageIcon("./data/australianCattleDog.jpg"), new File("./data/australianCattleDog.txt"));
        testDogBreed2 = new DogBreed("Test Dog 2", 1, "medium", 0, 0, 0, 0, 0, 0,
                new ImageIcon("./data/americanPitbullTerrier.jpg"), new File("./data/americanPitbullTerrier.txt"));
        testDogBreed3 = new DogBreed("Test Dog 3", 1, "small", 0, 0, 1, 0, 1, 1,
                new ImageIcon("./data/americanPitbullTerrier.jpg"), new File("./data/americanPitbullTerrier.txt"));
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

    @Test
    public void testRemove() {
        testWishList.add(testDogBreed1);
        testWishList.add(testDogBreed2);
        assertEquals(testWishList.size(), 2);
        assertTrue(testWishList.contains(testDogBreed1));
        assertTrue(testWishList.contains(testDogBreed2));

        testWishList.remove(testDogBreed2);
        assertEquals(testWishList.size(), 1);
        assertTrue(testWishList.contains(testDogBreed1));
        assertFalse(testWishList.contains(testDogBreed2));

    }

    @Test
    public void testGet() {
        testWishList.add(testDogBreed1);
        testWishList.add(testDogBreed2);
        testWishList.add(testDogBreed3);
        assertEquals(testWishList.get(2), testDogBreed3);
        assertEquals(testWishList.get(2).getName(), "Test Dog 3");
    }
}
