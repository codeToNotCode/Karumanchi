/*
 * To find the node at which two given linked lists intersect
 * 1) Brute Force - Check every node of 1st LL with all the nodes of the 2nd LL . Time O(mn) space O(1)
 * 2) HashMap - O(m) or O(n) Time and Space depending on which list you put into HashMap and which you use to traverse
 * 3) Stacks -  Time O(m) + O(n)  Space O(m + n ) for two stacks
 * 4) Search - 	Time - O(m+n) Space O(m+n) . By Finding first repeating element
 * 5) BEST ALGORITHM - Time - O(max(m,n)) . Space O(1)
 */

package ch3LinkedLists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class IntersectionPointLL
{
	class Node
	{
		int data;
		Node next;

		public Node(int d)
		{
			data = d;
			next = null;
		}
	}

	Node head;

	// Push a node
	public void push(int data)
	{
		Node new_node = new Node(data);
		new_node.next = head;
		head = new_node;
	}

	public void display(Node head)
	{
		if (head == null)
		{
			System.err.println("Empty Stack");
			return;
		}
		Node trav = head;
		while (trav != null)
		{
			System.out.print(trav.data + " ");
			trav = trav.next;
		}
	}

	
	/*
	 * Return Merge Point of Two linked lists
	 * Brute Force O(mn) Time . O(1) Space
	 */
	public Node mergePointBrute(Node h1, Node h2){
		if( h1 == null || h2 == null ){
			System.err.println("Empty Lists");
			return null;
		}
		Node trav1 = h1;
		Node trav2 = h2;
		
		while(trav1 != null ){
			while(trav2 != null ){
				if( trav1 == trav2  )
					return trav1;
				trav2 = trav2.next;
			}
			
			//increment trav1 to the next node
			trav1 = trav1.next;
			//After each successfull traversal of ll2, make the trav2 pointer point to the start of ll2
			trav2 = h2;
		}
		
		System.err.println("No Merge Point");
		return trav1;
	}
	
	/*
	 * HashMap
	 * O(m) or O(n) Time and Space depending on which list you put into HashMap and which you use to traverse
	 */
	public Node mergePointMap(Node h1, Node h2){
		if( h1 == null || h2 == null ){
			System.err.println("Empty Lists");
			return null;
		}
		Node trav1 = h1;
		Node trav2 = h2;
		
		//Put list 1 into hashMap with keys as Nodes(addresses) and values as Data
 		HashMap<Node,Integer> map = new HashMap<>();
		while(trav1 != null ){
			map.put(trav1, trav1.data);
			trav1 = trav1.next;
		}
		
		//Traverse the 2nd list to check whether it has a node with same address as that of linked list1
		while(trav2 != null ){
			if( map.containsKey(trav2))
				return trav2;
			trav2 = trav2.next;
		}
		
		//No merge point found
		System.err.println("No Merge Point");
		return trav2;
	}
	
	/*
	 * Using two Stacks
	 * Time O(m) + O(n)
	 * Space O(m + n ) for two stacks
	 */
	public Node mergePointStacks(Node h1, Node h2){
		if( h1 == null || h2 == null ){
			System.err.println("Empty Lists");
			return null;
		}
		Node trav1 = h1;
		Node trav2 = h2;
		
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		
		//Put all elements of ll1 in stack s1
		while(trav1 != null ){
			s1.push(trav1);
			trav1 = trav1.next;
		}
		//Put all elements of ll2 in stack s2
		while(trav2 != null ){
			s2.push(trav2);
			trav2 = trav2.next;
		}
		
		//Keep popping elements from stacks untill they are the same memory address
		Node p1 = s1.pop();
		Node p2 = s2.pop();
		if( p1 != p2 ){
			System.err.println("No Merge Point");
			return null;
		}
		
		//Node to store the last same memory address
		Node mergePoint = p1;
		while(p1 == p2){
			mergePoint = p1;
			p1 = s1.pop();
			p2 = s2.pop();
		}
		
		//Return the point where the two linked lists merge
		return mergePoint;
	}
	
	/*
	 * Search - By Finding the first repeating element
	 * Store elements of both the lls into an arraylist
	 * Use HashMap to find the first repeating element
	 * Time - O(m+n) Space O(m+n)
	 * Problem 11 - Page 303 - Karumanchi
	 */
	public Node mergePointSearch(Node h1, Node h2){
		if( h1 == null || h2 == null ){
			System.err.println("Empty Lists");
			return null;
		}
		Node trav1 = h1;
		Node trav2 = h2;
		
		//Store elements of both the lists in the arraylist
		//Can use array also if lengths of both the lists is provided
		ArrayList<Node> a = new ArrayList<>();
		while(trav1!=null){
			a.add(trav1);
			trav1 = trav1.next;
		}
		while(trav2!=null){
			a.add(trav2);
			trav2 = trav2.next;
		}
		
		//HashMap to store element position and the element address
		HashMap<Integer,Node> map = new HashMap<>();
		for(int i = 0 ; i < a.size(); i++ ){
			if(!map.containsValue(a.get(i)))
				map.put( i+1,a.get(i));
			else
				//Multiplied by -1 in order to find the 1st element from the start that occurs twice
				//Eg {3,1,2,5,2,3} will return 3 instead of 2. This is what is required here
				//Can also use LinkedHashMap for the same
				map.put((i+1)*(-1),a.get(i));
		}
		
		//TO find the maximum negative key. This will give us the first address that is repeated
		Set<Integer> s = map.keySet();
		int maxNegative = Integer.MIN_VALUE;
		for(Integer i : s){
			if( i < 0 ){
				maxNegative = Math.max(maxNegative, i);
			}
		}
		
		//Return the node which is repeated
		return map.get(maxNegative);
	}
	
	
	/*
	 * Best Algorithm!
	 * O(max(m,n) ) Time . Space : O(1)
	 * 1) Find lengths of both lls . Let them be L1 and L2
	 * 2) Find differnce between the two : d = |L1-L2|
	 * 3) Move the pointer in Longer List d steps forward
	 * 4) Move both pointers simultaneously until they meet.
	 * 5) If they dont meet, the two lists dont merge
	 */
	public Node mergePointBest(Node h1, Node h2){
		if( h1 == null || h2 == null ){
			System.err.println("Empty Lists");
			return null;
		}
		Node trav1 = h1;
		Node trav2 = h2;
		
		//Find lengths of both the lists
		int l1=0,l2=0;
		while(trav1!=null){
			l1++;
			trav1 = trav1.next;
		}
		while(trav2!=null){
			l2++;
			trav2 = trav2.next;
		}
		//Make trav1 and trav2 point to the head of their respective lists again
		trav1 = h1;
		trav2 = h2;
		
		//Find the difference in lengths and move the longer list 'd'steps forward
		if(l1>=l2){
			int d = l1-l2;
			for(int i = 0; i<d; i++)
				trav1 = trav1.next;
		}
		else{
			int d = l2-l1;
			for(int i = 0; i<d; i++)
				trav2 = trav2.next;
		}
		
		//Traverse both the lists simultaneously to find the mergePoint if present
		while(trav1!=null || trav2!=null){
			if(trav1 == trav2)
				return trav1;
			trav1 = trav1.next;
			trav2 = trav2.next;
		}
		
		//No merge point found
		return null;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		IntersectionPointLL l1 =new IntersectionPointLL();
		IntersectionPointLL l2 =new IntersectionPointLL();
		
		l1.push(10);l1.push(100);l1.push(1110);l1.push(20);l1.push(210);l1.push(410);
		l2.push(101);l2.push(102);l1.push(110);
		
		//To merge the given linked lists
		l2.head.next.next = l1.head.next.next.next.next;
		
		l2.push(22);l2.push(3);l2.push(44);
		l1.push(99);
		
		
		l1.display(l1.head);
		System.out.println();
		l2.display(l2.head);
		System.out.println();
		System.out.println();
		System.out.println("Merge Point Brute..........."+l1.mergePointBrute(l1.head, l2.head).data);
		System.out.println("Merge Point HashMap........."+l1.mergePointMap(l1.head, l2.head).data);
		System.out.println("Merge Point Stacks.........."+l1.mergePointStacks(l1.head, l2.head).data);
		System.out.println("Merge Point Search.........."+l1.mergePointSearch(l1.head, l2.head).data);
		System.out.println("Merge Point Best Algorithm.."+l1.mergePointBest(l1.head, l2.head).data);
	}
}
