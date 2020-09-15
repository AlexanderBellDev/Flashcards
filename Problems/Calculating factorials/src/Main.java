import java.util.Scanner;

public class Main {

    public static long factorial(long n) {
        long i1 = 1;
        for (long i = n; i > 0; i--) {
            i1 = i1 * i;
        }
        return i1;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}