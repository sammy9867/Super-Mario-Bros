package Sprites;

import java.awt.image.BufferedImage;

/**
 * This class is responsible to get the image.
 * @author Samuel Menezes
 */
public class SpriteSheet {
private BufferedImage image;

public SpriteSheet(BufferedImage image){
	this.image = image;
}

//Grabs a subImage from a given Sprite with the given co-ordinates.
public BufferedImage grabImage(float col,float row,float width, float height) {
	BufferedImage img = image.getSubimage((int)((col*width)-width),(int)((row*height)-height),(int) width,(int) height);
	return img;
}

//Grabs a subImage from a given Sprite with the given co-ordinates.
public BufferedImage grabImage2(float col,float row,float width, float height) {
	BufferedImage img = image.getSubimage((int)((col*38.5f)-38.5f),(int)((row*38.5f)-38.5f),(int)38f, (int)49.5f);
	return img;
}
}
