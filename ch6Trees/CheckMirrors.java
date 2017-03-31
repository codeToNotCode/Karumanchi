/*
 * To check whether the given two trees are mirror images of each other or not
 */

package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckMirrors
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
	
	//check whether mirror images or not
	//Using DFS recursion
	public boolean areMirrors(Node root1, Node root2) {
		if(root1==null&&root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		if(root1.data!=root2.data)
			return false;
		return areMirrors(root1.left,root2.right)&&areMirrors(root1.left,root2.right);
	}
	
	//Using Stacks Iterative
	public boolean checkMirror(Node root1, Node root2) {
		if(root1==null&&root2==null)
			return true;
		Stack<Node> s = new Stack<>();
		s.push(root1);
		s.push(root2);
		while(!s.isEmpty()) {
			Node n1 = s.pop();
			Node n2 = s.pop();
			if(n1==null&&n2==null)
				continue;
			if(n1==null||n2==null)
				return false;
			if(n1.data!=n2.data)
				return false;
			s.push(n1.left);
			s.push(n2.right);
			s.push(n1.right);
			s.push(n2.left);
		}
		return true;
	}
	

	//Using Queue Iterative
	public boolean checkMirrorQ(Node root1, Node root2) {
		if(root1==null&&root2==null)
			return true;
		Queue<Node> q = new LinkedList<>();
		q.add(root1);
		q.add(root2);
		while(!q.isEmpty()) {
			Node n1 = q.remove();
			Node n2 = q.remove();
			if(n1==null&&n2==null)
				continue;
			if(n1==null||n2==null)
				return false;
			if(n1.data!=n2.data)
				return false;
			q.add(n1.left);
			q.add(n2.right);
			q.add(n1.right);
			q.add(n2.left);
		}
		return true;
	}
	//make mirror image
	public void makeMirror(Node root) {
		if(root == null)
			return;
		makeMirror(root.left);
		makeMirror(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	public static void main(String[] args)
	{
		CheckMirrors cm = new CheckMirrors();
		Node root1 = cm.createTree();
		Node root2 = cm.createTree();
		cm.makeMirror(root2);
		System.out.println("Using recursion :"+cm.areMirrors(root1,root2));
		System.out.println("Using Stacks :"+cm.checkMirror(root1,root2));
		System.out.println("Using Queue :"+cm.checkMirrorQ(root1,root2));
		
	}

}
