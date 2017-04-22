/*
 * Given an array of integers, find all the possible subsets of the given numbers
 * [3 1 2] should return [] [1] [1 2] [1 2 3] [1 3] [2] [2 3] [3]
 * https://www.interviewbit.com/problems/subset/
 * https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
 * 
 */

package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets
{
	public List<List<Integer>> subsets(int nums[]){
		List<List<Integer>> result = new ArrayList<>();
		//Because the desired output is in increasing order
		Arrays.sort(nums);
		findSubsets(result,new ArrayList<>(),nums, 0);
		return result;
	}
	private void findSubsets(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
		result.add(new ArrayList<>(tempList));
		for(int i =start; i<nums.length; i++) {
			tempList.add(nums[i]);
			findSubsets(result, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);
		}
	}
	public static void main(String[] args)
	{
		Subsets ss = new Subsets();
		int nums[] = {4,3,1};
		List<List<Integer>> result = ss.subsets(nums);
		for(int i = 0; i<result.size(); i++)
			System.out.println(result.get(i));
		
	}
}
