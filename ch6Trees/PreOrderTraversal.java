/*
 * To do a Pre Order traversal of the given tree
 * <Root><LeftSubTreeTree><RightSubTree>
 * Recursive
 * Iterative
 * Done from tushar Roy videos
 */

package ch6Trees;

import java.util.Stack;

public class PreOrderTraversal
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
	
	//Iterative Pre-Order Traversal
	//O(n) time where n is the number of nodes in the tree
	//O(h) space where h is the maximum height of the tree
	public void preIterative(Node root){
		Stack<Node> stk = new Stack<>();
		Node trav = root;
		stk.push(trav);
		while(!stk.isEmpty()){
			Node popped = stk.pop();
			System.out.print(popped.data+" ");
			if(popped.right!=null)
				stk.push(popped.right);
			if(popped.left!=null)
				stk.push(popped.left);
		}
	}
	
	//Recursive Pre-Order Traversal
	//O(n) time
	//O(n) space
	public void preOrder(Node trav){
		if(trav == null)
			return;
		System.out.print(trav.data+" ");
		preOrder(trav.left);
		preOrder(trav.right);
	}
	public static void main(String[] args)
	{
		PreOrderTraversal pot = new PreOrderTraversal();
		Node root = pot.createTree();
		System.out.println("Recursive Pre Order : ");
		pot.preOrder(root);
		System.out.println("\n\nIterative Pre Order : ");
		pot.preIterative(root);
	}
}
