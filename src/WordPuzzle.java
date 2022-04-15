import java.util.Arrays;

public class WordPuzzle {
	public final static int LOWER_UPPER_CASE_ASCII_DIFF = 32;
	private char[][] grid;
	private String[] wordList;
	WordPuzzle(char[][] grid, String[] wordList) {
		this.grid = grid;
		this.wordList = wordList;
	}
	
	//copy constructor
	WordPuzzle(WordPuzzle wordPuzzle){
		grid = deepCopy(wordPuzzle.grid);
		wordList = new String[wordPuzzle.wordList.length];
		for(int i = 0; i < wordList.length; i++)
			wordList[i] = new String(wordPuzzle.wordList[i]);
		
	}
	//helper function
	private static char[][] deepCopy(char[][] original) {
	    if (original == null) {
	        return null;
	    }
	    final char[][] result = new char[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        result[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return result;
	}
	@Override
	public String toString() {
		String res = "";
		for(char[] line : grid) {
			for(char c : line) {
				res += c;
			}
			res += "\n";
		}
		return res;
	}
	
	public PuzzleSolution findWords(){
		PuzzleSolution puzzleSolution = new PuzzleSolution();
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				for(String word : wordList) {
					WordOrientation orientation = findWord(word, 0, i, j, null);
					if(orientation != null)
						puzzleSolution.getList().add(new WordPosition(word, i, j, orientation));
				}
			}
		}
		return puzzleSolution;
	}
	public WordOrientation findWord(String word, int index, int row, int col, WordOrientation wordOrientation) {
		if(index >= word.length() || word.charAt(index) != grid[row][col])
			return null;
		if(index == word.length() - 1 && word.charAt(index) == grid[row][col])
			return wordOrientation;
		WordOrientation result = null;
		
		if((wordOrientation == null || wordOrientation == WordOrientation.UP) && result == null && row > 0) {
			result = findWord(word, index + 1, row - 1, col, WordOrientation.UP);
		}
		if((wordOrientation == null || wordOrientation == WordOrientation.RIGHT) && result == null && col < grid[row].length - 1) {
			result = findWord(word, index + 1, row, col + 1, WordOrientation.RIGHT);
		}
		if((wordOrientation == null || wordOrientation == WordOrientation.DOWN) && result == null && row < grid.length - 1) {
			result = findWord(word, index + 1, row + 1, col, WordOrientation.DOWN);
		}
		if((wordOrientation == null || wordOrientation == WordOrientation.LEFT) && result == null && col > 0) {
			result = findWord(word, index + 1, row, col - 1, WordOrientation.LEFT);
		}

		if((wordOrientation == null || wordOrientation == WordOrientation.UP_RIGHT) && result == null && row > 0 && col < grid[row].length - 1) {
			result = findWord(word, index + 1, row - 1, col + 1, WordOrientation.UP_RIGHT);
		}
		if((wordOrientation == null || wordOrientation == WordOrientation.DOWN_RIGHT) && result == null && row < grid.length - 1 && col < grid[row].length - 1) {
			result = findWord(word, index + 1, row + 1, col + 1, WordOrientation.DOWN_RIGHT);
		}
		if((wordOrientation == null || wordOrientation == WordOrientation.DOWN_LEFT) && result == null && row < grid.length - 1 && col > 0) {
			result = findWord(word, index + 1, row + 1, col - 1, WordOrientation.DOWN_LEFT);
		}
		if((wordOrientation == null || wordOrientation == WordOrientation.UP_LEFT) && result == null && row > 0 && col > 0) {
			result = findWord(word, index + 1, row - 1, col - 1, WordOrientation.UP_LEFT);
		}
		return result;
	}
	public void printSolution() {
		PuzzleSolution puzzleSolution = findWords();
		char[][] grid_copy = deepCopy(grid);
		for(WordPosition wordPosition : puzzleSolution.getList()) {
			for(int i = 0; i < wordPosition.getWord().length(); i++) {
				if(wordPosition.getWordOrientation() == WordOrientation.UP) {
					grid_copy[wordPosition.getRow() - i][wordPosition.getCol()] = Character.toUpperCase(grid_copy[wordPosition.getRow()- i][wordPosition.getCol()]);
				}
				if(wordPosition.getWordOrientation() == WordOrientation.RIGHT) {
					grid_copy[wordPosition.getRow()][wordPosition.getCol() + i] = Character.toUpperCase(grid_copy[wordPosition.getRow()][wordPosition.getCol() + i]);
				}
				if(wordPosition.getWordOrientation() == WordOrientation.DOWN) {
					grid_copy[wordPosition.getRow() + i][wordPosition.getCol()] = Character.toUpperCase(grid_copy[wordPosition.getRow() + i][wordPosition.getCol()]);
				}
				if(wordPosition.getWordOrientation() == WordOrientation.LEFT) {
					grid_copy[wordPosition.getRow()][wordPosition.getCol() - i] = Character.toUpperCase(grid_copy[wordPosition.getRow()][wordPosition.getCol() - i]);
				}
				if(wordPosition.getWordOrientation() == WordOrientation.UP_RIGHT) {
					grid_copy[wordPosition.getRow() - i][wordPosition.getCol() + i] = Character.toUpperCase(grid_copy[wordPosition.getRow() - i][wordPosition.getCol() + i]);
				}
				if(wordPosition.getWordOrientation() == WordOrientation.DOWN_RIGHT) {
					grid_copy[wordPosition.getRow() + i][wordPosition.getCol() + i] = Character.toUpperCase(grid_copy[wordPosition.getRow() + i][wordPosition.getCol() + i]);
				}
				if(wordPosition.getWordOrientation() == WordOrientation.DOWN_LEFT) {
					grid_copy[wordPosition.getRow() + i][wordPosition.getCol() - i] = Character.toUpperCase(grid_copy[wordPosition.getRow() + i][wordPosition.getCol() - i]);
				}
				if(wordPosition.getWordOrientation() == WordOrientation.UP_LEFT) {
					grid_copy[wordPosition.getRow() - i][wordPosition.getCol() - i] = Character.toUpperCase(grid_copy[wordPosition.getRow() - i][wordPosition.getCol() - i]);
				}
				
			}
			
		}
		for(char[] line: grid_copy) {
			for(char c : line) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public char[][] getGrid() {
		return grid;
	}

	public void setGrid(char[][] grid) {
		this.grid = grid;
	}

	public String[] getWordList() {
		return wordList;
	}

	public void setWordList(String[] wordList) {
		this.wordList = wordList;
	}
	
}
