/*
 * To generate all the possible strings from a k-ary string
 */

package ch2Recursion;

import java.util.Arrays;

public class GenerateAllKaryStrings
{
	
	public static void Kary(String[] A, int n, int k)
	{
		if( n < 1)
		{
			StringBuilder sb = new StringBuilder(Arrays.toString(A));
			System.out.println(sb.reverse());
		}
		else
		{
			for( int j =  1; j <= k ; j++ )
			{
				A[n-1] = String.valueOf(j);
				Kary(A,n-1,k);
			}
		}
	}
	public static void main(String[] args)
	{
		String A[] = new String[3];
		Kary(A,3,3);
	}
}
