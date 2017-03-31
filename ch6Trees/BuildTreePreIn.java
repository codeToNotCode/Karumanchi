/*
 * To build a binary tree from the given inOrder and PreOrder traversals
 * Assume that the inOrder and preOrder traversals form a tree always
 * https://discuss.leetcode.com/topic/3695/my-accepted-java-solution
 * Concept from :
 * https://www.youtube.com/watch?v=LrmitUxgXbc
 */
package ch6Trees;


public class BuildTreePreIn
{
	class Node{
		char data;
		Node left,right;
		public Node(char d){
			data = d;
			left = null;
			right = null;
		}
	}
	Node root;

	//Build a tree from the given inorder and preorder traversals
	public Node buildTree(char[] in, char[] pre) {
		return helper(in,pre,0,0,in.length-1);
	}
	private Node helper(char[] in, char[] pre, int preIndex, int inStart, int inEnd) {
		if(preIndex > pre.length-1 || inStart > inEnd)
			return null;
		Node tNode = new Node(pre[preIndex]);
		if(inStart == inEnd)
			return tNode;
		int inIndex = search(in,inStart,inEnd,tNode.data);
		tNode.left = helper(in,pre,preIndex+1,inStart,inIndex-1);
		tNode.right  = helper(in,pre,preIndex+inIndex-inStart+1,inIndex+1,inEnd);
		return tNode;	
	}
	private int search(char[] in, int strt, int end, int data) {
		int i = 0;
		for(i = strt; i<=end; i++)
			if(in[i] == data)
				return i;
		return i;
	}
	
	//Display in preOrder Traversal
	public void display(Node root) {
		if(root == null)
			return;
		System.out.print(root.data+" ");
		display(root.left);
		display(root.right);
	}
	public static void main(String[] args)
	{
		BuildTreePreIn btpi = new BuildTreePreIn();
		char inOrder[] = {'D','C','B','A'};
		char preOrder[] = {'A','B','C','D'};
		Node root = btpi.buildTree(inOrder, preOrder);
		btpi.display(root);
		
	}
}
