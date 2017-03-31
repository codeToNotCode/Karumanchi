/*
 * To swap a linked list in pairs
 * 1 -> 2 -> 3 -> 4 -> X should become 2 -> 1 -> 4 -> 3 -> X
 * O(n) time Space O(1)
 * Watch this video for better understanding 
 * https://www.youtube.com/watch?v=jiLloHVmLDc
 */

package ch3LinkedLists;


public class SwapPairs
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
	
	///Swap Pairs
	public Node swap(Node h1){
		if(h1 == null || h1.next==null)
			return h1;
		
		Node hNew = h1.next;
		Node p = h1;
		
		while(true){
			Node q = p.next;
			Node trav = q.next;
			q.next = p;
			if( trav==null  || trav.next == null){
				p.next = trav;
				break;
			}
			p.next =trav.next;
			p = trav;
		}
		return hNew;
	}
	public static void main(String[] args)
	{
		SwapPairs list = new SwapPairs();
		
		list.push(100);list.push(90);list.push(80);list.push(70);list.push(50);list.push(150);
		
		list.display(list.head);
		System.out.println();
		list.display(list.swap(list.head));
	}
}
