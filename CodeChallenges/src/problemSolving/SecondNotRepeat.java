public class SecondNotRepeat {

    public static char findSecondNonRepeated(String value){
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
        return '0';
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
