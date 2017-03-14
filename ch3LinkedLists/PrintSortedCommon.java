/*
 * Given two sorted linked lists, print the common elements
 * HashMap - O(m+n) time , O(n) space
 * Two Pointers - O(m+n) time , O91) space
 */
package ch3LinkedLists;

public class PrintSortedCommon
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
    public void common(Node head1,Node head2){
    	if(head1 == null || head2 == null){
    		System.out.println("No Elements in common");
    		return;
    	}
    	while(head1!=null && head2!=null){
    		if(head1.data == head2.data){
    			System.out.print(head1.data +" ");
    			head1 = head1.next;
    			head2 = head2.next;
    		}
    		else if( head1.data < head2.data)
    			head1 = head1.next;
    		else
    			head2 = head2.next;
    	}
    }
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
    	PrintSortedCommon list2 = new PrintSortedCommon();
        PrintSortedCommon list1 = new PrintSortedCommon();
        list1.push(6);list1.push(5);list1.push(4); list1.push(3);
        list1.push(2);        list1.push(1);
        list2.push(12);list2.push(7);list2.push(6); 
        list2.push(2);        list2.push(0);
    
        // Print the original and cloned linked list.
        System.out.println("list 1");
        list1.print(list1.head);
        System.out.println("\nlist 2");
        list2.print(list2.head);
        System.out.println();
        list1.common(list1.head,list2.head);
 
    }

}
