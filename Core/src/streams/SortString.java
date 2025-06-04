package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
* https://www.w3resource.com/java-exercises/stream/java-stream-exercise-6.php
* Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
*
* */
public class SortString {

    public static void main(String [] args){
        List<String> list = Arrays.asList("Foo", "Bar", "Aba", "Zip", "FooBar");
        System.out.println("Unordered List" + list);

        List <String> listAtoZ = list.stream()
                .sorted()
                .toList();
        System.out.println("A-Z list " +listAtoZ);

        List<String > listZtoA = list.stream().
                sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Z-A list "+listZtoA);
    }


}
