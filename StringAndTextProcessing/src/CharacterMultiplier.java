import java.util.Scanner;

/**
 * Created by Bobo on 6/7/2016.
 */
public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().trim().split("\\s+");

        String firstString = input[0];
        String secondString = input[1];

        long sum = 0;

        if (firstString.length() <= secondString.length()){
            for (int i = 0; i < firstString.length(); i++) {
                sum += (long)firstString.charAt(i) * (long)secondString.charAt(i);
            }

            for (int i = firstString.length(); i < secondString.length(); i++) {
                sum += (long)secondString.charAt(i);
            }
        } else{
            for (int i = 0; i < secondString.length(); i++) {
                sum += (long)firstString.charAt(i) * (long)secondString.charAt(i);
            }

            for (int i = secondString.length(); i < firstString.length(); i++) {
                sum += (long)firstString.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
