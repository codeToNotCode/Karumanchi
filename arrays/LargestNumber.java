/*
 * Given an array of positive numbers, return the largest number that can be formed using the integers
 * 
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330
 * https://www.interviewbit.com/problems/largest-number/
 */

package arrays;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
    	 // 1.Convert to Integer array since Arrays.sort(A,T) forces that
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 2.Sort in descending order
        //Use java visualizer if not able to understand the below sort
        //Sorts in decreasing lexicographical order
        Arrays.sort(strs, (s1, s2) -> ((s2 + s1).compareTo(s1 + s2)));

        // 3.Append together and check final result
        String result = String.join("", strs);
        if (result.isEmpty() || result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }
    
	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int nums[] = {1, 0, 0, 0 ,0};
		System.out.println(ln.largestNumber(nums));
	}
}
