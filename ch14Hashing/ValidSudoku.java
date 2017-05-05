/*
 * To check whether the given sudoku problem is a valid sudoku or not
 */

package ch14Hashing;

import java.util.HashSet;

public class ValidSudoku {
	private boolean isValid(char[][] board) {
		if( board == null )	return false;
		for(int i =0; i<9; i++){
			HashSet<Character> rows = new HashSet<>();
			HashSet<Character> cols = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			for(int j = 0; j<9; j++){
				if( board[i][j]!='.' && !rows.add(board[i][j])) return false;
				if( board[j][i]!='.' && !cols.add(board[j][i])) return false;
				int cubeRow = 3*(i/3) + j/3;
				int cubeCol = 3*(i%3) + j%3;
				if( board[cubeRow][cubeCol]!='.' && !cube.add(board[cubeRow][cubeCol])) return false;
 			}
		}
		return true;
	}
	public static void main(String[] args) {
		ValidSudoku vs = new ValidSudoku();
		char[][] board = {
				{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','7','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'},
		};
		System.out.println(vs.isValid(board));
	}

	
}
