import java.util.Scanner;

public class Main {

    public static boolean isComposite(long number) {
        if (number <= 0) {
            return false;
        }
        long sqrt = (long) Math.sqrt(number);
        int count = 0;
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count > 0;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long number = scanner.nextLong();
        System.out.println(isComposite(number));
    }
}