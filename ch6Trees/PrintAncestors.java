/*
 * To print all ancestors of a given binary tree
 * https://www.youtube.com/watch?v=qjD-CmuC0MQ
 */
package ch6Trees;

import java.util.Stack;

public class PrintAncestors
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
	
	//To find all ancestors of the target Node if present
	public Stack<Integer> getAncestors(Node root, Node target){
		Stack<Integer> ancestors = new Stack<>();
		helper(root, target, ancestors);
		return ancestors;
	}
	private boolean helper(Node root, Node target, Stack<Integer> ancestors) {
		if(root == null)
			return false;
		if(root.data == target.data) {
			ancestors.push(root.data);
			return true;
		}
		if(helper(root.left,target,ancestors)||helper(root.right,target,ancestors)) {
			ancestors.push(root.data);
			return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		PrintAncestors pa = new PrintAncestors();
		Node root = pa.createTree();
		Stack<Integer> ancestors = pa.getAncestors(root,root.left.right);
		System.out.print("Ancestors of "+root.left.left.data+" are :");
		while(!ancestors.isEmpty())
			System.out.print(ancestors.pop()+" ");
	}
}
