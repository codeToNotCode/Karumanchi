/*
 * To find the deepest node in a given binary tree
 */

package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNode
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

	//Deepest node will be the node which is removed from the queue at the end
	//Do not have to perform a level order exactly
	//Just add all the nodes to the queue and keep removing one by one
	//Last node to be removed from the queue will be the deepest
	public Node getDeepest(Node root){
		if(root == null)
			return null;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node dqd = null;
		while(!q.isEmpty()){
			 dqd = q.remove();
			if(dqd.left!=null)
				q.add(dqd.left);
			if(dqd.right!=null)
				q.add(dqd.right);
		}
		return dqd;
	}
	
	
	public static void main(String[] args)
	{
		DeepestNode dn = new DeepestNode();
		Node root = dn.createTree();
		System.out.println("Deepest Node : "+dn.getDeepest(root).data);
	}


}
