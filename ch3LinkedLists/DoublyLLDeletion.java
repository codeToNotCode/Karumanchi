/*
 * To perform deletion operation on a doubly linked list
 * 1) Delete the first node
 * 2) Delete the last node
 * 3) Delete a node with the given data element
 */

package ch3LinkedLists;


public class DoublyLLDeletion
{
	class Node
	{
		int data;
		Node next;
		Node prev;

		public Node(int d)
		{
			data = d;
			next = null;
			prev = null;
		}
	}

	Node head;
	Node tail;
	
	//Delete the head node
	public Node pop(){
		Node temp = head;
		if( head == null ){
			System.err.println("Empty List");
			return null;
		}
		if( head == tail){
			Node pop = head;
			head = null;
			tail = null;
			return pop;
		}
		
		head.next.prev = null;
		head = head.next;
		
		return temp;
	}
	
	//Delete the last node
	public Node deleteLast(){
		if( head == null || tail == null ){
			System.err.println("Empty List");
			return null;
		}
		
		Node deleted = tail;
		tail = tail.prev;
		tail.next = null;
		
		return deleted;
	}
	
	//Delete a node that corrosponds to the given data element
	public Node deleteElement(int value){
		Node trav = head;
		if( head == null || tail == null){
			System.err.println("Empty List");
			return null;
		}
		while(trav!=null && trav.data != value)
			trav = trav.next;
		if( trav == null ){
			System.err.println("Element not found");
			return null;
		}
		if(trav == tail ){
			return deleteLast();
		}
			
		Node deleted = trav;
		trav.prev.next = trav.next;
		trav.next.prev = trav.prev;
		
		return deleted;
	}
	
	//Insert data at the begining of the list
	public Node push(int data)
	{
		Node n = new Node(data);
		if (head == null || tail == null)
		{
			head = n;
			tail = n;
			return head;
		}
		if( head == tail ){
			n.next = head;
			head.prev = n;
			head = n;
			tail.prev = head;
			return head;
		}
		n.next = head;
		head.prev = n;
		head = n;

				
		return head;
	}

	//To display the linked list
	public void display(Node head)
	{
		if (head == null || tail == null)
		{
			System.err.println("List is empty");
			return;
		}
		Node trav = head;
		while (trav != null)
		{
			System.out.print(trav.data + " ");
			trav = trav.next;
		}
		
		System.out.println();
		
		Node backTrav = tail;
		while( backTrav != null){
			System.out.print(backTrav.data + " " );
			backTrav = backTrav.prev;
		}
	}

	
	//Driver Function
	public static void main(String[] args)
	{
		DoublyLLDeletion dll = new DoublyLLDeletion();
		dll.push(23);		dll.push(2);
		dll.push(323);		dll.push(50);
		dll.push(213);		dll.push(12);
		dll.push(3323);		dll.push(530);
		System.out.println("Deleted Node "+dll.pop().data);
		System.out.println("Deleted Node "+dll.deleteLast().data);
		System.out.println("Deleted Node "+dll.deleteElement(2).data);
		dll.display(dll.head);
	}
}
