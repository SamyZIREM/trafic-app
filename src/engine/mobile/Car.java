package engine.mobile;


import engine.map.Block;

/**
 * 
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe hérite de MobilElement gère les aspects du véhicule (position, génération...etc)
 */
public class Car extends MobileElement{
	private int direction = 4;
	private int tour=0;
	private int compt=0;
	private boolean etat=true;
	private int solId=-1;



	public Car(Block position) {
		super(position);
		
		
	}
	
	public Car(Block position,int direction) {
		super(position);
		this.direction=direction;
		
	}
	
	public Car(Block position,int direction, int tour) {
		super(position);
		this.direction=direction;
		this.tour=tour;
		
	}
	
	public Car(Block position,int direction, int tour,int id) {
		super(position);
		this.direction=direction;
		this.tour=tour;
		solId=id;
		
	}
public void droite() {
	setPosition(new Block(getPosition().getLine(),getPosition().getColumn()+1));
}
public void gauche() {
	setPosition(new Block(getPosition().getLine(),getPosition().getColumn()-1));
}

public void haut() {
	setPosition(new Block(getPosition().getLine()-1,getPosition().getColumn()));
	
}

public void bas() {
	setPosition(new Block(getPosition().getLine()+1,getPosition().getColumn()));
}



public int getSolId() {
	return solId;
}

public void setSolId(int solId) {
	this.solId = solId;
}

public void incrementTour() {
	tour++;
}
public void incrementCompt() {
	if(compt<4) {
		compt++;
	}
	else {
		compt=0;
	}
	
}

public void marche() {
	etat=true;
}

public void arret() {
	etat=false;
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

public int getCompt() {
	return compt;
}

public void setCompt(int compt) {
	this.compt = compt;
}

public int getTour() {
	return tour;
}

public void setTour(int tour) {
	this.tour = tour;
}

@Override
public String toString() {
	return "Car []";
}



}


