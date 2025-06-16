import java.util.ArrayList;
import java.util.List;

public class RepeatAnagram {
    /*
Given two strings s and p, return an array of all the start indices of p anagrams in s. 
You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the original
letters exactly once.
Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
Constraints:
1 <= s.length, p.length &lt;= 3 * 104
s and p consist of lowercase English letters.
*/

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> soln = new ArrayList<Integer>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        int[] chars = new int[26];
        for (Character c : p.toCharArray()) {
            //Increment to setup hash of all characters currently in the window
            //Later on, these get DECREMENTED when a character is found
            //A positive count later on means that the character is still "needed" in the anagram
            //A negative count means that either the character was found more times than necessary
            //Or that it isn't needed at all
            chars[c - 'a']++;
        }
        int start = 0, end = 0, len = p.length(), diff = len;
        char temp;
        for (end = 0; end < len; end++) {
            temp = s.charAt(end);
            chars[temp - 'a']--;
            //If it's still >= 0, the anagram still "needed" it so we count it towards the anagram by
            if (chars[temp - 'a'] >= 0)
                diff--;
        }
        if (diff == 0)
            soln.add(0);
        while (end < s.length()) {
            temp = s.charAt(start);
            if (chars[temp - 'a'] >= 0)
                diff++;
            //Increment the hash value for this character, because it is no longer contained in the window
            chars[temp - 'a']++;
            //Increment start to start shifting the window over by 1
            start++;
            //Temp represents the last character of the window, the "new" character from the window shift.
            //This character "replaces" the one we removed before so the window stays the same length (p.length())
            temp = s.charAt(end);
            //Decrement hash value for this character, because it is now a part of the window
            chars[temp - 'a']--;
            //Again, if it's not negative it is part of the anagram. So decrement diff
            if (chars[temp - 'a'] >= 0)
                diff--;
            if (diff == 0) //solution found
                soln.add(start);
            end++;
        }
        return soln;
    }

    // quick demo
    public static void main(String[] args) {
        RepeatAnagram sol = new RepeatAnagram();
        System.out.println(sol.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(sol.findAnagrams("abab",        "ab")); // [0, 1, 2]
    }
}
