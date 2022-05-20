package engine.process;

import config.GameConfiguration;

import engine.map.Map;



/**
 * 
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe renvoit à la construction de la map, ainsi que sa gestion 
 * en faisant appel à la classe MobileElementManager
 */
public class GameBuilder {

	public static Map buildMap() {
		return new Map(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);
	}
	public static Map buildMap(int x, int y) {
		return new Map(x, y);
	}

	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		
		intializeTrafic(map, manager);
		
		return manager;
	}

	private static void intializeTrafic(Map map, MobileElementManager manager) {
		
	}

}
