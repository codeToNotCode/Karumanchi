/*
 * Given an array of integers, write all possible permutations
 * [1 2 3] should return : [1 2 3] [1 3 2] [2 1 3] [2 3 1] [3 1 2] [3 2 1]
 * https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
 * https://www.interviewbit.com/problems/permutations/
 */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations
{
	public List<List<Integer>> permutate(int nums[]){
		List<List<Integer>> result = new ArrayList<>();
		findAllPermutations(result, new ArrayList<>(), nums);
		return result;
	}
	private void findAllPermutations(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
		if(tempList.size() == nums.length)
			result.add(new ArrayList<Integer>(tempList));
		else {
			for(int i = 0; i < nums.length; i++) {
				if(tempList.contains(nums[i]))	continue;
				tempList.add(nums[i]);
				findAllPermutations(result, tempList, nums);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	
	/*
	 * Iterative Solution
	 * This solution will only when the number of digits to be permutated is 3
	 * This is because we have 3 loops which run n * n-1* n-2 times
	 * If you want to find permutations of 5 numbers, then you will need
	 * 5 nested loops each running n, n-1, n-2, n-3, n-4 times
	 */
	public List<List<Integer>> findPermutations(int nums[]){
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for(int i=0; i<nums.length; i++) {
			List<List<Integer>> temp = new ArrayList<>();
			for(List<Integer> a : result) {
				for(int j = 0; j<=a.size(); j++) {
					a.add(j,nums[i]);
					List<Integer> current = new ArrayList<>(a);
					temp.add(current);
					a.remove(j);
				}
			}
			result = new ArrayList<>(temp);
		}
		return result;
 	}
	
	public static void main(String[] args)
	{
		Permutations ps = new Permutations();
		int A[] = {1,2,3};
		List<List<Integer>> result = ps.findPermutations(A);
		for(int i = 0 ; i < result.size(); i++)
			System.out.println(result.get(i));
	}
}
