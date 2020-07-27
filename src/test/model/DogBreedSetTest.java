package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DogBreedSetTest {
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
    public void testFilterMultipleFluffy() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterFluffy();
        assertEquals(testSetAll.size(), 5 );
        assertTrue(testSetAll.containsFluffyOnly());
    }

    @Test
    public void testFilterOneFluffy() {
       testSetEmpty.add(testDogBreed1);
       testSetEmpty.add(testDogBreed4);
       testSetEmpty.filterFluffy();
       assertEquals(testSetEmpty.size(), 1);
       assertTrue(testSetEmpty.containsFluffyOnly());
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

    }

    @Test
    public void testFilterOneNonFluffy() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed4);
        testSetEmpty.filterNonFluffy();
        assertEquals(testSetEmpty.size(), 1);
        assertTrue(testSetEmpty.containsNonFluffyOnly());
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
        testSetAll.filterSmall();
        assertEquals(testSetAll.size(), 3 );
        assertTrue(testSetAll.containsSmallOnly());
    }

    @Test
    public void testFilterOneSmall() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterSmall();
        assertEquals(testSetEmpty.size(), 1);
        assertTrue(testSetEmpty.containsSmallOnly());
    }

    @Test
    public void testFilterNoSmall() {
        assertFalse(testSetEmpty.containsSmallOnly());
        testSetEmpty.filterSmall();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsSmallOnly());
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterSmall();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsSmallOnly());
    }

    @Test
    public void testFilterMultipleMedium() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterMedium();
        assertEquals(testSetAll.size(), 3 );
        assertTrue(testSetAll.containsMediumOnly());
    }

    @Test
    public void testFilterOneMedium() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterMedium();
        assertEquals(testSetEmpty.size(), 1);
        assertTrue(testSetEmpty.containsMediumOnly());
    }

    @Test
    public void testFilterNoMedium() {
        assertFalse(testSetEmpty.containsSmallOnly());
        testSetEmpty.filterMedium();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsMediumOnly());
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterMedium();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsMediumOnly());
    }

    @Test
    public void testFilterMultipleLarge() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterLarge();
        assertEquals(testSetAll.size(), 3 );
        assertTrue(testSetAll.containsLargeOnly());
    }

    @Test
    public void testFilterOneLarge() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed5);
        testSetEmpty.filterLarge();
        assertEquals(testSetEmpty.size(), 1);
        assertTrue(testSetEmpty.containsLargeOnly());
    }

    @Test
    public void testFilterNoLarge() {
        assertFalse(testSetEmpty.containsLargeOnly());
        testSetEmpty.filterLarge();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsLargeOnly());
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.filterLarge();
        assertEquals(testSetEmpty.size(), 0);
        assertFalse(testSetEmpty.containsLargeOnly());
    }

    @Test
    public void testFilterMultipleEnergetic() {
        assertEquals(testSetAll.size(), 9);
        testSetAll.filterEnergetic();
        assertEquals(testSetAll.size(), 4 );
        assertTrue(testSetAll.containsEnergeticOnly());

    }

    @Test
    public void testFilterOneEnergetic() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterEnergetic();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsEnergeticOnly());
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

    }

    @Test
    public void testFilterOneNonEnergetic() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNonEnergetic();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonEnergeticOnly());
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

    }

    @Test
    public void testFilterOneShedALot() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterShedALot();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsShedALotOnly());
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

    }

    @Test
    public void testFilterOneShedALittle() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterShedALittle();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsShedALittleOnly());
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

    }

    @Test
    public void testFilterOneDogFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterDogFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsDogFriendlyOnly());
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

    }

    @Test
    public void testFilterOneNonDogFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNotDogFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonDogFriendlyOnly());
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

    }

    @Test
    public void testFilterOneKidFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterKidFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsKidFriendlyOnly());
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

    }

    @Test
    public void testFilterOneNonKidFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNotKidFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonKidFriendlyOnly());
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

    }

    @Test
    public void testFilterOneStrangerFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterStrangerFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsStrangerFriendlyOnly());
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

    }

    @Test
    public void testFilterOneNonStrangerFriendly() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNotStrangerFriendly();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonStrangerFriendlyOnly());
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

    }

    @Test
    public void testFilterOneIntelligent() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterIntelligent();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsIntelligentOnly());
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

    }

    @Test
    public void testFilterOneNonIntelligent() {
        testSetEmpty.add(testDogBreed1);
        testSetEmpty.add(testDogBreed2);
        testSetEmpty.filterNotIntelligent();
        assertEquals(testSetEmpty.size(),1);
        assertTrue(testSetEmpty.containsNonIntelligentOnly());
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
        testDogBreed1 = new DogBreed("Test Dog 1", 1, "small", 1, 1,
                1, 1,1,1);
        testDogBreed2 = new DogBreed("Test Dog 2", 1, "medium", 0, 0,
                0, 0,0,0);
        testDogBreed3 = new DogBreed("Test Dog 3", 1, "small", 0, 0,
                1, 0,1,1);
        testDogBreed4 = new DogBreed("Test Dog 4", 0, "medium", 1, 1,
                0, 1,1,0);
        testDogBreed5 = new DogBreed("Test Dog 5", 0, "large", 0, 1,
                1, 1,0,0);
        testDogBreed6 = new DogBreed("Test Dog 6", 0, "large", 1, 0,
                0, 0,0,1);
        testDogBreed7 = new DogBreed("Test Dog 7", 1, "small", 0, 1,
                1, 1,1,1);
        testDogBreed8 = new DogBreed("Test Dog 8", 0, "medium", 1, 0,
                0, 0,0,0);
        testDogBreed9 = new DogBreed("Test Dog 9", 1, "large", 0, 1,
                1, 1,1,1);
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