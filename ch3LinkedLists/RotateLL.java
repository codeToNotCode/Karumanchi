/*
 * TO rotate a linked list by k positions
 * 1->2->3->4->5->6->NULL, k = 2
 * output : 5->6->1->2->3->4->NULL
 * 
 * ALGORITHM:
 * Find kth Node from the end
 * Save the kth node as the new Head
 * Make prev node of kth point to null
 * Move kth to end
 * Make kth point to original head
 * Return the newHead
 * 
 * NOTE : Also check for condition when k is greater than the length of the list
 */

package ch3LinkedLists;


public class RotateLL
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
    
    //To rotate the linked list
    public Node rotate(Node head, int k){
    	if(head == null || k <= 0)
    		return head;
    	Node kth = findKthFromEnd(head,k);
    	Node rotatedHead = kth;
    	while(kth.next != null ){
    		kth = kth.next;
    	}
    	kth.next = head;
    	return rotatedHead;
    }
    
    //Find kth from end
    private Node findKthFromEnd(Node head,int k){
    	Node trav = head;
    	int i =0;
    	for(; i < k  && trav!=null; i++)
    		trav = trav.next;
    	//If value of k is greater than the length of linkedlist
    	if(trav == null){
    		k = k%i;
    	   	trav = head;
    	   	for(int j=0; j < k ; j++)
    	   		trav = trav.next;
    	}
    	
    	Node kth =head;
    	Node prev = new Node(0);
    	prev.next = head;
    	while(trav!=null){
    		trav = trav.next;
    		prev = kth;
    		kth = kth.next;
    	}
    	prev.next = null;
    	return kth;
    }
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        RotateLL list = new RotateLL();
        list.push(8);list.push(7);
        list.push(6);list.push(5);list.push(4); list.push(3);
        list.push(2);        list.push(1);
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print(list.head);
 
        System.out.println("\nRotated List :\n");
        // Rotate the original linked list.
        list.print(list.rotate(list.head,13));
 
    }

}
