package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/solutions/127810/two-sum/">...</a>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they
 *
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: int array [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSumHash {
    public int [] sumOfTwo (int [] nums, int target){
       //Create HashMap to store elements and index
       Map<Integer, Integer> numberMap = new HashMap<>();
       int n = nums.length;

       //populate hash table <Key (number) , Value(index where is)>
        for (int i=0; i<n;i++){
            numberMap.put(nums[i],i);
        }
        //find the target
        for (int i =0;i<n;i++){
            //calculate how much is missing against target
            int complement = target - nums[i];
            //validate that complement exist on the Hash Map and also that is not the same element that we are iterating
            if (numberMap.containsKey(complement)&& numberMap.get(complement)!=i)
            {
                return new int[]{i,numberMap.get(complement)};
            }
        }
        //reach this point it means that first iteration is over and no match has found
        return new int[]{};
    }
    public static void main(String[] args) {
        //use this main method in case to try local testing

    }

}
