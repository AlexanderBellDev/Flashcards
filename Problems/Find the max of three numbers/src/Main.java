import java.util.Scanner;

public class Main {

    public static int getNumberOfMaxParam(int a, int b, int c) {
        int[] collection = {a, b, c};
        int max = 0;
        int index = 0;
        for (int i = 0; i < collection.length; i++) {
            if (collection[i] > max) {
                max = collection[i];
                index = i;
            }
        }
        return index + 1;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
    }
}