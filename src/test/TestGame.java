package test;

import gui.AcceuilGUI;


/**
 * 
 * 
 * @author Samy, M�lissa, Billel
 * Cette classe est une classe test qui permet de lancer l'application
 */
public class TestGame {
	public static void main(String[] args) {

		AcceuilGUI gameMainGUI = new AcceuilGUI("Trafic");

		Thread gameThread = new Thread(gameMainGUI);
		gameThread.start();
	}
}
