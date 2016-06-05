import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Bobo on 6/4/2016.
 */
public class WordCount {
    private static final String WORDS_PATH = "resources\\words.txt";
    private static final String TEXT_PATH = "resources\\text.txt";

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> wordsCount = new LinkedHashMap<>();
        List<String> wordsArr = new ArrayList<>();

        try {
            File words = new File(WORDS_PATH);
            FileReader wordsInput = new FileReader(words);
            BufferedReader wordsReader = new BufferedReader(wordsInput);

            String line = wordsReader.readLine();

            while (line != null){
                String[] wordArr = line.trim().split("\\s+");
                for (String s : wordArr) {
                    wordsArr.add(s.toLowerCase());
                }

                line = wordsReader.readLine();
            }

            wordsReader.close();

            for (String s : wordsArr) {
                wordsCount.put(s, 0);
            }

            File text = new File(TEXT_PATH);
            FileReader inputText= new FileReader(text);
            BufferedReader textReader = new BufferedReader(inputText);

            line = textReader.readLine();

            while (line != null){
                String[] lineArr = line.trim().split("\\W+");
                for (String s : lineArr) {
                    if (wordsCount.containsKey(s.toLowerCase())){
                        int oldCount = wordsCount.get(s.toLowerCase());
                        int newCount = ++oldCount;
                        wordsCount.put(s.toLowerCase(), newCount);
                    }
                }

                line = textReader.readLine();
            }

            textReader.close();

            wordsCount.entrySet().stream()
                    .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
            .forEach(w -> System.out.printf("%s - %d%n", w.getKey(), w.getValue()));

        }catch (Exception e){
            System.out.println("File not found.");
        }
    }
}
