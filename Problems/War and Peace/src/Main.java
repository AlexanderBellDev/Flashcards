import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLine = scanner.nextLine().toLowerCase().split(" ");

        Map<String, Long> map = Arrays.stream(inputLine)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        map.forEach((s, aLong) -> System.out.println(s + " " + aLong));
    }
}