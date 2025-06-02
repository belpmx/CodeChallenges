package problemSolving;

import java.util.List;

public class HourGlassSum
{
    class Result {

        /*
         * Complete the 'hourglassSum' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY arr as parameter.
         */

        public static int hourglassSum(List<List<Integer>> arr) {
            //if(arr.size() < 3) return 0; //no possible hourglass
            int max = -63;
            //iterate over each row except the last two
            int i = 0;
            while(i < arr.size() - 2){
                //iterate over each col except the first & last
                int j = 1;
                while(j < arr.get(i).size() - 1){
                    int currMax = calcHourglassSum(arr, i, j); //calculate the max for this hourglass
                    max = Math.max(currMax, max); //determine if this iteration is the max over the previous one
                    j++;
                }
                i++;
            }
            return max;

        }
        public static int calcHourglassSum(List<List<Integer>> arr, int i, int j){
            //i and j are the coordinates of the hourglass pivot
            // based on this center, calculate the sum of above and below elements
            //x       x        x
            //    x(pivot)
            //x       x        x
            return
                    arr.get(i).get(j) + arr.get(i).get(j-1) + arr.get(i).get(j+1)
                            + arr.get(i+1).get(j) + arr.get(i+2).get(j) + arr.get(i+2).get(j-1)
                            + arr.get(i+2).get(j+1);
        }

    }
}
