/*
 * Find stock spans
 */

package ch4stacks;

import java.util.Arrays;
import java.util.Stack;

public class FindingSpans
{
	
	//Brute Force
	//O(n^2) TIme
	//O(1) space
	public int[] find(int A[]){
		int[] spans = new int[A.length];
		for(int i = 0; i<A.length; i++){
			int span = 1;
			int j = i - 1;
			while(j>=0 && A[j]<=A[i]){
				span++;
				j--;
			}
			spans[i] = span;
		}
		return spans;
	}
	
	
	public int[] findSpan(int[] A){
		Stack<Integer> s = new Stack<>();
		s.push(0);
		int[] span = new int[A.length];
		span[0] = 1;
		
		for(int i = 1 ; i < A.length; i++){
			while(!s.isEmpty() && A[s.peek()]<=A[i])
				s.pop();
			span[i] = s.isEmpty() ? i+1 : i - s.peek();
			s.push(i);
		}
		return span;
	}
	public static void main(String[] args)
	{
		FindingSpans fs = new FindingSpans();	
		int A[] = {100,80,60,70,60,75,85};
		System.out.println(Arrays.toString(fs.find(A)));
		System.out.println(Arrays.toString(fs.findSpan(A)));
	}
}
