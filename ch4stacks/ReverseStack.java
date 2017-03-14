/*
 * TO reverse a stack without using additional data structure
 * The Time complexity of this algo - O(n^2)
 * Space Complexity - O(n)
 * https://www.youtube.com/watch?v=dQsZP8UvHVk
 */

package ch4stacks;

import java.util.Stack;

public class ReverseStack
{
	public Stack<Integer> reverse(Stack<Integer> stk){
		if(stk.isEmpty())
			return stk;
		int temp = stk.pop();
		stk = reverse(stk);
		insertAtBottom(stk,temp);
		return stk;
	}
	private void insertAtBottom(Stack<Integer> stk, int data){
		if(stk.isEmpty()){
			stk.push(data);
			return;
		}
		int temp = stk.pop();
		insertAtBottom(stk,data);
		stk.push(temp);
	}
	
	
	public static void main(String[] args)
	{
		ReverseStack rs = new ReverseStack();
		Stack<Integer> s = new Stack<>();
		s.push(1);s.push(2);s.push(3);s.push(4);
	
	
		s = rs.reverse(s);
		
		System.out.println("Reversed Stack :\n");
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
}
