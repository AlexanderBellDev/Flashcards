import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Integer targetNum = Integer.valueOf(scanner.nextLine());
        String[] s = numbers.split(" ");
        ArrayList<Integer> newArrayList = new ArrayList<>();
        ArrayList<Integer> outputList = new ArrayList<>();
        for (String s1 : s) {
            newArrayList.add(Integer.parseInt(s1));
        }
        int smallestdiff = Integer.MAX_VALUE;
        for (Integer integer : newArrayList) {
            if (Math.abs(targetNum - integer) < smallestdiff) {
                smallestdiff = Math.abs(targetNum - integer);
            }
        }
        for (Integer integer : newArrayList) {
            if (Math.abs(targetNum - integer) == smallestdiff) {
                outputList.add(integer);
            }
        }
        Collections.sort(outputList);
        for (Integer integer : outputList) {
            System.out.print(integer + " ");
        }

    }

}