/*
 * To find middle element of the given linked list
 * Use 2 pointers - BEST!
 * Time - O(n/2) ~~ O(n) . Space O(1)
 */

package ch3LinkedLists;

public class FindMiddle
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
	
	//Find Middle Element
	public Node getMiddle(Node head){
		if(head == null ){
			System.err.println("Empty List");
			return null;
		}
		
		Node trav1 = head;
		Node trav2 = head;
		
		//1st check is for odd numbers
		//2nd Check is for even numbers
		while( trav1!=null && trav1.next!= null ){
			trav1 = trav1.next.next;
			trav2 = trav2.next;
		}
		//System.out.println(trav1.data);
		return trav2;
	}
	public static void main(String[] args)
	{
		FindMiddle list = new FindMiddle();
		
		list.push(100);list.push(90);list.push(80);list.push(70);//list.push(60);
	//	list.push(100);list.push(90);list.push(80);list.push(70);list.push(70);list.push(70);list.push(70);
		list.display(list.head);
		System.out.println();
		System.out.println(list.getMiddle(list.head).data);
	}
}