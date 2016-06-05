import java.util.Scanner;

/**
 * Created by Bobo on 5/30/2016.
 */
public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sizes = sc.nextLine().trim().split("\\s+");

        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);

        int[][] matrix = new int[rows][cols];

        int value = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++, value++) {
                matrix[row][col] = value;
            }
        }

        String line = sc.nextLine();

        while (!line.equals("Nuke it from orbit")) {
            String[] data = line.trim().split("\\s+");
            int rowCross = Integer.parseInt(data[0]);
            int colCross = Integer.parseInt(data[1]);
            int radiusCross = Integer.parseInt(data[2]);

            if (rowCross >= 0 && rowCross < rows && colCross >= 0 && colCross < cols) {
                matrix[rowCross][colCross] = -1;
            }

            for (int i = 1; i <= radiusCross; i++) {
                if ((rowCross - i) >= 0 && (rowCross - i) < rows && colCross >= 0 && colCross < cols) {
                    matrix[rowCross - i][colCross] = -1;
                }

                if ((rowCross + i) < rows && (rowCross + i) >= 0 && colCross >= 0 && colCross < cols) {
                    matrix[rowCross + i][colCross] = -1;
                }

                if ((colCross - i) >= 0 && (colCross - i) < cols && rowCross >= 0 && rowCross < rows) {
                    matrix[rowCross][colCross - i] = -1;
                }

                if ((colCross + i) < cols && (colCross + i) >= 0 && rowCross >= 0 && rowCross < rows) {
                    matrix[rowCross][colCross + i] = -1;
                }
            }

            boolean check = true;
            while (check) {
                check = false;
                for (int row = 0; row < rows; row++) {
                    for (int col = cols - 1; col >= 1; col--) {
                        if (matrix[row][col] != -1 && matrix[row][col - 1] == -1) {
                            matrix[row][col - 1] = matrix[row][col];
                            matrix[row][col] = -1;
                            check = true;
                        }
                    }
                }
            }

            line = sc.nextLine();
        }

        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] != -1){
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == -1) {
                        System.out.print(" ");
                    } else {
                        System.out.print(matrix[row][col]);
                        System.out.print(" ");
                    }
                }

                System.out.println();
            }

        }
    }
}
