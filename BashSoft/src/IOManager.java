import java.io.File;
import java.util.LinkedList;

/**
 * Created by Bobo on 5/31/2016.
 */
public class IOManager {
    public static void changeCurrentDirRelativePath(String relativePath){
        if(relativePath.equals("..")){
            String currentPath = SessionData.currentPath;
            int indexOfLastSlash = currentPath.lastIndexOf("\\");
            String newPath = currentPath.substring(0, indexOfLastSlash);
            SessionData.currentPath = newPath;
        }else {
            String currentPath = SessionData.currentPath;
            currentPath += "\\" + relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    private static void changeCurrentDirAbsolute(String absolutePath) {
        File file = new File(absolutePath);
        if(!file.exists()){
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);

            return;
        }

        SessionData.currentPath = absolutePath;
    }

    public static void traverseDirectory(String path){
        LinkedList<File> subFolders = new LinkedList<>();
        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0){
            File currentFolder = subFolders.removeFirst();
            File[] filesList = currentFolder.listFiles();

            if (currentFolder.listFiles() != null){
                for (File file : filesList) {
                    if (file.isDirectory()){
                        traverseDirectory(file.getPath());
                    }
                }
            }

            System.out.println(currentFolder.toString());
        }
    }

    public static void createDirectoryInCurrentFolder(String name){
        String path = getCurrentDirectorypath() + "\\" + name;
        File file = new File(path);
        file.mkdir();
    }

    public static String getCurrentDirectorypath() {
        String currentPath = SessionData.currentPath;

        return currentPath;
    }

    public static void traverseDirectory(int depth){
        LinkedList<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;

        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0){
            File currentFolder = subFolders.removeFirst();
            int currentIndentation = currentFolder.toString().split("\\\\").length - initialIndentation;

            if (depth - currentIndentation < 0){
                break;
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if (currentFolder.listFiles() != null){
                for (File file : currentFolder.listFiles()) {
                    if(file.isDirectory()){
                        subFolders.add(file);
                    }else {
                        int indexOflastSlash = file.toString().lastIndexOf("\\");
                        for (int i = 0; i < indexOflastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }
        }
    }
}
