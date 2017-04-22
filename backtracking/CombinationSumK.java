/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *	Input: k = 3, n = 9
 *  Output:
 *  [[1,2,6], [1,3,5], [2,3,4]]
 */



package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumK
{
	    public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> result = new ArrayList<>();
	        findCombs(result, n, k, new ArrayList<Integer>(), 1);
	        return result;
	    }
	    private void findCombs(List<List<Integer>> result, int target, int k, List<Integer> tempList, int start){
	        if(target<0)
	            return;
	        if(target == 0 && k == 0)
	            result.add(new ArrayList<Integer>(tempList));
	        else if( k == 0 )
	            return;
	        else{
	            for(int i = start; i<=9; i++){
	                tempList.add(i);
	                findCombs(result, target-i, k-1, tempList, i+1);
	                tempList.remove(tempList.size()-1);
	            }
	        }
	    }
	    
	    public static void main(String[] args)
		{
			CombinationSumK csk = new CombinationSumK();
			System.out.println(csk.combinationSum3(3,9));
		}
}
