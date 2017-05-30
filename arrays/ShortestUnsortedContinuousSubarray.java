/*
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * 
 * https://leetcode.com/articles/shortest-unsorted-continous-subarray/
 */


package arrays;

import java.util.Arrays;
import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
	
	
	//Brute Force - O(n^3) and confusing!
	public int findShortestBrute(int nums[]){
		int res = nums.length;
		for(int i = 0; i<nums.length; i++){
			for(int j = i; j<=nums.length; j++){
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;
				int prevMax = Integer.MIN_VALUE;
				
				for(int k = i; k<j; k++){
					min = Math.min(min, nums[k]);
					max = Math.max(max, nums[k]);
				}
				if((i>0 && nums[i-1] > min) || (j<nums.length&& nums[j] < max))
					continue;
				
				int k =0;
				while(k<i && prevMax <= nums[k]){
					prevMax = nums[k];
					k++;
				}
				if(k!=i)	
					continue;
				
				k=j;
				while(k<nums.length && prevMax <= nums[k]){
					prevMax = nums[k];
					k++;
				}
				
				if(k==nums.length){
					res = Math.min(res, j-i);
				}
			}
		}
		return res;
	}
	
	
	//Brute Force : Selection Sort Technique - O(n^2)
	public int optBrute(int nums[]){
		int res = nums.length;
		int leftBoundary = nums.length;
		int rightBoundary = -1;
		
		for(int i = 0; i<nums.length; i++){
			for(int j = i+1; j<nums.length; j++){
				if(nums[i] > nums[j]){
					leftBoundary = Math.min(leftBoundary, i);
					rightBoundary = Math.max(rightBoundary, j);
				}
			}
		}
		if( rightBoundary - leftBoundary < 0)
			res = 0;
		else
			res = rightBoundary - leftBoundary + 1;
		
		return res;
	}
	
	
	//Using Sort : O(nlogn) time.
	//O(n) space as we create a copy
	public int usingSort(int nums[]){
		int[] copy = nums.clone();
		Arrays.sort(copy);
		
		int leftBoundary = nums.length;
		int rightBoundary = -1;
		int res = nums.length;
		
		for( int i = 0; i<nums.length; i++){
			if( copy[i] != nums[i]){
				leftBoundary = Math.min(leftBoundary, i);
				rightBoundary = Math.max(rightBoundary, i);
			}
		}
		
		if( rightBoundary - leftBoundary < 0)
			res = 0;
		else
			res = rightBoundary - leftBoundary + 1;
		
		return res;
	}
	
	
	//Using Stack
	//O(n) time, O(n) space
	public int usingStack(int nums[]){
		Stack<Integer> stk  = new Stack<>();
		int leftBoundary = nums.length;
		int rightBoundary = -1;
		int res = nums.length;
		
		for(int i = 0; i<nums.length; i++){
			while(!stk.isEmpty() && nums[stk.peek()] > nums[i])
				leftBoundary = Math.min(leftBoundary, stk.pop());
			stk.push(i);
		}
		stk.clear();
		
		for(int j = nums.length-1; j>=0; j--){
			while(!stk.isEmpty() && nums[stk.peek()] < nums[j])
				rightBoundary = Math.max(rightBoundary, stk.pop());
			stk.push(j);
		}
		
		if( rightBoundary - leftBoundary < 0)
			res = 0;
		else
			res = rightBoundary - leftBoundary + 1;
		
		return res;
	}
	
	
	//Best Solution 
	//O(n) time 
	//O(1) space
	public int bestSolution(int nums[]){
		int res = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean flag = false;
		
		for(int i = 1; i<nums.length; i++){
			if(nums[i] < nums[i-1])
				flag = true;
			if(flag)
				min = Math.min(min, nums[i]);
		}
		
		flag = false;
		for(int j = nums.length-2; j>=0; j--){
			if(nums[j] > nums[j+1])
				flag = true;
			if(flag)
				max = Math.max(max, nums[j]);
		}
		
		int leftBoundary, rightBoundary;
		for(leftBoundary = 0; leftBoundary<nums.length; leftBoundary++)
			if( min < nums[leftBoundary])
				break;
		
		for(rightBoundary=nums.length-1; rightBoundary>=0; rightBoundary--)
			if( max > nums[rightBoundary])
				break;
		
		if( rightBoundary-leftBoundary < 0)
			res = 0;
		else
			res = rightBoundary-leftBoundary+1;
		
		return res;
	}
	
	
	
	public static void main(String[] args) {
		ShortestUnsortedContinuousSubarray sucs = new ShortestUnsortedContinuousSubarray();
		int nums[] = {2, 6, 4, 8, 10, 9, 15};
		System.out.println("Using Brute Force :"+sucs.findShortestBrute(nums));
		System.out.println("Using Optimized Brute Force- Selection Sort Technique :"+sucs.optBrute(nums));
		System.out.println("Using Sorting :"+sucs.usingSort(nums));
		System.out.println("Using Stack :"+sucs.usingStack(nums));
		System.out.println("Using the optimal soultion :"+sucs.bestSolution(nums));
	}
}
