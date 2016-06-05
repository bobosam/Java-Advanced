import java.io.File;

/**
 * Created by Bobo on 6/5/2016.
 */
public class GetFolderSize {
    private static final String FOLDER_PATH = "resources\\TestFolder";

    public static void main(String[] args) {
        File directory = new File(FOLDER_PATH);

        File[] files = directory.listFiles();
        double size = 0f;

        for (File file : files) {
            if (!file.isDirectory()){
              long tmp =   file.length();
                size += (double)tmp;
            }
        }

        System.out.println(size/(1024*1024));
    }
}
