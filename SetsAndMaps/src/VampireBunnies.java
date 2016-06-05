import java.util.Scanner;

/**
 * Created by Bobo on 5/30/2016.
 */
public class VampireBunnies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sizes = sc.nextLine().trim().split("\\s+");

        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);

        char[][] matrix = new char[rows][cols];
        char[][] oldMatrix = new char[rows][cols];
        int prow = 0, pcol = 0, newRow = 0, newCol = 0;

        for (int row = 0; row < rows; row++) {
            String line = sc.nextLine().trim();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line.charAt(col);
                oldMatrix[row][col] = matrix[row][col];
                if (line.charAt(col) == 'P') {
                    prow = row;
                    pcol = col;
                }
            }
        }

        String commands = sc.nextLine().trim();

        for (int i = 0; i < commands.length(); i++) {
            bubles(rows, cols, matrix, oldMatrix);

            char direction = commands.charAt(i);

            if (direction == 'U') {
                newRow = prow - 1;
                newCol = pcol;
            }

            if (direction == 'D') {
                newRow = prow + 1;
                newCol = pcol;
            }

            if (direction == 'L') {
                newCol = pcol - 1;
                newRow = prow;
            }

            if (direction == 'R') {
                newCol = pcol + 1;
                newRow = prow;
            }

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                matrix[prow][pcol] = '.';
                printMatrix(matrix, rows, cols);
                System.out.printf("won: %d %d", prow, pcol);
                break;
            }

            if (matrix[newRow][newCol] == 'B') {
                matrix[prow][pcol] = '.';
                bubles(rows, cols, matrix, oldMatrix);
                printMatrix(matrix, rows, cols);
                System.out.printf("dead: %d %d", newRow, newCol);
                break;
            }

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                matrix[newRow][newCol] = 'P';
                matrix[prow][pcol] = '.';
                oldMatrix[newRow][newCol] = 'P';
                oldMatrix[prow][pcol] = '.';
            }

            prow = newRow;
            pcol = newCol;

            boolean check = false;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (oldMatrix[row][col] == 'P' && matrix[row][col] == 'B') {
                        bubles(rows, cols, matrix, oldMatrix);
                        printMatrix(matrix, rows, cols);
                        System.out.printf("dead: %d %d", row, col);
                        check = true;
                    }
                    oldMatrix[row][col] = matrix[row][col];
                }
            }

            if (check) {
                break;
            }
        }
    }

    private static void bubles(int rows, int cols, char[][] matrix, char[][] oldMatrix) {
        int brow = 0;
        int bcol = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (oldMatrix[row][col] == 'B') {
                    brow = row - 1;
                    if (brow >= 0) {
                        matrix[brow][col] = 'B';
                    }

                    brow = row + 1;
                    if (brow < rows) {
                        matrix[brow][col] = 'B';
                    }

                    bcol = col - 1;
                    if (bcol >= 0) {
                        matrix[row][bcol] = 'B';
                    }

                    bcol = col + 1;
                    if (bcol < cols) {
                        matrix[row][bcol] = 'B';
                    }
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix, int printRows, int printCols) {
        for (int row = 0; row < printRows; row++) {
            for (int col = 0; col < printCols; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }


}
