/*
 * To generate a tree from a given preOrder traversa
 * Assume that the tree either has 0 nodes or 2 nodes only
 * N means a normal node and L means a leaf node
 */
package ch6Trees;

public class TreeFromPreOrder
{
	class Node{
		char data;
		Node left;
		Node right;
		public Node(char d) {
			data = d;
			left = null;
			right = null;
		}
	}
	public Node createTree(char[] ch, int i) {
		if(ch == null)		return null;
		if(ch.length==i)	return null;
		Node newNode = new Node(ch[i]);
		if(ch[i] == 'L')
			return newNode;
		newNode.left = createTree(ch,++i);
		newNode.right = createTree(ch,++i);
		return newNode;
	}
	public void display(Node root) {
		if(root == null)	return;
		System.out.print(root.data+" ");
		display(root.left);
		display(root.right);
	}
	public static void main(String[] args)
	{
		TreeFromPreOrder tfpo = new TreeFromPreOrder();
		char ch[] = {'N','L','N','L','L'};
		Node root = tfpo.createTree(ch, 0);
		tfpo.display(root);
	}
}
