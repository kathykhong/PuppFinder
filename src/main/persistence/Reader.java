package persistence;

import model.DogBreed;
import model.DogBreedSet;
import model.WishList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A reader that can read the saved wish list and
//the dog breed data from file when app launches
//***Parsing methods and read methods source: TellerApp
//https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
public class Reader {
    public static final String DELIMITER = ",";

    //EFFECTS: returns the initial DogBreedSet parsed from file;
    //throws IOException if an exception is raised when opening/reading from file
    public static DogBreedSet readDogBreadSet(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseDogBreedSetContent(fileContent);
    }

    private static DogBreedSet parseDogBreedSetContent(List<String> fileContent) {
        DogBreedSet initialDogBreedSet = new DogBreedSet();
        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            initialDogBreedSet.add(parseDogBreed(lineComponents));
        }
        return initialDogBreedSet;
    }


    //EFFECTS: returns  the result of the WishList parsed from file;
    //throws IOException if an exception is raised when opening/reading from file
    public static WishList readWishList(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseWishListContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    private static WishList parseWishListContent(List<String> fileContent) {
        WishList wishList = new WishList();
        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            wishList.add(parseDogBreed(lineComponents));
        }
        return wishList;
    }


    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    //REQUIRES:components has size 9, where element 0 represents the name of the dog breed,
    //element 1 represents the the fluffiness, element 3 represents the size, element
    // 4,5,6,7,8,9 represents whether or not the dog is energetic, shedsALot, dogFriendly,
    // kidFriendly, stranger friendly, and intelligent, respectively
    private static DogBreed parseDogBreed(List<String> components) {
        String name = components.get(0);
        int fluffiness = Integer.parseInt(components.get(1));
        String size = components.get(2);
        int isEnergetic = Integer.parseInt(components.get(3));
        int doesShedALot = Integer.parseInt(components.get(4));
        int isDogFriendly = Integer.parseInt(components.get(5));
        int isKidFriendliness = Integer.parseInt(components.get(6));
        int isStrangerFriendly = Integer.parseInt(components.get(7));
        int isIntelligent = Integer.parseInt(components.get(8));
        return new DogBreed(name, fluffiness, size, isEnergetic, doesShedALot,
                isDogFriendly, isKidFriendliness, isStrangerFriendly, isIntelligent);
    }
}

