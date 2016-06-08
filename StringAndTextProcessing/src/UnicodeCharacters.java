import java.util.Scanner;

/**
 * Created by Bobo on 6/7/2016.
 */
public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            System.out.printf("\\u%04x", (int) current);
        }
    }
}
