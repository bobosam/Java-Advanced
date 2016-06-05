import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Bobo on 5/21/2016.
 */
public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> numbers = new Stack<>();
        Stack<Integer> maxElements = new Stack<>();
        int maxValue = Integer.MIN_VALUE;

        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String[] data = sc.nextLine().split(" ");

            if (data[0].equals("1")){
                int currentNumber = Integer.parseInt(data[1]);
                numbers.push(currentNumber);

                if (currentNumber >= maxValue){
                    maxElements.push(currentNumber);
                    maxValue = currentNumber;
                }
            }

            if (data[0].equals("2")){
                int currentNumber = numbers.pop();

                if (currentNumber == maxElements.peek()){
                    maxElements.pop();
                    if (!maxElements.isEmpty()) {
                        maxValue = maxElements.peek();
                    }
                }

                if (numbers.isEmpty()){
                    maxValue = Integer.MIN_VALUE;
                }
            }

            if (data[0].equals("3")){
                System.out.println(maxElements.peek());
            }
        }
    }
}
