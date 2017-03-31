/*
 * Find a number that occurs odd number of times in a given array
 * 0 1 0 1 0 2 2 3 3 1 0 1 2 should return 2
 */

package ch11Searching;

public class OccuringOddTimes
{
	public int occurOdd(int A[]){
		if(A==null||A.length==0)
			return -1;
		int X = 0;
		for(int i = 0; i < A.length; i++)
			X ^= A[i];
		return X;
	}
	public static void main(String[] args)
	{
		OccuringOddTimes oot = new OccuringOddTimes();
		int A[] = {0,1,0,1,2};
		System.out.println(oot.occurOdd(A));
	}
}
