package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.JPanel;

import config.GameConfiguration;

import engine.map.Block;

import engine.map.Map;
import engine.mobile.Batiment;
import engine.mobile.Car;
import engine.mobile.Feu;
import engine.mobile.Route;
import engine.mobile.Sol;
import engine.mobile.Stop;
import engine.process.MobileElementManager;

/**
 * 
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe hérite de JPanel, Déclare la map pour le circuit, paintStrategy pour les véhicules...etc 
 * ainsi que la position du feu
 */
public class GameDisplay extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Map map;
	private MobileElementManager manager;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GameDisplay(Map map, MobileElementManager manager) {
		this.map = map;
		this.manager = manager;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		paintStrategy.paint(map, g);
		
		
		for (Batiment b : manager.getBatiment()){
			paintStrategy.paint(b, g2);
			
		}
		
		for (Sol s : manager.getSol()){
			paintStrategy.paint(s, g2);
		
		}
		
		for (Route r : manager.getRoute()){
			paintStrategy.paint(r, g2);
			
		}
		
		for (Car c : manager.getCar()){
			paintStrategy.paint(c, g2);
		}
		
		for (Feu f : manager.getFeu()) {
			paintStrategy.paint(f, g);
		}
		for (Stop stop : manager.getStop()) {
			paintStrategy.paint(stop, g2);
		}

		
	}
	
	public Block getFeuPosition(int x , int y) {
		int line = y / GameConfiguration.BLOCK_SIZE;
		int column = x/ GameConfiguration.BLOCK_SIZE;
		return map.getBlock(line, column);
	}
	
	public Block getFeuPosition2(int x , int y) {
		int line = y / GameConfiguration.BLOCK_SIZE;
		int column = x/ GameConfiguration.BLOCK_SIZE;
		return map.getBlock(line, column);
	}


	

}
