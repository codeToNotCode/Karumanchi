/*
 * To build a binary tree from the given inOrder and PostOrder traversals
 * Assume that the inOrder and postOrder traversals form a tree always
 * https://discuss.leetcode.com/topic/3695/my-accepted-java-solution
 * 
 * Concept from https://www.youtube.com/watch?v=pBULoHAI0pg&t=311s
 */
package ch6Trees;


public class BuildTreePostIn
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
	public Node buildTree(char[] in, char[] post) {
		return helper(in,post,in.length-1,0,in.length-1);
	}
	private Node helper(char[] in, char[] post, int postIndex, int inStart, int inEnd) {
		if(postIndex < 0 || inStart > inEnd)
			return null;
		Node tNode = new Node(post[postIndex]);
		int inIndex = search(in,inStart,inEnd,tNode.data);
		tNode.left = helper(in,post,postIndex-(inEnd-inIndex)-1,inStart,inIndex-1);
		tNode.right  = helper(in,post,postIndex-1,inIndex+1,inEnd);
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
		BuildTreePostIn btpi = new BuildTreePostIn();
		char inOrder[] = {'D','B','E','A','F','C'};
		char postOrder[] = {'D','E','B','F','C','A'};
		Node root = btpi.buildTree(inOrder, postOrder);
		btpi.display(root);
		
	}
}
