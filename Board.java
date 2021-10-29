public class Board {
	private char[][] board;

	public Board() {
		this.board = new char[][] {
			{'1', '2', '3'},
			{'4', '5', '6'},
			{'7', '8', '9'},
		};
	}

	@Override
	public String toString() {
		String ret = "";
		for (int i = 0; i < board.length; i++) {
			char[] row = board[i];
			for (int j = 0; j < row.length; j++) {
				char square = row[j];
				ret += square;
				if (j != board.length - 1)
					ret += "│";
			}
			if (i != board.length - 1)
				ret += "\n─┼─┼─\n";
		}
		return ret;
	}

	boolean checkRows(char c) {
		for (char[] row : this.board) {
			boolean didWin = true;
			for (char square : row) {
				if (square != c) {
					didWin = false;
					break;
				}
			}
			if (didWin) {
				return true;
			}
		}
		return false;
	}

	boolean checkColumns(char c) {
		for (int i = 0; i < board[0].length; i++) {
			boolean didWin = true;
			for (char[] row : this.board) {
				if (row[i] != c) {
					didWin = false;
					break;
				}
			}
			if (didWin) {
				return true;
			}
		}
		return false;
	}

	boolean checkDiagonals(char c) {
		return board[0][0] == c && board[1][1] == c && board[2][2] == c
				|| board[0][2] == c && board[1][1] == c && board[2][0] == c;
	}
	
	GameState isGameOver() {
		if (checkRows('X') || checkColumns('X') || checkDiagonals('X')) {
			return GameState.Player1Victory;
		} else if (checkRows('O') || checkColumns('O') || checkDiagonals('O')) {
			return GameState.Player2Victory;
		} else {
			return GameState.InProgress;
		}
	}

	public void set(int i, int j, char c) {
		this.board[i][j] = c;
	}

	public char get(int i, int j) {
		return this.board[i][j];
	}
}
