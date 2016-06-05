import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Created by Bobo on 5/24/2016.
 */
public class UniqueUsernames {
    public static void main(String[] args) {
        LinkedHashSet<String> names = new LinkedHashSet<>();
        Scanner sc =new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String name = sc.nextLine();

            names.add(name);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
