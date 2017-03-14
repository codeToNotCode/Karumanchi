/*
 * Add two linked lists and store the sum in another linked list
 * 
 */

package ch3LinkedLists;

public class AddTwoLLs
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
    public Node addLists(Node head1, Node head2){
    	if(head1 == null)	return head2;
    	if(head2 == null)	return head1;
    	
    	int sum = 0; int carry = 0;
    	Node sumHead =new Node(0);
    	Node t1 = head1;
    	Node t2 = head2;
    	if( t1 == head1 && t2 == head2){
    		sum = carry + (t1!=null?t1.data:0 )+ 
    				(t2!=null?t2.data:0 );
    		carry = (sum>=10)?1:0;
    		sumHead.data = (sum>=10)?sum%10:sum;
    		t1 = t1.next;
    		t2 = t2.next;
    	}
    	Node t3 = sumHead;
    	while(t1!=null || t2!=null){
    		sum = carry + (t1!=null?t1.data:0 )+ 
    				(t2!=null?t2.data:0 );
    		Node n = new Node((sum>=10)?sum%10:sum);
    		carry = (sum>=10)?1:0;
    		t3.next = n;
    		t3 = t3.next;
    		if(t1!=null)
    			t1=t1.next;
    		if(t2!=null)
    			t2=t2.next;
    	}
    	if(carry==1){
    		Node n = new Node(1);
    		t3.next = n;
    		t3 = t3.next;
    	}
    	return sumHead;
    }
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        AddTwoLLs list1 = new AddTwoLLs();
        AddTwoLLs list2 = new AddTwoLLs();
        AddTwoLLs list3 = new AddTwoLLs();
        
        list1.push(9);list1.push(9); list1.push(9);
        list2.push(9);

        // Print the original and cloned linked list.
        System.out.println("First number: ");
        list1.print(list1.head);
 
        System.out.println("\nSecond number: ");
        list2.print(list2.head);

        System.out.println("\nSum List :\n");
        // Rotate the original linked list.
        list3.print(list3.addLists(list1.head,list2.head));
 
    }

}
