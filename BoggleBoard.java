import java.util.Random;
import java.util.ArrayList;

public class BoggleBoard {

	public BoggleBoard() {
		makeBoard();
	}

	char[][] board = new char[4][4];

	public void makeBoard() {
		char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };
		Random x = new Random();
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

	boolean[][] visited = new boolean[4][4]; 
	
	public boolean onBoard(BogglePoint point, char[] word, int pos) { 
		if (board[point.x][point.y] != word[pos]){
			return false;
		}
		if (word.length - 1 == pos){
			return true;
		}
		visited[point.x][point.y] = true;
		pos ++;
		BogglePoint[] points = getAdjacent(point);
		for (int i = 0; i < points.length; i ++){
			BogglePoint nextPoint = points[i];
			if (nextPoint != null){
				if (!visited[nextPoint.x][nextPoint.y] && onBoard(nextPoint, word, pos)){
					return true;
				}
			}
		}
		visited[point.x][point.y] = false;
		return false;
	}
	
	public BogglePoint[] getAdjacent(BogglePoint point){
		BogglePoint[] adjacent = new BogglePoint[8];
		for (int i = 0; i < adjacent.length; i ++){
			adjacent[i] = null;
		}
		int counter = -1;
		for (int i = -1; i <= 1; i ++){
			for (int j = -1; j <= 1; j ++){
				BogglePoint point2 = new BogglePoint(point.x + i, point.y + j);
				if (point2.x >= 0 && point2.x <= 3 && point2.y >= 0 && point2.y <= 3 && (i != 0 || j != 0)){
					counter ++;
					adjacent[counter] = point2;
				}
			}
		}
		return adjacent;
	}
}
