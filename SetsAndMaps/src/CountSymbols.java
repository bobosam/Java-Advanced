import java.util.Map;
        import java.util.Scanner;
        import java.util.TreeMap;

/**
 * Created by Bobo on 5/24/2016.
 */
public class CountSymbols {
    public static void main(String[] args) {
        TreeMap<Character, Integer> characters = new TreeMap<>();

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        char[] inputArr = line.toCharArray();

        for (char c : inputArr) {
            int counter = characters.containsKey(c)? characters.get(c) : 0;
            characters.put(c, ++counter);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : characters.entrySet()) {
            System.out.printf("%s: %d time/s%n", characterIntegerEntry.getKey(), characterIntegerEntry.getValue());
        }
    }
}
