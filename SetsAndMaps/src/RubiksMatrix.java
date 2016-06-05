import java.util.Scanner;

/**
 * Created by Bobo on 5/29/2016.
 */
public class RubiksMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sizes = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);
        int[][] matrix = new int[rows][cols];
        int value = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++, value++) {
                matrix[row][col] = value;
            }
        }

        int countLine = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < countLine; i++) {
            String[] commands = sc.nextLine().split("\\s+");
            int position = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int count = Integer.parseInt(commands[2]);
            int first;

            switch (direction) {
                case "up":
                    for (int j = 0; j < count % rows; j++) {
                        first = matrix[0][position];
                        for (int k = 0; k < rows - 1; k++) {
                            matrix[k][position] = matrix[k + 1][position];
                        }

                        matrix[rows - 1][position] = first;
                    }
                    break;
                case "down":
                    for (int j = 0; j < count % rows; j++) {
                        first = matrix[rows - 1][position];
                        for (int k = rows - 1; k > 0; k--) {
                            matrix[k][position] = matrix[k - 1][position];
                        }

                        matrix[0][position] = first;
                    }
                    break;
                case "left":
                    for (int j = 0; j < count % cols; j++) {
                        first = matrix[position][0];
                        for (int k = 0; k < cols - 1; k++) {
                            matrix[position][k] = matrix[position][k + 1];
                        }

                        matrix[position][cols - 1] = first;
                    }

                    break;
                case "right":
                    for (int j = 0; j < count % cols; j++) {
                        first = matrix[position][cols - 1];
                        for (int k = cols - 1; k > 0; k--) {
                            matrix[position][k] = matrix[position][k - 1];
                        }

                        matrix[position][0] = first;
                    }
                    break;
            }
        }
        value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++, value++) {
                if (matrix[i][j] == value) {
                    System.out.println("No swap required");
                } else {
                    for (int k = 0; k < rows; k++) {
                        for (int l = 0; l < cols; l++) {
                            if (matrix[k][l] == value) {
                                System.out.printf("Swap (%d, %d) with (%d, %d)%n", i, j, k, l);
                                int oldValue = matrix[i][j];
                                matrix[i][j] = matrix[k][l];
                                matrix[k][l] = oldValue;
                            }
                        }
                    }
                }
            }

        }
    }
}
