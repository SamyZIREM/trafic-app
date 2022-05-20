package engine.mobile;

import engine.map.Block;

/**
 *
 * 
 * @author Samy, M�lissa, Billel
 * Cette classe h�rite de MobilElement et g�re l'image du batiment avec la m�thode
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

	
	


