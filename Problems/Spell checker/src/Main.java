import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfValidStrings = Integer.parseInt(scanner.nextLine());
        Set<String> stringSet = new HashSet<>();
        Set<String> stringsOfInput = new HashSet<>();
        Set<String> finalSet = new HashSet<>();
        for (int i = 0; i < sizeOfValidStrings; i++) {
            stringSet.add(scanner.nextLine().toLowerCase());
        }
        int sizeOfInput = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sizeOfInput; i++) {
            stringsOfInput.add(scanner.nextLine().toLowerCase());
        }
        for (String s : stringsOfInput) {
            String[] s1 = s.split(" ");
            finalSet.addAll(Arrays.asList(s1));
        }
        finalSet.removeAll(stringSet);
        for (String s : finalSet) {
            System.out.println(s);
        }
    }
}