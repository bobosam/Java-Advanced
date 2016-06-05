import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Bobo on 5/26/2016.
 */
public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> data = new LinkedHashMap<>();
        List<Character> number = Arrays.asList('0', '0', '2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A');
        List<Character> suits = Arrays.asList('0', 'C', 'D', 'H', 'S');

        String line = sc.nextLine();

        while (!line.equals("JOKER")){
            String[] input = line.trim().split(":");

            String name = input[0];
            String[] cards = input[1].trim().split(", ");

            if (!data.containsKey(name)){
                data.put(name, new HashSet<String>());
            }

            for (String card : cards) {
                data.get(name).add(card);
            }

            line = sc.nextLine();
        }

        for (Map.Entry<String, HashSet<String>> hand : data.entrySet()) {
            String name = hand.getKey();
            int power = 0;
            for (String card : hand.getValue()) {
                char first = card.charAt(0);
                char second = card.charAt(card.length() - 1);
                int curNumber = number.indexOf(first);
                int curSuits = suits.indexOf(second);

                power += curNumber * curSuits;
            }

            System.out.printf("%s: %d%n", name, power);
        }
    }
}
