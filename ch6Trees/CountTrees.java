/*
 * To count the number of trees that can be formed from a given number of nodes
 * https://www.youtube.com/watch?v=YDf982Lb84o
 */

package ch6Trees;

public class CountTrees
{	
	public int count(int n) {
		int count[] = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		for(int i = 2; i<=n; i++) {
			for(int j = 0; j<i ; j++)
				count[i]+= count[j]*count[i-j-1];
		}
		return count[n];
	}
	public static void main(String[] args)
	{
		CountTrees ct = new CountTrees();
		System.out.println(ct.count(3));
	}
}
