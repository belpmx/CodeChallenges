package problemSolving;

import java.util.Arrays;
import java.util.List;

public class maximumToys {
    class Result {
        /*
         * Complete the 'maximumToys' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY prices
         *  2. INTEGER k
         */
        public static int maximumToys(List<Integer> prices, int k) {
            Integer [] myArray = new Integer[prices.size()];
            myArray = prices.toArray(myArray);
            Arrays.sort(myArray);
            int sum =0;
            int counter =0;
            for(Integer element: myArray)
                System.out.print(element+" ");
            int index =0;
            while (sum < k){
                if (!(sum > k)){
                    sum = sum + myArray[index];
                    if(sum >k)
                        break;
                    counter++;
                }
                index++;
            }
            return counter;
        }
    }
}
