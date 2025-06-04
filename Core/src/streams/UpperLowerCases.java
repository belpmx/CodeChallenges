package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperLowerCases {
    public static void main (String [] args ){
        List<String> colors = Arrays.asList("RED", "grEEN", "blue","cofFE");
        System.out.println("Original List "+colors);

        List<String > upperCase = colors.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("UpperCase list "+upperCase);

        List<String> lowerCase = colors.stream()
                .map(String::toLowerCase)
                .toList();
        System.out.println("Lower case "+ lowerCase);
    }



}
