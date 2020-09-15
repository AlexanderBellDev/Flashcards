import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Problem {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>(Arrays.asList(args));
        Integer test = strings.indexOf("test");
        System.out.println(test);
    }
}