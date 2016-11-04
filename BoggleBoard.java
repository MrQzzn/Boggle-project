import java.util.Random;

public class BoggleBoard {

	public BoggleBoard() {

	}

	char[][] board = new char[4][4];

	public void makeBoard(){ 
		char [] vowels = new char[]{'a', 'e', 'i', 'o','u'};
		Random x = new Random(vowels.length);
		for (int i = 0; i < board.length; i ++){
			for (int j = 0; j < board[i].length; j ++){
				if (x.nextInt(26) % 3 == 0){
					int buffer = x.nextInt(vowels.length);
					board[i][j] = vowels[buffer];
				} else {
					board[i][j] = (char)(x.nextInt(26) + 'a');
				}
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println("");
		}
	}

}
