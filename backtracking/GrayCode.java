/*
 * Given a number n, return the gray code equivalent of all numbers from 0 to n
 * input n = 4 , output [0,1,3,2]
 */

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode
{
	//Using Bit manipulations involving XOR operator
	//Gray equivalent of a number is equal to ( num XOR num/2 )
	//This code is accepted by interview bit and leetcode
	public List<Integer> grayBit(int n){
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < 1<<n ; i++)
			result.add(i^i>>1);
		return result;
	}
	
	
	//Iterative solution - idea mentioned in interviewbit hint section
	//Not accepted by interviewBit
	public List<Integer> grayIterative(int n){
		List<Integer> result = new ArrayList<>();
		result.add(0);
		for(int i = 1; i< 1<<n ; i = i<<1)
			for(int j = result.size()-1 ; j>=0 ; j--)
				result.add(i + result.get(j));
		return result;
	}
	
	
	 int start = 0;
	//Recursive solution using backtrackking
	public List<Integer> grayBackTrack(int n){
		List<Integer> result = new ArrayList<>();
		generateGray(result, n);
		return result;
	}
	private void generateGray(List<Integer> result, int n) {
		if(n == 0)
			result.add(start);
		else {
			generateGray(result, n-1);
			start = start^( 1 << n - 1 );
			generateGray(result, n-1);
		}
	}
	
	public static void main(String[] args)
	{
		GrayCode gc= new GrayCode();
		int n =3;
		System.out.println("Gray Code using Bit manipulations :"+gc.grayBit(n));
		System.out.println("Gray Code using Iterative method :"+gc.grayIterative(n));
		System.out.println("Gray Code using BackTracking method :"+gc.grayBackTrack(n));
	}
}
