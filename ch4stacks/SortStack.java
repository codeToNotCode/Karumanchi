/*
 * To sort a given stack in increasing order
 * 4 2 3 1
 * output  1 2 3 4 
 */

package ch4stacks;

import java.util.Stack;

public class SortStack
{
	public Stack<Integer> sort(Stack<Integer> stk){
		if(stk == null || stk.isEmpty())
			return stk;
		Stack<Integer> sorted = new Stack<>();
		sorted.push(stk.pop());
		
		while(!stk.isEmpty()){
			int temp = stk.pop();
			while(!sorted.isEmpty()&&temp>sorted.peek())
				stk.push(sorted.pop());
			sorted.push(temp);
		}
		return sorted;
	}
	public static void main(String[] args)
	{
		SortStack ss = new SortStack();
		Stack<Integer> stk = new Stack<>();
		stk.push(4);stk.push(2);stk.push(3);stk.push(1);
	
		Stack<Integer> result = ss.sort(stk);
		while(!result.isEmpty())
			System.out.println(result.pop());
	}
}
