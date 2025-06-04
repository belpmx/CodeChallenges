package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* https://www.w3resource.com/java-exercises/stream/java-stream-exercise-1.php
* 1. Calculate average of integers using streams
Write a Java program to calculate the average of a list of integers using streams.
* */

public class Average {
    public static void main (String [] args){
        List<Integer> numberList = Arrays.asList(1,2,3,5,7,9,11);
        System.out.println("List of numbers "+numberList);

        double average = numberList.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println(average);
    }
}
