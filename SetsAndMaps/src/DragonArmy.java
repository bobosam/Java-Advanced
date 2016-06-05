import java.util.*;

/**
 * Created by Bobo on 5/28/2016.
 */
public class DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer[]> dataSum = new HashMap<>();
        LinkedHashMap<String, TreeMap<String, Integer[]>> data = new LinkedHashMap<>();

        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String line = sc.nextLine();
            String[] dataArr = line.split("\\s+");

            String type = dataArr[0];
            String name = dataArr[1];
            int damage = dataArr[2].equals("null") ? 45 : Integer.parseInt(dataArr[2]);
            int health = dataArr[3].equals("null") ? 250 : Integer.parseInt(dataArr[3]);
            int armor = dataArr[4].equals("null") ? 10 : Integer.parseInt(dataArr[4]);

            if (!data.containsKey(type)) {
                data.put(type, new TreeMap<>());
                dataSum.put(type, new Integer[]{0, 0, 0, 0});
            }

            if (!data.get(type).containsKey(name)) {
                data.get(type).put(name, new Integer[]{-1, -1, -1});
                            }

            int oldDamage = data.get(type).get(name)[0];
            int oldhealth = data.get(type).get(name)[1];
            int oldArmor = data.get(type).get(name)[2];
            data.get(type).get(name)[0] = damage;
            data.get(type).get(name)[1] = health;
            data.get(type).get(name)[2] = armor;

            if (oldDamage == -1) {
                dataSum.get(type)[0] += damage;
                dataSum.get(type)[1] += health;
                dataSum.get(type)[2] += armor;
                dataSum.get(type)[3] += 1;
            } else{
                dataSum.get(type)[0] += damage;
                dataSum.get(type)[0] -= oldDamage;
                dataSum.get(type)[1] += health;
                dataSum.get(type)[1] -= oldhealth;
                dataSum.get(type)[2] += armor;
                dataSum.get(type)[2] -= oldArmor;
            }
        }

        for (Map.Entry<String, TreeMap<String, Integer[]>> d : data.entrySet()) {
            String type =  d.getKey();
            double avDamage = dataSum.get(type)[0] /(double)(dataSum.get(type)[3]);
            double avHealth = dataSum.get(type)[1] /(double)(dataSum.get(type)[3]);
            double avArmor = dataSum.get(type)[2] /(double)(dataSum.get(type)[3]);

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avDamage, avHealth, avArmor);

            for (Map.Entry<String, Integer[]> n : data.get(type).entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", n.getKey(), n.getValue()[0], n.getValue()[1], n.getValue()[2]);
            }
        }
    }
}
