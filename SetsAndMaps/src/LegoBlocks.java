import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by Bobo on 5/29/2016.
 */
public class LegoBlocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        LinkedHashMap<Integer, String[]> data = new LinkedHashMap<>();

        for (int i = 0; i < 2 * rows; i++) {
            String[] line = sc.nextLine().trim().split("\\s+");
            data.put(i, line);
        }

        boolean check = true;
        int arrLength = data.get(0).length + data.get(0 + rows).length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            int currentLength = data.get(i).length + data.get(i + rows).length;
            count += currentLength;
            if (currentLength != arrLength) {
                check = false;
            }
        }

        if (check == false) {
            System.out.printf("The total number of cells is: %d", count);
        } else {
            for (int i = 0; i < rows; i++) {
                String[] current = new String[arrLength];
                for (int j = 0; j < data.get(i).length; j++) {
                    current[j] = data.get(i)[j];
                }

                for (int j = data.get(i).length; j < arrLength; j++) {
                    current[j] = data.get(i + rows)[arrLength - 1 - j];
                }

                System.out.println(Arrays.toString(current));
            }
        }
    }
}
