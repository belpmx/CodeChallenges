package problemSolving;

import java.util.HashMap;

public class SherlockString {
    public static String isValid(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        // Count the frequency of each character
        for (char thisChar : s.toCharArray()) {
            if(frequencyMap.containsKey(thisChar)){
                //the char is already inserted, increase value
                int tempValue = frequencyMap.get(thisChar);
                frequencyMap.put(thisChar, tempValue +1);
            } else {
                frequencyMap.put(thisChar, 1);
            }
        }

        HashMap<Integer, Integer> frequencyCounts = new HashMap<>();
        // Count the frequency of the frequencies
        // example: if all characters occur 1 time, then it will be just one element with n number of occurrences
        // if there are 2 elements then it might be possible to substract
        // 3 or more is impossible
        for (int freq : frequencyMap.values()) {
            if(frequencyCounts.containsKey(freq)){
                //the char is already inserted, increase value
                int tempValue = frequencyCounts.get(freq);
                frequencyCounts.put(freq, tempValue +1);
            } else {
                frequencyCounts.put(freq, 1);
            }
        }

        // Check if the string is valid
        if (frequencyCounts.size() == 1) {
            return "YES"; // All frequencies are the same
        } else if (frequencyCounts.size() == 2) {
            //if only two frequencies then need to evaluate
            int key1 = (int) frequencyCounts.keySet().toArray()[0];
            int key2 = (int) frequencyCounts.keySet().toArray()[1];
            //Validate that key1 only happen one time
            boolean ifKey1 = frequencyCounts.get(key1) == 1;
            //Validate if removing one element will be equal to key2 or to zero
            boolean canReduceKey1 = key1 - 1 == key2 || key1 - 1 == 0;
            //Validate that key2 only happen one time
            boolean ifKey2 = frequencyCounts.get(key2) == 1;
            //Validate if removing one element will be equal to key1 or to zero
            boolean canReduceKey2 = key2 - 1 == key1 || key2 - 1 == 0;
            if ((ifKey1 && canReduceKey1)
                    ||(ifKey2 && canReduceKey2)) {
                return "YES";
            }
        }
        return "NO";
    }


    public static void main(String[] args) {
        String input = "aabbcc"; // Replace with your string
        System.out.println(isValid(input));
    }

}
