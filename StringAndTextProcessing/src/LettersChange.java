import java.util.Scanner;

/**
 * Created by Bobo on 6/8/2016.
 */
public class LettersChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] input = sc.nextLine().trim().split("\\s+");
        double sum = 0;

        for (String str : input) {
            int size = str.length();
            char firstChar = str.charAt(0);
            char secondChar = str.charAt(size - 1);
            String numberStr = str.substring(1, size -1);
            int number = Integer.parseInt(numberStr);

            if (firstChar == Character.toLowerCase(firstChar)){
                sum += 1.0* number * (firstChar - 'a' + 1);
            } else {
                sum +=(1.0 * number )/ (firstChar - 'A' + 1);
            }

            if (secondChar == Character.toLowerCase(secondChar)){
                sum += secondChar - 'a' +1;
            } else {
                sum -= secondChar - 'A' +1;
            }
        }

        System.out.printf("%.2f%n", sum);
    }
}
