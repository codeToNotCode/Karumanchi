/*
 * To Sort a linked list using merge sort
 * ALgorithm :
 * 1) Find Middle element of the list
 * 2) Split the list into two halves
 * 3) Recursively Sort the two halves
 * 4) Merge the sorted halves into one 
 */


package ch3LinkedLists;


public class MergeSortLL
{
	class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
			next = null;
		}
	}
	Node head;
	
	public void push(int data){
		Node n = new Node(data);
		if(head==null){
			head = n;
		}
		else{
		n.next = head;
		head = n;
		}
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
	
	
	//To merge the sorted halves
	public Node mergeLists(Node trav1, Node trav2){
		if(trav1 == null)	return trav2;
		if(trav2 == null)	return trav1;
		Node mergeHead = new Node(0);
		Node trav3 = mergeHead;
		
		while(trav1 != null && trav2 != null ){
			 if(trav1.data <= trav2.data){
				 trav3.next = trav1;
				 trav1 = trav1.next;
			 }
			 else{
				 trav3.next = trav2;
				 trav2 = trav2.next;
			 }
			 trav3 = trav3.next;
		}
		if(trav1 == null){
			trav3.next = trav2;
		}
		else if( trav2 == null)
			trav3.next = trav1;
		
		return mergeHead.next;
	}
	
	
	//To recursively split the linked list into 2 halves
	//Divide and conquer approach
	public Node splitAtMiddle(Node head){
		if(head == null|| head.next == null )
			return head;
		
		Node trav = head;
		Node prev = head;
		
		while(trav.next != null && trav.next.next != null ){
			prev = prev.next;
			trav = trav.next.next;
		}
		Node mid = prev.next;
		prev.next = null;
		trav = head;
		
		Node l1 = splitAtMiddle(trav);
		Node l2 = splitAtMiddle(mid);
		return mergeLists(l1,l2);
	}
	
	public static void main(String[] args)
	{
		MergeSortLL ll = new MergeSortLL();
		ll.push(10);ll.push(50);
		ll.push(11);
		ll.push(0);ll.push(25);
		ll.push(452);ll.push(24);ll.push(42);ll.push(41);
		ll.display(ll.head);
		System.out.println();
		ll.display(ll.splitAtMiddle(ll.head));
	
	}

}
