import java.util.Scanner;

/**
 * Created by Bobo on 6/8/2016.
 */
public class MelrahShake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String pattern = sc.nextLine();

        while (text.contains(pattern)) {
            if (pattern.equals("")) {
                break;
            }

            int first = text.indexOf(pattern);
            int last = text.lastIndexOf(pattern);

            if (first == last){
                break;
            }

            int patternSize = pattern.length();
            StringBuilder sbText = new StringBuilder(text);
            sbText.delete(first,first + patternSize);
            last = sbText.lastIndexOf(pattern);
            sbText.delete(last, last + patternSize);

            text = sbText.toString();

            StringBuilder sbPattern = new StringBuilder(pattern);
            sbPattern.deleteCharAt(sbPattern.length()/2);

            pattern = sbPattern.toString();

            System.out.println("Shaked it.");
        }

        System.out.println("No shake.");
        System.out.println(text);
    }
}
