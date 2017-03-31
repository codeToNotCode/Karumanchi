/*
 * Find the maximum element in a given binary tree
 */

package ch6Trees;

import java.util.Stack;

public class FindMax
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
		root = new Node(160);
		Node left40 = new Node(40);
		Node right70 = new Node(70);
		root.left = left40;
		root.right = right70;
		Node left30 = new Node(30);
		Node right50 = new Node(150);
		left40.left = left30;
		left40.right = right50;
		Node left65 = new Node(65);
		Node right80 = new Node(80);
		right70.left = left65;
		right70.right = right80;
		return root;
	}
	//Using recursion
	//Find Max in left subtree
	//Find max in right subtree
	//Compare max obtained from both subtrees with root
	//Return the maximum element
	//O(n) time O(n) space
	public int getMax(Node root){
		int max = Integer.MIN_VALUE;
		if(root == null)
			return max;
		int leftMax = getMax(root.left);
		int rightMax = getMax(root.right);
		if(leftMax>max)
			max = leftMax;
		if(rightMax>max)
			max = rightMax;
		if(root.data>max)
			max = root.data;
		return max;
	}
	//Using preOrder Iterative traversal
	//O(n) time
	//O(h) stack space 
	public int max(Node root){
		if(root == null)
			return -1;
		Node trav = root;
		Stack<Node> s = new Stack<>();
		s.push(trav);
		int max = Integer.MIN_VALUE;
		while(!s.isEmpty()){
			Node popped = s.pop();
			if(max < popped.data)
				max = popped.data;
			if(popped.right!=null)
				s.push(popped.right);
			if(popped.left!=null)
				s.push(popped.left);
		}
		return max;
	}
	public static void main(String[] args)
	{
		FindMax fm = new FindMax();
		Node root = fm.createTree();
	//	System.out.println("Maximum Element : "+fm.max(root));
		System.out.println("Maximum Element : "+fm.getMax(root));
	}

}
