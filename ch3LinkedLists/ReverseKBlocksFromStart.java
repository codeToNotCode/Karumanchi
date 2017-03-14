/*
 * To reverse the first k elements of a given linked list
 * 1->2->3->4->5->6->null k = 3 
 * output 3->2->1->4->5->6->null
 * 
 * Here the normal reverse procedure is changed a bit
 * 
 */


package ch3LinkedLists;


public class ReverseKBlocksFromStart
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
	
	//To reverse first k elements of the linked list
	public Node revKBlocks(Node head,int k){
		if( k == 0 || head == null )
			return head;
		int length = 0;
		Node trav = head;
		while (trav!=null){
			length++;
			trav = trav.next;
		}
		if(k > length)
			k = length;
		Node kth = findKthNode(head,k);
		Node attach = kth.next;
		reverse(head,kth);
		head.next = attach;
		head = kth;
		return head;
	}
	//Find the kth node in the linked list
	private Node findKthNode(Node trav, int k){
		for(int i = 1; i < k ; i++)
			trav = trav.next;
		return trav;
	}
	//Reverse the elements upto the kth node
	private void reverse(Node trav, Node kth){
		if( trav == kth){
			head = kth;
			return;
		}
		reverse(trav.next,kth);
		Node p = trav.next;
		p.next = trav;
		trav.next = null;
	}
	public static void main(String[] args)
	{
		ReverseKBlocksFromStart list = new ReverseKBlocksFromStart();
		
		list.push(100);list.push(90);list.push(80);list.push(70);list.push(50);list.push(150);
		
		list.display(list.head);
		System.out.println();
		list.display(list.revKBlocks(list.head,2));
	}
	

}
