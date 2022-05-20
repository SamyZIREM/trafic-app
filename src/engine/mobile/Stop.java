package engine.mobile;

import config.GameConfiguration;
import engine.map.Block;

/**
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe hérite de MobilElement gère les aspects du stop (temps d'arret des véhicules...etc)
 */


public class Stop extends MobileElement{
	int time;
	
	public Stop(Block position) {
		super(position);
		time=GameConfiguration.TIME;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Stop [time=" + time + "]";
	}
	
	
}
