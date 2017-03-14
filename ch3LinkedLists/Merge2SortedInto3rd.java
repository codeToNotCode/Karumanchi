/*
 * To merge two sorted linked lists into a new lists in sorted order
 * O(m+n) Time 
 * Using Recursion 
 * Using Iteration
 */


package ch3LinkedLists;


public class Merge2SortedInto3rd
{
	class Node
	{
		int data;
		Node next;

		public Node(int d)
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

	public void display(Node head)
	{
		if (head == null)
		{
			System.err.println("Empty Stack");
			return;
		}
		Node trav = head;
		while (trav != null)
		{
			System.out.print(trav.data + " ");
			trav = trav.next;
		}
	}
	
	//Merge two nodes
	public Node merge(Node h1, Node h2){
		if(h1 == null)	return h2;
		if(h2 == null)	return h1;
		
		Node trav1 = h1;
		Node trav2 = h2;
		Node h3 ;
		
		if( trav1.data<=trav2.data){
			h3 = trav1;
			trav1 = trav1.next;
		}
		else{
			h3 = trav2;
			trav2 = trav2.next;
		}
		Node trav = h3;
		while(trav1!=null && trav2!=null){
			if( trav1.data<=trav2.data){
				trav.next = trav1;
				trav1 = trav1.next;
			}
			else{
				trav.next= trav2;
				trav2 = trav2.next;
			}
			trav = trav.next;
		}
		if( trav1 == null)
			trav.next= trav2;
		else
			trav.next = trav1;
		
		return h3;
	}
	
	
	//Merge using Recursion
	public Node mergeRec(Node h1, Node h2){
		if( h1 == null )
			return h2;
		if( h2 == null )
			return h1;
		Node h3 = new Node(0);
		if( h1.data <= h2.data ){
			h3 = h1;
			h3.next = mergeRec(h1.next, h2);
		}
		else{
			h3 = h2;
			h3.next = mergeRec(h2.next,h1);
		}
		return h3;
	}
	public static void main(String[] args)
	{
		Merge2SortedInto3rd list = new Merge2SortedInto3rd();
		Merge2SortedInto3rd list2 = new Merge2SortedInto3rd();
		
		list.push(100);list.push(90);list.push(80);list.push(70);list.push(60);list.push(60);
		list2.push(110);list2.push(80);list2.push(30);list2.push(20);list2.push(10);list2.push(9);list.push(0);
		
		list.display(list.head);
		System.out.println();
		list2.display(list2.head);
		System.out.println();
		list.display((list.merge(list.head,list2.head)));
		System.out.println();
		//list2.display((list.mergeRec(list.head,list2.head)));
	}
}
