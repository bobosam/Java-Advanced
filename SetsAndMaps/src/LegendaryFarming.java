import java.util.*;

/**
 * Created by Bobo on 5/28/2016.
 */
public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Integer> keyMaterial = new LinkedHashMap<>();
        TreeMap<String, Integer> junk = new TreeMap<>();

        keyMaterial.put("fragments", 0);
        keyMaterial.put("motes", 0);
        keyMaterial.put("shards", 0);

        boolean check = true;

        while (check) {
            String line = sc.nextLine();
            String[] input = line.split("\\s+");
            int size = input.length;

            for (int i = 0; i < size; i++) {
                int quantity = Integer.parseInt(input[i]);
                i++;
                String material = input[i].trim().toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int oldQuantity = keyMaterial.get(material);
                    keyMaterial.put(material, oldQuantity + quantity);
                    if (keyMaterial.get(material) >= 250) {
                        check = false;
                        break;
                    }
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, 0);
                    }

                    int oldQuantity = junk.get(material);
                    junk.put(material, oldQuantity + quantity);
                }
            }
        }

        if (keyMaterial.get("shards") >= 250) {
            System.out.println("Shadowmourne obtained!");
        }

        if (keyMaterial.get("fragments") >= 250) {
            System.out.println("Valanyr obtained!");
        }

        if (keyMaterial.get("motes") >= 250) {
            System.out.println("Dragonwrath obtained!");
        }

        for (Map.Entry<String, Integer> material : keyMaterial.entrySet()) {
            if (material.getValue() >= 250) {
                keyMaterial.put(material.getKey(), material.getValue() - 250);
            }
        }

        keyMaterial.entrySet().stream()
                .sorted((k1, k2) -> (k1.getValue() == k2.getValue()) ? k1.getKey().compareTo(k2.getKey()) : k2.getValue().compareTo(k1.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        for (Map.Entry<String, Integer> material : junk.entrySet()) {
            System.out.printf("%s: %d%n", material.getKey(), material.getValue());
        }
    }
}
