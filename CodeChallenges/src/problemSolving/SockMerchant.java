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

// https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
public class SockMerchant {



    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        int pairs =0;
        //Key value of sock, value = count of value
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer thisSock : ar){
            if (countMap.containsKey(thisSock)){
                int temp = countMap.get(thisSock);
                countMap.put(thisSock, temp+1);
            }
            else
                countMap.put(thisSock, 1);
        }
        for (Integer thisCount : countMap.values()){
            if (thisCount%2 ==0){
                pairs = pairs + thisCount/2;
            }
            else{
                if(thisCount -1 >0){
                    pairs = pairs + (thisCount -1)/2;
                }
            }

        }
        return pairs;
    }

}

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = SockMerchant.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
