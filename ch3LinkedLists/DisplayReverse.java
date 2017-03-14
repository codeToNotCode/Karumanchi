/*
 * To display a linked list in reverse order
 * Recursion - O(n) time . O(n) stack space
 */

package ch3LinkedLists;

public class DisplayReverse
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
	
	//TO display the list in reverse order
	public void displayReverse(Node trav){
		//Base case
		if(trav == null)
			return;
		
		//Reach the end of loop
		displayReverse(trav.next);
		
		//When recursion is unfolding, print its elements
		System.out.print(trav.data+" ");
	}
	
	
	public static void main(String[] args)
	{
		DisplayReverse list = new DisplayReverse();
		
		list.push(100);list.push(90);list.push(80);list.push(70);list.push(60);list.push(60);
		list.push(100);list.push(90);list.push(80);list.push(70);list.push(60);
		list.display(list.head);
		System.out.println();
		list.displayReverse(list.head);
	}
}
