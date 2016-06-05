import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Bobo on 5/26/2016.
 */
public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countryPopulation = new LinkedHashMap<>();
        

        String line = sc.nextLine();
        while (!line.equals("report")){
            String[] data = line.split("\\|");

            String country = data[1].trim();
            String city = data[0].trim();
            Long population = Long.parseLong(data[2].trim());

            if(!countries.containsKey(country)){
                countries.put(country, new LinkedHashMap<>());
            }
            
            countries.get(country).put(city, population);

            line = sc.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> country : countries.entrySet()) {
            long sum = 0;
            for (Map.Entry<String, Long> city : countries.get(country.getKey()).entrySet()) {
                sum += city.getValue();
            }
           countryPopulation.put(country.getKey(), sum);
        }

        countries.entrySet().stream()
                .sorted((c1, c2) -> countryPopulation.get(c2.getKey()).compareTo(countryPopulation.get(c1.getKey())))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), countryPopulation.get(country.getKey()));
                    country.getValue().entrySet().stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(city -> {
                                System.out.printf("=>%s: %d%n", city.getKey(),city.getValue());
                            });
                });
    }
}
