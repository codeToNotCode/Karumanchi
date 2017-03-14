package ch2Recursion;

public class TowerOfHanoi
{
	public static void tHanoi(int n , char source, char destination, char auxillary){
		if( n == 0 )
			return;
		
		tHanoi(n-1,source, auxillary, destination );
		System.out.println("Move Disk "+n+" from peg "+source+" to peg "+destination);
		tHanoi(n-1, auxillary, destination, source);
	}
	
	public static void main(String[] args)
	{
		tHanoi(5,'S','D','A');
	}
}	
