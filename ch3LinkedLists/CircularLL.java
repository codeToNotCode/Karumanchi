/*
 * TO implement Circular linked lists and various operations involved
 */

package ch3LinkedLists;

public class CircularLL
{
	class Node{
		int data;
		Node next;;
		public Node(int d){
			data = d;
			next = null;
		}
	}
	Node last;
	
	//Insert elements to the begining of the circular list
	public Node push(int data){
		Node n = new Node(data);
		if(last == null){
			last = n;
			last.next = last;
			return last;
		}
		n.next = last.next ;
		last.next = n;
		
		return last;
	}
	
	
	//Insert element at the end of the circular List
	public Node insertAtLast(int data){
		Node n = new Node(data);
		if( last == null ){
			last=n;
			last.next = last;
			return last;
		}
		
		n.next = last.next;
		last.next = n;
		last = n ;
				
		return last;
	}
	
	
	//Insert element after a given position in the list
	public Node insertAfterPos(int data, int pos){
		Node n = new Node(data);
		if( last == null ){
			last = n;
			last.next = last;
			return last;
		}
		if(pos <= 0 ){
			return push(data);
		}
		Node trav = last.next;
		int i = 0;
		do{
			i++;
			trav = trav.next;
		}while(trav.next!=last.next && i < pos);
		
		if( trav.next == last.next)
			return insertAtLast(data);
		
		n.next = trav.next;
		trav.next = n;
		
		return last;
	}
	
	
	//Delete the first element in the circular list
	public Node pop(){
		if(last == null ){
			System.err.println("Empty List");
			return null;
		}
		Node deleted = last.next;
		last.next= deleted.next;
		
		return deleted;
	}
	
	//Delete the last element of the circular linked list
	public Node deleteLast(){
		if(last == null){
			System.err.println("Empty List");
			return null;
		}
		Node trav = last.next;
		do{
			trav = trav.next;
		}while(trav.next!=last);
		
		Node deleted = last;
		trav.next = last.next;
		last = trav;
		
		return deleted;
	}
	
	//Delete element that corrosponds to the given data
	public Node deleteElem(int value){
		if(last == null){
			System.err.println("Empty List");
			return null;
		}
		if(last.data == value)
			return deleteLast();
		Node trav = last.next;
		do{
			trav = trav.next;
		}while(trav.next!=last.next && trav.next.data!=value);
		
		if( trav.next == last.next){
			System.err.println("Element not found");
			return null;
		}
		Node deleted = trav.next;
		trav.next = deleted.next;
		
		return deleted;
	}
	//Display the circular linked list
	public void display(){
		if(last == null ){
			System.err.println("Empty List");
			return;
		}
		Node trav = last.next;
		do{
			System.out.print(trav.data+" ");
			trav = trav.next;
		}
		while(trav != last.next);
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		CircularLL cll = new CircularLL();
		cll.push(23);	cll.push(3);  cll.push(30); 
		cll.insertAtLast(45);	cll.insertAtLast(5);
		cll.push(0); 	cll.insertAfterPos(12, 2);
		cll.push(1222); 	cll.insertAfterPos(322, 43);
		cll.display();

		System.out.println("Element popped "+cll.pop().data);
		System.out.println("Element deleted "+cll.deleteLast().data);
		System.out.println("Element deleted "+cll.deleteElem(12).data);
		cll.display();
	}
}
