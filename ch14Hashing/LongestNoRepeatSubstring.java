/*
 * To find the length of longest substring which does not contains any repeating characters
 * ["abcabcabc"] should return 3
 * 
 * View the below solution for complete implementation details
 * https://leetcode.com/articles/longest-substring-without-repeating-characters/#approach-2-sliding-window-accepted
 */

package ch14Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class LongestNoRepeatSubstring {
	
	//Brute Force
	//O(n^3)
	public int findLong(String s){
		int max  = 0;
		for(int i = 0; i < s.length(); i++){
			for(int j = i+ 1; j<=s.length(); j++){
				if(allUnique(s,i,j))
					max = Math.max(max, j-i);
			}
		}
		return max;
	}
	private boolean allUnique(String s, int start, int end){
		HashSet<Character> set = new HashSet<>();
		for(int i = start; i<end; i++){
			char ch = s.charAt(i);
			if(set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}
	
	
	//Using Hashset as a Sliding Window
	//O(n)
	public int findLongest(String s){
		int max  = 0;
		HashSet<Character> set = new HashSet<>();
		int i = 0; int j = 0;
		while( i < s.length() && j < s.length()){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				max = Math.max(max, j-i);
			}else{
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}
	
	
	//Sliding Window Optimized
	//Using HashMap
	public int findWithMap(String s){
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0, j = 0; j<s.length(); j++){
			if(map.containsKey(s.charAt(j))){
				i = Math.max(map.get(s.charAt(j)), i);
			}
			max = Math.max(max, j-i+1);
			map.put(s.charAt(j), j+1);
		}
		return max;
	}
	
	
	//If the character set of the input is restricted
	//int[26] for Letters 'a' - 'z' or 'A' - 'Z'
	//int[128] for ASCII
	//int[256] for Extended ASCII
	public int findLength(String s){
		int max = 0;
		int[] index = new int[128];
		for(int j=0,i=0;j<s.length(); j++){
			i = Math.max(index[s.charAt(j)], i);
			max = Math.max(max, j-i+1);
			index[s.charAt(j)] = j + 1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		LongestNoRepeatSubstring lnrs = new LongestNoRepeatSubstring();
		System.out.println("Using Brute Force "+lnrs.findLong("aaaPrasandeep Singh"));
		System.out.println("Using Sliding Window "+lnrs.findLongest("aaaPrasandeep Singh"));
		System.out.println("Using Optimized Sliding Window "+lnrs.findWithMap("aaaPrasandeep Singh"));
		System.out.println("Using Restricted Character set "+lnrs.findLength("aaaPrasandeep Singh"));
	}
}
