import java.util.Random;
import java.util.Scanner;

enum GameState {
	Player1Victory, Player2Victory, InProgress
}

public class GameManager {
	boolean isPlayer1AI;
	boolean isPlayer2AI;
	char[][] board;
	Scanner scanner;
	Random random;

	GameManager(boolean isPlayer1AI, boolean isPlayer2AI) {
		this.isPlayer1AI = isPlayer1AI;
		this.isPlayer2AI = isPlayer2AI;
		this.board = new char[][] {
			{'1', '2', '3'},
			{'4', '5', '6'},
			{'7', '8', '9'},
		};
		scanner = new Scanner(System.in);
		random = new Random();
	}

	void printBoard() {
		for (int i = 0; i < board.length; i++) {
			char[] row = board[i];
			for (int j = 0; j < row.length; j++) {
				char square = row[j];
				System.out.print(square);
				if (j != board.length - 1)
					System.out.print("│");
			}
			if (i != board.length - 1)
				System.out.println("\n─┼─┼─");
		}
		System.out.println();
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
	
	void AIMove(char c) {
		// just do a random legal move
		int move;
		do {
			move = this.random.nextInt(9);
		} while (!Character.isDigit(board[move % 3][move / 3]));
		board[move % 3][move / 3] = c;
	}

	void playerMove(char c) {
		boolean successfulMove = false;
		do {
			this.printBoard();
			char move = prompt();
			for (int i = 0; i < 9; i++) {
				if (board[i % 3][i / 3] == move) {
					board[i % 3][i / 3] = c;
					successfulMove = true;
					break;
				}
			}
		} while (!successfulMove);
	}

	char prompt() {
		System.out.println("Please enter a move:");
		System.out.print("> ");
		String answer = this.scanner.nextLine();
		System.out.println();
		return answer.charAt(0);
	}

	void startGame() {
		boolean isP1 = true;
		while (isGameOver() == GameState.InProgress) {
			if (isP1) {
				if (isPlayer1AI) {
					AIMove('X');
				} else {
					playerMove('X');
				}
			} else {
				if (isPlayer2AI) {
					AIMove('O');
				} else {
					playerMove('O');
				}
			}
			isP1 = !isP1;
		}
		System.out.println("Game is over!");
		System.out.println("The winner is player " + (isGameOver() == GameState.Player1Victory ? "1!" : "2!"));
	}

	public static void main(String... args) {
		GameManager gm = new GameManager(false, true);
		gm.startGame();
	}
}
