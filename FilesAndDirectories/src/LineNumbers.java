import java.io.*;

/**
 * Created by Bobo on 6/4/2016.
 */
public class LineNumbers {
    private static final String SOURCE_PATH = "resources\\LinesIn.txt";
    private static final String DESTINATION_PATH = "resources\\LinesOut.txt";

    public static void main(String[] args) {
        try {
            File inputFile = new File(SOURCE_PATH);
            File outputFile = new File(DESTINATION_PATH);

            FileReader fileReader = new FileReader(inputFile);
            FileWriter fileWriter = new FileWriter(outputFile);

            BufferedReader reader = new BufferedReader(fileReader);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            String line = reader.readLine();
            int counter = 1;

            while (line != null){
                String output = String.format("%d. %s%n", counter, line);
                writer.write(output);
                counter++;

                line = reader.readLine();
            }

            reader.close();
            writer.close();
        } catch (Exception e) {
            System.out.println("File not found.");
        }

    }
}
