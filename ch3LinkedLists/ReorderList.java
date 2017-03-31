/*
 * Reorder the given linked list as per the below pattern
 * 1->2->3->4->5->6
 * 1->6->2->5->3->4
 * 
 * N1->NLast->N2->Nlast-1....
 */

package ch3LinkedLists;

public class ReorderList
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
    public Node reOrder(Node head){ 
    	if(head == null )	return null;
    	//Split list into two halves at the middle
    	Node mid;
    	Node trav1 = head;
    	Node trav2 = head;
    	while(trav1!=null&&trav1.next!=null){
    		trav1 = trav1.next.next;
    		trav2 = trav2.next;
    	}
    	mid = trav2.next;
    	trav2.next = null;
    	
    	//Reverse the 2nd half
    	mid = reverse(mid,mid);
    	
    	return mergeAlternate(head,mid);
    	
    }
    //Merge the two lists at alternate locations
    private Node mergeAlternate(Node head,Node mid){
    	Node trav1 = head;
    	Node trav2 = mid;
    	while(trav1.next!=null && trav2!=null){
    		Node t1 = trav1.next;
    		Node t2 = trav2.next;
    		
    		trav1.next = trav2;
    		trav2.next = t1;
    		
    		trav1 = t1;
    		trav2 = t2;
    	}
    	if(trav1.next == null)
    			trav1.next = trav2;
    	return head;
    }
    //Reverse the second half of the list
    private Node reverse(Node mid,Node trav){
    	if(trav.next == null){
    		mid = trav;
    		return mid;
    	}
    	mid = reverse(mid,trav.next);
    	Node p = trav.next;
    	p.next = trav;
    	trav.next = null;
    	return mid;
    }
	// Main method.
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        ReorderList list = new ReorderList();
        list.push(8);list.push(7);
        list.push(6);list.push(5);list.push(4); list.push(3);
        list.push(2);        
    
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print(list.head);
 
        System.out.println("\nReOrdered List :\n");
        // Making a clone of the original linked list.
        list.print(list.reOrder(list.head));
 
 
//        System.out.println("\nCloned linked list using HashMap");
//       	list.print(list.head);
    }

}
