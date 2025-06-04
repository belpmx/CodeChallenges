package streams;

import java.util.Arrays;
import java.util.List;

/*
* https://www.w3resource.com/java-exercises/stream/java-stream-exercise-5.php
* Write a Java program to count the number of strings in a list that start with a specific letter using streams.
*
* */
public class StartWithLetter {
    public static void main (String [] args){
        List<String> colors = Arrays.asList("green","brown","coffe","red", "red-dark", "cian");
        System.out.println("Original list "+ colors);
        String filterParam = "r";
        Long countWords = colors.stream()
                .filter(s->s.startsWith(filterParam))
                .count();

        System.out.println("Count starting with "+ filterParam +" "+countWords);



    }
}
