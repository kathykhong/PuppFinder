package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

//test class for DogBreedSet

public class DogBreedSetTest {
    private static final String SMALL_STRING = "small";
    private static final String MEDIUM_STRING = "medium";
    private static final String LARGE_STRING = "large";
    private DogBreedSet testSetAll;
    private DogBreed testDogBreed1;
    private DogBreed testDogBreed2;
    private DogBreed testDogBreed3;
    private DogBreed testDogBreed4;
    private DogBreed testDogBreed5;
    private DogBreed testDogBreed6;
    private DogBreed testDogBreed7;
    private DogBreed testDogBreed8;
    private DogBreed testDogBreed9;
    private DogBreedSet testSetEmpty;


    @BeforeEach
    public void setUp() {
        initializeDogBreeds();
        testSetAll = new DogBreedSet();
        testSetEmpty = new DogBreedSet();
        addAllDogBreedsToTestSet();
    }

    @Test
    public void testAdd() {
        assertTrue(testSetEmpty.isEmpty());
        testSetEmpty.add(testDogBreed1);
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.contains(testDogBreed1));
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.add(testDogBreed3);
        assertTrue(testSetEmpty.contains(testDogBreed2));
        assertTrue(testSetEmpty.contains(testDogBreed3));
    }

    @Test
    public void testGet() {
        assertEquals(testSetAll.get(0),testDogBreed1);
        assertEquals(testSetAll.get(0).getName(), "Test Dog 1");
    }

    @Test
    public void testFilterMultipleFluffy() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterFluffy();
        assertEquals(testSetAll.size(), 5 );
        assertTrue(testSetAll.containsFluffyOnly());
        assertFalse(testSetAll.containsNonFluffyOnly());
    }

    @Test
    public void testFilterOneFluffy() {
       testSetEmpty.add(testDogBreed1);
       testSetEmpty.add(testDogBreed4);
       testSetEmpty.filterFluffy();
       assertEquals(testSetEmpty.size(), 1);
       assertTrue(testSetEmpty.containsFluffyOnly());
       assertFalse(testSetEmpty.containsNonFluffyOnly());
    }

    @Test
    public void testFilterNoFluffy() {
        assertFalse(testSetEmpty.containsFluffyOnly());
        testSetEmpty.filterFluffy();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsFluffyOnly());
        testSetEmpty.add(testDogBreed4);
        testSetEmpty.filterFluffy();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsFluffyOnly());

    }

    @Test
    public void testFilterMultipleNonFluffy() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterNonFluffy();
        assertEquals(testSetAll.size(), 4 );
        assertTrue(testSetAll.containsNonFluffyOnly());
        assertFalse(testSetAll.containsFluffyOnly());
    }

    @Test
    public void testFilterOneNonFluffy() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed4);
        testSetEmpty.filterNonFluffy();
        assertEquals(testSetEmpty.size(), 1);
        assertTrue(testSetEmpty.containsNonFluffyOnly());
        assertFalse(testSetEmpty.containsFluffyOnly());
    }

    @Test
    public void testFilterNoNonFluffy() {
        assertFalse(testSetEmpty.containsNonFluffyOnly());
        testSetEmpty.filterNonFluffy();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonFluffyOnly());
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterNonFluffy();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonFluffyOnly());
    }

    @Test
    public void testFilterMultipleSmall() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterSize(SMALL_STRING);
        assertEquals(testSetAll.size(), 3 );
        assertTrue(testSetAll.containsSizeOnly(SMALL_STRING));
        assertFalse(testSetAll.containsSizeOnly(MEDIUM_STRING));
        assertFalse(testSetAll.containsSizeOnly(LARGE_STRING));
    }

    @Test
    public void testFilterOneSmall() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterSize(SMALL_STRING);
        assertEquals(testSetEmpty.size(), 1);
        assertTrue(testSetEmpty.containsSizeOnly(SMALL_STRING));
        assertFalse(testSetEmpty.containsSizeOnly(MEDIUM_STRING));
        assertFalse(testSetEmpty.containsSizeOnly(LARGE_STRING));
    }

    @Test
    public void testFilterNoSmall() {
        assertFalse(testSetEmpty.containsSizeOnly(SMALL_STRING));
        testSetEmpty.filterSize(SMALL_STRING);
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsSizeOnly(SMALL_STRING));
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterSize(SMALL_STRING);
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsSizeOnly(SMALL_STRING));
    }

    @Test
    public void testFilterMultipleMedium() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterSize(MEDIUM_STRING);
        assertEquals(testSetAll.size(), 3 );
        assertTrue(testSetAll.containsSizeOnly(MEDIUM_STRING));
        assertFalse(testSetAll.containsSizeOnly(LARGE_STRING));
        assertFalse(testSetAll.containsSizeOnly(SMALL_STRING));
    }

    @Test
    public void testFilterOneMedium() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterSize(MEDIUM_STRING);
        assertEquals(testSetEmpty.size(), 1);
        assertTrue(testSetEmpty.containsSizeOnly(MEDIUM_STRING));
        assertFalse(testSetEmpty.containsSizeOnly(LARGE_STRING));
        assertFalse(testSetEmpty.containsSizeOnly(SMALL_STRING));
    }

    @Test
    public void testFilterNoMedium() {
        assertFalse(testSetEmpty.containsSizeOnly(MEDIUM_STRING));
        testSetEmpty.filterSize(MEDIUM_STRING);
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsSizeOnly(MEDIUM_STRING));
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterSize(MEDIUM_STRING);
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsSizeOnly(MEDIUM_STRING));
    }

    @Test
    public void testFilterMultipleLarge() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterSize(LARGE_STRING);
        assertEquals(testSetAll.size(), 3 );
        assertTrue(testSetAll.containsSizeOnly(LARGE_STRING));
        assertFalse(testSetAll.containsSizeOnly(SMALL_STRING));
        assertFalse(testSetAll.containsSizeOnly(MEDIUM_STRING));
    }

    @Test
    public void testFilterOneLarge() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed5);
        testSetEmpty.filterSize(LARGE_STRING);
        assertEquals(testSetEmpty.size(), 1);
        assertTrue(testSetEmpty.containsSizeOnly(LARGE_STRING));
        assertFalse(testSetEmpty.containsSizeOnly(MEDIUM_STRING));
        assertFalse(testSetEmpty.containsSizeOnly(SMALL_STRING));
    }

    @Test
    public void testFilterNoLarge() {
        assertFalse(testSetEmpty.containsSizeOnly(LARGE_STRING));
        testSetEmpty.filterSize(LARGE_STRING);
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsSizeOnly(LARGE_STRING));
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterSize(LARGE_STRING);
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsSizeOnly(LARGE_STRING));
    }

    @Test
    public void testFilterMultipleEnergetic() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterEnergetic();
        assertEquals(testSetAll.size(), 4 );
        assertTrue(testSetAll.containsEnergeticOnly());
        assertFalse(testSetAll.containsNonEnergeticOnly());

    }

    @Test
    public void testFilterOneEnergetic() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterEnergetic();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsEnergeticOnly());
        assertFalse(testSetEmpty.containsNonEnergeticOnly());
    }

    @Test
    public void testFilterNoEnergetic() {
        assertFalse(testSetEmpty.containsEnergeticOnly());
        testSetEmpty.filterEnergetic();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsEnergeticOnly());
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterEnergetic();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsEnergeticOnly());
    }

    @Test
    public void testFilterMultipleNonEnergetic() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterNonEnergetic();
        assertEquals(testSetAll.size(), 5 );
        assertTrue(testSetAll.containsNonEnergeticOnly());
        assertFalse(testSetAll.containsEnergeticOnly());
    }

    @Test
    public void testFilterOneNonEnergetic() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNonEnergetic();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonEnergeticOnly());
        assertFalse(testSetEmpty.containsEnergeticOnly());
    }

    @Test
    public void testFilterNoNonEnergetic() {
        assertFalse(testSetEmpty.containsNonEnergeticOnly());
        testSetEmpty.filterNonEnergetic();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonEnergeticOnly());
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterNonEnergetic();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonEnergeticOnly());
    }

    @Test
    public void testFilterMultipleShedALot() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterShedALot();
        assertEquals(testSetAll.size(), 5 );
        assertTrue(testSetAll.containsShedALotOnly());
        assertFalse(testSetAll.containsShedALittleOnly());
    }

    @Test
    public void testFilterOneShedALot() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterShedALot();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsShedALotOnly());
        assertFalse(testSetEmpty.containsShedALittleOnly());
    }

    @Test
    public void testFilterNoShedALot() {
        assertFalse(testSetEmpty.containsShedALotOnly());
        testSetEmpty.filterShedALot();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsShedALotOnly());
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterShedALot();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsShedALotOnly());
    }

    @Test
    public void testFilterMultipleShedALittle() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterShedALittle();
        assertEquals(testSetAll.size(), 4 );
        assertTrue(testSetAll.containsShedALittleOnly());
        assertFalse(testSetAll.containsShedALotOnly());
    }

    @Test
    public void testFilterOneShedALittle() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterShedALittle();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsShedALittleOnly());
        assertFalse(testSetEmpty.containsShedALotOnly());
    }

    @Test
    public void testFilterNoShedALittle() {
        assertFalse(testSetEmpty.containsShedALittleOnly());
        testSetEmpty.filterShedALittle();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsShedALittleOnly());
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterShedALittle();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsShedALittleOnly());
    }

    @Test
    public void testFilterMultipleDogFriendly() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterDogFriendly();
        assertEquals(testSetAll.size(), 5 );
        assertTrue(testSetAll.containsDogFriendlyOnly());
        assertFalse(testSetAll.containsNonDogFriendlyOnly());
    }

    @Test
    public void testFilterOneDogFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterDogFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsDogFriendlyOnly());
        assertFalse(testSetEmpty.containsNonDogFriendlyOnly());
    }

    @Test
    public void testFilterNoDogFriendly() {
        assertFalse(testSetEmpty.containsDogFriendlyOnly());
        testSetEmpty.filterDogFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsDogFriendlyOnly());
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterDogFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsDogFriendlyOnly());
    }

    @Test
    public void testFilterMultipleNonDogFriendly() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterNotDogFriendly();
        assertEquals(testSetAll.size(), 4 );
        assertTrue(testSetAll.containsNonDogFriendlyOnly());
        assertFalse(testSetAll.containsDogFriendlyOnly());
    }

    @Test
    public void testFilterOneNonDogFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNotDogFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonDogFriendlyOnly());
        assertFalse(testSetEmpty.containsDogFriendlyOnly());
    }

    @Test
    public void testFilterNoNonDogFriendly() {
        assertFalse(testSetEmpty.containsNonDogFriendlyOnly());
        testSetEmpty.filterNotDogFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonDogFriendlyOnly());
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterNotDogFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonDogFriendlyOnly());
    }

    @Test
    public void testFilterMultipleKidFriendly() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterKidFriendly();
        assertEquals(testSetAll.size(), 5 );
        assertTrue(testSetAll.containsKidFriendlyOnly());
        assertFalse(testSetAll.containsNonKidFriendlyOnly());
    }

    @Test
    public void testFilterOneKidFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterKidFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsKidFriendlyOnly());
        assertFalse(testSetEmpty.containsNonKidFriendlyOnly());
    }

    @Test
    public void testFilterNoKidFriendly() {
        assertFalse(testSetEmpty.containsKidFriendlyOnly());
        testSetEmpty.filterKidFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsKidFriendlyOnly());
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterKidFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsKidFriendlyOnly());
    }

    @Test
    public void testFilterMultipleNonKidFriendly() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterNotKidFriendly();
        assertEquals(testSetAll.size(), 4 );
        assertTrue(testSetAll.containsNonKidFriendlyOnly());
        assertFalse(testSetAll.containsKidFriendlyOnly());

    }

    @Test
    public void testFilterOneNonKidFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNotKidFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonKidFriendlyOnly());
        assertFalse(testSetEmpty.containsKidFriendlyOnly());
    }

    @Test
    public void testFilterNoNonKidFriendly() {
        assertFalse(testSetEmpty.containsNonKidFriendlyOnly());
        testSetEmpty.filterNotKidFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonKidFriendlyOnly());
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterNotKidFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonKidFriendlyOnly());
    }

    @Test
    public void testFilterMultipleStrangerFriendly() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterStrangerFriendly();
        assertEquals(testSetAll.size(), 5 );
        assertTrue(testSetAll.containsStrangerFriendlyOnly());
        assertFalse(testSetAll.containsNonStrangerFriendlyOnly());
    }

    @Test
    public void testFilterOneStrangerFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterStrangerFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsStrangerFriendlyOnly());
        assertFalse(testSetEmpty.containsNonStrangerFriendlyOnly());
    }

    @Test
    public void testFilterNoStrangerFriendly() {
        assertFalse(testSetEmpty.containsStrangerFriendlyOnly());
        testSetEmpty.filterStrangerFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsStrangerFriendlyOnly());
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterStrangerFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsStrangerFriendlyOnly());
    }

    @Test
    public void testFilterMultipleNonStrangerFriendly() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterNotStrangerFriendly();
        assertEquals(testSetAll.size(), 4 );
        assertTrue(testSetAll.containsNonStrangerFriendlyOnly());
        assertFalse(testSetAll.containsStrangerFriendlyOnly());
    }

    @Test
    public void testFilterOneNonStrangerFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNotStrangerFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonStrangerFriendlyOnly());
        assertFalse(testSetEmpty.containsStrangerFriendlyOnly());
    }

    @Test
    public void testFilterNoNonStrangerFriendly() {
        assertFalse(testSetEmpty.containsStrangerFriendlyOnly());
        testSetEmpty.filterNotStrangerFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonStrangerFriendlyOnly());
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterNotStrangerFriendly();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonStrangerFriendlyOnly());
    }

    @Test
    public void testFilterMultipleIntelligent() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterIntelligent();
        assertEquals(testSetAll.size(), 5 );
        assertTrue(testSetAll.containsIntelligentOnly());
        assertFalse(testSetAll.containsNonIntelligentOnly());
    }

    @Test
    public void testFilterOneIntelligent() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterIntelligent();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsIntelligentOnly());
        assertFalse(testSetAll.containsNonIntelligentOnly());
    }

    @Test
    public void testFilterNoIntelligent() {
        assertFalse(testSetEmpty.containsIntelligentOnly());
        testSetEmpty.filterIntelligent();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsIntelligentOnly());
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterIntelligent();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsIntelligentOnly());
    }

    @Test
    public void testFilterMultipleNonIntelligent() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterNotIntelligent();
        assertEquals(testSetAll.size(), 4 );
        assertTrue(testSetAll.containsNonIntelligentOnly());
        assertFalse(testSetAll.containsIntelligentOnly());
    }

    @Test
    public void testFilterOneNonIntelligent() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNotIntelligent();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonIntelligentOnly());
        assertFalse(testSetEmpty.containsIntelligentOnly());
    }

    @Test
    public void testFilterNoNonIntelligent() {
        assertFalse(testSetEmpty.containsNonIntelligentOnly());
        testSetEmpty.filterNotIntelligent();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonIntelligentOnly());
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterNotIntelligent();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsNonIntelligentOnly());
    }

    private void initializeDogBreeds() {
        testDogBreed1 = new DogBreed("Test Dog 1", 1, "small", 1, 1, 1, 1,1,1,
                new ImageIcon("./data/australianCattleDog.jpg"), new File("./data/australianCattleDog.txt"));
        testDogBreed2 = new DogBreed("Test Dog 2", 1, "medium", 0, 0, 0, 0,0,0,
                new ImageIcon("./data/americanPitbullTerrier.jpg"), new File("./data/americanPitbullTerrier.txt"));
        testDogBreed3 = new DogBreed("Test Dog 3", 1, "small", 0, 0, 1, 0,1,1,
                new ImageIcon("./data/americanPitbullTerrier.jpg"), new File("./data/americanPitbullTerrier.txt"));
        testDogBreed4 = new DogBreed("Test Dog 4", 0, "medium", 1, 1, 0, 1,1,0,
                new ImageIcon("./data/boxer.png"), new File("./data/boxer.txt"));
        testDogBreed5 = new DogBreed("Test Dog 5", 0, "large", 0, 1, 1, 1,0,0,
                new ImageIcon("./data/drever.jpg"), new File("./data/drever.txt"));
        testDogBreed6 = new DogBreed("Test Dog 6", 0, "large", 1, 0, 0, 0,0,1,
                new ImageIcon("./data/germanPinscher.jpg"), new File("./data/germanPinscher.txt"));
        testDogBreed7 = new DogBreed("Test Dog 7", 1, "small", 0, 1, 1, 1,1,1,
                new ImageIcon("./data/ibizanHound.jpg"), new File("./data/ibizanHound.txt"));
        testDogBreed8 = new DogBreed("Test Dog 8", 0, "medium", 1, 0, 0, 0,0,0,
                new ImageIcon("./data/vizsla.jpg"), new File("./data/vizsla.txt"));
        testDogBreed9 = new DogBreed("Test Dog 9", 1, "large", 0, 1, 1, 1,1,1,
                new ImageIcon("./data/spanishMastiff.jpg"), new File("./data/spanishMastiff.txt"));
    }

    private void addAllDogBreedsToTestSet() {
        testSetAll.add(testDogBreed1);
        testSetAll.add(testDogBreed2);
        testSetAll.add(testDogBreed3);
        testSetAll.add(testDogBreed4);
        testSetAll.add(testDogBreed5);
        testSetAll.add(testDogBreed6);
        testSetAll.add(testDogBreed7);
        testSetAll.add(testDogBreed8);
        testSetAll.add(testDogBreed9);
    }
}
