import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Bobo on 5/21/2016.
 */
public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] commandsArr = sc.nextLine().trim().split(" ");
        String[] numbersArr = sc.nextLine().trim().split(" ");

        Stack<Integer> numbers = new Stack<>();

        int pushN = Integer.parseInt(commandsArr[0]);
        int popS = Integer.parseInt(commandsArr[1]);
        int number = Integer.parseInt(commandsArr[2]);

        for (int i = 0; i < pushN; i++) {
            int current = Integer.parseInt(numbersArr[i]);
            numbers.push(current);
        }

        for (int i = 0; i < popS; i++) {
            numbers.pop();
        }

        if (numbers.isEmpty()){
            System.out.println("0");
        } else if(numbers.contains(number)){
            System.out.println("true");
        } else{
            System.out.println(Collections.min(numbers));
        }
    }
}
