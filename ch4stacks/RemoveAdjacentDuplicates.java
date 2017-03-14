/*
 * To remove adjacent duplicates from a given array
 * 1 5 6 8 8 8 0 1 1 0 6 5 ............output : 1
 * 1 9 6 8 8 8 0 1 1 0 6 5 ............output : 1 9 5
 * 
 * O(n) solution 
 */

package ch4stacks;

import java.util.Stack;

public class RemoveAdjacentDuplicates
{
	public String remAdjDups(String A){
		if(A==null || A.length()==0)
			return A.toString();
		Stack<Character> s = new Stack<>();
		char prev;
		s.push(A.charAt(0));
		for(int i = 1 ; i < A.length(); i++){
			prev = A.charAt(i-1);
			if(A.charAt(i) == prev && !s.isEmpty()){
				if(A.charAt(i) == s.peek())
					s.pop();
				continue;
			}
			else if(!s.isEmpty() && A.charAt(i) == s.peek()){
				s.pop();
				continue;
			}
			s.push(A.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty())
			sb.append(s.pop());
		
		return sb.reverse().toString();
	}
	public static void main(String[] args)
	{
		RemoveAdjacentDuplicates sad = new RemoveAdjacentDuplicates();
		String A = "acaaabbbacdddd";
		System.out.println(sad.remAdjDups(A));
	}
}
