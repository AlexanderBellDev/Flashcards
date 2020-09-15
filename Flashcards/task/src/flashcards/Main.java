package flashcards;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    static HashMap<String, String> flashcards = new HashMap<>();
    static HashMap<String, Integer> flashcardsTries = new HashMap<>();
    static List<String> log = new ArrayList<>();
    static boolean exportFlag = false;
    static boolean importFlag = false;
    static String exportFile = "";
    static String importFile = "";

    public static void main(String[] args) throws IOException {
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(args));

        if (arguments.contains("-import")) {
            int index = arguments.indexOf("-import");
            importFile = arguments.get(index + 1);
            importFlag = true;
        }
        if (arguments.contains("-export")) {
            int index = arguments.indexOf("-export");
            exportFile = arguments.get(index + 1);
            exportFlag = true;
        }
        if (importFlag) {
            importCardsArgument(importFile);
        }
        Scanner scanner = new Scanner(System.in);
        String action = "";
        while (!action.equals("exit")) {
            System.out.println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
            action = scanner.nextLine();
            switch (action) {
                case "add":
                    addNewCard(scanner);
                    break;
                case "remove":
                    removeCard(scanner);
                    break;
                case "import":
                    importCards(scanner);
                    break;
                case "export":
                    exportCards(scanner);
                    break;
                case "ask":
                    askCards(scanner);
                    break;
                case "exit":
                    exit();
                    break;
                case "hardest card":
                    hardestCard();
                    break;
                case "reset stats":
                    resetStats();
                    break;
                case "log":
                    log(scanner);
                    break;
            }
        }


    }

    private static void importCardsArgument(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File not found.");
            System.out.println();
            log.add("File not found.");
            //log.add("\n");
        } else {
            int counter = 0;
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] keyValueString = line.split(":");
                flashcards.put(keyValueString[0], keyValueString[1]);
                if (flashcardsTries.get(keyValueString[0]) != null) {
                    int amount = flashcardsTries.get(keyValueString[0]);
                    flashcardsTries.put(keyValueString[0], Integer.valueOf(amount + keyValueString[2]));
                }
                counter++;
            }
            System.out.println(counter + " cards have been loaded.");
            log.add(counter + " cards have been loaded.");
        }
    }

    private static void log(Scanner scanner) throws IOException {
        System.out.println("File name:");
        log.add("File name:");
        String fileName = scanner.nextLine();
        log.add(fileName);
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        for (String s : log) {
            fileWriter.write(s);
            fileWriter.write("\n");
        }
        fileWriter.close();
        System.out.println("The log has been saved.");
    }

    private static void resetStats() {
        flashcardsTries.clear();
        System.out.println("Card statistics has been reset.");
        System.out.println();
    }

    private static void hardestCard() {
        if (flashcardsTries.size() == 0) {
            System.out.println("There are no cards with errors.");
            System.out.println();
            log.add("There are no cards with errors.");
            //log.add("\n");
        } else {
            StringBuilder logLine = new StringBuilder();
            Integer max = Collections.max(flashcardsTries.values());
            Map<String, Integer> collect = flashcardsTries.entrySet()
                    .stream()
                    .filter(map -> max.equals(map.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            if (collect.size() > 1) {
                logLine.append("The hardest cards are ");
                System.out.print("The hardest cards are ");
                int counter = 1;
                for (Map.Entry<String, Integer> stringIntegerEntry : collect.entrySet()) {
                    if (counter == collect.size()) {
                        logLine.append("\"" + stringIntegerEntry.getKey() + "\". ");
                        System.out.print("\"" + stringIntegerEntry.getKey() + "\". ");
                    } else {
                        logLine.append("\"" + stringIntegerEntry.getKey() + "\", ");
                        System.out.print("\"" + stringIntegerEntry.getKey() + "\", ");
                    }
                    counter++;
                }
                logLine.append("You have " + max + " errors answering them.");
                System.out.print("You have " + max + " errors answering them.");
                log.add(logLine.toString());
                //log.add("\n");
                System.out.println();
            } else {
                for (Map.Entry<String, Integer> stringIntegerEntry : collect.entrySet()) {
                    System.out.println("The hardest card is \"" + stringIntegerEntry.getKey() + "\". You have " + stringIntegerEntry.getValue() + " errors answering it.");
                    log.add("The hardest card is \"" + stringIntegerEntry.getKey() + "\". You have " + stringIntegerEntry.getValue() + " errors answering it.");
                }
            }
        }


    }


    private static void exit() throws IOException {
        System.out.println("Bye bye!");
        log.add("Bye bye!");
        if (exportFlag) {
            File file = new File(exportFile);
            FileWriter fileWriter = new FileWriter(file);
            for (Map.Entry<String, String> flashCards : flashcards.entrySet()) {
                if (flashcardsTries.get(flashCards.getKey()) != null) {
                    fileWriter.write(flashCards.getKey() + ":" + flashCards.getValue() + ":" + flashcardsTries.get(flashCards.getKey()));
                    fileWriter.write("\n");
                } else {
                    fileWriter.write(flashCards.getKey() + ":" + flashCards.getValue() + ":" + 0);
                    fileWriter.write("\n");
                }

            }
            fileWriter.close();
            System.out.println(flashcards.size() + " cards have been saved");
            log.add(flashcards.size() + " cards have been saved");
        }
    }

    private static void askCards(Scanner scanner) {
        System.out.println("How many times to ask?");
        log.add("How many times to ask?");
        int questions = Integer.parseInt(scanner.nextLine());
        log.add(String.valueOf(questions));
        ArrayList<String> flashCardsKeys = new ArrayList<>(flashcards.keySet());
        new ArrayList<>(50);
        for (int i = 0; i < questions; i++) {
            Random random = new Random();
            String chosenKey = flashCardsKeys.get(random.nextInt(flashCardsKeys.size()));
            System.out.println("Print the definition of \"" + chosenKey + "\":");
            log.add("Print the definition of \"" + chosenKey + "\":");
            String definitionGuess = scanner.nextLine();
            log.add(definitionGuess);
            if (definitionGuess.equals(flashcards.get(chosenKey))) {
                System.out.println("Correct!");
                log.add("Correct!");
            } else if (flashcards.containsValue(definitionGuess)) {
                AtomicReference<String> keyValue = new AtomicReference<>("");
                flashcards.forEach((key, value) -> {
                    if (value.equals(definitionGuess)) {
                        keyValue.set(key);
                    }
                });
                System.out.println("Wrong. The right answer is \"" + flashcards.get(chosenKey) + "\", but your definition is correct for \"" + keyValue + "\".");
                log.add("Wrong. The right answer is \"" + flashcards.get(chosenKey) + "\", but your definition is correct for \"" + keyValue + "\".");
                flashcardsTries.merge(chosenKey, 1, Integer::sum);
            } else {
                System.out.println("Wrong. The right answer is \"" + flashcards.get(chosenKey) + "\".");
                log.add("Wrong. The right answer is \"" + flashcards.get(chosenKey) + "\".");
                flashcardsTries.merge(chosenKey, 1, Integer::sum);
            }
        }

    }

    private static void exportCards(Scanner scanner) throws IOException {
        System.out.println("File name:");
        log.add("File name:");
        String fileName = scanner.nextLine();
        log.add(fileName);
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        for (Map.Entry<String, String> flashCards : flashcards.entrySet()) {
            if (flashcardsTries.get(flashCards.getKey()) != null) {
                fileWriter.write(flashCards.getKey() + ":" + flashCards.getValue() + ":" + flashcardsTries.get(flashCards.getKey()));
                fileWriter.write("\n");
            } else {
                fileWriter.write(flashCards.getKey() + ":" + flashCards.getValue() + ":" + 0);
                fileWriter.write("\n");
            }

        }
        fileWriter.close();
        System.out.println(flashcards.size() + " cards have been saved");
        log.add(flashcards.size() + " cards have been saved");
    }

    private static void importCards(Scanner scanner) throws FileNotFoundException {
        System.out.println("File name:");
        log.add("File name:");
        String fileName = scanner.nextLine();
        log.add(fileName);
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found.");
            System.out.println();
            log.add("File not found.");
            //log.add("\n");
        } else {
            int counter = 0;
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] keyValueString = line.split(":");
                flashcards.put(keyValueString[0], keyValueString[1]);
                if (flashcardsTries.get(keyValueString[0]) != null) {
                    int amount = flashcardsTries.get(keyValueString[0]);
                    flashcardsTries.put(keyValueString[0], Integer.valueOf(amount + keyValueString[2]));
                }
                counter++;
            }
            System.out.println(counter + " cards have been loaded.");
            log.add(counter + " cards have been loaded.");
        }
    }

    private static void removeCard(Scanner scanner) {
        System.out.println("The card:");
        log.add("The card:");
        String card = scanner.nextLine();
        log.add(card);
        if (Main.flashcards.containsKey(card)) {
            Main.flashcards.remove(card);
            System.out.println("The card has been removed.");
            Main.flashcardsTries.remove(card);
            log.add("The card has been removed.");
        } else {
            System.out.println("Can't remove \"" + card + "\": there is no such card.");
            log.add("Can't remove \"" + card + "\": there is no such card.");
        }
        //log.add("\n");
        System.out.println();
    }

    private static void addNewCard(Scanner scanner) {
        System.out.println("The card:");
        log.add("The card:");
        String card = scanner.nextLine();
        log.add(card);
        if (Main.flashcards.containsKey(card)) {
            System.out.println("The card \"" + card + "\" already exists.");
            log.add("The card \"" + card + "\" already exists.");
        } else {
            System.out.println("The definition of the card:");
            log.add("The definition of the card:");
            String def = scanner.nextLine();
            log.add(def);
            if (Main.flashcards.containsValue(def)) {
                System.out.println("The definition \"" + def + "\" already exists.");
                log.add("The definition \"" + def + "\" already exists.");
            } else {
                Main.flashcards.put(card, def);
                System.out.println("The pair (\"" + card + "\":\"" + def + "\") has been added.");
                log.add("The pair (\"" + card + "\":\"" + def + "\") has been added.");
            }
        }
        System.out.println();
        //log.add("\n");
    }
}
