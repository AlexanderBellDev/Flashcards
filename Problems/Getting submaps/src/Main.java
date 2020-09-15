import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lowerBound, upperBound, numOfPairs;
        lowerBound = scanner.nextInt();
        upperBound = scanner.nextInt();
        numOfPairs = scanner.nextInt();
        Map<Integer, String> hashMap = new TreeMap<>();
        for (int i = 0; i < numOfPairs; i++) {
            int key = scanner.nextInt();
            String value = scanner.next();
            if (key >= lowerBound && key <= upperBound) {
                hashMap.put(key, value);
            }
        }
        hashMap.forEach((integer, s) -> System.out.println(integer + " " + s));
    }
}