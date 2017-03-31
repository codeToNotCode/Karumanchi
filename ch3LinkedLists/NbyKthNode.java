/*
 * To find n/k th node in the linked list in only 1 scan
 * Time O(n)
 * Space O(1)
 * https://www.youtube.com/watch?v=oMP-G-zGeYI
 */

package ch3LinkedLists;

public class NbyKthNode
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
    
    //To print the n/kth modular node
    public Node nByk(Node head, int k){
    	if(head == null || k <= 0 )	return null;
    	Node s = null;
    	int i = 1;
    	while( head!=null){
    		if(i%k==0){
    			if(s==null)
    				s=head;
    			else
    				s=s.next;
    		}
    		i++;
    		head=head.next;
    	}
    	return s;
    }
	// Main method.
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        NbyKthNode list = new NbyKthNode();
        list.push(41);        list.push(39);
        list.push(21);        list.push(13);
        list.push(401);        list.push(24);
        list.push(801); list.push(601); list.push(501); list.push(201); list.push(301); list.push(42); 
    
 
        // Print the original linked list.
        System.out.println("Original linked list");
        list.print(list.head);
        System.out.println("\n N/K Node "+list.nByk(list.head,3 ).data);
    }

}
