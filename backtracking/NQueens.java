/*
 * The n-queens puzzle is the problem of placing n queens on an 
 * n×n chessboard such that no two queens attack each other
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 *  where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *[
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."
 *  ],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."
 *  ]
 *]
 *
 *
 *https://discuss.leetcode.com/topic/25078/clean-back-tracking-java-solution-with-simple-explaination
 */

package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens
{
	public List<List<String>> placeQueens(int n){
		List<List<String>> finalBoard = new ArrayList<>();
		finalPositions(finalBoard, n, new ArrayList<String>(), new boolean[n],
				new boolean[2*n], new boolean[2*n], 0);
		return finalBoard;
	}
	private void finalPositions(List<List<String>> finalBoard, int n, ArrayList<String> tempBoard,
			boolean[] cols, boolean[] diag1, boolean[] diag2, int rows) {
		if(rows == n) {
			finalBoard.add(new ArrayList<String>(tempBoard));
			return;
		}
		for(int col = 0; col<n; col++) {
			int d1 = col - rows + n;
			int d2 = col + rows;
			if(!cols[col] && !diag1[d1] && !diag2[d2]) {
				char[] r = new char[n];
				Arrays.fill(r, '.');
				r[col] = 'Q';
				tempBoard.add(new String(r));
				cols[col] = true; diag1[d1] = true; diag2[d2] = true;
				finalPositions(finalBoard, n, tempBoard, cols, diag1, diag2, rows+1);
				tempBoard.remove(tempBoard.size()-1);
				cols[col] = false; diag1[d1] = false; diag2[d2] = false;
			}
		}
	}
	public static void main(String[] args)
	{
		NQueens nq = new NQueens();
		List<List<String>> finalBoard = nq.placeQueens(4);
		for(int i = 0; i<finalBoard.size(); i++) {
			for(int j = 0; j<finalBoard.get(i).size(); j++)
				System.out.println(finalBoard.get(i).get(j));
			System.out.println();
		}
	}
}
