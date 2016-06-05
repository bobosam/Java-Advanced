import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Bobo on 5/21/2016.
 */
public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] commands = sc.nextLine().trim().split(" ");
        String[] data = sc.nextLine().trim().split(" ");

        Queue<Integer> numbers = new LinkedList<>();

        int countEnqueue = Integer.parseInt(commands[0]);
        int countDequeue = Integer.parseInt(commands[1]);
        int number = Integer.parseInt(commands[2]);

        for (int i = 0; i < countEnqueue; i++) {
            int currentNumber = Integer.parseInt(data[i]);
            numbers.add(currentNumber);
        }

        for (int i = 0; i < countDequeue; i++) {
            numbers.poll();
        }

        if(numbers.contains(number)){
            System.out.println("true");
        }else if(!numbers.isEmpty()){
            System.out.println(Collections.min(numbers));
        }else{
            System.out.println("0");
        }
    }
}
