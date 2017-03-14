/*
 * To evaluate the given infix expression
 *   "10 + 2 * 6"            ---> 22
 *   "100 * 2 + 12"          ---> 212
 *   "100 * ( 2 + 12 )"      ---> 1400
 *   "100 * ( 2 + 12 ) / 14" ---> 100   
 *   
 *   http://www.geeksforgeeks.org/expression-evaluation/
 */

package ch4stacks;

import java.util.Stack;

public class InfixEvaluation
{
	public int inEval(String str){
		if(str==null || str.length()==0)
			return -1;
		char tokens[] = str.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		
		for(int i = 0; i<tokens.length; i++){
			if(tokens[i] == ' ')
				continue;
			
			if(tokens[i]>='0' && tokens[i]<='9'){
				StringBuffer sb =new StringBuffer();
				while(i<tokens.length && tokens[i]>='0'&&tokens[i]<='9')
					sb.append(tokens[i++]);
				values.push(Integer.parseInt(sb.toString()));
			}
			else if(tokens[i] == '(')
				operators.push(tokens[i]);
			else if(tokens[i]==')'){
				while(operators.peek()!='(')
					values.push(applyOperation(operators.pop(),values.pop(),values.pop()));
				operators.pop();
			}
			else if(tokens[i]=='+'||tokens[i]=='-'||tokens[i]=='*'||tokens[i]=='/'){
				while(!operators.isEmpty() && hasPrecedence(tokens[i],operators.peek()))
					values.push(applyOperation(operators.pop(),values.pop(),values.pop()));
				operators.push(tokens[i]);
			}
		}
		while(!operators.isEmpty()){
			values.push(applyOperation(operators.pop(),values.pop(),values.pop()));
		}
		return values.pop();
	}
	private boolean hasPrecedence(Character op1,Character op2){
		if(op2=='('||op2==')')
			return false;
		if((op1=='*'||op1=='/')&&(op2=='+'||op2=='-'))
			return false;
		return true;
	}
	private int applyOperation(Character op, int b, int a){
		switch(op){
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
		}
		return 0;
	}
	public static void main(String[] args)
	{
		InfixEvaluation ie = new InfixEvaluation();
		System.out.println(ie.inEval("100 * ( 2 + 12 ) / 14"));
	}
}
