/*
 * To find the minimum depth of a given binary tree
 * Min depth of a tree is defined as the shorted number of nodes from the root to the nearest leaf node
 * Important case to cheeck is the skew trees
 */
package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth
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
		Node right7 = new Node(7);
		right3.left = left6;
		right3.right = right7;
		return root;
	}

	//Level Order	
	//Better than recursion
	public int minD(Node root){
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int depth = 0;
		while(true){
			int nodeCount = q.size();
			if(nodeCount == 0)
				return depth;
			depth++;
			while(nodeCount>0){
				Node dqd = q.remove();
				if(dqd.left==null&&dqd.right==null)
					return depth;
				if(dqd.left!=null)
					q.add(dqd.left);
				if(dqd.right!=null)
					q.add(dqd.right);
				nodeCount--;
			}
		}
	}
	
	//Using recursion
	public int minimumDepth(Node root){
		// Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;
 
        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;
 
        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minimumDepth(root.right) + 1;
 
        // If right subtree is NULL, recur for right subtree
        if (root.right == null)
            return minimumDepth(root.left) + 1;
 
        return Math.min(minimumDepth(root.left),
                        minimumDepth(root.right)) + 1;
    }
	
	public static void main(String[] args)
	{
		MinDepth md = new MinDepth();
		Node root = md.createTree();
		System.out.println("Minimum depth : "+md.minD(root));
		System.out.println("Minimum depth using recursion : "+md.minimumDepth(root));
	}

}
