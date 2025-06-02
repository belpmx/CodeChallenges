package problemSolving;

public class MakingAnagrams {

    class Result{
        /*
         * Complete the 'makeAnagram' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. STRING a
         *  2. STRING b
         */

        public static int makeAnagram(String a, String b) {
            int result =0;
            int[] aBucket = new int[26];
            int[] bBucket = new int [26];

            //fill the occurence of each letter on a String
            for(int i=0; i<a.length(); i++){
                int intValue = (char)a.charAt(i);
                //substract the value from a to get any charater
                int index = intValue - (int)'a';
                aBucket[index]++;
            }

            for(int i=0; i<b.length(); i++){
                int intValue = (char)b.charAt(i);
                //substract the value from a to get any charater
                int index = intValue - (int)'a';
                bBucket[index]++;
            }

            //iterate on the array and calculate how many delettions are need it

            for (byte i =0;i<26;i++){
                int difference = Math.abs(aBucket[i]-bBucket[i]);
                result += difference;
            }

            return result;
        }
    }
}
