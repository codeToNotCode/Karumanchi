/*
 * To find the size of a given binary tree
 * Size of a binary tree is equal to the total number of nodes in the tree
 */

package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfTree
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
		q.add(root);
		while (!q.isEmpty())
		{
			Node dqd = q.remove();
			System.out.print(dqd.data + " ");
			if (dqd.left != null)
				q.add(dqd.left);
			if (dqd.right != null)
				q.add(dqd.right);
		}
		return;
	}
	
	public int getSize(Node root){
		if(root == null)
			return 0;
		return 1 + getSize(root.left) + getSize(root.right);
	}

	public static void main(String[] args)
	{
		SizeOfTree s = new SizeOfTree();
		Node root = s.createTree();
		s.traverse(root);
		System.out.println("\nSize of the above tree :"+s.getSize(root));
	}
}
