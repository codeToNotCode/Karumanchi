package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal
{
	class Node{
		int data;
		Node left,right;
		public Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}
	Node root;
	public Node createTree(){
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
	
	public void levelOrder(Node root){
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node dequeued = q.remove();
			if(dequeued.left!=null)
				q.add(dequeued.left);
			if(dequeued.right!=null)
				q.add(dequeued.right);
			System.out.print(dequeued.data+" ");
		}
	}
	public static void main(String[] args)
	{
		LevelOrderTraversal lot = new LevelOrderTraversal();
		Node root = lot.createTree();
		System.out.println("\n\nLevel Order : ");
		lot.levelOrder(root);
	}

}
