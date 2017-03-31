/*
 * To Find the diameter of a given tree
 * Diameter of a tree is defined as the max number of nodes bw any two leaf nodes
 * It might or might not include the root node
 * 
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * http://javabypatel.blogspot.in/2015/12/diameter-of-binary-tree.html
 */

package ch6Trees;


public class Diameter
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
		left4.left = left6;
		left6.left = right7;
		right5.right = right3;
		
		return root;
	}
	
	//Diameter of the tree will be the maximum of :
	//1)Diameter of the current Node
	//2)Diameter of the left subtree
	//3)Diameter of the right subtree
	public int getDia(Node root){
		if (root == null)
			return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		//If the length is considered as the number of nodes, then add 1 to the nodeDia formula
		//Currently, it is the number of edges as per leetcode
		int nodeDia = leftHeight + rightHeight ;
		int leftSubTreeDia = getDia(root.left);
		int rightSubTreeDia = getDia(root.right);
		
		return Math.max(nodeDia, Math.max(leftSubTreeDia, rightSubTreeDia));
	}
	//To find the height of a given tree
	private int getHeight(Node root){
		if(root == null)
			return 0;
		int leftSubTreeHeight = getHeight(root.left);
		int rightSubTreeHeight = getHeight(root.right);
		return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
	}
	
	//Optimized solution for finding diameter
	//Instead of making a separate recursive call to calculate height,
	//We will find height in the same call
	//use an int array of size 2. First array index will store diameter 
	//2nd array index will store the height
	public int[] getDiaOpt(Node root){
		int result[] = {0,0};
		if (root == null)
			return result;
		
		int leftResult[] = getDiaOpt(root.left);
		int rightResult[] = getDiaOpt(root.right);
		int height = Math.max(leftResult[1],rightResult[1]) +1;
		
		int nodeDia = leftResult[1] + rightResult[1] ;
		int leftDia = leftResult[0];
		int rightDia = rightResult[0];
		
		result[0] = Math.max(nodeDia, Math.max(leftDia, rightDia));
		result[1] = height;
		
		return result;
	}
	public static void main(String[] args)
	{
		Diameter dia = new Diameter();
		Node root = dia.createTree();
		System.out.println("Diameter : " + dia.getDia(root));
		int optResult[] = dia.getDiaOpt(root);
		System.out.println("Diameter Optimized: " +optResult[0	]);
	}

}
