import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Bobo on 5/22/2016.
 */
public class TruckTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Pump> pumps = new ArrayDeque<>();
        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String[] data = sc.nextLine().split("\\s+");
            int currFuel = Integer.parseInt(data[0]);
            int currDistance = Integer.parseInt(data[1]);

            Pump currentPump = new Pump();
            currentPump.index = i;
            currentPump.fuel = currFuel;
            currentPump.distance = currDistance;

            pumps.add(currentPump);
        }

        int tank = 0;
        Pump currPump;
        boolean check = true;
        while (check){
                        currPump = pumps.removeFirst();
            pumps.addLast(currPump);

            if (currPump.fuel >= currPump.distance){
                check = false;
                tank = currPump.fuel - currPump.distance;
                for (Pump pump : pumps){
                    tank += pump.fuel - pump.distance;
                    if(tank < 0){
                        check = true;
                        tank = 0;
                        break;
                    }
                }
            }

            if (check == false){
                System.out.println(currPump.index);
            }
        }
    }
}

class Pump{
    int fuel;
    int distance;
    int index;
}
