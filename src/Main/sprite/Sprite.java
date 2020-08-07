package main.sprite;

import java.awt.image.BufferedImage;

public class Sprite {

	private BufferedImage image;
	
	public Sprite(BufferedImage image){
		this.image = image;
	}
	
	public BufferedImage[] buildSprite(int columns, int rows, int width, int height) {
	    BufferedImage[] spriteSheet = new BufferedImage[rows * columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				spriteSheet[(i * columns) + j] = image.getSubimage(j * width, i * height, width, height);
			}
		}
		return spriteSheet;
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
