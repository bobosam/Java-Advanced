import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bobo on 6/6/2016.
 */
public class StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder sb = new StringBuilder(input);
        sb.setLength(20);
        String output = sb.toString();
        String result = output.replace('\0', '*');

        System.out.println(result);
    }
}
