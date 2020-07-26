package ui;

import model.DogBreed;
import model.DogBreedSet;

import java.util.Scanner;

public class PuppLauncher {
    private static final String SMALL_COMMAND = "small";
    private static final String MEDIUM_COMMAND = "medium";
    private static final String LARGE_COMMAND = "large";
    private static final String YES_COMMAND = "yes";
    private static final String NO_COMMAND = "no";
    private static final String ENERGETIC_COMMAND = "energetic";
    private static final String CALM_COMMAND = "calm";

    private static final String DOESNT_MATTER_COMMAND = "doesn't matter";
    private static final String QUIT_COMMAND = "quit";

    private Scanner input;
    private boolean runProgram;

    private DogBreed americanEskimo = new DogBreed("American Eskimo", 1, "medium", 1,
            1, 1, 1, 1, 1);
    private DogBreed australianTerrier = new DogBreed("Australian Terrier", 1, "small", 1,
            0, 0, 1, 1, 1);
    private DogBreed germanSpitz = new DogBreed("German Spitz", 1, "medium", 1,
            1, 1, 1, 1, 1);
    private DogBreed papillon = new DogBreed("Papillon", 1, "small", 1,
            1, 1, 1, 1, 1);
    private DogBreed pekingnese = new DogBreed("Pekingnese", 1, "small", 0,
            0, 0, 0, 0, 1);
    private DogBreed pomeranian = new DogBreed("Pomeranian", 1, "small", 1,
            1, 0, 0, 1, 1);
    private DogBreed shitZu = new DogBreed("Shi Tzu", 1, "small", 0,
            1, 1, 1, 1, 1);
    private DogBreed scottishTerrier = new DogBreed("Scottish Terrier", 1, "medium", 1,
            0, 1, 1, 1, 1);
    private DogBreed yorkiPoo = new DogBreed("Yorki Poo", 1, "small", 1,
            0, 1, 1, 0, 1);
    private DogBreed yorkshireTerrier = new DogBreed("Yorkshire Terrier", 1, "small", 1,
            0, 1, 1, 0, 1);

    private DogBreed beardedCollie = new DogBreed("Bearded Collie", 1, "large", 1,
            1, 1, 1, 1, 1);
    private DogBreed borderCollie = new DogBreed("Border Collie", 1, "medium", 1,
            1, 1, 1, 1, 1);
    private DogBreed finnishLaphund = new DogBreed("Finnish Laphund", 1, "medium", 1,
            1, 1, 1, 1, 1);
    private DogBreed gordonSetter = new DogBreed("Gordon Setter", 1, "large", 1,
            1, 0, 1, 1, 1);
    private DogBreed goldenRetriever = new DogBreed("Golden Retriever", 1, "large", 1,
            1, 1, 1, 1, 1);
    private DogBreed icelandicSheepdog = new DogBreed("Icelandic Sheepdog", 1, "medium", 1,
            1, 0, 1, 0, 1);
    private DogBreed siberianHusky = new DogBreed("Siberian Husky", 1, "large", 1,
            1, 1, 1, 1, 1);
    private DogBreed samoyed = new DogBreed("Samoyed", 1, "large", 1,
            1, 1, 1, 1, 1);
    private DogBreed australianCattleDog = new DogBreed("Australian Cattle Dog", 0, "medium", 1,
            1, 1, 1, 0, 1);
    private DogBreed americanPitbullTerrier = new DogBreed("American Pitbull Terrier", 0, "large", 1,
            1, 0, 1, 1, 1);
    private DogBreed boxer = new DogBreed("Boxer", 0, "large", 1,
            1, 1, 1, 1, 1);
    private DogBreed drever = new DogBreed("Drever", 0, "medium", 1,
            1, 1, 1, 1, 1);
    private DogBreed germanPinscher = new DogBreed("German Pinscher", 0, "medium", 1,
            1, 0, 1, 0, 1);
    private DogBreed ibizanHound = new DogBreed("Ibizan Hound", 0, "large", 1,
            1, 1, 1, 1, 1);
    private DogBreed vizsla = new DogBreed("Vizsla", 0, "large", 1,
            1, 1, 1, 1, 1);

