import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Bobo on 5/24/2016.
 */
public class SetsOfElements {
    public static void main(String[] args) {
        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> secondSet = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        int firstCount = sc.nextInt();
        int secondCount = sc.nextInt();

        for (int i = 0; i < firstCount; i++) {
            firstSet.add(sc.nextInt());
        }

        for (int i = 0; i < secondCount; i++) {
            secondSet.add(sc.nextInt());
        }

        firstSet.retainAll(secondSet);

        for (Integer number : firstSet) {
            System.out.println(number);
        }
    }
}
