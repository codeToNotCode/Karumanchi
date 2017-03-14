/*
 * TO check whether a given linked list is a palindrome or not
 * Algorithm:
 * 1) FInd middle node
 * 2) Reverse 2nd half of the list
 * 3) Compare the 2 halves
 */

package ch3LinkedLists;

public class Palindrome
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
	
	//To check whether a given linked list is a palindrome or not
	public boolean isPalin(Node head){
		if( head == null || head.next == null )
			return true;
		Node mid = findMiddle(head);
		Node newHead = mid.next;
		newHead = reverseHalf(newHead,newHead);
		mid.next = newHead;
		return compareLists(head,newHead);
		
	}
	//Returns the middle element of the list
	private Node findMiddle(Node head){
		Node fast = head;
		Node slow = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	//Reverses the 2nd half of the list and returns newHead
	private Node reverseHalf(Node newHead,Node trav){
		if(trav.next == null){
			newHead = trav;
			return newHead;
		}
		newHead = reverseHalf(newHead,trav.next);
		Node p = trav.next;
		p.next = trav;
		trav.next = null;
		return newHead;
	}
	//Compares two lists to check whether they are palindromes or not
	private boolean compareLists(Node h1, Node h2){
		while( h1!= null && h2 != null){
			if (h1.data != h2.data)
				return false;
			h1 = h1.next;
			h2 = h2.next;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		Palindrome ll = new Palindrome();
		ll.push(10);ll.push(41);ll.push(13);ll.push(13);ll.push(41);ll.push(0);
		ll.display(ll.head);
		System.out.println();
		System.out.println(ll.isPalin(ll.head));
	}
}
