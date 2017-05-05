package ch14Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSumDuplicates {
	
	public ArrayList<Integer> twoSum(int nums[], int target){
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<nums.length; i++){
			//To handle duplicate values and edge cases like [1,1,1] and the one given in the main function
			int temp = i;
			if(!map.containsKey(target - nums[i])){
				if(map.containsKey(nums[i]))
					temp = map.get(nums[i]);
				map.put(nums[i], temp);
			}
			else{
				result.add(map.get(target-nums[i]) + 1);
				result.add(i+1);
				break;
			}
		}
		return result;
	}
 	public static void main(String[] args) {
		TwoSumDuplicates tsd = new TwoSumDuplicates();
		int nums[] = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
		int target = -3;
		System.out.println(tsd.twoSum(nums, target));
	}
}
