package main.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private int speed, frames;
	private int index, count = 0;
	
	private BufferedImage image;
	private BufferedImage[] imageList;

	public Animation(int speed, BufferedImage...args) {
		this.speed = speed;
		imageList = new BufferedImage[args.length];
		
		for(int i = 0; i < args.length; i++) {
			imageList[i] = args[i];
		}
		frames = args.length;
	}
	
	public void runAnimation() {
		index++;
		if(index > speed) {
			index = 0;
			nextFrame();
		}
	}
	
	private void nextFrame() {
		for(int i = 0; i < frames; i++) {
			if(count == i) image = imageList[i];
		}
		count++;
		if(count > frames) count = 0;
	}
	
	public void drawAnimation(Graphics g, int x,int y) {
		g.drawImage(image, x, y, null);
	}

	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
		g.drawImage(image, x, y, scaleX, scaleY, null);
	}
	
}
