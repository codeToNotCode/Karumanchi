/*
 * To do a Pre Order traversal of the given tree
 * <LeftSubTreeTree><RightSubTree><Root>
 * Recursive
 * Iterative
 */
package ch6Trees;

import java.util.Stack;


public class PostOrderTraversal
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
	//Iterative Post-Order Traversal
	//Using 1 stack
	//O(n) time
	//O(h) space
	//Done from geeksforgeeks - best explanation and code
	public void postIterativeOneStack(Node root){
		if(root == null )
			return;
		Stack<Node> s = new Stack<>();
		s.push(root);
		Node prev = null;
		while(!s.isEmpty()){
			Node curr = s.peek();
			if(prev == null || prev.left == curr || prev.right == curr){
				if(curr.left!=null)
					s.push(curr.left);
				else if(curr.right!=null)
					s.push(curr.right);
				else{
					s.pop();
					System.out.print(curr.data+" ");
				}
			}else if(curr.left == prev){
				if(curr.right!=null)
					s.push(curr.right);
				else{
					s.pop();
					System.out.print(curr.data+" ");
				}
			}else if(curr.right == prev){
				s.pop();
				System.out.print(curr.data+" ");
			}
			prev = curr;
		}
	}
	//Iterative Post-Order Traversal
	///Using 2 stacks
	//O(n) time 
	//O(n) space because all the nodes are stored in the result stack
	//Done from tushar roy videos
	public void postIterativeTwoStacks(Node root){
		if(root == null)
			return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> result = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()){
			Node popped = s1.pop();
			result.push(popped);
			if(popped.left!=null)
				s1.push(popped.left);
			if(popped.right!=null)
				s1.push(popped.right);
		}
		while(!result.isEmpty())
			System.out.print(result.pop().data+" ");
		
	}
	
	//Recursive in-Order Traversal
	public void postOrder(Node trav){
		if(trav == null)
			return;
		
		postOrder(trav.left);
		postOrder(trav.right);
		System.out.print(trav.data+" ");
	}
	public static void main(String[] args)
	{
		PostOrderTraversal pos = new PostOrderTraversal();
		Node root = pos.createTree();
		System.out.println("Recursive Post Order : ");
		pos.postOrder(root);
		System.out.println("\n\nIterative Post Order using 2 Stacks : ");
		pos.postIterativeTwoStacks(root);
		System.out.println("\n\nIterative Post Order using 1 Stack : ");
		pos.postIterativeOneStack(root);
	}

}
