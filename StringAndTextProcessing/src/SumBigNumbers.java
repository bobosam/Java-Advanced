import java.util.Scanner;

/**
 * Created by Bobo on 6/7/2016.
 */
public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstNumber = sc.nextLine().trim();
        String secondNumber = sc.nextLine().trim();

        while (firstNumber.length() < secondNumber.length()) {
            firstNumber = "0" + firstNumber;
        }

        while (secondNumber.length() < firstNumber.length()) {
            secondNumber = "0" + secondNumber;
        }

        int size = Math.max(firstNumber.length(), secondNumber.length());
        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        int sum = 0;

        for (int i = size - 1; i >= 0; i--) {
            int firstDigit = Integer.parseInt(firstNumber.charAt(i) + "");
            int secondDigit = Integer.parseInt(secondNumber.charAt(i) + "");

            int tmp = firstDigit + secondDigit;

            int resultDigit = (remainder + firstDigit + secondDigit) %10;
            remainder = (remainder + firstDigit + secondDigit) / 10;

            sb.append(resultDigit);

            if (i == 0 && remainder != 0){
                sb.append(remainder);
            }
        }

        sb = sb.reverse();

        while ( sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        System.out.println(sb.toString());
    }
}
