package javaPractice;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result{
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        Integer[] rankedArr = ranked.toArray(new Integer[0]);
        int lengthRankedArr =  rankedArr.length;
        Integer[] possitionRankArr = new Integer[lengthRankedArr+1];
        //possitionRankArray hold the possition of the value on rankedArr this is to handle if
        //there are more elements to be added to rankedArr in case of new lowest of higher
        //set the lowest element to one as the best score
        possitionRankArr[0] = 1;
        //start from one since is alreaby initializaded
        for(int i=1;i<lengthRankedArr;i++ ){

            if(rankedArr[i].equals(rankedArr[i-1])){
                //if the two top elements are equal then they have the same score
                System.out.print("if i "+ rankedArr[i] + " i-1 "+rankedArr[i-1]+"      ");
                //then set the score of previous one to current
                possitionRankArr[i]=possitionRankArr[i-1];
                System.out.println("dense "+ possitionRankArr[i]);
            }
            else{
                System.out.print(" else (i-1) +1 "+rankedArr[i-1]+" ");
                //if not, then the current score is increased one
                possitionRankArr[i]=possitionRankArr[i-1] +1;
                System.out.println("dense "+ possitionRankArr[i]);
            }

        }
        //add an extra one for lower scenario
        possitionRankArr[lengthRankedArr] = possitionRankArr[lengthRankedArr-1] +1;

        for(Integer play: player) {
            int index = Arrays.binarySearch(rankedArr, play, (a, b)->b-a);
            if(index <0){
                //if this is the case it means that index is negative due the comparator result
                //multiply by minus one to make it possite and add one
                index = (index * -1) -1;
            }

            result.add(possitionRankArr[index]);
        }


        return result;

    }
}
class Resullt2{
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard2(List<Integer> ranked, List<Integer> player) {
        List <Integer> output = new ArrayList<>();
        Integer [] rankedArr = ranked.toArray(Integer[]::new);
        //List<Integer>rankedArr = ranked;
        for (int play :player){
            if (!(ranked.contains(play))){
                //means that the play is new to the scoreboard
                ranked.add(play);
            }
        }
        Arrays.sort(rankedArr);




        return null;
    }

}
public class ClimbingtheLeaderboard {

}
