/*
 * Find 3 numbers in a given array that sum up closest to zero
 * return sum
 */

package ch11Searching;

import java.util.Arrays;

public class ThreeSumClosest
{
	  public int closestSum(int[] nums, int target) {
	        int diff = 0;
	        int closestSum = Integer.MAX_VALUE;
	        int minDiff = Integer.MAX_VALUE;
	        Arrays.sort(nums);
	        
	        for(int i = 0; i<nums.length; i++){
	            int j = i+1;
	            int k = nums.length-1;
	            while(j<k){
	                int localSum = nums[i] + nums[j] + nums[k];
	                diff = target - localSum;
	                if(diff == 0 )
	                    return localSum;
	                else if (diff>0){
	                    j++;
	                }else{
	                    k--;   
	                }
	                if(Math.abs(diff) < minDiff){
	                        minDiff = Math.abs(diff);
	                        closestSum = localSum;
	                }
	            }
	        }
	        return closestSum;
	    }
	public static void main(String[] args)
	{
		ThreeSumClosest tsc = new ThreeSumClosest();
		int A[] = {-10,10,200,31,41,51,-160,-13,-14};
		System.out.println(tsc.closestSum(A,0));
	}
}
