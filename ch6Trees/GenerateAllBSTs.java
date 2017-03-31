/*
 * Given total number of nodes in a tree, generate all the possible permutations of trees from 1 to n
 *http://ideone.com/fDJ5HM
 */

package ch6Trees;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBSTs
{
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}
	
	public List<Node> generateTrees(int n){
		if(n==0)
			return generate(1,0);
		return generate(1,n);
	}
	private List<Node> generate(int start, int end){
		List<Node> subTrees = new ArrayList<>();
		if(start>end) {
			subTrees.add(null);
			return subTrees;
		}
		for(int i= start; i<=end; i++) {
			List<Node> leftSubTree = generate(start, i-1);
			List<Node> rightSubTree = generate(i+1, end);
			
			for(int j = 0; j < leftSubTree.size(); j++) {
				Node left = leftSubTree.get(j);
				for(int k = 0; k < rightSubTree.size(); k++) {
					Node right = rightSubTree.get(k);
					Node root = new Node(i);
					root.left = left;
					root.right = right;
					subTrees.add(root);
				}
			}
		}
		return subTrees;
	}
	public void display(Node root) {
		if(root == null) 	return;
		System.out.print(root.data +" ");
		display(root.left);
		display(root.right);
	}
	public static void main(String[] args)
	{
		GenerateAllBSTs ga = new GenerateAllBSTs();
		List<Node> result = ga.generateTrees(3);
		for(int i = 0; i < result.size(); i++) {
			ga.display(result.get(i));
			System.out.println();
		}
			
	}
}
