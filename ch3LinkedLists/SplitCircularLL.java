/*
 * To split a circular linked list into 2 halves
 */

package ch3LinkedLists;

public class SplitCircularLL
{
	class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
			next = null;
		}
	}
	Node last;
	
	public void push(int data){
		Node n = new Node(data);
		if ( last == null ){
			last = n;
			last.next = last;
			return;
		}
		n.next = last.next;
		last.next = n;
	}
	public void display(Node last){
		if(last == null){
			System.err.println("Empty List");
			return;
		}
		Node trav = last.next;
		do{
			System.out.print(trav.data +" ");
			trav = trav.next;
		}while(trav!=last.next);
		
	}

	public void splitCircular(Node last){
		if( last == null ){
			System.err.println("Empty List");
			return;
		}
		Node fast = last.next;
		Node slow = last.next;
		//Find middle
		do{
			fast = fast.next.next;
			slow = slow.next;
		}while(fast.next!=last.next && fast.next.next!=last.next );
		
		//Split the list
		Node mid = slow.next;
		slow.next = last.next;
		last.next = mid;
		
		display(slow);
		System.out.println();
		display(last);
		
	}
	public static void main(String[] args)
	{
		SplitCircularLL ll = new SplitCircularLL();
		ll.push(10);ll.push(20);ll.push(10);ll.push(90);ll.push(29);ll.push(29);ll.push(29);
		ll.display(ll.last);
		System.out.println();
		ll.splitCircular(ll.last);
	}
}
