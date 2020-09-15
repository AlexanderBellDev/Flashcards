import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seed;
        double iterations, upperBound;
        seed = scanner.nextInt();
        iterations = scanner.nextDouble();
        upperBound = scanner.nextDouble();
        boolean flag = false;
        while (!flag) {
            ArrayList<Double> numbers = new ArrayList<>();
            Random random = new Random(seed);
            for (int i = 0; i < iterations; i++) {
                double gaussian = random.nextGaussian();
                numbers.add(gaussian);
            }
            if (numbers.stream().allMatch(aDouble -> aDouble <= upperBound)) {
                flag = true;
            } else {
                seed++;
            }

        }

        System.out.println(seed);

    }

    public void deleteOldFiles(File rootDir, long thresholdDate) {
        Deque<File> files = new ArrayDeque<>(getChildren(rootDir));

        while (files.size() != 0) {
            File file = files.pop();

            if (file.isFile()) {
                if (file.lastModified() < thresholdDate) {
                    file.delete();
                }
            } else {
                files.addAll(getChildren(file));
            }
        }
    }

    private List<File> getChildren(File dir) {
        File[] children = dir.listFiles();

        return children == null || children.length == 0 ?
                Collections.emptyList() :
                Arrays.asList(children);
    }
}