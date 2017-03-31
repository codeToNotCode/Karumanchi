/*
 * To print the contents of the tree in a reversed level order traversal
 * Better and harder code in leetcode Level Order Traversal ||
 */

package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversedLevelOrder
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

	// Level order traversal to check the insertion
	public void traverse(Node root)
	{
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		q.add(root);
		while (!q.isEmpty())
		{
			Node dqd = q.remove();
			s.push(dqd.data);
			if (dqd.left != null)
				q.add(dqd.left);
			if (dqd.right != null)
				q.add(dqd.right);
		}
		while(!s.isEmpty())
			System.out.print(s.pop()+" ");
		return;
	}
	
	public static void main(String[] args)
	{
		ReversedLevelOrder rlot = new ReversedLevelOrder();
		Node root = rlot.createTree();
		rlot.traverse(root);
	}
}
