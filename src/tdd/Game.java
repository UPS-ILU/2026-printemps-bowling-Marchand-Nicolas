package tdd;

public class Game {
	private int nbQuillesTourPrecedent = 0;
	private int nbQuilles = 0;
	private int iTour = 0;
	private int bonus = 0;
	
	private static final int QUILLES_MAX = 10;
	private static final int LANCERS_PAR_TOUR = 2;
	
	public void roll(int nbQuilles) {
		this.nbQuilles += nbQuilles;
		if (nbQuillesTourPrecedent == QUILLES_MAX)
			bonus = nbQuilles;
		if (estPremierLancerTour()) 
			nbQuillesTourPrecedent = nbQuilles;
		else
			nbQuillesTourPrecedent += nbQuilles;
		iTour++;
	}
	
	public int score() {
		return nbQuilles + bonus;
	}
	
	private boolean estPremierLancerTour() {
		return iTour % LANCERS_PAR_TOUR == 0;
	}
}
