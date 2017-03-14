/*
 * TO insert a new node into an sorted linked list at the appropriate position
 */

package ch3LinkedLists;


public class InsertIntoSorted
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
	
	
	//Insert into sorted
	public Node insert(int data){
		Node n = new Node(data);
		if(head == null){
			head = n;
			return head;
		}
		if( head.data >=  data){
			n.next = head;
			head = n;
			return head;
		}
		
		Node trav = head;
		Node prev = null;
		while(trav!=null && trav.data < data){
			prev = trav;
			trav= trav.next;
		}
		n.next = prev.next;
		prev.next = n;
		
		return head;
	}
	
	public void display(){
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
	public static void main(String[] args)
	{
		InsertIntoSorted list = new InsertIntoSorted();
		
		list.push(100);list.push(90);list.push(80);list.push(70);list.push(60);list.push(20);
		list.display();
		System.out.println();
		list.insert(20);
		list.display();
	}
}
