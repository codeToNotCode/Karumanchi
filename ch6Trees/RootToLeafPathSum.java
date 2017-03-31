/*
 * To check whether there exists a path from root to a leaf in which all the nodes add up to a given sum
 */

package ch6Trees;

public class RootToLeafPathSum
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

	//Find Path using DFS
	public boolean isPath(Node root, int sum) {
		if(root == null)
			return false;
		if(root.left==null&&root.right==null&&root.data==sum)
			return true;
		return isPath(root.left,sum-root.data)||isPath(root.right,sum-root.data);

	}
	public static void main(String[] args)
	{
		RootToLeafPathSum rlps = new RootToLeafPathSum();
		Node root = rlps.createTree();
		System.out.println(rlps.isPath(root,10));
	}

}
