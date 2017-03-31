/*
 * To check whether the given two trees are structurally identical or not
 * Two trees are structurally identical if they have the same data at the same positions
 */
package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalStructure
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
	public Node createTree1()
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
		Node right8 = new Node(8);
		right7.left = right8;
		return root;
	}
	
	
	//Using Recursion
	public boolean areIdentical(Node root1, Node root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.data!=root2.data)
			return false;
		return areIdentical(root1.left,root2.left)&&areIdentical(root1.right,root2.right);
	}

	//Using Iteration
	public boolean areIden(Node root1, Node root2){
		if(root1==null&&root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		q1.add(root1);
		q2.add(root2);
		while(!q1.isEmpty()&&!q2.isEmpty()){
			Node dqd1 = q1.remove();
			Node dqd2 = q2.remove();
			if(dqd1.data!=dqd2.data)
				return false;
			if(dqd1.left!=null&&dqd2.left!=null){
				q1.add(dqd1.left);
				q2.add(dqd2.left);
			}else if(dqd1.left!=null||dqd2.left!=null)
				return false;
			
			if(dqd1.right!=null&&dqd2.right!=null){
				q1.add(dqd1.right);
				q2.add(dqd2.right);
			}else	if(dqd1.right!=null||dqd2.right!=null)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		IdenticalStructure is = new IdenticalStructure();
		Node root1 = is.createTree();
		Node root2 = is.createTree1();
		
		System.out.println(is.areIdentical(root1,root2));
		System.out.println(is.areIden(root1,root2));
	}

}
