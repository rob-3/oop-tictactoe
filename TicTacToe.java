enum GameState {
	Player1Victory, Player2Victory, InProgress
}

public class TicTacToe {
	public static void main(String... args) {
		Board board = new Board();
		Player player1 = new HumanPlayer('X');
		Player player2 = new AIPlayer('O');
		boolean isP1 = true;
		while (board.isGameOver() == GameState.InProgress) {
			if (isP1) {
				player1.makeMove(board);
			} else {
				player2.makeMove(board);
			}
			isP1 = !isP1;
		}
		System.out.println("Game is over!");
		System.out.println("The winner is player " + (board.isGameOver() == GameState.Player1Victory ? "1!" : "2!"));
		System.out.println(board);
	}
}
