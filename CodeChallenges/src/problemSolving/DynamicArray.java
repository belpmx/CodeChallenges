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

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    		
    		//Create a list of n  empty sequences
    		ArrayList <ArrayList<Integer>> seqList = new ArrayList<>();
    		for (int i =0; i < n; i++) {
    			seqList.add(new ArrayList<Integer>());
    		}    		
    	    List <Integer> output = new ArrayList<Integer>();
    	    List <Integer> thisSeq;    	    
    	    int lastAnswer = 0;       	
    	    int q= 0;
    	    int x = 0;
    	    int y = 0;

  
    	    for (List <Integer> listElement : queries) {
    	        q= listElement.get(0);
    	        x = listElement.get(1);
    	        y = listElement.get(2);
    	        
    	        thisSeq = seqList.get((x ^ lastAnswer) % n);
    	        
    	        if (q==1) 
    	        	thisSeq.add(y);
    	        else if (q ==2) {
    	        	lastAnswer = thisSeq.get(y % thisSeq.size());
    	        	output.add(lastAnswer);
    	        }    	    
    	     }     
    	    return output;
    
    }   

}

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getenv("INPUT_PATH")+"/input10.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}