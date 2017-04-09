/*
 * To return the sliding window maximum
 * http://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */
package ch5Queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMax
{
	
	//O(n^2) solution
	public List<Integer> getMax(int[] nums, int k) {
		List<Integer> max = new ArrayList<>();
		if(nums.length<1|| k<0)
			return max;
		int maxim;
		for(int i = 0; i<=nums.length-k; i++) {
			maxim = nums[i];
			for(int j =1 ; j<k; j++)
				maxim = Math.max(maxim, nums[j+i]);
			max.add(maxim);
		}
		return max;
	}
	
	//O(n) Time and O(n) space
	public List<Integer> maxWindow(int[] nums, int k){
		List<Integer> result = new LinkedList<>();
		if(nums.length<k || k <0) return result;
		Deque<Integer> dq = new LinkedList<>();
		for(int i = 0; i<nums.length; i++) {
			//Remove the first index from the deque when the window moves to the next set
			while(!dq.isEmpty() && dq.peek() < i-k+1)
				dq.poll();
			//Keep removing the last indexes if the element at that index is less than the element at i
			while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
				dq.pollLast();
			
			//Add current index to the deque
			dq.offer(i);
			
			//The first index will always contain the largest element
			//If the window is scanned completely add the largest element to the result
			if(i >= k-1)
				result.add(nums[dq.peek()]);
		}
		return result;
	}
	public static void main(String[] args)
	{
		SlidingWindowMax swm = new SlidingWindowMax();
		int nums[] =  {10,9,8,7,6,5,4,3,2,1};
		List<Integer> result = swm.getMax(nums,4);
		System.out.println(result);
		System.out.println();
		System.out.println(swm.maxWindow(nums, 4));
	}
}
