/*
 * Find the index at which the array is circularly rotated
 * 8 9 5 4 3 2 1 0 should return 1
 */


package ch11Searching;

public class FindRotatedIndex
{
	public int findIndex(int A[]){
		if( A.length == 0 ||  A.length == 1)
			return 0;
		int i = 0;
		int j = A.length -1 ;
		while(i < j ){
			int mid = i + (j - i)/2;
			if( A[mid] >= A[mid-1] && A[mid] >= A[mid+1])
				return mid;
			else if( A[mid] >= A[mid-1] && A[mid] < A[mid+1])
				i++;
			else if( A[mid] >= A[mid+1] && A[mid] < A[mid-1])
				j--;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		FindRotatedIndex fri = new FindRotatedIndex();
		int A[] = {8,9,10,14,113,212,2141,1241410};
		System.out.println(fri.findIndex(A));
		
	}
}
