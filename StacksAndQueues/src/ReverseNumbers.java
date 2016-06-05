import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> numbers = new Stack<>();

        String[] numbersArr = sc.nextLine().trim().split(" ");
        for(String currNumber:numbersArr){
            numbers.push(Integer.parseInt(currNumber));
        }

        while (!numbers.isEmpty()){
            System.out.printf("%d ", numbers.pop());
        }
    }
}
