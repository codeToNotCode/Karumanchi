/*
 * To check whether a given number is a colorful number or not
 * A number can be broken into different contiguous sub-subsequence parts. 
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
 * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 */

package ch14Hashing;

import java.util.HashSet;

public class ColorFulNumber {
	public boolean isColorfull(int num){
		String s = String.valueOf(num);
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i<s.length(); i++){
			if(set.contains(s.charAt(i)-'0'))
				return false;
			set.add(s.charAt(i)-'0');
		}
		for(int i=0; i+1<s.length(); i++){
			int num1 = s.charAt(i)-'0';
			int num2 = s.charAt(i+1)-'0';
			if(set.contains(num1*num2))
				return false;
			set.add(num1*num2);
		}
		return true;
	}
	public static void main(String[] args) {
		ColorFulNumber cm = new ColorFulNumber();
		System.out.println(cm.isColorfull(3245));
	}
}