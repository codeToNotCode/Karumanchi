/*
 * To remove duplicates from the given list
 * 1->3->2->3->1->4
 * output 1->3->2->4
 */

package ch3LinkedLists;

import java.util.HashSet;

public class RemoveDuplicates
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
    
    //O(n^2) time 
    //O(n) space
    public Node remDups(Node head){
    	if(head == null)	return head;
    	Node trav = head;
    	while(trav!=null){
    		Node curr=trav;
    		while(curr.next!=null){
    			if(curr.next.data == trav.data)
    				curr.next = curr.next.next;
    			else
    				curr = curr.next;
    		}
    		trav = trav.next;
    	}
    	return head;
    }
    
    public Node remDup(Node head){
    	if(head == null )	return head;
    	Node trav = head;
    	Node prev = null;
    	HashSet<Integer> set = new HashSet<>();
    	while(trav!=null){
    		if(set.contains(trav.data))
    			prev.next = trav.next;
    		else{
    			set.add(trav.data);
    			prev = trav;
    		}
    		trav = trav.next;
    	}
       return head;
    }
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        RemoveDuplicates list = new RemoveDuplicates();
       // list.push(81);list.push(72);
        list.push(63);list.push(5);list.push(111); list.push(3231);
        list.push(25);        list.push(111);
        list.push(25);list.push(1242);list.push(25);list.push(5);
    
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print(list.head);
 
        System.out.println("\nNew List :\n");
        // Making a clone of the original linked list.
        list.print(list.remDups(list.head));
        System.out.println();
        // Making a clone of the original linked list.
        list.print(list.remDup(list.head));
 
    }
	
}
