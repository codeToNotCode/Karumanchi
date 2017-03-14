/*
 * To check whether there is a loop in the linked list or not
 * 2) To find the starting point of the loop
 * 3) To find the number of nodes in the loop
 */

package ch3LinkedLists;

public class HasACycle
{
	class Node
	{
		char data;
		Node next;

		Node(char d)
		{
			data = d;
			next = null;
		}
	}

	Node head;

	// Push a node
	public void push(char data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	public int hasLoop(Node head){
		if(head == null ){
			System.err.println("Empty List");
			return 0;
		}
		Node trav1 = head;
		Node trav2 = head;
		
		while(trav2.next != null && trav1.next != null ){
			trav2 = trav2.next.next;
			trav1 = trav1.next;
			
			//If Loop occurs break
			if( trav2.equals(trav1 ))
				break;
		}
		
		//If either of the pointers reach the end, no loop
		if( trav1 == null || trav2 == null ){
			System.err.println("No Loop");
			return 0;
		}
		//To find the starting node in the loop
		trav1 = head;
		while( trav1 != trav2 ){
			trav1 = trav1.next;
			trav2 = trav2.next;
		}
		
		//To find the number of elements in the loop, including the start element
		int count = 0;
		while(trav1.next != trav2 ){
			trav1 = trav1.next;
			count++;
		}
		return count;
	}
	
	// Driver Function
	public static void main(String[] args)
	{
		// Create a Linked list
		HasACycle llist = new HasACycle();

		// Insert nodes into the list
		llist.push('A');
		llist.push('B');
		llist.push('C');
		llist.push('D');
		llist.push('E');
		llist.push('F');
		llist.push('G');

		/* Create loop for testing */
		//llist.head.next.next.next.next = llist.head.next;
		llist.head.next = llist.head;
		System.out.println(llist.hasLoop(llist.head)+1);
	}

}
