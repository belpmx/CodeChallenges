package streams;

import java.util.Arrays;
import java.util.List;

/*
* https://www.w3resource.com/java-exercises/stream/java-stream-exercise-4.php
* Write a Java program to remove all duplicate elements from a list using streams.
* */
public class RemoveDuplicates {

    public static void main (String[] args ){

        List<Integer> numbers = Arrays.asList(10,20,10,5,5,2,4,9,15,69,69);
        System.out.println("List "+ numbers);
        List<Integer> cleanList = numbers.stream().distinct().toList();

        System.out.println("Distinct list "+cleanList);

    }
}
