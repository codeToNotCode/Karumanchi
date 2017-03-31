/*
 * Given a sorted array of integers, find the number of occurences of a given integer
 * 0 1 1 2 2 3 3 3 3 4 4  , number of occurences of 2 = 2
 */

package ch11Searching;

public class NumberOfOccurences
{
	public int timesRepeat(int A[], int k){
		if(A==null || A.length == 0)
			return -1;
		int firstOcc = findOcc(A,k,true);
		int lastOcc = findOcc(A,k,false);
		if(lastOcc == -1 && firstOcc == -1)
			return -1;
		return lastOcc - firstOcc + 1;
	}
	private int findOcc(int A[], int k, boolean findfirst){
		int start = 0;
		int end = A.length - 1;
		int res = -1;
		while(start<=end){
			int mid = start + (end-start)/2;
			if(A[mid] == k){
				res = mid;
				if(findfirst == true)
					end = mid -1;
				else
					start = mid + 1;
			}
			else if(A[mid] < k)
				start = mid + 1;
			else
				end = mid -1;
		}
		return res;
	}
	public static void main(String[] args)
	{
		NumberOfOccurences noo = new NumberOfOccurences();
		int A[] = {0,0,0,1,1,2,2,2,2,4,4,4,5,5,5,5,5,5,5,5,6};
		System.out.println(noo.timesRepeat(A,6));
	}
}
