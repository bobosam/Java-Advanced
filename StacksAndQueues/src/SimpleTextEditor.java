import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Bobo on 5/22/2016.
 */
public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> strings = new Stack<>();

        String result = "";

        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String[] commands = sc.nextLine().trim().split("\\s+");
            switch (commands[0]) {
                case "1":
                    result += commands[1];
                    strings.push(result);
                    break;
                case "2":
                    int size = result.length();
                    result = result.substring(0, size - Integer.parseInt(commands[1]));
                    strings.push(result);
                    break;
                case "3":
                    int index = Integer.parseInt(commands[1]) - 1;
                    System.out.println(result.charAt(index));
                    break;
                case "4":
                    if (!strings.isEmpty()) {
                        strings.pop();
                    }

                    if (!strings.isEmpty()) {
                        result = strings.peek();
                    }else {
                        result = "";
                    }

            }
        }
    }
}
