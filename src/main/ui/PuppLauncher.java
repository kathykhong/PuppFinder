package ui;

import model.DogBreed;
import model.DogBreedSet;
import model.WishList;
import java.util.Scanner;

//Class represents the PuppFinder application
//contains all dog breed data
//manages all the user inputs

public class PuppLauncher {
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

    private DogBreed americanEskimo;
    private DogBreed australianTerrier;
    private DogBreed germanSpitz;
    private DogBreed papillon;
    private DogBreed pekingnese;
    private DogBreed pomeranian;
    private DogBreed shitZu;
    private DogBreed scottishTerrier;
    private DogBreed yorkiPoo;
    private DogBreed yorkshireTerrier;
    private DogBreed beardedCollie;
    private DogBreed borderCollie;
    private DogBreed finnishLaphund;
    private DogBreed gordonSetter;
    private DogBreed goldenRetriever;
    private DogBreed icelandicSheepdog;
    private DogBreed siberianHusky;
    private DogBreed samoyed;
    private DogBreed australianCattleDog;
    private DogBreed americanPitbullTerrier;
    private DogBreed boxer;
    private DogBreed drever;
    private DogBreed germanPinscher;
    private DogBreed ibizanHound;
    private DogBreed vizsla;
    private DogBreed spanishMastiff;
    private DogBreed saintBernard;
    private DogBreed filaBrasileiro;
    private DogBreed rottweiler;
    private DogBreed bloodhound;
    private DogBreed newfoundland;
    private DogBreed germanShepherd;
    private DogBreed giantSchnauzer;

    DogBreedSet dbs = new DogBreedSet();
    WishList wishList = new WishList();

