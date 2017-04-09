/*
 * To make each node in a particular level point to its next sibling
 * https://leetcode.com/submissions/detail/98704267/
 */
package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class NextSibling
{
	class Node{
		int data;
		Node left;
		Node right;
		Node nextSibling;
		public Node(int d) {
			data = d;
			left = null;
			right = null;
			nextSibling = null;
		}
	}
	Node root;
	public Node createTree(){
		root = new Node(1);
		Node left2 = new Node(2);
		Node right3 = new Node(3);
		Node left4 = new Node(4);
		Node right5 = new Node(5);
		Node left6 = new Node(6);
		Node right7 = new Node(7);
		Node right8 = new Node(8);
		root.left = left2;
		root.right = right3;
		left2.left = left4;
		left2.right = right5;
		right3.left = left6;
		right3.right = right7;
		right7.right = right8;
		return root;
	}
	
	//If the tree is a complete binary tree ie. each node either has no child or has 2 chilren
	public void nextComplete(Node root) {
		if(root == null )	return;
		Node trav = root;
		Node nextLevel = null;
		while(trav.left!=null) {
			nextLevel = trav.left;
			while(trav!=null) {
				trav.left.nextSibling = trav.right;
				trav.right.nextSibling = (trav.nextSibling!=null) ? trav.nextSibling.left : null;
				trav = trav.nextSibling;
			}
			trav = nextLevel;
		}
	}
	
	//If the tree is a normal binary tree
	public void nextBinary(Node root) {
		if(root == null )	return;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int levelSize = q.size();
			while(levelSize>0) {
				Node dqd = q.poll();
				dqd.nextSibling = (levelSize==1) ? null : q.peek();
				if(dqd.left!=null)	q.offer(dqd.left);
				if(dqd.right!=null)	q.offer(dqd.right);
				levelSize--;
			}
		}
	}
	public static void main(String[] args)
	{
		NextSibling ns = new NextSibling();
		Node root = ns.createTree();
		ns.nextComplete(root);
		ns.nextBinary(root);
	}
}
