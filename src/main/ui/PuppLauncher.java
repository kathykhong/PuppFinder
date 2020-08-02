package ui;


import model.DogBreedSet;
import model.WishList;
import persistence.Reader;
import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

//Class represents the PuppFinder application
//contains all dog breed data
//manages all the user inputs

public class PuppLauncher {
    private static final String WISH_LIST_FILE = "./data/wishList.txt";
    private static final String DOG_BREED_SET_FILE = "./data/initalDogBreeds.txt";

    DogBreedSet dbs = new DogBreedSet();
    WishList wishList;
    private static final String VIEW_COMMAND = "view";
    private static final String CONTINUE_COMMAND = "continue";
    private static final String QUIT_COMMAND = "quit";
    private static final String SMALL_COMMAND = "small";
    private static final String MEDIUM_COMMAND = "medium";
    private static final String LARGE_COMMAND = "large";
    private static final String YES_COMMAND = "yes";
    private static final String NO_COMMAND = "no";
    private static final String ENERGETIC_COMMAND = "energetic";
    private static final String CALM_COMMAND = "calm";
    private static final String DOESNT_MATTER_COMMAND = "doesn't matter";

    private Scanner input;
    private boolean runProgram;

    //Source: code from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    public PuppLauncher() {
        input = new Scanner(System.in);
        runProgram = true;
    }

    //MODIFIES: this
    //EFFECTS: runs the PuppFinder Application
    public void runPuppFinderApp() {
        loadInitialDogBreedSet();
        loadWishList();
        handleUserResponseToWelcome();


    }

    // MODIFIES: this
    // EFFECTS: loads the wish list from the WISH_LIST_FILE
    //Source code from TellerApp
    ////https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
    private void loadWishList() {
        try {
            this.wishList = Reader.readWishList(new File(WISH_LIST_FILE));
        } catch (IOException e) {
            initializeWishList();
        }
    }

    //MODIFIES: this
    //EFFECT: loads the initial dog breed set
    //Source code from TellerApp
    ////https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
    private void loadInitialDogBreedSet() {
        try {
            this.dbs = Reader.readDogBreadSet(new File(DOG_BREED_SET_FILE));
        } catch (IOException e) {
            System.out.println("No data found");
        }
    }

    //MODIFIES: this
    //EFFECTS: initializes the wish list
    private void initializeWishList() {
        this.wishList = new WishList();

    }

    //EFFECTS: saves the state of the wish list to the WISH_LIST_FILE
    //Source code from TellerApp
    ////https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
    private void saveWishList() {
        try {
            Writer writer = new Writer(new File(WISH_LIST_FILE));
            for (int i = 0; i < wishList.size(); i++) {
                writer.write(wishList.get(i));
            }

            writer.close();
            System.out.println("Wish List is saved to file:  " + WISH_LIST_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save Wish List to " + WISH_LIST_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            //due to programming error
        }

    }

    //EFFECTS: prints out welcome message and processes user input
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToWelcome() {
        System.out.println("Welcome to PuppFinder!");
        System.out.println("We are here to help you find your perfect beloved pup in no time!");
        System.out.println("Enter 'view' to see your WishList");
        System.out.println("Enter 'quit' to leave PuppFinder");
        System.out.println("Enter 'continue' to get started!");

        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputStart(str);
        }
    }


    //EFFECTS: begins questionaire depending on user input
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputStart(String str) {
        if (str.length() > 0) {
            switch (str) {
                case CONTINUE_COMMAND:
                    handleUserResponseToFluff();
                    break;
                case QUIT_COMMAND:
                    handleUserResponseToEnd();
                case VIEW_COMMAND:
                    handleUserResponseToSavedWishList();

            }
        }
    }

    //EFFECTS: prints out saved wishList and prompts user options to
    //quit or begin questionaire
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void handleUserResponseToSavedWishList() {
        if (!wishList.isEmpty()) {
            System.out.println("Here is your wish list:");
            printWishListDogBreedNames();
            System.out.println("If you think your preferences have changed: ");
        } else {
            System.out.println("There are no dog breeds in the Wish List");
        }
        System.out.println("Enter 'continue' to begin our questionaire");
        System.out.println("Enter 'quit' to end the application");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputSavedWishList(str);

        }
    }

    //EFFECTS: depending on user input either ends program or begins questionaire
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputSavedWishList(String str) {
        if (str.length() > 0) {
            switch (str) {
                case CONTINUE_COMMAND:
                    handleUserResponseToFluff();
                    break;
                case QUIT_COMMAND:
                    endProgram();
                    break;
            }
        }
    }

    //EFFECTS: prompts user to select fluffiness preference
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToFluff() {
        System.out.println("Please enter 'yes' or 'no' to the following question");
        System.out.println("Would you like your dog to be fluffy?");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputFluff(str);

        }
    }

    //EFFECTS: filters out the fluffy or non-fluffy dog breeds depending on user input and proceeds to nest question
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputFluff(String str) {
        if (str.length() > 0) {
            switch (str) {
                case YES_COMMAND:
                    dbs.filterFluffy();
                    break;
                case NO_COMMAND:
                    dbs.filterNonFluffy();
                    break;
                case DOESNT_MATTER_COMMAND:
                    break;
            }
        }
        handleUserResponseToSize();
    }

    //EFFECTS: prompts user to select size preference
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToSize() {
        System.out.println("Do you prefer small dogs (<=25 lbs), medium dogs (26-45 lbs), or large dogs (46lbs +) ?");
        System.out.println("Please enter 'small', 'medium', 'large', or 'doesn't matter' for your response");
        System.out.println("Size guide: ");
        System.out.println("Small dogs: ~4-25 lbs");
        System.out.println("Medium dogs: ~25-45 lbs ");
        System.out.println("Large dogs: 45+ lbs ");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputSize(str);

        }
    }

    //EFFECTS: filters out the small, medium, or large dog breeds depending on user input and proceeds to next question
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputSize(String str) {
        if (str.length() > 0) {
            switch (str) {
                case SMALL_COMMAND:
                    dbs.filterSmall();
                    break;
                case MEDIUM_COMMAND:
                    dbs.filterMedium();
                    break;
                case LARGE_COMMAND:
                    dbs.filterLarge();
                    break;
                case DOESNT_MATTER_COMMAND:
                    break;
            }
        }
        handleUserResponseToEnergetic();
    }

    //EFFECTS: prompts user to select preference to energy levels
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToEnergetic() {
        System.out.println("Would you like your dog to be energetic or calm?");
        System.out.println("Please enter 'energetic', 'calm' or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputEnergetic(str);
        }
    }

    //EFFECTS: filters out the energetic or calm dog breeds depending on user input and proceeds to next question
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputEnergetic(String str) {
        if (str.length() > 0) {
            switch (str) {
                case ENERGETIC_COMMAND:
                    dbs.filterEnergetic();
                    break;
                case CALM_COMMAND:
                    dbs.filterNonEnergetic();
                    break;
                case DOESNT_MATTER_COMMAND:
                    break;
            }
        }
        handleUserResponseToShedALot();
    }

    //EFFECTS: prompts user to select preference for shedding
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToShedALot() {
        System.out.println("Are you comfortable with your dog shedding a lot?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputShedALot(str);
        }
    }

    //EFFECTS: filters out the dog breeds that shed a lot or a little depending on
    // user input and proceeds to next question
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputShedALot(String str) {
        if (str.length() > 0) {
            switch (str) {
                case YES_COMMAND:
                    dbs.filterShedALot();
                    break;
                case NO_COMMAND:
                    dbs.filterShedALittle();
                    break;
                case DOESNT_MATTER_COMMAND:
                    break;
            }
        }
        handleUserResponseToDogFriendly();
    }

    //EFFECTS: prompts user to select preference for friendliness between dogs
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToDogFriendly() {
        System.out.println("Do you prefer your dog to be friendly with other dogs ?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputDogFriendly(str);
        }
    }

    //EFFECTS: filters out the dog-friendly or not dog-friendly dog breeds
    // depending on user input and proceeds to next question
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputDogFriendly(String str) {
        if (str.length() > 0) {
            switch (str) {
                case YES_COMMAND:
                    dbs.filterDogFriendly();
                    break;
                case NO_COMMAND:
                    dbs.filterNotDogFriendly();
                    break;
                case DOESNT_MATTER_COMMAND:
                    break;
            }
        }
        handleUserResponseToKidFriendly();
    }

    //EFFECTS: prompts user to select preference for kid-friendliness
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToKidFriendly() {
        System.out.println("Do you prefer your dog to be friendly with children?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputKidFriendly(str);
        }
    }

    //EFFECTS: filters out the kid-friendly or not kid-friendly dog breeds
    // depending on user input and proceeds to next question
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputKidFriendly(String str) {
        if (str.length() > 0) {
            switch (str) {
                case YES_COMMAND:
                    dbs.filterKidFriendly();
                    break;
                case NO_COMMAND:
                    dbs.filterNotKidFriendly();
                    break;
                case DOESNT_MATTER_COMMAND:
                    break;
            }
        }
        handleUserResponseToStrangerFriendly();
    }

    //EFFECTS: prompts user to select preference for stranger-friendliness
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToStrangerFriendly() {
        System.out.println("Do you prefer your dog to be friendly with strangers?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputStrangerFriendly(str);
        }
    }

    //EFFECTS: filters out the stranger-friendly or not stranger-friendly dog breeds
    // depending on user input and proceeds to next question
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputStrangerFriendly(String str) {
        if (str.length() > 0) {
            switch (str) {
                case YES_COMMAND:
                    dbs.filterStrangerFriendly();
                    break;
                case NO_COMMAND:
                    dbs.filterNotStrangerFriendly();
                    break;
                case DOESNT_MATTER_COMMAND:
                    break;
            }
        }
        handleUserResponseToIntelligence();
    }

    //EFFECTS: prompts user to select preference for intelligence
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToIntelligence() {
        System.out.println("Do you prefer your dog to be smart?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputIntelligent(str);
        }
    }

    //EFFECTS: filters out the intelligent or not intelligent dog breeds
    // depending on user input and proceeds to result
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputIntelligent(String str) {
        if (str.length() > 0) {
            switch (str) {
                case YES_COMMAND:
                    dbs.filterIntelligent();
                    break;
                case NO_COMMAND:
                    dbs.filterNotIntelligent();
                    break;
                case DOESNT_MATTER_COMMAND:
                    break;
            }
        }
        handleUserResponseResult();


    }

    //EFFECTS: prints out the result of dog breeds that matched user preference
    //and prompts user to add to wish list
    private void handleUserResponseResult() {
        if (dbs.isEmpty()) {
            System.out.println("Sorry, we did not find any match for your preferences.");
            handleUserResponseToRating();
        } else {
            System.out.println("Here are the results based on your preferences: ");
            printDogBreedNamesInResult();
            handleUserResponseToWishList();
            handleUserResponseToMoreWishList();
        }
    }

    //EFFECTS: prompts user to add more dog breeds from result to wish list
    //and handles user input
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToMoreWishList() {
        System.out.println("Would you like to add more to your wish list?");
        while (runProgram) {
            String str;
            str = getUserInputString();
            parseInputWishList(str);
        }
    }


    //EFFECTS: prompts user to add a dog breed from the result to the wish list
    //and handles the response
    private void handleUserResponseToWishList() {
        System.out.println("Please enter the dog breed you would like to add to the wishList: ");
        String dogName = getUserInputString();
        for (int i = 0; i < dbs.size(); i++) {
            if (dogName.equalsIgnoreCase(dbs.get(i).getName())) {
                wishList.add(dbs.get(i));
            }
        }
        System.out.println("Here is your wish list:");
        printWishListDogBreedNames();
        handleUserResponseToMoreWishList();
    }

    //EFFECTS: allow user to add more dog breeds to the wish list or proceed to the
    //rating prompts depending on the user input
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputWishList(String str) {
        if (str.length() > 0) {
            switch (str) {
                case YES_COMMAND:
                    handleUserResponseToWishList();
                    break;
                case NO_COMMAND:
                    handleUserResponseToEnd();
                    break;
            }
        }
    }

    //EFFECTS: prints the names of all the dog breeds in the wish list
    private void printWishListDogBreedNames() {
        for (int i = 0; i < wishList.size(); i++) {
            String name = wishList.get(i).getName();
            System.out.println(name);
        }
    }

    //EFFECTS: print the names of all the dog breeds in the resulting set
    public void printDogBreedNamesInResult() {
        for (int i = 0; i < dbs.size(); i++) {
            String name = dbs.get(i).getName();
            System.out.println(name);
        }
    }

    //EFFECTS: prompts user to save their wish list processes the user input
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToEnd() {
        System.out.println("Thank-you for choosing PuppFinder!");
        System.out.println("Would you like your wish list saved in case you need to see it again?");
        while (runProgram) {
            String str;
            str = getUserInputString();
            parseInputWantSaveWishList(str);
        }
    }

    //EFFECTS: saves wish list depending on user input and proceeds to the rating prompts
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputWantSaveWishList(String str) {
        if (str.length() > 0) {
            switch (str) {
                case YES_COMMAND:
                    saveWishList();
                    break;
                case NO_COMMAND:
                    break;
            }
            handleUserResponseToRating();
        }
    }

    //EFFECTS: prints the good-bye message to end the program
    private void endProgram() {
        System.out.println("Thank-you for choosing PuppFinder!");

    }


    //EFFECTS: prompts the user to give a rating for the quality of service
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToRating() {
        System.out.println("From 1 to 5 stars, please rate the quality the service");
        while (runProgram) {
            String str;
            str = getUserInputString();
            parseInputRating(str);
        }
    }

    //EFFECTS: confirms the user's rating proceeds to end the program
    private void parseInputRating(String str) {
        if (str.length() > 0) {
            System.out.println("You have given us a rating of " + str + " out of 5");
            System.out.println("We appreciate your honest response");
            endProgram();
        }
    }

    //EFFECTS: processes the user's input
    //Source: code for gathering user input from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private String getUserInputString() {
        String str = null;
        if (input.hasNext()) {
            str = input.nextLine();
            str = makePrettyString(str);
        }
        return str;
    }

    //EFFECTS: formats the given string so it is pretty
    //Source: code for string string formatting - B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private String makePrettyString(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\"|'", "");
        return s;
    }

}

