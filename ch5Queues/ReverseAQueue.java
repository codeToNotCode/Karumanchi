/*
 * To reverse elements of the given queue
 */

package ch5Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueue
{
	public Queue<Integer> reverse(Queue<Integer> q){
		if(q == null || q.isEmpty())
			return q;
		Stack<Integer> s = new Stack<>();
		while(!q.isEmpty())
			s.push(q.remove());
		while(!s.isEmpty())
			q.add(s.pop());
		return q;
	}
	public static void main(String[] args)
	{
		ReverseAQueue raq = new ReverseAQueue();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);q.add(2);q.add(3);q.add(4);q.add(5);
//		while(!q.isEmpty())
//			System.out.println(q.remove());
		Queue<Integer> reversed = raq.reverse(q);
		while(!reversed.isEmpty())
		System.out.println(reversed.remove());
	}
}
