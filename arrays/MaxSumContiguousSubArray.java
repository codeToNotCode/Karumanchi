/*
 * Given an array of integers, find a subarray whose sum is the maximum
 * [-2 1 -3 4 -1 2 1 -5 4] should return 6 which is the output of integers in the subarray [4 -1 2 1 -5 4]
 * 
 * https://www.youtube.com/watch?v=ohHWQf1HDfU
 */

package arrays;

public class MaxSumContiguousSubArray {
	
	
	//Using Brute Force - O(n^3)
	//Start from subarrays of size 1 and go upto subarray of size n
	//Calculate max sum for all subarrays and return the result
	public int findSumBrute(int nums[]){
		int result = Integer.MIN_VALUE;
		for(int subArraySize = 1; subArraySize<=nums.length; subArraySize++){
			for(int startIndex = 0; startIndex<nums.length; startIndex++){
				if(startIndex + subArraySize > nums.length)
					break;
				int sum = 0;
				for(int i = startIndex; i< startIndex+subArraySize; i++){
					sum += nums[i];
					result = Math.max(result, sum);
				}
			}
		}
		return result;
	}
	
	
	//Optimized Brute Force - O(n^2)
	//Instead of starting with subArrays of size 1, we start with startIndex
	//This is because, sum of subArray of size n will be equal to sum of subArray of size n - 1 + the last element
	//Hence, by changing the order of execution, we save a lot on time
	public int findSumBruteOpt(int nums[]){
		int result = Integer.MIN_VALUE;
		for(int startIndex = 0; startIndex<nums.length; startIndex++){
			int sum = 0;
			for(int subArraySize = 1; subArraySize<=nums.length; subArraySize++){
				if(startIndex+subArraySize > nums.length)
					break;
				sum += nums[startIndex+subArraySize-1];
				result = Math.max(result, sum);
			}
		}
		return result;
	}
	
	
	//Using Divide and Conquer Technique - O(nlogn)
	//https://discuss.leetcode.com/topic/42213/my-divide-and-conquer-solution-in-java-under-instruction-of-clrs-o-nlogn/2
	public int findSumDnC(int nums[]){
		 if(nums.length==0) return 0;
	        return subArray(nums,0,nums.length-1);
	}
	private int subArray(int[] A, int left, int right){
	    if (left == right){
	        //base case
	        return A[left];
	    }
	    int mid = left + (right-left)/2;
	    int leftsum = subArray(A, left, mid); //left part of the subarray sum, condition 1
	    int rightsum = subArray(A, mid+1, right); //right part of the subarray sum, condition 2
	    int middlesum = midSubArray(A, left, mid, right); //cross part of the subarray sum, condition 3
	    // System.out.println(leftsum);
	    // System.out.println(rightsum);
	    // System.out.println(middlesum);
	    
	    //following if condition will return middlesum if lost the "=" under the conditon of leftsum = rightsum, which may be problematic if leftsum = rightsum < middlesum.
	    //for example: [-1, -1, -2, -2]
	    if (leftsum >= rightsum && leftsum >= middlesum){
	        return leftsum;
	    }
	    if (rightsum >= leftsum && rightsum >= middlesum){
	        return rightsum;
	    }
	    return middlesum;
	}
	private int midSubArray(int[] A, int left, int mid, int right){
	    int leftsum = Integer.MIN_VALUE;
	    int rightsum = Integer.MIN_VALUE;
	    int sum = 0;
	    for (int i = mid; i >= left; i--){
	        sum += A[i];
	        if (leftsum < sum){
	            leftsum = sum;
	        }
	    }  
	    sum = 0;
	    for (int j = mid + 1; j <= right; j++){
	        sum += A[j];
	        if (rightsum < sum){
	            rightsum = sum;
	        }
	    }
	    
	    return leftsum + rightsum;
	}
	
	
	//Using Dynamic Programming
	//Space O(n) Time O(n)
	 public int maxSubArrayDP(int[] A) {
	        int n = A.length;
	        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
	        dp[0] = A[0];
	        int max = dp[0];
	        
	        for(int i = 1; i < n; i++){
	            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
	            max = Math.max(max, dp[i]);
	        }
	        
	        return max;
	    }
    
	 //Using DP but with space O(1)
	 public int maxSubArrayDPOpt(int[] nums) {
	        int n = nums.length;
	        int currSum = nums[0];
	        int maxSum = currSum;
	        for(int i = 1; i < n; i++){
	        	currSum = nums[i] + (currSum > 0 ? currSum : 0);
	        	maxSum = Math.max(maxSum, currSum);
	        }
	        return maxSum;
	    }
    
	 //Using Kadane's Algorithm: kadane does not work if there are all negative numbers. This is improved versio of Kadane
	 //Time O(n)
	 public int findMaxKadane(int nums[]){
		 int maxSum = Integer.MIN_VALUE;
		 int currSum = 0;
		 int start = 0; int end = 0; int startSubArrayIndex = 0;
		 for (int i = 0; i<nums.length; i++) {
		        
		     currSum += nums[i];
		     if(currSum > maxSum){
		    	 maxSum = currSum;
		    	 start = startSubArrayIndex;
		    	 end = i;
		     }
	         if (currSum < 0){
		         currSum = 0;
		         startSubArrayIndex = i+1;
	         }
		 }
		 System.out.println("Start Index "+start);
		 System.out.println("End Index "+end);
		 return maxSum;
	 }
	 
	 
	 
	public static void main(String[] args) {
		MaxSumContiguousSubArray msxsa = new MaxSumContiguousSubArray();
		int nums[] = {-3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
		System.out.println("Max Sum of the contiguous subarray by Brute Force :"+msxsa.findSumBrute(nums));
		System.out.println("Max Sum of the contiguous subarray by Optimized Brute Force :"+msxsa.findSumBruteOpt(nums));
		System.out.println("Max Sum of the contiguous subarray by Divide and Conquer :"+msxsa.findSumDnC(nums));
		System.out.println("Max Sum of the contiguous subarray by DP :"+msxsa.maxSubArrayDP(nums));
		System.out.println("Max Sum of the contiguous subarray by DP Optimized :"+msxsa.maxSubArrayDPOpt(nums));
		System.out.println("Max Sum of the contiguous subarray by Kadane's Algorithm :"+msxsa.findMaxKadane(nums));
	}
}
