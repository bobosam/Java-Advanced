import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Bobo on 6/7/2016.
 */
public class ConvertToBaseN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        BigInteger base = new BigInteger(input[0]);
        BigInteger number = new BigInteger(input[1]);

        StringBuilder sb = new StringBuilder();

        while (number.compareTo(BigInteger.ZERO) > 0) {
            String remainder = "" + (number.remainder(base));
            number = number.divide(base);
            sb.append(remainder);
        }

        String result = sb.reverse().toString();

        System.out.println(result);
    }
}
