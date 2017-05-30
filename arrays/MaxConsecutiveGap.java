/*
 * To find the maximum consecutive gap amongst two elements if the array was sorted
 * [1 10 5] should return 5
 * 
 * Do it in O(n)
 */

package arrays;

public class MaxConsecutiveGap {
	
	//Using Radix Sort O(number of Digits in the maximum number * n )
	public int findMaxGapR(int nums[]){
		if(nums==null || nums.length<2)
			return 0;
		
		int maxElement = nums[0];
		for(int i = 1; i<nums.length; i++)
			maxElement = Math.max(maxElement, nums[i]);
		
		int exp = 1;
		while(maxElement/exp > 0){		//sort all elements from LSD to MSD
			int buckets[] = new int[10];
			int aux[] = new int[nums.length];
			
			for(int i = 0; i < nums.length; i++)
				buckets[(nums[i]/exp)%10]++;
			
			for(int i =1; i<buckets.length; i++)
				buckets[i]+=buckets[i-1];
			
			for(int i = nums.length-1; i>=0; i--)
				aux[--buckets[(nums[i]/exp)%10]] = nums[i];
			
			for(int i =0; i<nums.length; i++)
				nums[i] = aux[i];
			
			exp *= 10;
		}
			
		int maxGap = 0;
		for(int i = 1; i<nums.length; i++)
			maxGap = Math.max(maxGap, nums[i]-nums[i-1]);
		
		return maxGap;
	}
	
	
	//Using the pigeon hole principle
	//https://www.youtube.com/watch?v=ROnetLvbl6M
	//https://leetcode.com/articles/maximum-gap/
	//Faster than radix sort
	public int maximumGap(int[] nums) {
	    int n = nums.length;
	    if(n < 2) return 0;
	    
	    int min = nums[0];
	    int max = nums[0];
	    
	    for(int i = 1;i < n;i++){
	        if(min > nums[i])
	            min = nums[i];
	        if(max < nums[i])
	            max = nums[i];
	    }
	    
	    int gap = (max-min)/(n-1);
	    if(gap == 0) gap++;
	    int len = (max-min)/gap+1;
	    
	    int [] tmax = new int [len];
	    int [] tmin = new int [len];
	    
	    for(int i = 0;i < n;i++){
	        int index = (nums[i]-min)/gap;
	        if(nums[i] > tmax[index]) 
	            tmax[index] = nums[i];
	        if(tmin[index] == 0 || nums[i] < tmin[index]) 
	            tmin[index] = nums[i];
	    }
	    
	    int myMax = 0;
	    for(int i = 0;i < len;i++){
	        if(myMax < tmin[i]-min)
	            myMax = tmin[i]-min;
	        if(tmax[i] != 0) 
	            min = tmax[i];
	    }
	    return myMax;
	}
	public static void main(String[] args) {
		MaxConsecutiveGap mcg = new MaxConsecutiveGap();
		int nums[] = {1,10,5};
		System.out.println("Max Consecutive Gap using Radix Sort :"+mcg.findMaxGapR(nums));
		System.out.println("Max Consecutive Gap using Pigeon Hole Principle :"+mcg.maximumGap(nums));
	}
}
