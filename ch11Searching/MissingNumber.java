/*
 * given n-1 integers from 1 to n . Find the missing integer
 * 1 2 4 6 3 7 8 should output 5
 */

package ch11Searching;

import java.util.HashMap;
import java.util.Map;

public class MissingNumber
{
	//Using HashMap
	//O(n) time
	//O(n) space
	public int missing(int A[]){
		if(A==null || A.length==0)
			return -1;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 1; i <= A.length+1; i++ )
			map.put(i, 0);
		for(int i = 0 ; i < A.length; i++)
			if(map.containsKey(A[i]))
				map.put(A[i], 1);
		for(Map.Entry<Integer,Integer> e : map.entrySet()){
			if(e.getValue()==0)
				return e.getKey();
		}
		return -1;
	}
	
	//Using sum
	//Will not work if the sum overflows
	//O(n) time
	//O(1) space
	public int missingNum(int A[]){
		if(A==null || A.length==0)
			return -1;
		int sum = 0;
		int n = A.length+1;
		int actualSum = (n*(n+1))/2;
		for(int i = 0 ; i <A.length; i++)
			sum+=A[i];
		return actualSum-sum;
	}
	
	//Using XOR
	//Solution to overflow problem
	public int missingNumber(int A[]){
		if(A==null||A.length==0)
			return -1;
		int n = A.length;
		int X=0,Y=0;
		for(int i = 0 ; i < n; i++)
			X^=A[i];
		for(int i = 1 ; i <=n+1; i++)
			Y^=i;
		return X^Y;
	}
	public static void main(String[] args)
	{
		MissingNumber mn = new MissingNumber();
		int A[] = {1,3,4,2,6,5,8};
		System.out.println(mn.missing(A));
		System.out.println(mn.missingNum(A));
		System.out.println(mn.missingNumber(A));
	}
}
