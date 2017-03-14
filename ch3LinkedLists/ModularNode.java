/*
 * To find the modular node
 * n - number of elements in the list
 * Find the last node for which n%k is zero
 * K is provided
 */
package ch3LinkedLists;

public class ModularNode
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
    
    //To print the last modular node
    public Node modNode(Node head, int k){
    	if(head == null || k <= 0 )	return null;
    	Node modNode = head;
    	for(int i = 1; head!=null; head = head.next){
    		if( i%k == 0 )
    			modNode = head;
    		i++;
    	}
    	return modNode;
    }
	// Main method.
    public static void main(String[] args)
    {
        // Pushing data in the linked list.
        ModularNode list = new ModularNode();
        list.push(41);        list.push(39);
        list.push(21);        list.push(13);
        list.push(40);        list.push(24);
        list.push(12);        list.push(40);
        list.push(43);        list.push(39);
        list.push(24);        list.push(16);
        list.push(40);        list.push(72);
        list.push(16);        list.push(40);
        list.push(172);
        list.push(126);        list.push(4440);
    
 
        // Print the original linked list.
        System.out.println("Original linked list");
        list.print(list.head);
        System.out.println("\nModular Node "+list.modNode(list.head, 4).data);
    }

}
