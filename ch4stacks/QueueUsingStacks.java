/*
 * Implement a queue using two stacks
 */


package ch4stacks;

import java.util.Stack;

public class QueueUsingStacks
{
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	//To check whether queue is empty of not
	public boolean isEmpty(){
		return s1.isEmpty()&&s2.isEmpty();
	}
	public void enqueue(int d){
		s1.push(d);
	}
	public int dequeue(){
		int popped = 0;
		if(!isEmpty()){
			if(!s2.isEmpty()){
				popped = s2.pop();
			}
			else{
				while(!s1.isEmpty())
					s2.push(s1.pop());
				popped =s2.pop();
			}
		}
		return popped;
	}
	
	public void display(){
		while(!s2.isEmpty())
			System.out.print(s2.pop()+" ");
		while(!s1.isEmpty())
			s2.push(s1.pop());
		while(!s2.isEmpty())  
			System.out.print(s2.pop()+" ");
		
	}
	public static void main(String[] args)
	{
		QueueUsingStacks qs = new QueueUsingStacks();
		qs.enqueue(4);
		qs.enqueue(3);
		qs.enqueue(1);
		qs.enqueue(2);
		qs.enqueue(2);
		qs.dequeue();
		qs.display();
	}
}
