/*
 * Find all combinations that can be formed from given n integers(1..n) which equal to a given target value
 * You can use individual element only once
 * All elements of the given input array are unique
 * [4 3 5 7] target = 7 should return [3 4]  [7]
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombSumUnique
{
	public List<List<Integer>> combine(int nums[], int target){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		findCombinations(result, new ArrayList<>(), nums, target, 0);
		return result;
	}
	private void findCombinations(List<List<Integer>> result, List<Integer> tempList,
			int nums[], int target, int start) {
		if( target == 0 ) 
				result.add(new ArrayList<>(tempList));
		else if(target>0){
			for(int i = start; i < nums.length; i++) {
				if(i>start && nums[i]==nums[i-1])
					continue;
				tempList.add(nums[i]);
				findCombinations(result, tempList, nums, target-nums[i], i+1);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	public static void main(String[] args)
	{
		CombinationSum csum = new CombinationSum();
		int nums[] = {5,3,4,7};
		List<List<Integer>> result = csum.combine(nums,7);
		for(int i = 0; i<result.size(); i++)
			System.out.println(result.get(i));
	}
}
