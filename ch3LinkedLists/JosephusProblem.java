/*
 * To solve the Josephus Problem and its variations
 */

package ch3LinkedLists;

public class JosephusProblem
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
	public void push(int d){
		Node n = new Node(d);
		if(last == null){
			last = n;
			last.next = last;
			return;
		}
		n.next = last.next;
		last.next = n;
	}
	public void display(Node last){
		if( last == null){
			System.err.println("Empty list");
			return;
		}
		Node trav = last.next;
		do{
			System.out.print(trav.data+" ");
			trav = trav.next;
		}while(trav!=last.next);
	}
	
	//Every person kills the mth person in the list and passes the sword to the next person
	public Node Josephus(Node last, int m){
		if(last == null || last.next == null ){
			return last;
		}
		Node trav = last.next;
		Node prev = null;
		int personsLeft = 0;
		do{
			trav = trav.next;
			personsLeft++;
		}while(trav!=last.next);
		
		while(true){
			if( personsLeft == 2 )
				break;
			for(int i = 0 ; i < m ; i++){
				prev = trav;
				trav = trav.next;
			}
			personsLeft--;
			prev.next = trav.next;
			trav = trav.next;
		}
		return trav;
	}
	public static void main(String[] args)
	{
		JosephusProblem ll = new JosephusProblem();
		ll.push(13);ll.push(12);ll.push(11);ll.push(10);ll.push(9);
		ll.push(8);ll.push(7);ll.push(6);
		ll.push(5);
		ll.push(4);ll.push(3);ll.push(2);ll.push(1);
		ll.display(ll.last);
		System.out.println();
		ll.display(ll.Josephus(ll.last,3));
	}
}
