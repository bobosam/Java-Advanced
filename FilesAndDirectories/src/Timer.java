import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Bobo on 6/5/2016.
 */
public class Timer {
    private static final String FILE1_PATH = "resources\\File1.csv";
    private static final String FILE2_PATH = "resources\\File2.txt.txt";

    public static void main(String[] args) {
        try {
            File first = new File(FILE1_PATH);
            File second = new File(FILE2_PATH);

            FileReader firstReader = new FileReader(first);
            FileReader secondReader = new FileReader(second);

            BufferedReader readerFirst = new BufferedReader(firstReader);
            BufferedReader readerSecond = new BufferedReader(secondReader);

            long firstTime = getTime(readerFirst);
            long secondTime = getTime(readerSecond);

            boolean result = firstTime < secondTime;

            System.out.println(result);


        }catch (Exception e){
            System.out.println("File not found.");
        }
    }

    private static long getTime(BufferedReader reader) throws IOException {
        long start = System.nanoTime();
        String line = reader.readLine();
        while (line != null){
            line = reader.readLine();
        }

        long stop = System.nanoTime();
        long time = stop - start;

        return  time;
    }
}
