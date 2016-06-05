import java.util.*;

/**
 * Created by Bobo on 5/21/2016.
 */
public class CalculateSequenceWithQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Long> numbers = new ArrayDeque<>();
        List<Long> listNumbers = new ArrayList<>();

        Long numberN = sc.nextLong();
        int counter = 1;
        numbers.add(numberN);
        listNumbers.add(numberN);
        counter++;

        for (int i = 0; i < 50; i++) {
            numbers.add(listNumbers.get(i) + 1);
            listNumbers.add(listNumbers.get(i) + 1);
            counter++;
            if (counter > 50){
                break;
            }

            numbers.add(2 * listNumbers.get(i) + 1);
            listNumbers.add(2 * listNumbers.get(i) + 1);
            counter++;
            if (counter > 50){
                break;
            }

            numbers.add(listNumbers.get(i) + 2);
            listNumbers.add(listNumbers.get(i) + 2);
            counter++;
            if (counter > 50){
                break;
            }
        }

        for (Long number: numbers){
            System.out.printf("%s ", number);
        }
    }
}
