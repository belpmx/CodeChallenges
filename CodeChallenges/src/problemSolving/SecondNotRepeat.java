import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondNotRepeat {

    public static char findSecondNonRepeated(String value){
        //List<Character> countChars = value
        // Build a frequency map of characters while preserving the order of appearance
        Map <Character, Long> freq = value.chars().mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        // Using stream to filter out repeated characters,
        // skip the first non-repeated and take the second one.
        return freq.entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // non-repeated characters only
                .skip(1) // skip the first non-repeated character
                .findFirst() // attempt to get the second one
                .map(Map.Entry::getKey)
                .orElse('0'); // return '0' if not present
/*
        int [] countChars = new int[26];
        for (char thisChar: value.toCharArray()){
            countChars[thisChar -'a']++;
        }
        int countUnique =0;
        for (char thisChar : value.toCharArray()){
            if(countChars[thisChar-'a'] ==1)
                countUnique++;
            if(countUnique ==2)
                return thisChar;
        }
        return '0';*/
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "swiss";
        System.out.println("Input: " + s1);
        System.out.println("Output: '" + findSecondNonRepeated(s1) + "'");
        // Explanation: 's' is repeated, 'w' is first non-repeated, 'i' is second non-repeated.

        String s2 = "aabbcc";
        System.out.println("Input: " + s2);
        System.out.println("Output: '" + findSecondNonRepeated(s2) + "'");
        // Explanation: All characters are repeated; thus, output is '0'.
    }

}
