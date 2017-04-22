/*
 * Find all combinations that can be formed from given n integers(1..n) selecting k at one time
 * [1 2 4] k = 2 should return [1 2] [1 4] [2 4].    [2 1] is invalid
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations
{
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> result = new ArrayList<>();
		findCombinations(result, new ArrayList<>(), 0, n, k);
		return result;
	}
	private void findCombinations(List<List<Integer>> result, List<Integer> tempList,
			int last, int n, int k) {
		if(k== 0 ) 
				result.add(new ArrayList<>(tempList));
		else {
			for(int i = last+1; i <= n; i++) {
				tempList.add(i);
				findCombinations(result, tempList, i, n, k-1);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	public static void main(String[] args)
	{
		Combinations cs = new Combinations();
		List<List<Integer>> result = cs.combine(4,2);
		for(int i = 0; i<result.size(); i++)
			System.out.println(result.get(i));
	}
}
