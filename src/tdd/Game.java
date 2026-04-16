package tdd;

public class Game {
	private int nbQuilles = 0;
	
	public void roll(int nbQuilles) {
		this.nbQuilles += nbQuilles;
	}
	
	public int score() {
		return nbQuilles;
	}
}
