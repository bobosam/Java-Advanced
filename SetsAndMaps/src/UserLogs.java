import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Bobo on 5/26/2016.
 */
public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();

        String line = sc.nextLine();

        while (!line.equals("end")) {
            String[] ipLine = line.split("\\s+");
            String[] first = ipLine[0].split("=");
            String ip = first[1].trim();

            String[] userLine = ipLine[2].split("=");

            String username = userLine[1].trim();
            if (!data.containsKey(username)) {
                data.put(username, new LinkedHashMap<>());
            }

            if (!data.get(username).containsKey(ip)) {
                data.get(username).put(ip, 0);
            }

            int count = data.get(username).get(ip);

            data.get(username).put(ip, ++count);

            line = sc.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> userData : data.entrySet()) {
            System.out.printf("%s:%n", userData.getKey());
            StringBuilder output = new StringBuilder();
            for (Map.Entry<String, Integer> ipData : data.get(userData.getKey()).entrySet()) {
                output.append(String.format("%s => %d, ", ipData.getKey(), ipData.getValue()));
            }

            String result = output.toString();
            int size = result.length();
            String tmp = result.substring(0, size-2);
            tmp = tmp + '.';
            System.out.println(tmp);
        }


    }
}
