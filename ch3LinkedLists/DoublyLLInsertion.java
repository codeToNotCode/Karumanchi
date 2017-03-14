/*
 * To insert data into a Doubly linked list
 * 1) Insert at the begining (push operation)
 * 2) Insert at the end
 * 3) Insert at a given position
 */


package ch3LinkedLists;

public class DoublyLLInsertion
{
	class Node{
		int  data;
		Node next;
		Node prev;
		
		public Node(int d){
			data = d;
			next = prev = null;
		}
	}
	
	Node head;
	
	/*
	 * Insert data at the begining of the list
	 */
	public Node push (int data){
		Node n = new Node(data);
		if(head == null){
			head = n;
			return head;
		}
		n.next = head;
		head.prev = n;
		head = n;
		return head;
	}

	
	/*
	 * Insert data at the end of the list
	 */
	 public Node insertAtEnd(int data){
		 Node n = new Node(data);
		 if( head == null ){
			 head = n;
			 return head;
		 }
		 Node trav = head;
		 while(trav.next != null )
			 trav = trav.next;
		 trav.next = n;
		 n.prev = trav;
		 n.next = null;
		 
		 return head;
	 }
	 
	 
	 /*
	  * Insert data at a given position in the linked list
	  */
	 public Node insertAfterPos(int data, int pos){
		 Node n = new Node(data);
		 if(head == null || pos <= 0){
			 n.next = head;
			 head = n ;
			 return head;
		 }
		 Node trav = head;
		 for(int i = 1 ; i < pos && trav.next!=null ; i++)
			 trav = trav.next;
		 if( trav.next == null)
			 return insertAtEnd(data);
		 n.next = trav.next;
		 trav.next = n;
		 n.prev = trav;
		 
		 return head;
	 }
	 
	 
	 
	 /*
	 * To display the linked list
	 */
	public void display(Node head){
		if( head == null ){
			System.err.println("List is empty");
			return;
		}
		Node trav = head;
		while(trav != null ){
			System.out.print(trav.data +" ");
			trav= trav.next;
		}
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		DoublyLLInsertion dll = new DoublyLLInsertion();
		dll.push(23);	dll.push(2);	dll.push(323);
		dll.insertAtEnd(100);
		dll.push(50);
		dll.insertAfterPos(55, 0);
		dll.insertAfterPos(5, 1);
		dll.insertAfterPos(55, 200);
		dll.insertAfterPos(90, 5);
		dll.display(dll.head);
	}
}
