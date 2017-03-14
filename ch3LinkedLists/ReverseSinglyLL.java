/*
  * To reverse a singly linked list
 * 1) Iteration
 * 2) Recursion - IMPORTANT!!! - https://www.youtube.com/watch?v=KYH83T4q6Vs
 */

package ch3LinkedLists;


public class ReverseSinglyLL
{
	class Node
	{
		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	Node head;

	// Push a node
	public void push(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}
	
	public void display(Node head){
		if( head == null ){
			System.err.println("Empty Stack");
			return;
		}
		Node trav = head;
		while(trav != null){
			System.out.print(trav.data+" ");
			trav = trav.next;
		}
	}
	
	//To reverse a linked list
	public Node reverse(Node head){
		if(head == null ){
			return null;
		}
		Node prev,curr,N;
		prev = null;
		curr = null;
		N = head;
		while(N != null ){
			prev = curr;
			curr = N;
			N = N.next;
			curr.next = prev;
		}
		head = curr;
		return head;
	}
	
	//Reverse a linked list using Recursion
	public void reverseRec(Node trav){
		//When you reach the last node, make the last node as the head
		if (trav.next == null ){
			head = trav;
			return;
		}
		reverseRec(trav.next);
		Node p = trav.next;
		p.next = trav;
		trav.next = null;
	}
	
	public static void main(String[] args)
	{
		ReverseSinglyLL list = new ReverseSinglyLL();
		
		list.push(100);list.push(90);list.push(80);list.push(70);list.push(60);list.push(20);
		list.display(list.head);
		System.out.println();
//		
//		list.display(list.reverse(list.head));
//		System.out.println();
		list.reverseRec(list.head);
		System.out.println();
		list.display(list.head);
	}
}
