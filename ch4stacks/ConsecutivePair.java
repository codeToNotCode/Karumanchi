/*
 * To check whether the successive elements in the stack are consecutive or not
 * If number of elements are odd, discard the last element
 */
package ch4stacks;

import java.util.Stack;

public class ConsecutivePair
{
	public boolean consecutive(Stack<Integer> s){
		if(s==null || s.isEmpty())
			return false;
		if(s.size()%2!=0)
			s.pop();
		if(s.isEmpty())
			return false;
		
		while(!s.isEmpty()){
			int t1 = s.pop();
			int t2 = s.pop();
			if((t1!=t2-1)&&(t1!=t2+1))
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		ConsecutivePair cp = new ConsecutivePair();
		Stack<Integer> s = new Stack<>();
		s.push(-2);s.push(-3);s.push(11);s.push(12);s.push(8);
//		while(!s.isEmpty())
//			System.out.println(s.pop());
		System.out.println(cp.consecutive(s));
	}
}
