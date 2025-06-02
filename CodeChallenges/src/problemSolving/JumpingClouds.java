package problemSolving;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class JumpingClouds {
    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;
        int size = c.size();
        int index =0;
        //always possible to win, then last element of the array is zero
        //  Always possible to do two jumps or one jump
        //  then try to two as greedy if not just one
        // no need to iterate last element as is grant zero
        // Move the index two if possible if not one
        //incrfease the jump at the end of each iteration
        while (index < size -1){
            //validate if we can see +2 elements
            if((index +2 )< size){
                if(c.get(index+2)==0){
                    index +=2;
                } else
                    index++;
            } else {//unabled to reach +2
                index++;
            }
            jumps++;
        }//end while

        return jumps;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = JumpingClouds.jumpingOnClouds(c);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
