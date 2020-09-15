import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        String vowelsString = "AEIOU";
        return vowelsString.contains(String.valueOf(ch).toUpperCase());
    }

    /* Do not change code below */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        char letter = scanner.nextLine().charAt(0);
        System.out.println(gcd(3,6));
      //  System.out.println(isVowel(letter) ? "YES" : "NO");
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}