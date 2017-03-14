/*
 * To partition a linked list in such a way such that all values less than the given
 * node occur before the given node. The order of the list should be preserved
 * 1->4->3->2->5->2->Null
 * output 1->2->2->4->3->5->null
 */

package ch3LinkedLists;


public class PartitionLL
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
    //partition linkedlist
    public Node partition(Node head,int k){
    	if(head == null )	return head;
    	Node prevLess = null;
    	Node prevGreater = null;
    	Node headGreater = null;
    	Node trav = head;
    	while(trav!=null){
    		if(trav.data<k){
    			if(prevLess!=null){
    				prevLess.next = trav;
    				prevLess=trav;
    			}
    			else{
    				prevLess = trav;
    				head = trav;
    			}
    		}
    		else{
    			if(prevGreater!=null){
    				prevGreater.next = trav;
    				prevGreater = trav;
    			}
    			else{
    				prevGreater = trav;
    				headGreater = trav;
    			}
    		}
    		trav = trav.next;
    	}
    	if(prevGreater!=null)
    		prevGreater.next = null;
    	if(prevLess!=null)
    		prevLess.next = headGreater;
    	
    	return head;
    }
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        PartitionLL list = new PartitionLL();
       // list.push(81);list.push(72);
        list.push(1);list.push(5);list.push(2); list.push(3);
        list.push(4);        list.push(5);list.push(15);
        list.push(11112);list.push(1242);list.push(162);list.push(122);
    
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print(list.head);
 
        System.out.println("\nPartitioned List :\n");
        // Making a clone of the original linked list.
        list.print(list.partition(list.head,122));
 
    }

}
