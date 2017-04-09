/*
 * To implement a Stack using two queues
 * http://code.geeksforgeeks.org/hyz5V5
 * 
 */

package ch4stacks;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue
{
	Queue<Integer> q = new LinkedList<>();
	Queue<Integer> temp = new LinkedList<>();
	
	public void push(int d){
		if(q.isEmpty())
			q.add(d);
		else{
			while(!q.isEmpty())
				temp.add(q.remove());
			q.add(d);
			while(!temp.isEmpty())
				q.add(temp.remove());
		}
	}
	
	public int pop(){
		int popped = 0;
		if(!q.isEmpty())
			popped = q.remove();
		return popped;
	}
	
	public void display(){
		if(!q.isEmpty()){
			@SuppressWarnings("rawtypes")
			Iterator trav = q.iterator();
			while(trav.hasNext())
				System.out.print(trav.next()+" ");
		}
	}
	
	public static void main(String[] args)
	{
		StackUsingQueue sq = new StackUsingQueue();
		sq.push(3);
		sq.push(4);
		sq.push(5);
		sq.pop();
		
		sq.display();
	}
}
