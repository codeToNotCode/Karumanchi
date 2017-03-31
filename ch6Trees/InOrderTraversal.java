/*
 * To do a In Order traversal of the given tree
 * <LeftSubTreeTree><Root><RightSubTree>
 * Recursive
 * Iterative
 * Done from tushar Roy videos
 */

package ch6Trees;

import java.util.Stack;


public class InOrderTraversal
{
	class Node{
		int data;
		Node left,right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	Node root;
	public Node createTree(){
		root = new Node(60);
		Node left40 = new Node(40);
		Node right70 = new Node(70);
		root.left = left40;
		root.right = right70;
		Node left30 = new Node(30);
		Node right50 = new Node(50);
		left40.left = left30;
		left40.right = right50;
		Node left65 = new Node(65);
		Node right80 = new Node(80);
		right70.left = left65;
		right70.right = right80;
		return root;
	}
	
	//Iterative In-Order Traversal
	//O(n) time
	//O(h) space
	//Done from Tushar Roy videos
	public void inIterative(Node root){
		if(root == null)
			return;
		Stack<Node> stk = new Stack<>();
		while(true){
			if(root!=null){
				stk.push(root);
				root = root.left;
			}else{
				if(stk.isEmpty())
					break;
				Node popped = stk.pop();
				System.out.print(popped.data+" ");
				root = popped.right;
			}
		}
	}
	
	//Recursive in-Order Traversal
	public void inOrder(Node trav){
		if(trav == null)
			return;
		
		inOrder(trav.left);
		System.out.print(trav.data+" ");
		inOrder(trav.right);
	}
	public static void main(String[] args)
	{
		InOrderTraversal iot = new InOrderTraversal();
		Node root = iot.createTree();
		System.out.println("Recursive In Order : ");
		iot.inOrder(root);
		System.out.println("\n\nIterative In Order : ");
		iot.inIterative(root);
	}
}
