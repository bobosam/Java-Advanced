import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Bobo on 5/22/2016.
 */
public class StackFibonacci {
    public static void main(String[] args) {
        Stack<Long> fibNums = new Stack<>();
        fibNums.push(1l);
        fibNums.push(1l);
        int counter = 2;

        Scanner sc = new Scanner(System.in);
        int position = sc.nextInt();

        while (counter <= position){
            long first = fibNums.pop();
            long second = fibNums.pop();
            fibNums.push(first);
            fibNums.push(first + second);
            counter++;
        }

        System.out.println(fibNums.peek());
    }
}
