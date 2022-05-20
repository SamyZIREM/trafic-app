package config;



/**
 *=
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe gère les dimensions de l'application, la vitesse du jeu...etc
 */
public class GameConfiguration {
	
	public static  int WINDOW_WIDTH = 600;
	public static  int WINDOW_HEIGHT = 600;
	
	public static  int WINDOW_WIDTH_ACCUEIL = 800;
	public static  int WINDOW_HEIGHT_ACCUEIL = 400;
	public static final int BLOCK_SIZE = 40;

	public static  int LINE_COUNT = WINDOW_HEIGHT / BLOCK_SIZE;
	public static  int COLUMN_COUNT = WINDOW_WIDTH / BLOCK_SIZE;
	
	public static final int GAME_SPEED = 1000;
	
	public static final int TIME=3;

	public static int getWINDOW_WIDTH() {
		return WINDOW_WIDTH;
	}

	public static void setWINDOW_WIDTH(int wINDOW_WIDTH) {
		WINDOW_WIDTH = wINDOW_WIDTH;
	}

	public static int getWINDOW_HEIGHT() {
		return WINDOW_HEIGHT;
	}

	public static void setWINDOW_HEIGHT(int wINDOW_HEIGHT) {
		WINDOW_HEIGHT = wINDOW_HEIGHT;
	}

	
	
	

}
