package arrays;

import java.util.ArrayList;

public class DiagTraverse {
	public ArrayList<Integer> diagTraverse(int A[][]){
		ArrayList<Integer> result = new ArrayList<>();
		int r = 0, c = 0;
		int rows = A.length;
		int cols = A[0].length;
		while(r<rows && c<cols){
				result.add(A[r][c]);
				if((r+c)%2 == 0){
					if(c == cols-1){
						r++;
					}else if( r == 0 ) c++;
					else { r--; c++; }
				}else{
					if(r == rows-1)	c++;
					else if ( c == 0 ) r++;
					else { r++; c--; }
				}
			}
		
		return result;
	}
	
	public static void main(String[] args) {
		DiagTraverse dt = new DiagTraverse();
		int[][] A = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		System.out.println(dt.diagTraverse(A));
		
		
	}
}
