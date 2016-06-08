import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Bobo on 6/8/2016.
 */
public class MagicWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstWord = sc.next();
        String secondWord = sc.next();

        boolean isExchangable = isexchangeble(firstWord, secondWord);

        System.out.println(isExchangable);
    }

    private static boolean isexchangeble(String firstWord, String secondWord) {
        HashMap<Character, Character> chars = new HashMap<>();

        int size = Math.min(firstWord.length(), secondWord.length());

        for (int i = 0; i < size; i++) {
            char first = firstWord.charAt(i);
            char second = secondWord.charAt(i);

            if (!chars.containsKey(first)){
                if (chars.containsValue(second)){
                    return false;
                }
                chars.put(first, second);
            }

            if (chars.get(first) != second){
                return  false;
            }
        }

        if (firstWord.length() > size){
            for (int i = size; i < firstWord.length(); i++) {
                if (!chars.containsKey(firstWord.charAt(i))){
                    return false;
                }
            }
        }

        if(secondWord.length() > size){
            for (int i = size; i < secondWord.length(); i++) {
                if (!chars.containsValue(secondWord.charAt(i))){
                    return false;
                }
            }
        }

        return true;
    }
}
