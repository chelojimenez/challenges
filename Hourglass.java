import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int calculate_hourglass(int i, int j, int[][] arr){
        System.out.println("Pair: " + i + " " + j);
        int sum = 0;
        sum += arr[i][j];
        System.out.println(sum);
        sum += arr[i][j + 1];
        System.out.println(sum);
        sum += arr[i][j + 2];
        System.out.println(sum);
        sum += arr[i + 1][j + 1];
        System.out.println(sum);
        sum += arr[i + 2][j];
        System.out.println(sum);
        sum += arr[i + 2][j + 1];
        System.out.println(sum);
        sum += arr[i + 2][j + 2];
        System.out.println(sum);
        return sum;
    }
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;    
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows - 2; i++){
            for (int j = 0; j < cols - 2; j++){
                int maxhere = calculate_hourglass(i, j, arr);
                if (maxhere > max){
                    max = maxhere;
                }    
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
