import java.util.ArrayList;
import java.util.Collections;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            integers.add(Integer.valueOf(args[i]));
        }
       switch (operator){
           case "MAX":
               System.out.println(Collections.max(integers));
               break;
           case "MIN":
               System.out.println(Collections.min(integers));
               break;
           case "SUM":
               long intSum = integers.stream()
                       .mapToLong(Integer::longValue)
                       .sum();
               System.out.println(intSum);
               break;
       }
    }
}