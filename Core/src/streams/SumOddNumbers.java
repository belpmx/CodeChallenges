package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* https://www.w3resource.com/java-exercises/stream/java-stream-exercise-3.php
* Sum even and odd numbers in list using streams
* */
public class SumOddNumbers {


    public static void main (String [] args){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sumEven = numbers.stream()
                .filter(num -> num % 2 ==0)
                .mapToInt(Integer::intValue).
                sum();
        System.out.println("Sum of even numbers: "+sumEven);

        int sumOdd = numbers.stream()
                .filter(num -> num % 2 !=0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of Odd numbers: "+sumOdd);
    }



}
