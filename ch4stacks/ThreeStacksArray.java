/*
 * Implement three stacks using one array
 */
package ch4stacks;

public class ThreeStacksArray
{
	int A[] = new int[10];
	int top1,top2,top3,base3;
	public ThreeStacksArray(){
		top1 = -1;
		top2 = A.length;
		top3 = A.length/2;
		base3 = top3;
	}
	
	public void push(int stackId, int data){
		if(stackId == 1){
			if(top1 + 1 == base3){
				if(isRightShiftable()){
					shiftRight();
					A[++top1] = data;
					
				}
				else{
					System.out.println("Stack1 is full");
					return;
				}
			}else{
				A[++top1] = data;
			}
		}
		else if(stackId == 2){
			if(top2 - 1 == top3){
				if(isLeftShiftable()){
					shiftLeft();
					A[--top2] = data;
					
				}
				else{
					System.out.println("Stack2 is full");
					return;
				}
			}else{
				A[--top2] = data;
			}
		}
		else if(stackId == 3){
			if(top2 - 1  == top3){
				if(isLeftShiftable()){
					shiftLeft();
					A[++top3] = data;
					
				}
				else{
					System.out.println("Stack3 is full");
					return;
				}
			}else{
				A[++top3] = data;
			}
		}
	}
	private boolean isRightShiftable(){
		return top3 + 1 < top2;
	}
	private boolean isLeftShiftable(){
		return top1 + 1 < base3;
	}
	private void shiftLeft(){
		for(int i = base3 - 1 ; i < top3; i++)
			A[i] = A[i+1];
		A[top3--] = Integer.MAX_VALUE;
		base3--;
	}
	private void shiftRight(){
		for(int i = top3 + 1; i >= base3 + 1; i--)
			A[i]= A[i-1];
		A[base3++] = Integer.MAX_VALUE;
		top3++;
	}
	public int pop(int stackId){
		int popped = Integer.MAX_VALUE;
		if(stackId == 1){
			if(!isEmpty(1))
				popped = A[top1];
				A[top1--] = Integer.MAX_VALUE;
		}
		else if(stackId == 2){
			if(!isEmpty(2))
				popped = A[top2];
				A[top2++] = Integer.MAX_VALUE;
		}
		else if(stackId == 3){
			if(!isEmpty(3))
				popped = A[top3];
				A[top3--] = Integer.MAX_VALUE;
		}
		return popped;
	}
	public boolean isEmpty(int stackId){
		if(stackId == 1)
			return top1 == -1;
		else if (stackId == 2)
			return top2 == A.length;
		else if (stackId == 3){
			if(top3 == base3 && A[top3]==Integer.MAX_VALUE)
				return true;
		}
		return false;
	}
	public void display(int stackId){
		if(stackId == 1){
			for(int i = top1 ; i!=-1; i--)
				System.out.println(A[i]);
		}
		else if(stackId == 2){
			for(int i = top2 ; i!=A.length; i++)
				System.out.println(A[i]);
		}
		else if(stackId == 3){
			for(int i = top3 ; i>base3; i--)
				System.out.println(A[i]);
		}
	}
	public static void main(String[] args)
	{
		ThreeStacksArray ts = new ThreeStacksArray();
		ts.push(1,5);
		ts.push(3, 3);
		ts.push(3, 2);
		ts.push(2, -1);
		ts.push(2, -2);
		ts.push(3, 5);
		ts.push(1,10);
		//ts.pop(3);ts.pop(3);ts.pop(3);
		ts.display(3);
		ts.display(1);
		ts.display(2);
	}
}
