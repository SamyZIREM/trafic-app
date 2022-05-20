package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;



import config.GameConfiguration;
import engine.map.Block;
import engine.map.Map;
import engine.mobile.Batiment;
import engine.mobile.Car;
import engine.mobile.Feu;
import engine.mobile.Route;
import engine.mobile.Sol;
import engine.mobile.Stop;
import engine.process.SimulationUtility;



/**
 * 
 * 
 * @author Samy, Mélissa, Billel
 * Cette classe évoque la création des méthodes de peinture pour le désign de l'application
 */
public class PaintStrategy {
	public void paint(Map map, Graphics graphics) {
		int blockSize = GameConfiguration.BLOCK_SIZE;
		Block[][] blocks = map.getBlocks();

		for (int lineIndex = 0; lineIndex < map.getLineCount(); lineIndex++) {
			for (int columnIndex = 0; columnIndex < map.getColumnCount(); columnIndex++) {
				Block block = blocks[lineIndex][columnIndex];

				Color color;
				 
				color = new Color(100,205,100);
	              
				 
				graphics.setColor(color);
				graphics.fillRect(block.getColumn() * blockSize, block.getLine() * blockSize, blockSize, blockSize);
			}
		}
	}

	
	public void paint(Sol sol, Graphics2D g2) {
        
		Block position = sol.getPosition();
        int blockSize = GameConfiguration.BLOCK_SIZE;

        int y = position.getLine()* blockSize;
        int x = position.getColumn()* blockSize ;
      
        g2.drawImage(SimulationUtility.readImage("src/images/"+sol.getDirection()+".png"),x,y ,  blockSize,  blockSize, null);
       
    }
	public void paint(Route route, Graphics2D g2) {
        
		Block position = route.getPosition();
        int blockSize = GameConfiguration.BLOCK_SIZE;

        int y = position.getLine()* blockSize;
        int x = position.getColumn()* blockSize ;
        
        
        g2.drawImage(SimulationUtility.readImage("src/images/4.png"),x,y , blockSize,  blockSize, null);
       
       
    }

	public void paint(Feu feu, Graphics graphics) {
	
		Block position = feu.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine();
		int x = position.getColumn();
		if(feu.getEtat()==0) {
			graphics.setColor(Color.GREEN);
		}
		else {
			graphics.setColor(Color.RED);
		}
		graphics.fillOval(x * blockSize, y * blockSize, blockSize/2, blockSize/2);
	}
	
	public void paint(Stop s, Graphics2D g2) {
		Block position = s.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine()* blockSize;
        int x = position.getColumn()* blockSize ;
		
		 g2.drawImage(SimulationUtility.readImage("src/images/stop.png"),x,y ,  blockSize/2,  blockSize/2, null);
	}

	public void paint(Car c, Graphics2D g2) {
		Block position = c.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine()* blockSize;
        int x = position.getColumn()* blockSize ;
		
		 g2.drawImage(SimulationUtility.readImage("src/images/V"+c.getDirection()+".png"),x,y ,  blockSize,  blockSize, null);
	}
	public void paint(Batiment b, Graphics2D g2) {
		Block position = b.getPosition();
		int blockSize = GameConfiguration.BLOCK_SIZE;

		int y = position.getLine()* blockSize;
        int x = position.getColumn()* blockSize ;
		
		 g2.drawImage(SimulationUtility.readImage("src/images/ville.png"),x,y , b.getSizeX(),b.getSizeY(),  null);
	}
	
}
