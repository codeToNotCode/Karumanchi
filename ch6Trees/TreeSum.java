/*
 * To find sum of all the elements in the given binary tree
 */

package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSum
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
		Node left4 = new Node(4);
		Node right5 = new Node(5);
		Node left6 = new Node(6);
		Node right7 = new Node(7);
		
		root.left = left2;
		
		left2.left = left4;
		left2.right = right5;
	
		left4.right=right3;
		right5.left = left6;
		right5.right = right7;
		return root;
	}

	// Using BFS
	public int treeSum(Node root)
	{
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node dqd = null;
		int sum = 0;
		while (!q.isEmpty()) {
			dqd = q.remove();
			sum += dqd.data;
			if (dqd.left != null)
				q.add(dqd.left);
			if (dqd.right != null)
				q.add(dqd.right);			
		}
		return sum;
	}

	//Using DFS
	public int treeSumRecur(Node root) {
		if(root==null)
			return 0;
		return root.data + treeSumRecur(root.left) + treeSumRecur(root.right);
	}
	
	public static void main(String[] args)
	{
		TreeSum ts = new TreeSum();
		Node root = ts.createTree();
		System.out.println("Sum of all nodes using BFS :"+ts.treeSum(root));
		System.out.println("Sum of all nodes using Recur :"+ts.treeSumRecur(root));
		
	}

}
