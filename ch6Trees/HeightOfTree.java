/*
 * TO find the height of the binary tree
 */

package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HeightOfTree
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
		Node right90 = new Node(90);
		Node right100 = new Node(100);
		right70.left = left65;
		right70.right = right80;
		right80.left = right90;
		right90.left = right100;
		return root;
	}

	// Finding height using recursion
	//Height of the given tree would be 2 according to myCodeSchool videos
	public int getHeight(Node root){
		if(root == null )
			return -1;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		return (leftHeight>rightHeight)?leftHeight+1:rightHeight+1;
	}

	//finding height using stacks
	//POst Order traversal gives height
	public int height(Node root){
		if(root == null)
			return -1;
		Stack<Node> s = new Stack<>();
		s.push(root);
		int height = 0;
		Node prev = null;
		while(!s.isEmpty()){
			Node curr = s.peek();
			if(prev == null || prev.left == curr || prev.right==curr){
				if(curr.left!=null)
					s.push(curr.left);
				else if(curr.right!=null)
					s.push(curr.right);
				else
					s.pop();
			}else if(curr.left==prev){
				if(curr.right!=null)
					s.push(curr.right);
				else
					s.pop();
			}else
				s.pop();
			prev = curr;
			if(height<s.size())
				height = s.size();
			
		}
		return height-1;
	}
	//Finding height using Level Order traversal
	//This is faster than using stacks(Post order)
	//Done from geeks for geeks
	public int getHeightQ(Node root){
		if(root == null)
			return 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int height = -1;
		while(true){
			int nodeCount = q.size();
			if(nodeCount == 0)
				return height;
			height++;
			while(nodeCount>0){
				Node dqd = q.remove();
				if(dqd.left!=null)
					q.add(dqd.left);
				if(dqd.right!=null)
					q.add(dqd.right);
				nodeCount--;
			}
		}
	}
	public static void main(String[] args)
	{
		HeightOfTree hot = new HeightOfTree();
		Node root = hot.createTree();
		System.out.println("Height using Recursion: "+hot.getHeight(root));
		System.out.println("Height using Stacks: "+hot.height(root));
		System.out.println("Height using Queue: "+hot.getHeightQ(root));
	}

}
