import java.util.Scanner;

/**
 * Created by Bobo on 6/7/2016.
 */
public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstNumber = sc.nextLine().trim();
        int secondNumber = Integer.parseInt(sc.nextLine());
        int remainder = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = firstNumber.length()-1; i >= 0; i--) {
            int currentDigit = Integer.parseInt(firstNumber.charAt(i) + "");
            int resultDigit = (currentDigit*secondNumber + remainder) % 10;
            remainder = (currentDigit * secondNumber + remainder) / 10;

            sb.append(resultDigit);

            if (i == 0 && remainder != 0){
                sb.append(remainder);
            }
        }

        sb = sb.reverse();

        while (sb.charAt(0) == '0'){
            if (sb.length() == 1){
                break;
            }
            sb.deleteCharAt(0);
        }

        System.out.println(sb.toString());
    }
}
