package Main;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class is required to load Images of the game.
 * @author Samuel Menezes
 */
public class ImageLoader {
public BufferedImage image;

public BufferedImage loadImage(String path){
	try{
		image = ImageIO.read(new FileInputStream(path));
	} catch (IOException e) {
		e.printStackTrace();
	}
	return image;
}
}
