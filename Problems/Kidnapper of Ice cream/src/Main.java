import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]  wordsAvailableArray = scanner.nextLine().split(" ");
        String[] wordsNeededArray = scanner.nextLine().split(" ");
        HashMap<String, Integer> wordsOccurrence = new HashMap<>();
        for (String s : wordsAvailableArray) {
            if (wordsOccurrence.get(s) == null) {
                wordsOccurrence.put(s, 1);
            } else {
                Integer currentOccurrence = wordsOccurrence.get(s);
                currentOccurrence++;
                wordsOccurrence.put(s, currentOccurrence);
            }
        }

        boolean flag = true;
        for (String s : wordsNeededArray) {
            if (wordsOccurrence.get(s) == null) {
                flag = false;
                break;
            } else {
                Integer currentOccurrence = wordsOccurrence.get(s);
                if (currentOccurrence == 0) {
                    flag = false;
                } else {
                    currentOccurrence--;
                    wordsOccurrence.put(s, currentOccurrence);
                }
            }
        }

        System.out.println(!flag ? "You are busted" : "You get money");
    }
}