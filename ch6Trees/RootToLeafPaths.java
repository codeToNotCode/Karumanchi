/*
 * To display paths that go from root to all the leaves of the tree
 * https://www.youtube.com/watch?v=zIkDfgFAg60
 */

package ch6Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RootToLeafPaths
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

	//To print paths from root to all the leaves
	//Wrapper function
	public void rootLeaf(Node root) {
		Stack<Integer> s = new Stack<>();
		printPaths(root,s);
	}
	
	//Function to actually traverse the tree and store all the nodes in a stack
	//Modification of DFS using inorder traversal
	//When a leaf node is encountered, print all the contents of the stack
	private void printPaths(Node root, Stack<Integer> s) {
		if(root == null)
			return;
		s.push(root.data);
		printPaths(root.left,s);
		if(root.left==null&&root.right==null)
			printStack(s);
		printPaths(root.right,s);
		s.pop();
	}
	
	//You cannot print the stack contents by popping out all the elements
	//Will give empty stack exception at line 61
	//Hence you pop all stack elements to a list
	//Print the list
	//Copy all the elements from the list back into the stack
	private void printStack(Stack<Integer> s) {
		List<Integer> list = new ArrayList<>();
		System.out.println();
		while(!s.isEmpty()) {
			list.add(0,s.pop());
		}
		
		for(int i = 0 ; i<list.size();i++) {
			System.out.print(list.get(i)+" ");
			s.push(list.get(i));
		}
	}

	
	//Simple implementation using arrays instead of stack
	public void findPaths(Node root) {
		int paths[] = new int[1000];
		findAllPaths(root,paths,0);
	}
	private void findAllPaths(Node root, int[] paths, int pathLen) {
		if(root == null)
			return;
		paths[pathLen] = root.data;
		pathLen++;
		if(root.left==null&&root.right==null)
			printPath(paths,pathLen);
		else {
			findAllPaths(root.left,paths,pathLen);
			findAllPaths(root.right,paths,pathLen);
		}
	}
	private void printPath(int[] paths, int len) {
		for(int i = 0 ; i < len ; i++)
			System.out.print(paths[i]+" ");
		System.out.println();
	}
	
	//Best Solution
	//From leetcode : https://discuss.leetcode.com/topic/21474/accepted-java-simple-solution-in-8-lines/13
	//By yfCheng in comments
	public List<String> findPathsL(Node root){
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		findAll(root,result,sb);
		return result;
	}
	private void findAll(Node root, List<String> res, StringBuilder sb) {
		if(root == null)
			return;
		int len = sb.length();
		sb.append(root.data);
		if(root.left==null&&root.right==null)
			res.add(sb.toString());
		else {
			sb.append("->");
			findAll(root.left,res,sb);
			findAll(root.right,res,sb);
		}
		//setLength terminates the string at the given length by adding a null character at the end
		//This is used in this program to backtrack
		//For more clarifications, search for setLength function of StringBuilder class
		sb.setLength(len);
	}
	
	public static void main(String[] args)
	{
		RootToLeafPaths rlp = new RootToLeafPaths();
		Node root = rlp.createTree();
		System.out.println("Stack implementaion :");
		rlp.rootLeaf(root);
		System.out.println("\n\nArray implementaion :");
		rlp.findPaths(root);
		List<String> result = rlp.findPathsL(root);
		System.out.println("\nLeetCOde variation :"+result);
	}

}
