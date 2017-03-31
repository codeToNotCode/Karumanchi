/*
 * To insert a new element into the binary tree
 * You can insert anywhere in the tree
 */

package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class InsertIntoTree
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

	// Insert using Level Order Traversal
	// It is better because you are inserting at the closest level
	public void insertBFS(Node root, int data)
	{
		if (root == null)
		{
			root = new Node(data);
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty())
		{
			Node dqd = q.remove();
			if (dqd.left != null)
				q.add(dqd.left);
			else
			{
				Node newNode = new Node(data);
				dqd.left = newNode;
				return;
			}
			if (dqd.right != null)
				q.add(dqd.right);
			else
			{
				Node newNode = new Node(data);
				dqd.right = newNode;
				return;
			}
		}
		return;
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

	public static void main(String[] args)
	{
		InsertIntoTree ist = new InsertIntoTree();
		Node root = ist.createTree();
		ist.insertBFS(root, 170);
		ist.traverse(root);
	}
}
