package engine.mobile;

import engine.map.Block;

/**
 *
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe hérite de MobilElement et gère l'image du batiment avec la méthode
 * agrandir et retrecir
 */
public class Batiment extends MobileElement {
	private int sizeX = 200;
	private int sizeY = 200;
	public Batiment(Block position) {
		super(position);
	}
	
	public void agrandir() {
		sizeX = sizeX + 40;
		sizeY = sizeY +40;
	}
	
	public void retrecir() {
		if(sizeX > 10 || sizeY > 10) {
			sizeX = sizeX - 40;
			sizeY = sizeY - 40;
		}
		
	}
	public int getSizeX() {
		return sizeX;
	}
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}
	public int getSizeY() {
		return sizeY;
	}
	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}
	
	
	
	}

	
	


