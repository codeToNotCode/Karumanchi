/*
 * To find the total number of leaves in a given tree
 */
package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfLeaves
{
	class Node
	{
		int data;
		Node left, right;

		public Node(int d)
		{
			data = d;
			left = null;
			right = null;
		}
	}

	Node root;

	public Node createTree()
	{
		root = new Node(1);
		Node left2 = new Node(2);
		Node right3 = new Node(3);
		root.left = left2;
		root.right = right3;
		Node left4 = new Node(4);
		Node right5 = new Node(5);
		left2.left = left4;
		left2.right = right5;
		Node left6 = new Node(6);
	//	Node right7 = new Node(7);
		right3.left = left6;
	//	right3.right = right7;
		return root;
	}

	//To find the total number of leaves in the tree
	public int leaves(Node root){
		if(root == null)
			return 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node dqd = null;
		int count = 0;
		while(!q.isEmpty()){
			dqd = q.remove();
			if(dqd.left==null && dqd.right==null)
				count++;
			if(dqd.left!=null)
				q.add(dqd.left);
			if(dqd.right!=null)
				q.add(dqd.right);
		}
		return count;
	}
	
	
	public static void main(String[] args)
	{
		NumberOfLeaves nol = new NumberOfLeaves();
		Node root = nol.createTree();
		System.out.println("Number of leaves : "+nol.leaves(root));
	}


}
