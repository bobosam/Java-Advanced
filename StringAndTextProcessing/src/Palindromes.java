import java.text.Collator;
import java.util.*;

/**
 * Created by Bobo on 6/7/2016.
 */
public class Palindromes {
    public static void main(String[] args) {
        HashSet<String> palindromes = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().trim().split("\\W+");

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (reversed.equals(word)){
                palindromes.add(word);
            }
        }

        List<String > listPalindromes = new ArrayList<>(palindromes);

        Collator coll = Collator.getInstance(Locale.US);
        Collections.sort(listPalindromes, coll);

        System.out.println(listPalindromes);
    }
}
