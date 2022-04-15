import java.util.ArrayList;

public class PuzzleSolution {
	private ArrayList<WordPosition> list;
	PuzzleSolution(){
		list = new ArrayList<WordPosition>();
	}
	PuzzleSolution(ArrayList<WordPosition> list){
		this.list = list;
	}
	PuzzleSolution(PuzzleSolution ps){
		list = new ArrayList<WordPosition>();
		for(WordPosition wo : ps.list) {
			list.add(wo);
		}
	}
	public ArrayList<WordPosition> getList() {
		return list;
	}
	public void setList(ArrayList<WordPosition> list) {
		this.list = list;
	}
	
}
