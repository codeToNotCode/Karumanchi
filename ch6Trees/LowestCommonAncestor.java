/*
 * To find the lowest common ancestor(LCA) of two nodes of a given binary tree
 * https://www.youtube.com/watch?v=F-_1sbnPbWQ
 */
package ch6Trees;

public class LowestCommonAncestor
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
		root = new Node(37);
		Node left40 = new Node(34);
		Node right70 = new Node(-48);
		root.left = left40;
		root.right = right70;
		Node right50 = new Node(-100);
		left40.right = right50;
		Node left65 = new Node(-100);
		Node right80 = new Node(48);
		right70.left = left65;
		right70.right = right80;
		return root;
	}
	
	//To find the lca of the given two nodes
	public Node lca(Node root, Node n1, Node n2) {
		if(root == null)
			return null;
		if(root.equals(n1) || root.equals(n2))
			return root;
		Node leftNodeReturned = lca(root.left,n1,n2);
		Node rightNodeReturned = lca(root.right, n1, n2);
		
		if(leftNodeReturned!=null && rightNodeReturned!=null)
			return root;
		else
			return (leftNodeReturned!=null)?leftNodeReturned:rightNodeReturned;
	}
	public static void main(String[] args)
	{
		LowestCommonAncestor lca = new LowestCommonAncestor();
		Node root = lca.createTree();
		System.out.print("Lowest Common Ancestors are :"+lca.lca(root,root.right.left,root.right).data);
	}
}
