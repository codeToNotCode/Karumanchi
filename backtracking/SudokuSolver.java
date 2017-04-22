package backtracking;

public class SudokuSolver
{
	
	public char[][] solveSudoku(char[][] board){
		solve(board, 0, 0);
		return board;
	}
	private boolean solve(char[][] board, int row, int col) {
		for(int i = row; i<9; i++, col = 0) {
			for(int j = col; j<9; j++) {
				//Check whether the position has a fixed number
				if( board[i][j] != '.')
					continue;
				for(char num = '1'; num<='9'; num++) {
					if(isValid(board, i,j, num)) {
						board[i][j] = num;
						if(solve(board, i, j+1))
							return true;
						board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}
	private boolean isValid(char[][] board, int row, int col, int num) {
		int cubeRow = 3 * (row/3);
		int cubeCol = 3 * (col/3);
		for(int i = 0; i<9; i++) {
			if(board[i][col] == num || board[row][i] == num ||
				board[cubeRow + i/3][cubeCol + i%3] == num)
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		SudokuSolver ss = new SudokuSolver();
		char[][] board = {
				{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'},
		};
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
		System.out.println("\n\n Solution : \n\n");
		board = ss.solveSudoku(board);
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}
}
