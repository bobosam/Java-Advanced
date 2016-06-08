import java.util.Scanner;

/**
 * Created by Bobo on 6/6/2016.
 */
public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int intNumber = sc.nextInt();
        double firstFloat = sc.nextDouble();
        double secondFloat = sc.nextDouble();

        String hexNumber = Integer.toHexString(intNumber).toUpperCase();
        String binaryString = Integer.toBinaryString(intNumber);
        String paddingBinary = "";

        if (binaryString.length() > 10){
            StringBuilder sb = new StringBuilder(binaryString);
            sb.setLength(10);
            paddingBinary = sb.toString();
        }else {
            paddingBinary = String.format("%10s", binaryString).replace(' ', '0');
        }

        System.out.printf("|%-10s|%s|%10.2f|%-10.3f|", hexNumber, paddingBinary, firstFloat, secondFloat);

    }
}
