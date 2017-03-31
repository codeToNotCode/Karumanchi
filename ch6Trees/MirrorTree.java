/*
 * To convert a given tree into its mirror counterpart
 */

package ch6Trees;

public class MirrorTree
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
	
	//Convert to Mirror
	public void makeMirror(Node root) {
		if(root == null)
			return;
		makeMirror(root.left);
		makeMirror(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	//Display the tree inOrder form
	public void display(Node root) {
		if(root == null)
			return;
		display(root.left);
		System.out.print(root.data+" ");
		display(root.right);
	}
	
	public static void main(String[] args)
	{
		MirrorTree mt = new MirrorTree();
		Node root = mt.createTree();
		System.out.println("Before Mirroring :\n");
		mt.display(root);
		mt.makeMirror(root);
		System.out.println("After Mirroring :\n");
		mt.display(root);		
	}

}
