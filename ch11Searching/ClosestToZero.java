/*
 * Given an array of integers, Find a sum of two numbers that is closest to zero
 */

package ch11Searching;

import java.util.Arrays;

public class ClosestToZero
{
	public int closest(int A[]){
		if(A.length<2)
			return -1;
		//60, -10, 70 -80 85
		Arrays.sort(A);
		
		//  0   1  2  3  4
		//-80 -10 60 70 85
		int diff = 0;
		int minDiff = Integer.MAX_VALUE;
		int closestSum = Integer.MAX_VALUE;
		int i = 0;
		int j = A.length-1;
		while(i<j){
			int localSum = A[i] + A[j];
			diff= 0 - localSum;
			if(diff == 0){
				return localSum;
			}
			else if (diff < 0 ){
				j--;
			}
			else
				i++;
			if(Math.abs(diff)<minDiff){
				minDiff = Math.abs(diff);
				closestSum = localSum;
			}
		}
		return closestSum;
	}
	public static void main(String[] args)
	{
		ClosestToZero ctz = new ClosestToZero();
		int A[] = {60,-10,70,-80,85};
		
		System.out.println(ctz.closest(A));
	}
}
