/*
 * To implement two stacks with one array
 */

package ch4stacks;

public class TwoStacksWithArray
{
	int A[];
	int top1;
	int top2;
	
	public TwoStacksWithArray(int size){
		A = new int[size];
		top1 = -1;
		top2 = size;
	}
	
	public boolean isFull(){
		return top1 == top2 -1;
	}
	public boolean isEmpty1(){
		return top1 == -1;
	}
	public boolean isEmpty2(){
		return top2 == A.length;
	}
	public void push1(int d){
		if(!isFull()){
			A[++top1] = d;
		}
		else
			return;
	}
	public void push2(int d){
		if(!isFull()){
			A[--top2] = d;
		}
		else
			return;
	}
	public int pop1(){
		 if(!isEmpty1())
			 return A[top1--];
		 else
			 return -1;
	}
	public int pop2(){
		 if(!isEmpty2())
			 return A[top2++];
		 else
			 return -1;
	}
	public void display1(){
		if(!isEmpty1()){
			for(int i = top1; i!=-1; i--)
				System.out.println(A[i]);
		}
	}
	public void display2(){
		if(!isEmpty2()){
			for(int i = top2; i!=A.length; i++)
				System.out.println(A[i]);
		}
	}
	public static void main(String[] args)
	{
		TwoStacksWithArray tsa = new TwoStacksWithArray(10);
//		tsa.push1(2);tsa.push1(1);tsa.pop1();
//		tsa.display1();
		tsa.push2(3);tsa.push2(2);tsa.pop2();
		tsa.display2();
	}
}
