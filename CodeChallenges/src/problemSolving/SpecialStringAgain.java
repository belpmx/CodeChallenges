package problemSolving;

public class SpecialStringAgain {

    public static long countSpecialSubstrings(String s) {
        int n = s.length();
        long count = 0;

        // Count all substrings where all characters are the same
        int i = 0;
        while (i < n) {
            int repeatCount = 0;
            char currentChar = s.charAt(i);

            // Count consecutive characters
            while (i < n && s.charAt(i) == currentChar) {
                repeatCount++;
                i++;
            }

            // Add the count of substrings for this character
            count += (repeatCount * (repeatCount + 1)) / 2;
        }

        // Handle the second condition for "special substrings"
        for (int j = 1; j < n - 1; j++) {
            int expand = 1;
            while (j - expand >= 0 && j + expand < n
                    && s.charAt(j - expand) == s.charAt(j + expand)
                    && s.charAt(j) != s.charAt(j - expand)) {
                    String thisS = s.substring(j-expand, j+expand+1);
                if (isSpecial(thisS)){
                    System.out.println(thisS );
                    count++;
                }
                expand++;
            }
        }

        return count;
    }
    public static boolean isSpecial (String str){
        boolean result =true;
        char sameChar = str.charAt(0);
        for (int i = 0, z = str.length()-1; i<z; i++, z--)
        {
            if (!(str.charAt(i)==sameChar && str.charAt(z)==sameChar)){
                result = false;
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String input = "abcbaba"; // Replace with your string
        System.out.println("Special substrings count: " + countSpecialSubstrings(input));
    }

}
