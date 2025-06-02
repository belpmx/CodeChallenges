package problemSolving;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NewYearChaos {
    class Result {

        /*
         * Complete the 'minimumBribes' function below.
         *
         * The function accepts INTEGER_ARRAY q as parameter.
         */

        public static void minimumBribes(List<Integer> q) {
            int n = q.size();
            int bribes = 0;

            for(int i = n; i >= 1; i--) {
                // quick exit if number is in the right place
                if (q.get(i - 1) == i) {
                    continue;
                }

                // case where expected element is only one
                // places ahead
                if(q.get(i - 2) == i) {
                    bribes++;
                    Collections.swap(q, i-1, i-2);
                }

                // case where expected element has moved two
                // places away
                if(q.get(i - 3) == (i)) {
                    bribes += 2;
                    Collections.rotate(q.subList(i - 3, i), -1);
                }

                // case where expected element has moved ahead
                // further places
                else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
            System.out.printf("%d\n",bribes);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
