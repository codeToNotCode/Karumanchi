/*
 * To display nth node from the end in a linked list
 * 1) O(n) time O(1) space- Find the length of the linked list- Traverse to (length - n + 1)th node in the list
 * 2) O(n) time O(m) space - Using HashMap
 * 3) O(n) time O(m) space - Recursion
 * 4) O(n) time and O(1) space - Move one pointer n nodes from the start. Move 2nd pointer from the begining until the first pointer reaches the end.
 * The time when 1st pointer reaches the end, the 2nd pointer is a nth node from the end 
 */

package ch3LinkedLists;

import java.util.HashMap;

public class NthFromEnd {
	class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
			next = null;
		}
	}
	Node head;
	
	
	//O(n) time O(1) space
	public  int nthFromEnd(int n){
		//If n is zero
		if(n <= 0 ){
			System.err.println("Invalid nth");
			return -1;
		}
		
		//If list is empty
		if(head == null){
			System.err.println("EMpty List");
			return -1;
		}
		
		//Count the total number of elements in the list
		Node trav = head;
		int count = 0;
		while(trav != null ){
			count++;
			trav = trav.next;
		}
		
		//If nth is greater than the total number of elements
		if( n > count){
			System.out.println("Invalid nth");
			return -1;
		}
		
		//Go to the nth node
		trav = head;
		int nth = count - n + 1;
		for(int i = 1; i < nth; i++)
			trav = trav.next;
		
		//Return data in the nth node
		return trav.data;
	}

	
	//O(n) Time , O(1) Space Solution
	public int nthOptimal(int n){
		//If n is zero
		if(n <= 0 ){
			System.err.println("Invalid nth");
			return -1;
		}
				
		//If list is empty
		if(head == null){
			System.err.println("EMpty List");
			return -1;
		}
		
		Node trav1 = head;
		Node trav2 = head;
		
		//Move one pointer n positions
		for(int i = 0 ; i<n && trav1 != null ;i++)
			trav1 = trav1.next;
		if(trav1 == null ){
			System.err.println("Invalid nth");
			return -1;
		}
		
		//Start 2nd pointer and go until 1st pointer reaches end
		while(trav1 != null ){
			trav2 = trav2.next;
			trav1 = trav1.next;
		}
		
		//Return data in the 2nd pointer
		return trav2.data;
	}
	
	
	//O(n) time O(m) space
	public int nthHash(int n){
		//If n is zero
		if(n <= 0 ){
			System.err.println("Invalid nth");
			return -1;
		}
					
		//If list is empty
		if(head == null){
			System.err.println("EMpty List");
			return -1;
		}
		
		//Store node number and node in a hashmap
		Node trav = head;
		HashMap<Integer, Node> map = new HashMap<>();
		int count = 0;
		for( ; trav!=null ; trav= trav.next)
			map.put(++count, trav);
		
		//If nth is greater than the total number of elements
		if( n > count){
			System.out.println("Invalid nth");
			return -1;
		}
		
		//Return data in the nth node
		int nth = count - n + 1;
		return map.get(nth).data;
	}
	
	
	//Using Recursion - O(n) for Time , O(m) for stack space
	public int nthRecur(int n){
		
		if( n <= 0 ){
			System.err.println("Ïnvalid nth");
			return -1;
		}
			
		int length = length(head);
		
		if( n > length){
			System.err.println("Invalid nth");
			return -1;
		}
			
		int nth = length - n + 1;
		
		return nth(head,nth);
	}
	
	private int length(Node trav ){
		if(trav == null)
			return 0;
		return 1 + length(trav.next);
	}
	
	private int nth(Node trav, int n ){
		if( n == 1)
			return trav.data;
		return nth(trav.next,n-1);
	}
	
	
	
	
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
		NthFromEnd ll = new NthFromEnd();
		ll.push(224);ll.push(46);ll.push(4252);ll.push(234);ll.push(46346);ll.push(452);ll.push(24);ll.push(42);ll.push(41);
		ll.display();
		System.out.println();
		System.out.println(ll.nthFromEnd(1));
		System.out.println(ll.nthOptimal(1));
		System.out.println(ll.nthHash(1));
		System.out.println(ll.nthRecur(1));
	}
}
