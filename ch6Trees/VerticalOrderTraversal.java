/*
 * To traverse the given binary tree in a vertical order . Also find the vertical sum
 * 
 * https://www.youtube.com/watch?v=PQKkr036wRc
 * https://discuss.leetcode.com/topic/31954/5ms-java-clean-solution/15
 * http://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
 */
package ch6Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal
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
		root = new Node(1);
		Node left2 = new Node(2);
		Node right3 = new Node(3);
		Node left4 = new Node(4);
		Node right5 = new Node(5);
		Node left6 = new Node(6);
		Node right7 = new Node(7);
		Node right8 = new Node(8);
		root.left = left2;
		root.right = right3;
		left2.left = left4;
		left2.right = right5;
		right3.left = left6;
		right3.right = right7;
		right7.right = right8;
		return root;
	}
	
	//To print the vertical sum of a given binary tree
	public List<Integer> verticalSum(Node root){
		List<Integer> vsum = new ArrayList<>();
		if(root == null)	return vsum;
		List<List<Integer>> res = traverse(root);
		for(int i = 0; i<res.size(); i++) {
			int sum = 0;
			for(int j=0; j<res.get(i).size();j++) {
				sum+=res.get(i).get(j);
			}
			vsum.add(sum);
		}
		return vsum;
	}
	/*
	 * Vertical order traversal using BFS
	 */
	public List<List<Integer>> traverse(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root==null)	return res;
		
		Queue<Node> q = new LinkedList<>();
		Queue<Integer> hd = new LinkedList<>();
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		q.offer(root);
		hd.offer(0);
		while(!q.isEmpty()) {
			Node dqd = q.poll();
			int horizontalDistance = hd.poll();
			if(!map.containsKey(horizontalDistance)) {
				List<Integer> list = new LinkedList<>();
				map.put(horizontalDistance, list);
				if(horizontalDistance<0)
					res.add(0,list);
				else
					res.add(list);
			}
			map.get(horizontalDistance).add(dqd.data);
			if(dqd.left!=null) {
				q.offer(dqd.left);
				hd.offer(horizontalDistance-1);
			}
			if(dqd.right!=null) {
				q.offer(dqd.right);
				hd.offer(horizontalDistance+1);
			}
		}
		return res;
	}
	
	//Vertical Sum using DFS
	public List<Integer> vSum(Node root){
		List<Integer> sum = new ArrayList<>();
		if(root == null) 	return sum;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		vSumHelper(map,root,0);
		for(int k : map.keySet()) {
			sum.add(map.get(k));
		}
		return sum;
	}
	private void vSumHelper(TreeMap<Integer, Integer> map, Node root, int hd) {
		if(root.left!=null)	vSumHelper(map, root.left, hd-1);
		if(root.right!=null) vSumHelper(map, root.right, hd+1);
		int data = 0;
		if(map.containsKey(hd))
			data = map.get(hd);
		map.put(hd, root.data+data);
	}
	public static void main(String[] args)
	{
		VerticalOrderTraversal vot = new VerticalOrderTraversal();
		Node root = vot.createTree();
		List<List<Integer>> res = vot.traverse(root);
		System.out.println("Vertical order traversal using BFS :"+res);
		System.out.println("Vertical Sum using BFS :"+vot.verticalSum(root));
		System.out.println("Vertical Sum using DFS :"+vot.vSum(root));
	}
}
