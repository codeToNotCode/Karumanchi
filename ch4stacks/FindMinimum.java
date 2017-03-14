/*
 * To implement stacks such that the getMin() function is always O(1) time
 */

package ch4stacks;

import java.util.Stack;

@SuppressWarnings("serial")
public class FindMinimum extends Stack<Integer>
{
	private Stack<Integer> min = new Stack<>();
	
	public void push(int data){
		super.push(data);
		if(min.isEmpty()||min.peek() >= data)
			min.push(data);
	}
	public Integer pop(){
		Integer popped = 0;
		if(!super.isEmpty())
			popped = super.pop();
		if(!min.isEmpty())
			min.pop();
		return popped;
	}
	public int getMin(){
		return min.peek();
	}
	public static void main(String[] args)
	{
		FindMinimum fm = new FindMinimum();
		fm.push(8);fm.push(18);fm.push(0);fm.push(6);
		System.out.println(fm.getMin());
	}
}
