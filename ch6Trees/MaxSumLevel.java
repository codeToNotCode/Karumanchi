/*
 * To find a level which contains the Maximum sum in the binary tree
 * Return the level number and the maximum sum
 */

package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSumLevel
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

	// To find the level which contains the maximum Sum of nodes
	public int[] maxSumLevel(Node root)
	{
		int result[] = new int[2];
		if (root == null)
			return result;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		Node dqd = null;

		int levelNumber = 0;
		int maxLevelSum = Integer.MIN_VALUE;
		while (!q.isEmpty())
		{	int levelSize = q.size();
			int levelSum = 0;
 			for(int i =0; i<levelSize;i++) {
				dqd = q.remove();
				if (dqd.left != null)
					q.add(dqd.left);
				if (dqd.right != null)
					q.add(dqd.right);
				levelSum += dqd.data;
			}
 			if(levelSum>maxLevelSum) {
 				maxLevelSum = levelSum;
 				result[0] = levelNumber;
 			}
			levelNumber++;
		}
		result[1] = maxLevelSum;
		return result;
	}

	public static void main(String[] args)
	{
		MaxSumLevel msl = new MaxSumLevel();
		Node root = msl.createTree();
		int result[] =  msl.maxSumLevel(root);
		System.out.println("Level that has the max sum :"+result[0]);
		System.out.println("Maximum Sum :"+result[1]);
	}

}
