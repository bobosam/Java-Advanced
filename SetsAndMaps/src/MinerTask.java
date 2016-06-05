import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Bobo on 5/26/2016.
 */
public class MinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> dataMap = new LinkedHashMap<>();

        String line = sc.nextLine();

        while (!line.equals("stop")){
            if (!dataMap.containsKey(line)){
                dataMap.put(line, 0);
            }

            int quantity = Integer.parseInt(sc.nextLine());
            dataMap.put(line, dataMap.get(line) + quantity);

            line = sc.nextLine();
        }

        for (Map.Entry<String, Integer> data : dataMap.entrySet()) {
            System.out.printf("%s -> %d%n", data.getKey(), data.getValue());
        }
    }
}
