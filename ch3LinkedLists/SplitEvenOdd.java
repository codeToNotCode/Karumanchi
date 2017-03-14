/*
 * To split a given list into even and odd elements
 * 1->2->3->4->5->6
 * output 2->4->6->1->3->5
 */


package ch3LinkedLists;


public class SplitEvenOdd
{
	class Node{
		int data;
		Node next;
		Node random;
		public Node(int d){
			data = d;
			next = null;
			random = null;
		}
	}
	Node head;
	public void push(int data){
		Node n = new Node(data);
		if(head == null){
			head = n;
			return;
		}
		n.next = head;
		head = n;
	}
    // Method to print the list.
    void print(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public Node split(Node head){
    	if( head == null || head.next == null)
    			return head;
    	Node odd =head;
    	Node even = head.next;
    	Node newHead = even;
    	while(true){
    		if(even.next == null ){
    			even.next = head;
    			odd.next = null;
    			break;
    		}
    		if(even.next.next == null){
    			odd.next = odd.next.next;
    			odd = odd.next;
    			even.next = head;
    			odd.next = null;
    			break;
    		}
    		odd.next = odd.next.next;
    		odd = odd.next;
    		even.next = even.next.next;
    		even = even.next;
    	}
    	return newHead;
    }
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        SplitEvenOdd list = new SplitEvenOdd();
       // list.push(81);list.push(72);
        list.push(6);list.push(5);list.push(4); list.push(3);
        list.push(2);        list.push(1);
    
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print(list.head);
 
        System.out.println("\nSplit List :\n");
        list.print(list.split(list.head));
 
    }

}
