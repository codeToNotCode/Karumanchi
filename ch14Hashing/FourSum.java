/*
 * To find 4 numbers in a given array such that their sum is equal to a given target value
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *	
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */

package ch14Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FourSum {
	
	public ArrayList<ArrayList<Integer>> findFour(int nums[], int target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		for(int i = 0; i<nums.length; i++){
			for(int j = i+1; j<nums.length; j++){
				int k = j+1;
				int l = nums.length-1;
				while(k<l){
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if(sum > target){
						l--;
					}else if( sum < target){
						k++;
					}else if( sum == target){
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						temp.add(nums[l]);
						if(!set.contains(temp)){
							set.add(temp);
							result.add(temp);
						}
						k++;
						l--;
						
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		FourSum fs = new FourSum();
		int nums[] = {1,0,-1,0,-2,2};
		ArrayList<ArrayList<Integer>> result = fs.findFour(nums, 0);
		for(ArrayList<Integer> list : result)
			System.out.println(list);
	}

}
