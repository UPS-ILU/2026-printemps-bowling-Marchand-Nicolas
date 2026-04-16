package tdd;

public class Game {
	private int nbQuillesTourPrecedent = 0;
	private boolean estTourPrecedentStrike = false;
	private int nbQuillesTourCourant = 0;
	private int nbQuilles = 0;
	private int iTour = 0;
	private int bonus = 0;
	
	private static final int QUILLES_MAX = 10;
	private static final int LANCERS_PAR_TOUR = 2;
	
	public void roll(int nbQuilles) {
		if (estPremierLancerTour()) {
			nbQuillesTourPrecedent = nbQuillesTourCourant;
			nbQuillesTourCourant = 0;
		}
		this.nbQuilles += nbQuilles;
		System.out.println(iTour + " " + nbQuillesTourPrecedent + " " + nbQuilles);
		if (nbQuillesTourPrecedent == QUILLES_MAX)
		{
			if (estTourPrecedentStrike) {
				// Strike
				bonus += nbQuilles;
			}
			else {
				// Spare
				if (estPremierLancerTour())
					bonus += nbQuilles;
			}
		}
		if (estPremierLancerTour() && nbQuilles == QUILLES_MAX) {
			estTourPrecedentStrike = true;
			iTour++;
		}
		nbQuillesTourCourant += nbQuilles;
		iTour++;
	}
	
	public int score() {
		return nbQuilles + bonus;
	}
	
	private boolean estPremierLancerTour() {
		return iTour % LANCERS_PAR_TOUR == 0;
	}
}
