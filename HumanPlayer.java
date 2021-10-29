import java.util.Scanner;

public class HumanPlayer implements Player  {
	private static Scanner scanner = new Scanner(System.in);;
	private char c;

	public HumanPlayer(char c) {
		this.c = c;
	}

	private static char prompt() {
		System.out.println("Please enter a move:");
		System.out.print("> ");
		String answer = scanner.nextLine();
		System.out.println();
		return answer.charAt(0);
	}

	@Override
	public void makeMove(Board board) {
		boolean successfulMove = false;
		do {
			System.out.println(board);
			char move = prompt();
			for (int i = 0; i < 9; i++) {
				if (board.get(i % 3, i / 3) == move) {
					board.set(i % 3, i / 3, c);
					successfulMove = true;
					break;
				}
			}
		} while (!successfulMove);
	}
}
