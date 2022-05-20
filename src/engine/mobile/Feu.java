package engine.mobile;

import engine.map.Block;

/**
 * 
 * 
 * @author Samy, M�lissa, Billel
 * Cette classe h�rite de MobilElement g�re les aspects du feu (position, mode vert et rouge...etc)
 */
public class Feu extends MobileElement {
	int etat= 0;
	int time=0;

	public Feu(Block position) {
		super(position);
	}
	
	public Feu(Block position,int etat,int time) {
		super(position);
		this.etat=etat;
		this.time=time;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Feu [etat=" + etat + ",  getPosition()=" + getPosition() + "]";
	}

	
	


	
	}

	
	


