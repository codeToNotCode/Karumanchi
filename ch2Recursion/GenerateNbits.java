/*
 * To generate all the strings that are possible from a n-bit binary number 
 * Time Complexity - O(2^n)
 * Backtracking
 */

package ch2Recursion;

import java.util.Arrays;

public class GenerateNbits
{
	
	public static void Binary(String A[], int n){
		if( n < 1 )
		{
			StringBuilder sb = new StringBuilder(Arrays.toString(A));
			System.out.println(sb.reverse() );
		}
		else
		{
			A[n-1] = "0";
			Binary(A,n-1);
			A[n-1] = "1";
			Binary(A,n-1);
		}
	}
	public static void main(String[] args)
	{
		String A[] = new String[4];
		Binary(A,4);
	}
}
