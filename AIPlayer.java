import java.util.Random;

public class AIPlayer implements Player {
	private static Random random = new Random();
	private char c;

	public AIPlayer(char c) {
		this.c = c;
	}

	@Override
	public void makeMove(Board board) {
		// just do a random legal move
		int move;
		do {
			move = random.nextInt(9);
		} while (!Character.isDigit(board.get(move % 3, move / 3)));
		board.set(move % 3, move / 3, c);
	}
}
