/*
 * To check whether the given array is sorted or not using recursion
 */

package ch2Recursion;

public class isArraySorted
{
	
	public static boolean isSorted(int[] A,int index)
	{
		if( index==1 || A.length == 1){
			return true;
		}
		return ((A[index-1] < A[index -2])?false : isSorted(A,index-1));
	}
	
	
	public static void main(String[] args)
	{
		int[] A = {10,20,90,140,150};
		System.out.println(isSorted(A,A.length));
	}
}
