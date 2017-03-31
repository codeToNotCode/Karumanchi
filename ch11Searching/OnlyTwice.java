/*
 * Given an array of integers from 1 to n such that all integers repeat thrice except one integer which repeats twice
 * find that integer
 * n = 4
 * 2,1,3,2,2,3,4,1,4,1,4 should return 3
 */

package ch11Searching;

public class OnlyTwice
{
	public int findTwice(int A[], int n){
		if(A==null|| A.length==0 )
			return -1;
		int X = A[0];
		for(int i = 1 ; i<A.length;i++)
			X^=A[i];
		for(int i = 1 ; i <= n ; i++)
			X^=i;
		return X;
	}
	public static void main(String[] args)
	{
		OnlyTwice ot = new OnlyTwice();
		int A[] = {2,1,3,3,2,3,4,2,4,1,1};
		System.out.println(ot.findTwice(A,4));
	}
}
