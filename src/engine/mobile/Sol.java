package engine.mobile;

import engine.map.Block;

/**
 * 
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe hérite de MobilElement, gère les aspects de la route d'entrée (position, direction...etc)
 */
public class Sol extends MobileElement{
	
	private int id =0;
	private boolean etat=true;
	int direction=0;
	

	public Sol(Block position) {
		super(position);
	}
	public Sol(Block position,int direction) {
		super(position);
		this.direction=direction;
		
	}
	
	public Sol(int id,Block position) {
		super(position);
		this.id=id;
	}
	public Sol(int id,Block position,int direction) {
		super(position);
		this.direction=direction;
		this.id=id;
	}

	public void incrementDirection() {
		if(direction<3) {
			direction++;
		}
		else {
			direction=0;
		}
		
	}
	public void arret() {
		etat=false;
	}
	public void marche() {
		etat=true;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Sol [id"+id+" direction=" + direction + ",  getPosition()=" + getPosition() + "]";
	}
	
	
	
	
	
}
