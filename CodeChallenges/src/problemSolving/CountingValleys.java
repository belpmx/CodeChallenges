package problemSolving;

import java.io.*;

public class CountingValleys {
    class Result {
        /*
        https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
         * Complete the 'countingValleys' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER steps
         *  2. STRING path
         */
        public static int countingValleys(int steps, String path) {
            int valleys = 0;
            int altitude =0;
            for (int i=0; i<steps;i++){
                if (path.charAt(i)=='D'){
                    altitude --;
                } else {
                    altitude++;
                    //when rising up and reaching sea level
                    if(altitude==0)
                        valleys++;
                }
            }
            return valleys;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int steps = Integer.parseInt(bufferedReader.readLine().trim());
        String path = bufferedReader.readLine();
        int result = Result.countingValleys(steps, path);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
