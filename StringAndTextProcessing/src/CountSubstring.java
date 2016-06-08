import java.util.Scanner;

/**
 * Created by Bobo on 6/7/2016.
 */
public class CountSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine().toLowerCase();
        String search = sc.nextLine().toLowerCase();
        int match = 0;
        int counter = 0;

        match = text.indexOf(search, match);
        while (match != -1) {
            counter++;
            match = text.indexOf(search, match + 1);
        }

        System.out.println(counter);
    }
}
