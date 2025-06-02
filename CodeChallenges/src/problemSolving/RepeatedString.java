package problemSolving;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepeatedString {

    class Result {

        /*
         * Complete the 'repeatedString' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts following parameters:
         *  1. STRING s
         *  2. LONG_INTEGER n
         */

        public static long repeatedString(String s, long n) {
           //count how many 'a'  in the string
            int countA =0;
            //how many times the string repeats into the n times
            long totalTimes = n/s.length();
            //remainder is to determine how many a's are into
            long remainder = n % s.length();
            long remA=0;
            for (char element: s.toCharArray()){
                if (element =='a')
                    countA++;
            }
            for (int i =0;i< remainder;i++){
                if(s.charAt(i)=='a')
                    remA++;
            }
            long repeated = (countA * totalTimes) +remA;
            return repeated;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
