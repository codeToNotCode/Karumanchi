/*
 * To reverse the first k number of elements in a given queue
 * 10 20 30 40 50 60 70 80 90, k = 4
 * output : 40 30 20 10 50 60  70 80 90
 */

package ch5Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements
{
	public Queue<Integer> reverseK(Queue<Integer> q, int k){
		if(q==null || q.isEmpty() || k <0 || k> q.size())
			return null;
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < k; i++)
			s.push(q.remove());
		while(!s.isEmpty())
			q.add(s.pop());
		for(int i = 0 ; i < q.size()-k;i++)
			q.add(q.remove());
		return q;
	}
	public static void main(String[] args)
	{
		ReverseKElements rke = new ReverseKElements();
		Queue<Integer> q = new LinkedList<>();
		q.add(10);q.add(20);q.add(30);q.add(40);q.add(50);q.add(60);q.add(70);q.add(80);q.add(90);
		
		Queue<Integer> rev = rke.reverseK(q,2);
		while(!rev.isEmpty())
			System.out.println(rev.remove());
	}
}
