import java.util.*;

/**
 * Created by Bobo on 5/28/2016.
 */
public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> durations = new TreeMap<>();
        HashMap<String, TreeSet<String>> ips = new HashMap<>();

        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String[] input = sc.nextLine().split("\\s+");

            String ip = input[0].trim();
            String user = input[1].trim();
            int duration = Integer.parseInt(input[2]);

            if (!durations.containsKey(user)) {
                durations.put(user, 0);
                ips.put(user, new TreeSet<>());
            }

            int oldDuration = durations.get(user);

            durations.put(user, oldDuration + duration);
            ips.get(user).add(ip);
        }

        for (Map.Entry<String, Integer> user : durations.entrySet()) {
            System.out.printf("%s: %d ", user.getKey(), user.getValue());
            System.out.println(ips.get(user.getKey()));
        }
    }
}
