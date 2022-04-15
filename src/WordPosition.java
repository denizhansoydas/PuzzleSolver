
public class WordPosition {
	private String word;
	private int row;
	private int col;
	private WordOrientation wordOrientation;
	public WordPosition(String word, int row, int col, WordOrientation wordOrientation){
		this.word = word;
		this.row = row;
		this.col = col;
		this.wordOrientation = wordOrientation;
	}
	
	public boolean intersects(WordPosition other) {
		int max_row = Math.max(word.length() + row, other.word.length() + other.row);
		int max_col = Math.max(word.length() + col, other.word.length() + other.col);
		boolean[][] grid = new boolean[max_row][max_col];
		
		
		
		for(int i = 0; i < word.length(); i++) {
			if(wordOrientation == WordOrientation.UP) {
				grid[row - i][col] = true;
			}
			if(wordOrientation == WordOrientation.RIGHT) {
				grid[row][col + i] = true;
			}
			if(wordOrientation == WordOrientation.DOWN) {
				grid[row + i][col] = true;
			}
			if(wordOrientation == WordOrientation.LEFT) {
				grid[row][col - i] = true;
			}
			if(wordOrientation == WordOrientation.UP_RIGHT) {
				grid[row - i][row + i] = true;
			}
			if(wordOrientation == WordOrientation.DOWN_RIGHT) {
				grid[row + i][col + i] = true;
			}
			if(wordOrientation == WordOrientation.DOWN_LEFT) {
				grid[row + i][col - i] = true;
			}
			if(wordOrientation == WordOrientation.UP_LEFT) {
				grid[row - i][col - i] = true;
			}
			
		}
		for(int i = 0; i < other.word.length(); i++) {
			if(other.wordOrientation == WordOrientation.UP) {
				if(grid[other.row - i][other.col])
					return true;
			}
			if(other.wordOrientation == WordOrientation.RIGHT) {
				if(grid[other.row][other.col + i])
					return true;
			}
			if(other.wordOrientation == WordOrientation.DOWN) {
				if(grid[other.row + i][other.col])
					return true;
			}
			if(other.wordOrientation == WordOrientation.LEFT) {
				if(grid[other.row][other.col - i])
					return true; 				
			}
			if(other.wordOrientation == WordOrientation.UP_RIGHT) {
				if(grid[other.row - i][other.row + i])
					return true;
			}
			if(other.wordOrientation == WordOrientation.DOWN_RIGHT) {
				if(grid[other.row + i][other.col + i])
					return true;
			}
			if(other.wordOrientation == WordOrientation.DOWN_LEFT) {
				if(grid[other.row + i][other.col - i])
					return true;
			}
			if(other.wordOrientation == WordOrientation.UP_LEFT) {
				if(grid[other.row - i][other.col - i])
					return true;
			}
			
		}
		return false;
	}
	@Override
	public String toString() {
		return "WordPosition [word=" + word + ", row=" + row + ", col=" + col + ", wordOrientation=" + wordOrientation
				+ "]";
	}

	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public WordOrientation getWordOrientation() {
		return wordOrientation;
	}
	public void setWordOrientation(WordOrientation wordOrientation) {
		this.wordOrientation = wordOrientation;
	}
	
}
