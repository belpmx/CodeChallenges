package problemSolving;
import java.util.*;


public class ArrayManipulation {
    class Result {

        /*
         * Complete the 'arrayManipulation' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. 2D_INTEGER_ARRAY queries
         */

        public static long arrayManipulation(int n, List<List<Integer>> queries) {
            long maxSum = 0;
            long current=0;
            long currentSum =0;
            int[] array = new int[n];
            for (List<Integer> row : queries){
                int a = row.get(0);
                int b = row.get(1);
                int k = row.get(2);
                //just store the edge elements (a,b)
                array[a-1] +=k;
                //validate index bound
                //save as negative to eliminate duplicates
                if(b<n){
                    array[b] -=k;
                }
            }
            for (int i =0; i<array.length; i++){
                currentSum += array[i];
                maxSum = Math.max(currentSum, maxSum);
            }
            return maxSum;
        }

    }

}
