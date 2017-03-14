/*
 * Given a linked list with data, next pointer and  a random pointer.
 * Clone this list!
 * http://www.geeksforgeeks.org/clone-linked-list-next-random-pointer-o1-space/
 * http://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
 */

package ch3LinkedLists;

import java.util.HashMap;

public class CloneLisst
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
	//Clone in O(1) space
	public Node cloneBetter(Node head){
		if( head == null)
			return head;
		Node X =head;
		//Create a copy of each node and make the current node point to this copy
		while(X!=null){
			Node temp = X.next;
			X.next = new Node(X.data);
			X.next.next = temp;
			X =temp;
		}
		X = head;
		//Set random pointers of the duplicate nodes
		while(X!=null){
			X.next.random = (X.random.next!=null)?X.random.next:X.random;
			X = X.next.next;
		}
		Node yHead = head.next;
		Node Y = head.next;
		X = head;
		//Separate the original from the duplicate nodes
		while(X!=null && X.next!=null &&Y!=null&&Y.next!=null){
			X.next = (X.next.next!=null)?X.next.next:X.next;
			Y.next = (Y.next.next!=null)?Y.next.next:Y.next;
			Y = Y.next;
			X = X.next;
		}
		
		//Return the head of the cloned list
		return yHead;
	}
	//Function to clone a list
	//USing HashMaps - Time O(n) Space O(n)
	public Node clone(Node head){
		if(head == null)
			return null;
		HashMap<Node,Node> map = new HashMap<>();
		Node X = head;
		Node Y = head;
		while(X!=null){
			map.put(X, new Node(X.data));
			X = X.next;
		}
		X = head;
		while(X!=null){
			Y = map.get(X);
			Y.next = map.get(X.next);
			Y.random = map.get(X.random);
			X = X.next;
		}
		
		return map.get(head);
	}
	
    // Method to print the list.
    void print(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            Node random = temp.random;
            int randomData = (random != null)? random.data: -1;
            System.out.println("Data = " + temp.data +
                               ", Random data = "+ randomData);
            temp = temp.next;
        }
    }
	// Main method.
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        CloneLisst list = new CloneLisst();
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        list.push(40);
    
 
        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
            list.head.next.next.next;
        list.head.next.next.random =
            list.head.next.next.next.next;
        list.head.next.next.next.random =
            list.head;
        list.head.next.next.next.next.random =
            list.head.next;
 
        // Making a clone of the original linked list.
        Node clone = list.clone(list.head);
 
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print(list.head);
        System.out.println("\nCloned linked list using HashMap");
       	list.print(clone);
       	System.out.println("\nCloned linked list without HashMap");
       	list.print(list.cloneBetter(list.head));
    }
}
