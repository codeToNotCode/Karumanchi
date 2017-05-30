/*
 * Given an array of integers in sorted order, find number of occurrences of a given integer
 * [1 2 2 2 3 4 5] and k = 2 should return 3
 */

package backtracking;

public class NumOccurence {
	
	/*
	 * Since the input is already sorted, the time complexity is O(n) because of the last return statement
	 * If the input was not sorted, then to sort the input, it would have taken O(nlogn) time atleast
	 * Hence overall time complexity would have become (nlogn).
	 */
	public int findOcc(int nums[], int k){
		return search(nums, k, 0, nums.length-1);
	}
	private int search(int nums[], int k, int start, int end){
		if(start>end)	return 0;
		int mid = (start+end)/2;
		if(nums[mid] < k )	return search(nums, k, mid+1, end);
		if(nums[mid] > k )	return search(nums, k, start, mid-1);
		return search(nums, k, mid+1, end) + 1 + search(nums, k, start, mid-1);
	}
	
	
	public static void main(String[] args) {
		NumOccurence no = new NumOccurence();
		int nums[] = {1,2,2,2,3,4,5};
		System.out.println(no.findOcc(nums, 3));
	}
}