    //Source: code from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    public PuppLauncher() {
        input = new Scanner(System.in);
        runProgram = true;
    }

    //MODIFIES: this
    //EFFECTS: runs the PuppFinder Application
    public void runPuppFinderApp() {
        setupListOfDogBreed();
        handleUserResponseToWelcome();

    }

    //EFFECTS: prints out welcome message and processes user input
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToWelcome() {
        System.out.println("Welcome to PuppFinder!");
        System.out.println("We are here to help you find your perfect beloved pup in no time!");
        System.out.println("Would you like to continue?");
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
                case YES_COMMAND:
                    handleUserResponseToFluff();
                    break;
                case NO_COMMAND:
                    handleUserResponseToEnd();
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
            handleUserResponseToEnd();
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
        if (!dbs.isEmpty()) {
            System.out.println("Would you like to add more to your wish list?");
            while (runProgram) {
                String str;
                str = getUserInputString();
                parseInputWishList(str);
            }
        } else {
            handleUserResponseToEnd();
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


    //EFFECTS: prompts user to rate the service and processes the user input
    //Source: while loop taken from B1: FitLifeGymChain Practice Problem
    //https://github.com/UBCx-Software-Construction/long-form-problem-starters.git
    private void handleUserResponseToEnd() {
        System.out.println("Thank-you for choosing PuppFinder!");
        System.out.println("Would you like to rate our service?");
        while (runProgram) {
            String str;
            str = getUserInputString();
            parseInputService(str);
        }
    }

    //EFFECTS: proceeds to the rating prompts or good bye message depending on the user input
    //Source: switch code taken from A3 TakeOut Order Solution
    //https://github.com/UBCx-Software-Construction/data-abstraction-solutions.git
    private void parseInputService(String str) {
        if (str.length() > 0) {
            switch (str) {
                case YES_COMMAND:
                    handleUserResponseToRating();
                    break;
                case NO_COMMAND:
                    endProgram();
                    break;
                case DOESNT_MATTER_COMMAND:
                    break;
            }
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

    //MODIFIES: this
    //EFFECTS: adds the remaining dogs to the dog breed set
    private void addRestOfDogs() {
        dbs.add(pekingnese);
        dbs.add(papillon);
        dbs.add(pomeranian);
        dbs.add(rottweiler);
        dbs.add(saintBernard);
        dbs.add(samoyed);
        dbs.add(scottishTerrier);
        dbs.add(shitZu);
        dbs.add(siberianHusky);
        dbs.add(spanishMastiff);
        dbs.add(vizsla);
        dbs.add(yorkiPoo);
        dbs.add(yorkshireTerrier);
    }

    //MODIFIES: this
    //EFFECTS: add the first set of dog breeds to the dog breed set
    private void addFirstSetOfDogs() {
        dbs.add(americanEskimo);
        dbs.add(americanPitbullTerrier);
        dbs.add(australianCattleDog);
        dbs.add(australianTerrier);
        dbs.add(beardedCollie);
        dbs.add(borderCollie);
        dbs.add(bloodhound);
        dbs.add(boxer);
        dbs.add(drever);
        dbs.add(filaBrasileiro);
        dbs.add(finnishLaphund);
        dbs.add(germanPinscher);
        dbs.add(germanShepherd);
        dbs.add(germanSpitz);
        dbs.add(giantSchnauzer);
        dbs.add(goldenRetriever);
        dbs.add(gordonSetter);
        dbs.add(ibizanHound);
        dbs.add(icelandicSheepdog);
        dbs.add(newfoundland);
    }

    //MODIFIES: this
    //EFFECTS: sets up the list of dog breed
    private void setupListOfDogBreed() {
        initializeFirstSetOfDogs();
        initializeSecondSetOfDogs();
        initializeThirdSetOfDogs();
        initializeFourthSetOfDogs();
        addFirstSetOfDogs();
        addRestOfDogs();

    }

    private void initializeFourthSetOfDogs() {
        saintBernard = new DogBreed("Saint Bernard", 1, "large", 1,
                1, 1, 1, 1, 1);
        filaBrasileiro = new DogBreed("Fila Brasileiro", 0, "large", 1,
                0, 0, 1, 0, 1);
        rottweiler = new DogBreed("Rottweiler", 0, "large", 1,
                1, 0, 1, 1, 1);
        bloodhound = new DogBreed("Bloodhound", 0, "large", 1,
                1, 1, 1, 1, 1);
        newfoundland = new DogBreed("Newfoundland", 1, "large", 1,
                1, 1, 1, 1, 1);
        germanShepherd = new DogBreed("German Shepherd", 1, "large", 1,
                1, 0, 1, 1, 1);
        giantSchnauzer = new DogBreed("Giant Schnauzer", 1, "large", 1,
                1, 1, 1, 0, 1);
    }

    private void initializeThirdSetOfDogs() {
        australianCattleDog = new DogBreed("Australian Cattle Dog", 0, "medium", 1,
                1, 1, 1, 0, 1);
        americanPitbullTerrier = new DogBreed("American Pitbull Terrier", 0, "large", 1,
                1, 0, 1, 1, 1);
        boxer = new DogBreed("Boxer", 0, "large", 1,
                1, 1, 1, 1, 1);
        drever = new DogBreed("Drever", 0, "medium", 1,
                1, 1, 1, 1, 1);
        germanPinscher = new DogBreed("German Pinscher", 0, "medium", 1,
                1, 0, 1, 0, 1);
        ibizanHound = new DogBreed("Ibizan Hound", 0, "large", 1,
                1, 1, 1, 1, 1);
        vizsla = new DogBreed("Vizsla", 0, "large", 1,
                1, 1, 1, 1, 1);
        spanishMastiff = new DogBreed("Spanish Mastiff", 0, "large", 1,
                1, 0, 1, 0, 1);
    }

    private void initializeSecondSetOfDogs() {
        yorkshireTerrier = new DogBreed("Yorkshire Terrier", 1, "small", 1,
                0, 1, 1, 0, 1);
        beardedCollie = new DogBreed("Bearded Collie", 1, "large", 1,
                1, 1, 1, 1, 1);
        borderCollie = new DogBreed("Border Collie", 1, "medium", 1,
                1, 1, 1, 1, 1);
        finnishLaphund = new DogBreed("Finnish Laphund", 1, "medium", 1,
                1, 1, 1, 1, 1);
        gordonSetter = new DogBreed("Gordon Setter", 1, "large", 1,
                1, 0, 1, 1, 1);
        goldenRetriever = new DogBreed("Golden Retriever", 1, "large", 1,
                1, 1, 1, 1, 1);
        icelandicSheepdog = new DogBreed("Icelandic Sheepdog", 1, "medium", 1,
                1, 0, 1, 0, 1);
        siberianHusky = new DogBreed("Siberian Husky", 1, "large", 1,
                1, 1, 1, 1, 1);
        samoyed = new DogBreed("Samoyed", 1, "large", 1,
                1, 1, 1, 1, 1);
    }

    public void initializeFirstSetOfDogs() {
        americanEskimo = new DogBreed("American Eskimo", 1, "medium", 1,
                1, 1, 1, 1, 1);
        australianTerrier = new DogBreed("Australian Terrier", 1, "small", 1,
                0, 0, 1, 1, 1);
        germanSpitz = new DogBreed("German Spitz", 1, "medium", 1,
                1, 1, 1, 1, 1);
        papillon = new DogBreed("Papillon", 1, "small", 1,
                1, 1, 1, 1, 1);
        pekingnese = new DogBreed("Pekingnese", 1, "small", 0,
                0, 0, 0, 0, 1);
        pomeranian = new DogBreed("Pomeranian", 1, "small", 1,
                1, 0, 0, 1, 1);
        shitZu = new DogBreed("Shi Tzu", 1, "small", 0,
                1, 1, 1, 1, 1);
        scottishTerrier = new DogBreed("Scottish Terrier", 1, "medium", 1,
                0, 1, 1, 1, 1);
        yorkiPoo = new DogBreed("Yorki Poo", 1, "small", 1,
                0, 1, 1, 0, 1);
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

