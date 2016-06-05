import java.util.Scanner;

/**
 * Created by Bobo on 5/29/2016.
 */
public class TargetPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sizes = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);
        int strlength = rows * cols;
        char[][] matrix = new char[rows][cols];

        String snakeWords = sc.nextLine();
        String snake = "";

        while (snake.length() < strlength){
            snake += snakeWords;
        }

        String[] shot = sc.nextLine().split("\\s+");
        int shotRow = Integer.parseInt(shot[0]);
        int shotCol = Integer.parseInt(shot[1]);
        int shotRadius = Integer.parseInt(shot[2]);
        int check = 0;
        int position = 0;

        for (int row = rows - 1; row >= 0 ; row--) {
            if (check%2 == 0) {
                for (int col = cols - 1; col >= 0; col--) {
                    matrix[row][col] = snake.charAt(position);
                    position++;
                }

                check++;
            }else {
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = snake.charAt(position);
                    position++;
                }

                check++;
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                double distance = Math.sqrt((row - shotRow)*(row - shotRow) + (col - shotCol)* (col - shotCol));
                if (distance <= shotRadius){
                    matrix[row][col] = ' ';
                }
            }

        }

        boolean checkSpase = true;

        while (checkSpase){
            checkSpase = false;
            for (int row = 0; row < rows - 1; row++) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row + 1][col] == ' ' && matrix[row][col] != ' '){
                        matrix[row + 1][col] = matrix[row][col];
                        matrix[row][col] = ' ';
                        checkSpase = true;
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }
}
