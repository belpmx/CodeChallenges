package streams;

import java.util.Arrays;
import java.util.List;

/*
* https://www.w3resource.com/java-exercises/stream/java-stream-exercise-7.php
* Write a Java program to find the maximum and minimum values in a list of integers using streams.
*
* */
public class FindMinMax {

    public static void main (String []args){
        List<Integer> numbers = Arrays.asList(1,3,-10, 50, 69);

        System.out.println("List "+numbers);

        Integer max = numbers.stream().max(Integer::compare).orElse(0);
        Integer min = numbers.stream().min(Integer::compare).orElse(0);

        System.out.println("Max "+max+" Min "+min);

    }

}
