/*
 * Given an array of integers, find the maximum distance j-i 2 integers in the array such that A[j] >= A[i]
 * [3 5 4 2] Output : 2 for the pair (3, 4)
 * 
 * Brute Force is O(n^2)
 * 
 * O(n)::
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */

package arrays;

public class MaxDistance {
	
	public int getMaxDist(int nums[]){
		int maxDistance = -1;
		
		int[] leftMin = new int[nums.length];
		int[] rightMax = new int[nums.length];
		
		int n = nums.length;
		
		leftMin[0] = nums[0];
		rightMax[n-1] = nums[n-1];
		
		//Start from left and store minimum seen till now and go till end of array
		for(int i = 1; i<n; i++)
			leftMin[i] = Math.min(leftMin[i-1], nums[i]);
		
		//Start from right and store maximum seen till now and go till beginning of array
		for(int i = n-2; i>=0; i--)
			rightMax[i] = Math.max(rightMax[i+1], nums[i]);
		
		//Similar to merge sort
		int i = 0; int j =0;
		while(i<n && j<n){
			if( leftMin[i] <= rightMax[j]){
				maxDistance = Math.max(maxDistance, j-i);
				j++;
			}else{
				i++;
			}
		}
		
		//return the maximum distance
		return maxDistance;
	}
	
	
	public static void main(String[] args) {
		MaxDistance md = new MaxDistance();
		int nums[] = {3,5,4,2};
		System.out.println(md.getMaxDist(nums));
	}
}
