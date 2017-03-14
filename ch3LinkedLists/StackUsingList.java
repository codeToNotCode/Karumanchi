/*
 * TO implement a stack using linked lists
 */

package ch3LinkedLists;

public class StackUsingList
{
	class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
			next = null;
		}
	}
	Node top;
	
	public void display(){
		if( top == null ){
			System.err.println("Empty Stack");
			return;
		}
		Node trav = top;
		while(trav != null){
			System.out.print(trav.data+" ");
			trav = trav.next;
		}
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int peek(){
		if(!isEmpty())
			return top.data;
		else{
			System.err.println("Empty Stack");
			return -1;
		}
	}
	
	public void push(int data){
		Node n = new Node(data);
		if(isEmpty()){
			top = n;
		}
		else{
		n.next = top;
		top = n;
		}
	}
	
	public Node pop(){
		if(isEmpty()){
			System.err.println("Empty Stack");
			return null;
		}
		Node popped = top;
		top = top.next;
		return popped;
	}
	
	
	public static void main(String[] args)
	{
		StackUsingList stack = new StackUsingList();
		
		stack.push(0);stack.push(10);stack.push(20);stack.push(30);stack.push(40);stack.push(220);
		System.out.println("Topmost Element of the stack :"+stack.peek());
		stack.display();
		System.out.println("Popped Element :"+stack.pop().data);
		stack.display();
	}
}
