/*
 * Given an array of integers from 1 to n with one number repeating twice and one number missing. Return the repeating and the missing number
 * You cannot alter the given array/list
 * [3 2 1 3 5] should return [3 4]
 * Be careful of very large integers and take care of overflows
 * 
 * For explanation of the solution, visit the below link and check for hints and solution approach
 * For Different solutions(Formula based, sorting, XOR) click on different languages under complete solution section of interviewbit
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * 
 * Good explanation for XOR based implementation
 * http://www.ritambhara.in/missing-and-repeating-number-in-an-array/
 * 
 * All the possible solutions are mentioned in the below link
 * http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 */
package arrays;

import java.util.ArrayList;

public class RepeatAndMissing {

	//O(n) solution
	//Using sum and sum of squares technique
	public ArrayList<Integer> findRepMiss(int[] nums){
		ArrayList<Integer> result = new ArrayList<>();
		long sumDiff = 0;
		long squareSumDiff = 0;
		long temp;
		
		// 
		for(int i = 0; i<nums.length; i++){
			temp = nums[i];
			sumDiff += temp;
			sumDiff -= (long)(i+1);
			squareSumDiff += temp*temp;
			squareSumDiff -= (long)(i+1) * (long)(i+1);
		}
		squareSumDiff /= sumDiff;
		int A = (int)((sumDiff+squareSumDiff)/2);
		int B = (int)(A - sumDiff);
		result.add(A);
		result.add(B);
		return result;
	}

	//Using XOR
	public ArrayList<Integer> findMR(int nums[]){
		ArrayList<Integer> result = new ArrayList<>();
		int xor = 0;
		int i;
		int A = 0, B = 0;
		
		for(i = 0; i<nums.length; i++)
			xor = xor ^ nums[i];
		for(i = 1; i<=nums.length; i++)
			xor = xor ^ i;
		//After the above two loops, we have xor = A ^ B
		//Separate and extract A and B
		int setBitNum = xor & ~(xor-1);
		for(i = 0; i<nums.length; i++){
			if( (nums[i] & setBitNum) > 0 )
				A = A ^ nums[i];
			else
				B = B ^ nums[i];
		}
		for(i = 1; i<=nums.length; i++){
			if( (i & setBitNum) > 0 )
				A = A ^ i;
			else
				B = B ^ i;
		}
		//After the above two loops, we have extracted A and B but we still dont know which one is missing and which one is repeating
		boolean isRepeat = false;
		for(i=0; i< nums.length; i++){
			if( nums[i] == A){
				isRepeat = true;
				break;
			}
		}
		if(isRepeat){
			result.add(A);
			result.add(B);
		}else{
			result.add(B);
			result.add(A);
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		RepeatAndMissing ram = new RepeatAndMissing();
		int nums[] = {2,1,2,3,5};
		System.out.println("Using Formula Technique : "+ram.findRepMiss(nums));
		System.out.println("Using XOR Technique : "+ram.findMR(nums));
	}
}
