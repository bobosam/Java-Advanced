import java.util.List;

/**
 * Created by Bobo on 5/31/2016.
 */
public class OutputWriter {
    public static void writeMessage(String message){
        System.out.print(message);
    }

    public static void writeMessageOnNewLine(String message){
        System.out.println(message);
    }

    public static void writeEmptyLine(){
        System.out.println();
    }

    public static void displayException(String message){
        System.err.println(message);
    }

    public static void printStudent(String name, List<Integer> marks){
        String output = String.format("%s - %s", name, marks.toString());
        OutputWriter.writeMessageOnNewLine(output);
    }
}
