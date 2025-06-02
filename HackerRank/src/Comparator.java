import java.util.*;
//https://www.hackerrank.com/challenges/java-comparator/problem?isFullScreen=true

public class Comparator<P> {

    class Checker implements java.util.Comparator<Player> {
        @Override
        public int compare(Player o1, Player o2) {
            // Returns a
            // negative integer -> first argument is less than second
            // zero -> return based on the Name natural ordering
            // a positive integer ->greater than the second.
            int response=0;
            if(o1.score > o2.score)
                response=  -1;
            if(o1.score < o2.score)
                response = 1;
            if(o1.score == o2.score)
                response = o1.name.compareTo(o2.name);
            return response;
        }
    }

// Write your Checker class here

    class Player{
        String name;
        int score;

        Player(String name, int score){
            this.name = name;
            this.score = score;
        }
    }

}
