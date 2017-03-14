/*
 * To implement insertion sort in a linked list
 * Maintain 2 lists - one sorted and one unsorted(the original)
 * Remove nodes from unsorted and put into sorted one by one
 */

package ch3LinkedLists;

public class InsertionSort
{
	class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
			next = null;
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
    
    //Insertion sort
    public Node sort(Node head){
    	if(head == null)	return head;
    	
    	Node trav = head.next;
    	Node result = head;
    	result.next = null;
    	while(trav!=null){
    		Node temp = trav;
    		trav = trav.next;
    		result = sortedInsert(result,temp);
    	}
    	return result;
    }
	//Insert into sorted
	public Node sortedInsert(Node result,Node n){
		if(head == null){
			head = n;
			return head;
		}
		if( head.data >=  n.data){
			n.next = head;
			head = n;
			return head;
		}
		
		Node trav = head;
		Node prev = null;
		while(trav!=null && trav.data < n.data){
			prev = trav;
			trav= trav.next;
		}
		n.next = prev.next;
		prev.next = n;
		
		return head;
	}
	
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        InsertionSort list = new InsertionSort();
       // list.push(81);list.push(72);
        list.push(63);list.push(5);list.push(214); list.push(3231);
        list.push(25);        list.push(111);
        list.push(11112);list.push(1242);list.push(162);list.push(122);
    
        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print(list.head);
 
        System.out.println("\nSorted List :\n");
        // Making a clone of the original linked list.
        list.print(list.sort(list.head));
 
    }

}
