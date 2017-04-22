/*
 * Given an array of integers with duplicates, write all unique permutations
 * [1 2 2] should return : [1 1 2] [2 1 2] [2 2 1]
 * https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
 * https://leetcode.com/problems/permutations-ii/#/description
 */	
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithDups
{
	public List<List<Integer>> permutate(int nums[]){
		List<List<Integer>> result = new ArrayList<>();
		findAllPermutations(result, new ArrayList<>(), nums, new boolean[nums.length]);
		return result;
	}
	private void findAllPermutations(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
		if(tempList.size() == nums.length)
			result.add(new ArrayList<Integer>(tempList));
		else {
			for(int i = 0; i < nums.length; i++) {
				if(used[i]||i>0&&nums[i]==nums[i-1]&&!used[i-1])	
					continue;
				used[i] = true;
				tempList.add(nums[i]);
				findAllPermutations(result, tempList, nums, used);
				used[i] = false;
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	
	
	public static void main(String[] args)
	{
		PermutationsWithDups pwd = new PermutationsWithDups();
		int A[] = {1,2,2};
		List<List<Integer>> result = pwd.permutate(A);
		for(int i = 0 ; i < result.size(); i++)
			System.out.println(result.get(i));
	}
}
