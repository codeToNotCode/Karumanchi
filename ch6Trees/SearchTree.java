/*
 * To search a binary tree to check whether the given data exists in the tree or not
 */

package ch6Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SearchTree
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
	
	//Search using recursion
	//Visit each node
	public boolean search(Node root, int data){
		if(root == null )
			return false;
		if(root.data ==data)
			return true;
		return search(root.left,data)||search(root.right,data);
	}
	

	//Search using Level Order Traversal
	//It is better because you are searching level vise and it is Breadth First going one level at a time
	public boolean searchBFS(Node root, int data){
		if(root == null)
			return false;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node dqd = q.remove();
			if(dqd.data == data)
				return true;
			if(dqd.left!=null)
				q.add(dqd.left);
			if(dqd.right!=null)
				q.add(dqd.right);
		}
		return false;
	}
	public static void main(String[] args)
	{
		SearchTree st = new SearchTree();
		Node root = st.createTree();
		System.out.println(st.search(root,170));
		System.out.println(st.searchBFS(root,170));
	}

}
