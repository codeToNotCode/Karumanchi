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
	public Node rotate(Node a, int b) {
		   if(a==null || a.next == null || b<=0)
		        return a;
		    int i =0;
	        Node t = a;
	        while(t!=null){
	            i++;
	            t = t.next;
	        }
	        b = b % i;
	        if (b == 0)
	            return a;
	        t = a;
	        i =0;
	        while(i<b){
	            i++;
	            t = t.next;
	        }
	        Node prevToB = a;
	        while(t.next!=null){
	            t = t.next;
	            prevToB= prevToB.next;
	        }
		   Node rotatedHead = prevToB.next;
		   prevToB.next = null;
		   Node bth = rotatedHead;
		   while(bth.next!=null)
		    bth = bth.next;
		   bth.next = a;
		   return rotatedHead;
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
        list.print(list.rotate(list.head,8));
 
    }

}
