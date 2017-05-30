/*
 * To find the maximum absolute difference from a given array of integers
 * [1 3 -1] should return 5
 * 
 * https://www.interviewbit.com/problems/maximum-absolute-difference/
 */

package arrays;

public class MaxAbsoluteDifference {

	//Brute Force - O(n^2)
	public int getMax(int nums[]) {
	   if(nums==null || nums.length== 0)    return 1;
	   int max = Integer.MIN_VALUE;
	   for(int i = 1 ; i<=nums.length; i++){
	       for(int j = i; j<=nums.length; j++){
	            int sum = Math.abs(nums[i-1]-nums[j-1]) + Math.abs(i-j);
	            max= Math.max(sum, max);
	       }
	   }
	   return max;
	 }
	 
	//Optimized O(n)
	public int getMaxOpt(int nums[]){
		if(nums==null || nums.length == 0)	return 1;
		int result = Integer.MIN_VALUE;
		int max1, max2, min1, min2;
		max1 = max2 = Integer.MIN_VALUE;
		min1 = min2 = Integer.MAX_VALUE;
		for(int i = 0; i<nums.length; i++){
			max1 = Math.max(max1, nums[i] + i);
			max2 = Math.max(max2, nums[i] - i);
			min1 = Math.min(min1, nums[i] + i);
			min2 = Math.min(min2, nums[i] - i);
		}	
		result = Math.max(result, max1-min1);
		result = Math.max(result, max2-min2);
		
		return result;
	}
	 public static void main(String[] args) {
		MaxAbsoluteDifference mad = new MaxAbsoluteDifference();
		int nums[] = {1, 3, -1,0,8};
		System.out.println("Using Brute Force : "+mad.getMax(nums));
		System.out.println("Using Optimized Algorithm : "+mad.getMaxOpt(nums));
	}
}
