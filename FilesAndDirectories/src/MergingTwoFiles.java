import java.io.*;

/**
 * Created by Bobo on 6/5/2016.
 */
public class MergingTwoFiles {
    private static final String FIRST_FAIL_PATH = "resources\\02_FileOne.txt";
    private static final String SECOND_FAIL_PATH = "resources\\02_FileTwo.txt";
    private static final String MERGED_FAIL_PATH = "resources\\02_Merged.txt";

    public static void main(String[] args) {
        try {
            File first = new File(FIRST_FAIL_PATH);
            File second = new File(SECOND_FAIL_PATH);
            File merged = new File(MERGED_FAIL_PATH);

            FileReader readerFirst = new FileReader(first);
            FileReader readerSecond = new FileReader(second);
            FileWriter writerMerged = new FileWriter(merged);

            BufferedReader firstReader = new BufferedReader(readerFirst);
            BufferedReader secondReader = new BufferedReader(readerSecond);
            BufferedWriter mergedWriter = new BufferedWriter(writerMerged);

            String firstLine = firstReader.readLine();
            String secondLine = secondReader.readLine();

            while (firstLine != null || secondLine != null){
                if (firstLine != null){
                    mergedWriter.write(firstLine);
                    mergedWriter.newLine();
                }

                if (secondLine != null){
                    mergedWriter.write(secondLine);
                    mergedWriter.newLine();
                }

                firstLine = firstReader.readLine();
                secondLine = secondReader.readLine();
            }

            firstReader.close();
            secondReader.close();
            mergedWriter.close();
        }catch (Exception e){
            System.out.println("Fie not found.");
        }

    }
}
