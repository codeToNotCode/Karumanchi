/*
 * Given a queue consisting of even number of elements, interleave the two halves
 * 1 2 3 4 5 6
 * output - 1 4 2 5 3 6
 * https://github.com/ramakastriot/practiceit/blob/master/chapter14/interleave.java
 */

package ch5Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterLeaveHalves
{
	public Queue<Integer> interLeave(Queue<Integer> q){
		if(q == null || q.size()%2 != 0)	return null;
		Stack<Integer> s = new Stack<>();
		
		int halfSize = q.size()/2;
		
		for(int i = 0; i < halfSize; i++)
			s.push(q.remove());
		for(int i = 0; i < halfSize; i++)
			q.add(s.pop());
		for(int i = 0; i < halfSize; i++)
			s.push(q.remove());
		
		while(!s.isEmpty()) {
			q.add(s.pop());
			q.add(q.remove());
		}
		
		//reverse the queue to get the result
		while(!q.isEmpty())
			s.push(q.remove());
		while(!s.isEmpty())
			q.add(s.pop());
		
		return q;
	}
 	public static void main(String[] args)
	{
		InterLeaveHalves ilh = new InterLeaveHalves();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);q.add(2);q.add(3);q.add(4);q.add(5);q.add(6);
		System.out.println(ilh.interLeave(q));
	}
}
