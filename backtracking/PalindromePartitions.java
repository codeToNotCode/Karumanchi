/*
 * Given a string s, partition s such that every string of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return :
 * [
 *   ["a","a","b"]
 *   ["aa","b"],
 * ]
 * 
 * 
 * https://www.interviewbit.com/problems/palindrome-partitioning/
 */

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitions
{
	public List<List<String>> findAllPp(String input){
		List<List<String>> result = new ArrayList<>();
		generate(result, input, new ArrayList<>(), 0);
		return result;
	}
	private void generate(List<List<String>> result, String input,
		List<String> tempList, int start) {
		if(start == input.length())
			result.add(new ArrayList<String>(tempList));
		else {
			for(int i = start; i<input.length(); i++) {
				if(isPalindrome(input, start, i)) {
					tempList.add(input.substring(start, i+1));
					generate(result, input, tempList, i+1);
					tempList.remove(tempList.size()-1);
				}
			}
		}
	}
	private boolean isPalindrome(String s, int low, int high) {
		while(low<high)
			if(s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}
	public static void main(String[] args)
	{
		PalindromePartitions pp = new PalindromePartitions();
		String input = "prasan";
		List<List<String>> result = pp.findAllPp(input);
		for(List<String> s : result)
			System.out.println(s);
	}
}
