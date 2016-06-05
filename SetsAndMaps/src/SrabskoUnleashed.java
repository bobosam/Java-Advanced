import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bobo on 5/28/2016.
 */
public class SrabskoUnleashed {
    public static void main(String[] args) {
       String pattern = "(\\w+\\s?\\w+\\s?\\w+)\\s@(\\w+\\s?\\w+\\s?[a-zA-Z]+)\\s([0-9]+)\\s([0-9]+)";
        Pattern r = Pattern.compile(pattern);

        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();

        String line = sc.nextLine();

        while (!line.equals("End")){
            Matcher m = r.matcher(line);
            if(m.find()){
                String venue = m.group(2);
                String singer = m.group(1);
                Integer price =Integer.parseInt(m.group(3));
                Integer count = Integer.parseInt(m.group(4));

                if (!venues.containsKey(venue)){
                    venues.put(venue, new LinkedHashMap<>());
                }

                if(!venues.get(venue).containsKey(singer)){
                    venues.get(venue).put(singer, 0);
                }

                Integer oldSum = venues.get(venue).get(singer);
                Integer newSum = oldSum + price*count;
                venues.get(venue).put(singer, newSum);

            }

            line = sc.nextLine();
        }

        venues.entrySet().stream()
                .forEach(ven -> {
                    System.out.printf("%s%n", ven.getKey());
                    ven.getValue().entrySet().stream()
                            .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                            .forEach(s -> {
                                System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue());
                            });
                });
    }
}

