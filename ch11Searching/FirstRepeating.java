/*
 * To return the first repeating number in the array of integers
 * 3 2 1 2 2 3 should return 3 
 */

package ch11Searching;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeating
{
	
	//Using LinkedHashMap
	//O(n) time 
	//O(n) space
	public int repeating(int A[]){
		if(A==null || A.length==0)
			return -1;
		LinkedHashMap<Integer,Boolean> lmap = new LinkedHashMap<>();
		for(int i = 0 ; i < A.length; i++)
			if(!lmap.containsKey(A[i]))
				lmap.put(A[i], true);
			else
				lmap.put(A[i], false);
		
		for(Map.Entry<Integer,Boolean> e : lmap.entrySet()){
			if(e.getValue()==false)
				return e.getKey();
		}
		return -1;
	}
	
	//Using normal HashMap
	//O(n) time
	//O(n) space
	public int firstRepeat(int A[]){
		if(A==null || A.length== 0)
			return -1;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0 ; i < A.length ; i++)
			if(!map.containsKey(A[i]))
				map.put(A[i], i+1);
			else if( map.get(A[i]) > 0)
				map.put(A[i], -map.get(A[i]));
		
		int maxNeg = Integer.MIN_VALUE;
		int firstRepeat = -1;
		
		for(Map.Entry<Integer, Integer> e : map.entrySet()){
			if(e.getValue()<0 && e.getValue()>maxNeg){
				maxNeg = e.getValue();
				firstRepeat = e.getKey();
			}
		}
		return firstRepeat;
	}
	
	
	public static void main(String[] args)
	{
		FirstRepeating fr = new FirstRepeating();
		int A[] = {3,2,1,1,2};
		System.out.println(fr.repeating(A));
		System.out.println(fr.firstRepeat(A));
	}
}
