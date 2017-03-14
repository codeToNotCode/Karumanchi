/*
 * TO convert a given tree into a Linked list
 * WE are considering in order traversal here
 * Also, the tree can be balanced or not balanced
 * All upto the interviewer
 */


package ch3LinkedLists;

public class TreeToList
{
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	//Create the binary tree
	public Node createTree(){
		Node rootNode = new Node(80);
		Node node60 = new Node(60);
		Node node25 = new Node(25);
		Node node35 = new Node(35);
		Node node90 = new Node(90);
		Node node10 = new Node(10);
		Node node70 = new Node(70);
		Node node50 = new Node(50);
		
		rootNode.left = node60;
		rootNode.right = node90;
		
		node60.left = node25;
		node60.right = node35;
		
		node90.left = node10;
		
		node10.left = node50;
		node10.right = node70;
		
		return rootNode;
	}
	
	//to display the tree in in-order traversal mode
	public void displayTree(Node root){
		if( root == null )	return ;
		displayTree(root.left);
		System.out.print(root.data + " ");
		displayTree(root.right);
	}
	
	
	//To concatenate two nodes for normal doubly linkedlist
	private Node concatenateD(Node a, Node b){
		if(a == null) return b;
		if(b == null) return a;
		Node aEnd = a;
		Node bEnd = b;
		while(aEnd.right != null ) aEnd = aEnd.right;
		while(bEnd.right != null ) bEnd = bEnd.right;
		a.left = null;	bEnd.right = null;
		aEnd.right = b; b.left = aEnd;
		return a;
	}
	//TO convert the given tree into a normal doubly linked list
	public Node TreeToDoubly(Node n){
		if( n == null )return null;
		Node leftList = TreeToDoubly(n.left);
		Node rightList = TreeToDoubly(n.right);
		n.left = null;
		n.right = null;
		n = concatenateD(leftList,n);
		n = concatenateD(n,rightList);
		return n;
	}
	
	
	//To concatenate two nodes for circular Doubly linked list
	private Node concatenate(Node a, Node b){
		if(a == null) return b;
		if(b == null) return a;
		
		Node aEnd = a.left;
		Node bEnd = b.left;
		a.left = bEnd;
		bEnd.right = a;
		aEnd.right = b;
		b.left = aEnd;
		
		return a;
	}
	
	//TO convert the given tree into a circular doubly linked list
	public Node treeToList(Node n){
		if (n == null) return null;
		Node leftList = treeToList(n.left);
		Node rightList = treeToList(n.right);
		n.left = n;
		n.right = n;
		n = concatenate(leftList, n);
		n = concatenate(n, rightList);
		return n;
	}
	
	//To display the newly formed linked list
	public void displayList(Node n){
		if( n == null ){
			System.err.println("No list formed");
			return ;
		}
		Node trav =n;
		do{
			System.out.print(trav.data +" ");
			trav = trav.right;
		}while(trav != n);
	}
	//To display the newly formed doubly linked list
	public void display(Node n){
		if( n == null ){
			System.err.println("No list formed");
			return ;
		}
		Node trav =n;
		while(trav!=null){
			System.out.print(trav.data +" ");
			trav = trav.right;
		}
	}
	
	
	//Driver function
	public static void main(String[] args)
	{
		TreeToList ttl = new TreeToList();
		Node root = ttl.createTree();
		System.out.println("Tree : ");
		ttl.displayTree(root);
		System.out.println();
	//Node listHead = ttl.treeToList(root);
	//ttl.displayList(listHead);
		System.out.println();
	Node head = ttl.TreeToDoubly(root);
	ttl.display(head);
		
	}
}
