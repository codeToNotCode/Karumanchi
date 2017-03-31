/*
 * Given an array/string, check whether duplicates exists
 * Algorithms :
 * 1) Brute Force
 * 2)Sorting
 * 3)HashMaps
 * 4)if input consists of only ascii, create a boolean array of 256 and check
 * 5)If input consists of only positive numbers ranging from 0 to the size of the array (implemented here)
 */


package ch11Searching;

public class CheckDuplicates
{
	public boolean checkDups(int A[]){
		if(A==null || A.length == 0)
			return false;
		for(int i = 0; i < A.length; i++){
			if(A[Math.abs(A[i])] < 0 )
				return false;
			A[Math.abs(A[i])] = -A[Math.abs(A[i])];
		}
		return true;
	}
	public static void main(String[] args)
	{
		CheckDuplicates cd = new CheckDuplicates();
		int[] A = {5,1,3,4,2,0};
		System.out.println(cd.checkDups(A));
	}
}
