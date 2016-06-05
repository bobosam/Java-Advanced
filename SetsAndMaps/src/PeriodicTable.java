import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Bobo on 5/24/2016.
 */
public class PeriodicTable {
    public static void main(String[] args) {
        TreeSet<String> elements = new TreeSet<>();

        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String[] currElements = sc.nextLine().split("\\s+");
            for (String currElement : currElements) {
                elements.add(currElement);
            }
        }

        for (String element : elements) {
            System.out.printf("%s ", element);
        }
    }
}
