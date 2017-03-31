/*
 * Given an array of integers, check whether there exists a pythagorean triplet or not
 * a*a + b*b = c*c
 */


package ch11Searching;

import java.util.Arrays;

public class PythagoreanTriplet
{
	public boolean pytha(int[] A){
		if(A==null || A.length<3)
			return false;
		
		//3 1 4 6 5
		for(int i = 0 ; i < A.length; i++)
			A[i] = A[i]*A[i];
		
		//9 1 16 36 25
		Arrays.sort(A);
		
		//1 9 16 25 36
		for(int i = A.length-1; i>0; i--){
			int start = 0;
			int end = i - 1;
			while(start<end){
				if(A[start]+A[end] == A[i])
					return true;
				else if (A[start]+A[end] < A[i])
					start++;
				else
					end--;
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		PythagoreanTriplet pt = new PythagoreanTriplet();
		int A[] = {3,1,4,6,5};
		System.out.println(pt.pytha(A));
	}
}
