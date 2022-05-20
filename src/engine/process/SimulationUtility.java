package engine.process;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * @author Samy, M�lissa, Billel
 * Cette classe permet d'afficher un message d'erreur personnel lorsque la lecture d'une image 
 * n'est pas r�ussie
 *
 */


public class SimulationUtility {
	
	
	

	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}

}
