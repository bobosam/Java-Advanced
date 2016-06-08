import java.util.Scanner;

/**
 * Created by Bobo on 6/7/2016.
 */
public class TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().trim().split(", ");
        String text = sc.nextLine();

        for (String word : words) {
            int size = word.length();

            StringBuilder sb = new StringBuilder();
            sb.setLength(size);
            String asterisks = sb.toString().replaceAll("\0", "*");

            text = text.replaceAll(word, asterisks);
        }

        System.out.println(text);
    }
}
