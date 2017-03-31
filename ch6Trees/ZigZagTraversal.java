/*
 * To print the given binary tree in zig zag pattern
 *https://www.youtube.com/watch?v=YsLko6sSKh8
 */
package ch6Trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal
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
		root.right = right8;
		left2.left = left4;
		left2.right = right5;
	
		left4.right=right3;
		right5.left = left6;
		right5.right = right7;
		return root;
	}
	
	//Use Level order traversal (BFS)
	//Using 1 Queue and 1 Stack.
	//REmove element from the queue and push it onto the stack
	//Implement the same code as for standard BFS but instead of working on dequeded node, work on the popped node
	public void zigZagQ(Node root) {
		if(root == null)
			return;
		int levelNumber = 0;
		Queue<Node> q = new LinkedList<>();
		Stack<Node> stk = new Stack<>();
		q.add(root);
		while(!q.isEmpty()) {
			int levelSize = q.size();
			while(levelSize>0) {
				Node dqd = q.remove();
				stk.push(dqd);
				levelSize--;
			}
			while(!stk.isEmpty()) {
				Node popped = stk.pop();
				System.out.print(popped.data+" ");
				if(levelNumber%2!=0) {
					if(popped.right!=null)
						q.add(popped.right);
					if(popped.left!=null)
						q.add(popped.left);
				}
				else {
					if(popped.left!=null)
						q.add(popped.left);
					if(popped.right!=null)
						q.add(popped.right);
				}
			}
			levelNumber++;
		}
			
	}
	
	//Using Two stacks
	//Understood from Vivekanand video
	public void zigZagTwoStacks(Node root) {
		if(root == null)
			return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()||!s2.isEmpty()) {
			while(!s1.isEmpty()) {
				Node popped = s1.pop();
				System.out.print(popped.data+" ");
				if(popped.left!=null) s2.push(popped.left);
				if(popped.right!=null) s2.push(popped.right);
			}
			while(!s2.isEmpty()) {
				Node popped = s2.pop();
				System.out.print(popped.data+" ");
				if(popped.right!=null) s1.push(popped.right);
				if(popped.left!=null) s1.push(popped.left);
			}
		}
 	}
	
	//Using Double ended Queue (DEQUE) data structure
	//Fastest implementation
	//https://www.youtube.com/watch?v=WAmiEMnsjZM
	//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/#/description
	public void zigzagDeQue(Node root) {
        if(root == null) return;
        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(root);
        int levelNumber = 0;
        Node dqd = null;
        int levelSize = 0;
        while(!deque.isEmpty()){
              levelSize = deque.size();
            while(levelSize > 0) {
                if(levelNumber%2!=0) {
                    dqd = deque.removeFirst();
                    System.out.print(dqd.data+" ");
                    if(dqd.right!=null) deque.addLast(dqd.right);
                    if(dqd.left!=null) deque.addLast(dqd.left);
                } else {
                    dqd = deque.removeLast();
                    System.out.print(dqd.data+" ");
                    if(dqd.left!=null) deque.addFirst(dqd.left);
                    if(dqd.right!=null) deque.addFirst(dqd.right);
                }
                levelSize--;
            }
            levelNumber++;
        }
    }
	public static void main(String[] args)
	{
		ZigZagTraversal zzt = new ZigZagTraversal();
		Node root = zzt.createTree();
		zzt.zigZagQ(root);
		System.out.println();
		zzt.zigZagTwoStacks(root);
		System.out.println();
		zzt.zigzagDeQue(root);
	}
}
