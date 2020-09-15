import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ConcatPositiveNumbersProblem {

    public static List<Integer> concatPositiveNumbers(List<Integer> l1, List<Integer> l2) {
        List<Integer> list1 = new ArrayList<>(l1);
        List<Integer> list2 = new ArrayList<>(l2);
        list1 = list1.stream().filter(integer -> integer >= 0).collect(Collectors.toList());
        list2 = list2.stream().filter(integer -> integer >= 0).collect(Collectors.toList());
        list1.addAll(list2);
        return list1; // write your code here
    }

    /* Do not modify this method */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
        ArrayList<Integer> list2 = readArrayList(scanner);

        List<Integer> result = concatPositiveNumbers(list1, list2);

        result.forEach(n -> System.out.print(n + " "));
    }

    /* Do not modify this method */
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}