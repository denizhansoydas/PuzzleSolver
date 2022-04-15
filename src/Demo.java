
public class Demo {
	public static void main(String[] args) {
//		char[][] grid = {
//						{'a','k','f','l','a','n','d','m','e','r','s'},
//						{'n','g','t','h','g','m','e','c','i','m','t'},
//						{'a','o','r','y','e','x','q','k','l','p','p'},
//						{'c','s','l','e','l','i','r','t','n','r','t'},
//						{'w','e','d','e','s','k','d','f','l','y','e'},
//						{'o','p','y','l','m','u','e','n','c','n','z'},
//						{'c','a','n','i','t','n','r','t','o','d','e'}
//						};
		char[][] grid = {
				"akflandmersakflandme".toCharArray(),
				"ngthgmecimtngthgmeci".toCharArray(),
				"aoryexqklppaoryexqkl".toCharArray(),
				"cslelirtnrtcslelirtn".toCharArray(),
				"wedeskdflyewedeskdfl".toCharArray(),
				"opylmuencnzopylmuenc".toCharArray(),
				"canitnrtodecanitnrto".toCharArray(),
				"akflandmersakflandme".toCharArray(),
				"ngthgmecimtngthgmeci".toCharArray(),
				"aoryexqklppaoryexqkl".toCharArray(),
				"cslelirtnrtcslelirtn".toCharArray(),
				"wedeskdflyewedeskdfl".toCharArray(),
				"opylmuencnzopylmuenc".toCharArray(),
				"canitnrtodecanitnrto".toCharArray(),
				"akflandmersakflandme".toCharArray(),
				"ngthgmecimtngthgmeci".toCharArray(),
				"aoryexqklppaoryexqkl".toCharArray(),
				"cslelirtnrtcslelirtn".toCharArray(),
				"wedeskdflyewedeskdfl".toCharArray(),
				"opylmuencnzopylmuenc".toCharArray()
				
				
				};
		
		String[] words = {	new String("land"),
							new String("mice"), 
							new String("melon"),
							new String("one"),
							new String("can")};
		
		WordPuzzle wordPuzzle = new WordPuzzle(grid, words);
		System.out.println("PUZZLE");
		System.out.println(wordPuzzle);
//		System.out.println(wordPuzzle.findWord("land", 0, 0, 3, null)); //RIGHT
//		System.out.println(wordPuzzle.findWord("mice", 0, 1, 9, null)); //LEFT
//		System.out.println(wordPuzzle.findWord("can", 0, 3, 0, null)); //UP
//		System.out.println(wordPuzzle.findWord("melon", 0, 5, 4, null)); //UP_LEFT
//		System.out.println(wordPuzzle.findWord("one", 0, 6, 8, null)); //UP_RIGHT
//		System.out.println(wordPuzzle.findWord("can", 0, 6, 0, null)); //RIGHT
		
//		for(WordPosition wp : wordPuzzle.findWords().getList()) {
//			System.out.println(wp);
//		}
//		System.out.println();
		System.out.println("SOLUTION");
		wordPuzzle.printSolution();
		
		//System.out.println(wordPosition1.intersects(wordPosition2));
	}
	 
}
