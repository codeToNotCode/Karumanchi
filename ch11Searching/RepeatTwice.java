/*
 * Given an array  with numbers from 1 to size - 2 such that 2 numbers are repeating twice
 * Print these repeating numbers
 * 1 2 2 3 4 4 5 should return 2 4
 */

package ch11Searching;

public class RepeatTwice
{
	
	//Similar to hashmap
	//O(n) time
	//O(n) space
	public void repTwice(int[] A){
		if(A==null||A.length==0)
			return;
		int n = A.length - 2;
		int count[] =  new int[n+1];
		for(int i = 0 ; i < A.length; i++){
			count[A[i]]++;
			if(count[A[i]] == 2)
				System.out.println(A[i]);
		}
	}
	
	//Using XOR
	//O(n) time
	//O(1) space
	public void repeatTwice(int[] A){
		if(A==null||A.length==0)
			return;
		int n = A.length - 2;
		int XOR = A[0];
		int X=0,Y=0, rightMostSetBit;
		
		for(int i = 1 ; i<A.length;i++)
			XOR^=A[i];
		for(int i = 1 ; i<=n;i++)
			XOR^=i;
		rightMostSetBit = XOR & ~(XOR-1);
		for(int i = 0 ; i<A.length; i++)
			if((A[i] & rightMostSetBit) > 0)
				X^=A[i];
			else
				Y^=A[i];
		for(int i = 1; i<=n; i++)
			if((i & rightMostSetBit) > 0)
				X^=i;
			else
				Y^=i;
		System.out.println(X+" "+Y);
	}
	
	
	//Using Negation
	//O(n) Time
	//O(1) space
    public void printRepeating(int A[])
    {
        System.out.println("The repeating elements are : ");
    
        for(int i = 0; i < A.length; i++)
        {
            if(A[Math.abs(A[i])] > 0)
                A[Math.abs(A[i])] = -A[Math.abs(A[i])];
            else
                System.out.print(Math.abs(A[i]) + " ");
        }         
    }
    
	public static void main(String[] args)
	{
		RepeatTwice rt = new RepeatTwice();
		int A[] = {1,2,2,5,4,3,5};
		rt.repTwice(A);
		rt.repeatTwice(A);
		rt.printRepeating(A);
	}
}
