/*
 * TO evaluate a given postfix expression
 * input  123*+5-
 * output 2
 */


package ch4stacks;

import java.util.Stack;

public class PostFixEvaluation
{
	public int pfEval(String str){
		if(str == null || str.length()==0)
			return -1;
		Stack<Integer> stk = new Stack<>();
		for(int i = 0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(ch!='*'&&ch!='/'&&ch!='+'&&ch!='-')
				stk.push(Character.getNumericValue(ch));
			else{
				int y = stk.pop();
				int x = stk.pop();
				int result = evaluate(x,ch,y);
				stk.push(result);
			}
		}
		return stk.peek();
	}
	
	private int evaluate(int x, char ch, int y){
		
		switch(ch){
		case '+':	return x + y;
		case '-':	return x - y;
		case '/':	if(y!=0)
						return x / y;
					else
					{
						System.err.println("Divide by zero error");
						return -1;
					}
		case '*':	return x * y;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		PostFixEvaluation pfe = new PostFixEvaluation();
		System.out.println(pfe.pfEval("92+53-/7*"));
	}
}
