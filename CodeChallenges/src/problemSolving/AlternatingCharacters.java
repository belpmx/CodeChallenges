package problemSolving;

public class AlternatingCharacters {

    class Solution {
        /*
         * Complete the 'alternatingCharacters' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts STRING s as parameter.
         */

        public static int alternatingCharacters(String s) {
            int result =0;
            //calculate if adyacent char is the same as initial
            // s[0] == s[1]...
            for (int i=0; i<s.length()-1;i++){
                if(s.charAt(i)==s.charAt(i+1))
                    result++;
            }


            return result;
        }
    }
}
