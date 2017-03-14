/*
 * TO check whether the parenthesis given in the form of a string are balanced or not
 * [[A+B] + {(A-b)}] should return true
 * O(n) time and space
 */

package ch4stacks;

import java.util.Stack;

public class BalancedSymbols
{
	public boolean balance(String s){
		if(s == null || s.length() < 2)	return false;
		Stack<Character> stk = new Stack<>();
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(ch=='['||ch=='{'||ch=='<'||ch=='(')
				stk.push(ch);
			else{
				switch(ch){
					case ']':  if(!stk.isEmpty() && stk.peek()=='['){
									stk.pop();
									break;
								}
								else
									return false;
					case '}':  if(!stk.isEmpty() && stk.peek()=='{'){
									stk.pop();
									break;
								}
								else
									return false;								
					case '>':  if(!stk.isEmpty() && stk.peek()=='<'){
									stk.pop();
									break;
								}
								else
									return false;	
					case ')':  if(!stk.isEmpty() && stk.peek()=='('){
									stk.pop();
									break;
								}
								else
									return false;
				}
			}
		}
		if(stk.isEmpty())
			return true;
		else
			return false;
	}
	public static void main(String[] args)
	{
		BalancedSymbols bs = new BalancedSymbols();
		System.out.println(bs.balance("[[A+B] + {(A-b)}]"));
	}
}
