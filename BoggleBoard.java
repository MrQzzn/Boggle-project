import java.util.Random;
import java.util.ArrayList;

public class BoggleBoard {

	public BoggleBoard() {
		makeBoard(); // added this
	}

	char[][] board = new char[4][4];

	public void makeBoard() {
		char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };
		Random x = new Random(vowels.length);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (x.nextInt(26) % 3 == 0) {
					int buffer = x.nextInt(vowels.length);
					board[i][j] = vowels[buffer];
				} else {
					board[i][j] = (char) (x.nextInt(26) + 'a');
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

	// basic idea:
	
	String find = ""; // search word
	boolean[][] b = new boolean[4][4]; // mark where we have been, where we haven't been
	
	public boolean onBoard(int i, int j, String s) { // call method in a nested for loop
		b[i][j] = true; // mark location
		find += board[i][j]; // add character to search word
		for (int row = i - 1; row <= i + 1 && row < board.length; row++) { // go to adjacent squares
			for (int col = j - 1; col <= j + 1 && col < board[0].length; col++) {
				if (row >= 0 && col >= 0 && b[row][col] == false) { // prevent array out of bounds, make sure we haven't been there yet
					onBoard(row, col, s);
				}
			}
		}
		// if everything fails: 
		find = find.substring(0, find.length() - 1); // erase last letter of search word to reverse the action above
		b[i][j] = false; // mark the spot as unvisited
		return false;
	}
}
