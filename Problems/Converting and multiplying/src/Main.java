import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            try {
                // code that may throw an exception
            } catch (RuntimeException | Exception e) {
                // ...
            }

            String lineIn = scanner.nextLine();
            try {
                int converted = Integer.parseInt(lineIn);
                if (converted == 0) {
                    break;
                }
                System.out.println(converted * 10);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Invalid user input: " + lineIn);
            }
        }
    }
}