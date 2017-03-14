/*
 * To implement k Stacks using 1 array
 */

package ch4stacks;


public class NStacksWithOneArray
{
	int topOfStack[];
	int stackData[];
	int nextIndex[];
	int nextAvailable;
	public NStacksWithOneArray(int numStacks, int capacity){
		topOfStack = new int[numStacks];
		for(int i = 0; i <numStacks; i++)
			topOfStack[i] = -1;
		
		stackData = new int[capacity];
		
		nextIndex = new int[capacity];
		for(int i = 0; i < capacity-1; i++)
			nextIndex[i] = i+1;
		nextIndex[capacity-1] = -1;
		
		nextAvailable = 0;
	}
	
	public boolean isFull(){
		return nextAvailable < 0;
	}
	public boolean isValidStack(int stackId){
		if (stackId < 0 || stackId >= topOfStack.length )
			return false;
		return true;
	}
	public boolean isEmpty(int stackId){
		return topOfStack[stackId] == -1;
	}
	
	public void push(int stackId, int data){
		if(!isValidStack(stackId))
			return;
		if(isFull())
			return;
		
		int cIndex = nextAvailable;
		stackData[cIndex] = data;
		nextAvailable = nextIndex[cIndex];
		nextIndex[cIndex] = topOfStack[stackId];
		topOfStack[stackId] = cIndex;
	}
	
	public int pop(int stackId){
		if(!isValidStack(stackId))
			return -1;
		if(isEmpty(stackId))
			return -1;
		
		int cIndex = topOfStack[stackId];
		int popped = stackData[cIndex];
		topOfStack[stackId] = nextIndex[cIndex];
		nextIndex[cIndex] = nextAvailable;
		nextAvailable = cIndex;
		
		return popped;
	}
	
	public void display(int stackId){
		if(!isValidStack(stackId))
			return;
		if(isEmpty(stackId))
			return;
		int cIndex = topOfStack[stackId];
		while(nextIndex[cIndex] != -1){
			System.out.println(stackData[cIndex]);
			cIndex = nextIndex[cIndex];
		}
		System.out.println(stackData[cIndex]);
	}
	
	
	public static void main(String[] args)
	{
		NStacksWithOneArray kStacks = new NStacksWithOneArray(3, 10);
		
		kStacks.push(0,1);		kStacks.push(0,2);		kStacks.push(1,15);
		kStacks.push(1,25);		kStacks.push(2,6);		kStacks.push(2,16);
		kStacks.push(2,26);		kStacks.push(2,36);		kStacks.push(1,35);
		kStacks.push(0,4);
//		
//		kStacks.pop(0);		kStacks.pop(1);		kStacks.pop(2);		
//		kStacks.pop(0);		kStacks.pop(1);		kStacks.pop(2);
//		kStacks.pop(0);		kStacks.pop(1);		kStacks.pop(2);		
//		kStacks.pop(0);		kStacks.pop(1);		kStacks.pop(2);
//		
		System.out.println("Elements of the First stack :");
		kStacks.display(0);
		
		System.out.println("\nElements of the Second stack :");
		kStacks.display(1);
		
		System.out.println("\nElements of the Third stack :");
		kStacks.display(2);
	}
}
