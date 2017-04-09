/*
 * Find stock spans
 */

package ch4stacks;

import java.util.Arrays;
import java.util.Stack;

public class FindingSpans
{
	
	//Brute Force O(n^2) TIme O(1) space
	/*
	 * Algorithm :
	 * 1) Initialize the spans array to 1 
	 * 2) For i = 1 to stockPrice.length
	 * 		For j=i-1 to j >= 0
	 * 			if( stockPrice[j] is less than stockPrice[i]
	 * 				increment spans[i] by 1
	 * 			else
	 * 				exit the inner loop
	 * 3) Return spans
	 */
	public int[] find(int stockPrice[]){
		int spans[] = new int[stockPrice.length];
		spans[0] = 1;
		for(int i = 1; i < stockPrice.length; i++) {
			spans[i] = 1;
			for(int j = i-1 ; j>=0; j--) 
				if(stockPrice[j] < stockPrice[i])
					spans[i]++;
				else 
					break;
		}
		return spans;
	}
	
	/*
	 * Algorithm  - O(n) time and O(n) stack space for worst case
	 * 1) Create a stack which will contain day number and push 0 as the first day
	 * 2) for i=1 to total number of days
	 * 3)	while stack is not empty and stockPrice[i] is greater than stockPrice[topOfStack]
	 * 4)		keep Popping from the stack
	 * 5)	if stack is empty : spans[i] is equal to i+1
	 * 6) 	else spans[i] is equal to i - topOfStack
	 * 7) Return spans
	 */
	public int[] findSpan(int[] stockPrice){
		Stack<Integer> s = new Stack<>();
		s.push(0);
		int[] span = new int[stockPrice.length];
		span[0] = 1;
		
		for(int i = 1 ; i < stockPrice.length; i++){
			while(!s.isEmpty() && stockPrice[s.peek()]<=stockPrice[i])
				s.pop();
			span[i] = s.isEmpty() ? i+1 : i - s.peek();
			s.push(i);
		}
		return span;
	}
	public static void main(String[] args)
	{
		FindingSpans fs = new FindingSpans();	
		int A[] = {10,20,60,70,160,75,85};
		System.out.println(Arrays.toString(fs.find(A)));
		System.out.println(Arrays.toString(fs.findSpan(A)));
	}
}
