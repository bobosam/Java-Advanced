import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Bobo on 5/22/2016.
 */
public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        int index = 0;
        int number = sc.nextInt();
        int maxDeys = 0;
        int deys = 1;

        for (int i = 1; i < count; i++) {
            int tmp = sc.nextInt();
            if (tmp <= number){
                number = tmp;
            }else{
                while (tmp > number && i < count){
                    tmp = sc.nextInt();

                }
            }
        }



        //int counter = 0;
        //boolean check = true;
        //while (check) {
        //    check = false;
//
        //    for (int i = numbers.size() - 1; i > 0; i--) {
        //        if (numbers.get(i) > numbers.get(i - 1)) {
        //            numbers.remove(i);
        //            check = true;
        //        }
//
        //        if (numbers.get(i) > numbers.get(i - 1) && i < numbers.size()) {
        //            numbers.remove(i);
        //            check = true;
        //        }
        //    }
//
        //    counter++;
        //}

        //System.out.println(--counter);
    }
}
