/*
 * To find the largest continuous sequence in an array whose sum is equal to a given target
 * [1 2 -2 4 -4] should return [2 -2 4 -4]
 */

package ch14Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousSequence {
	
	//O(n^2) for algorithm * O(length of output) to create the list
	public ArrayList<Integer> findSeq(int nums[], int targetSum){
		ArrayList<Integer> result = new ArrayList<>();
		int max = 0;

		//Create a new array and store sums in it
		int sumArray[] = new int[nums.length];
		sumArray = createSumArray(sumArray,nums);
		
		//Algorithm
		for(int i = 0; i < sumArray.length; i++){
			for(int j = i; j<sumArray.length; j++){
				int sum = sumArray[j] - ((i>0)?sumArray[i-1]:0);
				if(sum == targetSum && j-i+1 > max){
					max = j-i+1;
					result = makeList(nums,i,j);
				}
			}
		}
		return result;
	}

	
	public int[] createSumArray(int sumArray[], int nums[]){
		sumArray[0] = nums[0];
		for(int i = 1; i < nums.length; i++)
			sumArray[i] = sumArray[i-1] + nums[i];
		return sumArray;
	}
	public ArrayList<Integer> makeList(int nums[], int start, int end){
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = start; i<=end; i++)
			result.add(nums[i]);
		return result;
	}
	
	
	
	//Using HashMaps - O(n) time and O(n) space
	public ArrayList<Integer> returnSeq(int nums[]){
		int sumArray[] = createSumArray(new int[nums.length], nums);
		int start = 0;
		int end = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i =0; i<sumArray.length; i++){
			int num = sumArray[i];
			if(num == 0){
				int tempStart = 0;
				int tempEnd = i+1;
				if(tempEnd - tempStart >= end - start){
					start = tempStart;
					end  = tempEnd;
				}
			}else if( map.containsKey(num)){
				int tempStart = map.get(num) + 1;
				int tempEnd = i+1;
				if( tempEnd - tempStart > end - start){
					start = tempStart;
					end = tempEnd;
				}else if( tempEnd - tempStart == end - start && tempStart<start){
					start = tempStart;
					end = tempEnd;
				}
			}else{
				map.put(num, i);
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = start; i < end; i++)
			result.add(nums[i]);
		return result;
	}
	public static void main(String[] args) {
		LargestContinuousSequence lcs = new LargestContinuousSequence();
		int nums[] = {1,-1,2,3,-3,-3,6};
		System.out.println(lcs.findSeq(nums, 0));
		System.out.println(lcs.returnSeq(nums));
	}
}
