import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Bobo on 5/22/2016.
 */
public class RecursiveFibonacci {
    private static long[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fibNumber = sc.nextInt();
        numbers = new long[fibNumber + 1];

        long currency = getFibonacci(fibNumber);
        System.out.println(currency);


    }

    public static long getFibonacci(int number) {

        if (number <= 1) {
            return 1;
        }

        if (numbers[number] != 0) {
            return numbers[number];
        }

        numbers[number] = getFibonacci(number - 1) + getFibonacci(number - 2);

        return numbers[number];
    }
}