    private DogBreed spanishMastiff = new DogBreed("Spanish Mastiff", 0, "large", 1,
            1, 0, 1, 0, 1);
    private DogBreed saintBernard = new DogBreed("Saint Bernard", 1, "large", 1,
            1, 1, 1, 1, 1);
    private DogBreed filaBrasileiro = new DogBreed("Fila Brasileiro", 0, "large", 1,
            0, 0, 1, 0, 1);
    private DogBreed rottweiler = new DogBreed("Rottweiler", 0, "large", 1,
            1, 0, 1, 1, 1);
    private DogBreed bloodhound = new DogBreed("Bloodhound", 0, "large", 1,
            1, 1, 1, 1, 1);
    private DogBreed newfoundland = new DogBreed("Newfoundland", 1, "large", 1,
            1, 1, 1, 1, 1);
    private DogBreed germanShepherd = new DogBreed("German Shepherd", 1, "large", 1,
            1, 0, 1, 1, 1);
    private DogBreed giantSchnauzer = new DogBreed("Giant Schnauzer", 1, "large", 1,
            1, 1, 1, 0, 1);

    DogBreedSet dbs = new DogBreedSet();

    public PuppLauncher() {
        input = new Scanner(System.in);
        runProgram = true;
    }

    public void runPuppFinderApp() {
        setupListOfDogBreed();
        handleUserResponseToWelcome();

    }

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

    private void handleUserResponseToFluff() {
        System.out.println("Please enter 'yes' or 'no' to the following question");
        System.out.println("Would you like your dog to be fluffy?");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputFluff(str);

        }
    }

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

    private void handleUserResponseToEnergetic() {
        System.out.println("Would you like your dog to be energetic or calm?");
        System.out.println("Please enter 'energetic', 'calm' or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputEnergetic(str);
        }
    }

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

    private void handleUserResponseToShedALot() {
        System.out.println("Are you comfortable with your dog shedding a lot?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputShedALot(str);
        }
    }

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

    private void handleUserResponseToDogFriendly() {
        System.out.println("Do you prefer your dog to be friendly with other dogs ?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputDogFriendly(str);
        }
    }

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

    private void handleUserResponseToKidFriendly() {
        System.out.println("Do you prefer your dog to be friendly with children?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputKidFriendly(str);
        }
    }

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

    private void handleUserResponseToStrangerFriendly() {
        System.out.println("Do you prefer your dog to be friendly with strangers?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputStrangerFriendly(str);
        }
    }

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

    private void handleUserResponseToIntelligence() {
        System.out.println("Do you prefer your dog to be smart?");
        System.out.println("Please enter 'yes', 'no', or 'doesn't matter' for your response");
        String str;
        while (runProgram) {
            str = getUserInputString();
            parseInputIntelligent(str);
        }
    }

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

    private void handleUserResponseResult() {
        if (dbs.isEmpty()) {
            System.out.println("Sorry, we did not find any match for your preferences.");
        } else {
            System.out.println("Here are the results based on your preferences: ");
            printDogBreedNames();
        }
    }

    public void printDogBreedNames() {
        for (int i = 0; i < dbs.size(); i++) {
            String name = dbs.get(i).getName();
            System.out.println(name);
        }

    }




    private void handleUserResponseToEnd() {
        System.out.println("Thank-you for choosing PuppFinder");
    }


    private String getUserInputString() {
        String str = null;
        if (input.hasNext()) {
            str = input.nextLine();
            str = makePrettyString(str);
        }
        return str;
    }


    private void printSizeQuestion() {
        System.out.println("Is your ideal dog small, medium, or large?");

    }


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

    private void setupListOfDogBreed() {
        addFirstSetOfDogs();
        addRestOfDogs();

    }

    private String makePrettyString(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\"|\'", "");
        return s;
    }
}

