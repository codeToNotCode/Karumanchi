/*
 * TO convert an infix expression to a postfix expression
 * input - A+((B+C)+(D+E)*F)/G
 * output ABC+DE+F*+G/+
 */

package ch4stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix
{
	public List<Character> convert(List<Character> input){
		if(input == null )
			return null;
		input.add(')');
		
		List<Character> output = new ArrayList<>();
		Stack<Character> stk = new Stack<>();
		stk.push('(');
		for(int i = 0; i <input.size();i++){
			char ch = input.get(i);
			if(ch>='A'&&ch<='Z')
				output.add(ch);
			else if( ch == '(')
				stk.push(ch);
			else if( ch == '*' || ch == '/'){
				while(stk.peek()=='/'||stk.peek()=='*'){
					output.add(stk.pop());
				}
				stk.push(ch);
			}
			else if( ch == '+' || ch == '-'){
				while(stk.peek()=='/'||stk.peek()=='*'||stk.peek()=='+'||stk.peek()=='-'){
					output.add(stk.pop());
				}
				stk.push(ch);
			}
			else if( ch == ')'){
				while(stk.peek() != '('){
					output.add(stk.pop());
				}
				stk.pop();				
			}
		}
		return output;
	}
	public static void main(String[] args)
	{
		InfixToPostfix bs = new InfixToPostfix();
		List<Character> input = new ArrayList<>();
		input.add('A');input.add('*');input.add('B');input.add('-');input.add('(');
		input.add('C');input.add('+');input.add('D');input.add(')');input.add('+');
		input.add('E');
//		input.add('+');input.add('E');input.add(')');input.add('*');
//		input.add('F');input.add(')');input.add('/');input.add('G'); 
		System.out.println(input);
		System.out.println(bs.convert(input));
	}
}
