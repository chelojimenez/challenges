import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static int countChar(String s, long length){
        int count = 0;
        for(int i = 0; i < length; i++){
            if(s.charAt(i) == 'a')
                count++;
        }
        return count;
    }
    static long repeatedString(String s, long n) {
        int len = s.length();
        long quotient = n / len;
        long remainder = n % len;
        long subLen = (remainder == 0) ? 0 : remainder;
        return quotient * countChar(s, len) + countChar(s, subLen);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
