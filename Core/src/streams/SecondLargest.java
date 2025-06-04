package streams;

import java.util.Arrays;
import java.util.List;

//https://www.w3resource.com/java-exercises/stream/java-stream-exercise-8.php
//Write a Java program to find the second smallest and largest elements in a list of integers using streams.
public class SecondLargest {
    public static void main (String [] args){
        List<Integer> numbers = Arrays.asList(-10,-5,0, 5, 15, 10);
        System.out.println("List "+numbers);

        Integer  secondMin= numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(0);

        Integer secondMax = numbers.stream()
                .distinct()
                .sorted((a,b)->Integer.compare(b,a))
                .skip(1)
                .findFirst()
                .orElse(0);

        System.out.println("second smallest "+secondMin +" second largest "+secondMax);
    }


}
