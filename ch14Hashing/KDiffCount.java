/*
 * Given an array of integers, count the total number of pairs whose absolute difference is equal to a target value
 * [3 1 4 1 5] and target = 2 should output 2---- (3,1) and (3,5).
 * Count all unique pairs
 */

package ch14Hashing;

import java.util.HashMap;

public class KDiffCount {
	public int countPairs(int nums[], int target){
		int pairCount = 0;
		if(target<0 || nums.length<2)	return pairCount;
		
		//Hashmap with key as the number and value as its count(number of times the number has been visited)
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<nums.length; i++){
			//Get the count if the number has been visited earlier, else get 0
			int count = map.getOrDefault(nums[i],0);
			map.put(nums[i], count+1);
			
			//If target diff is not zero and the number has not yet been visited once
			if( target!=0 && count==0){
				int num1 = nums[i] - target;
				int num2 = nums[i] + target;
				if(map.containsKey(num1))
					pairCount++;
				if(map.containsKey(num2))
					pairCount++;
			}
			//If target is zero, increase the paircount only if the number is visited the second time
			//Do not increase the paircount if the number is visited more than 2 times( redundant pair)
			else if( target == 0 && count == 1){
				pairCount++;
			}
		}
		return pairCount;
	}
	public static void main(String[] args) {
		KDiffCount kdc = new KDiffCount();
		int nums[] = {3,1,4,1,5};
		System.out.println(kdc.countPairs(nums, 2));
	}
}
