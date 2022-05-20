package engine.mobile;

import config.GameConfiguration;
import engine.map.Block;

/**
 * 
 * @author Samy, M�lissa, Billel
 * Cette classe h�rite de MobilElement g�re les aspects du stop (temps d'arret des v�hicules...etc)
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
