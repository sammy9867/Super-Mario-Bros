 package Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * This class represents the Animation of specfic characters/enemies/fireballs in the Game.
 * @author Samuel Menezes
 */
public class Animation {
private int speed,frames;
private int index = 0,count = 0;
private BufferedImage[] images;
private BufferedImage currentimg;

//to load multiple images during an Animation
public Animation(int speed,BufferedImage... args){
	this.speed = speed;
	images = new BufferedImage[args.length];
	for(int i = 0; i < args.length ;i++)
	{
		images[i] = args[i];
	}
	frames = args.length;
	
}

//Runs the Animation
public void runAnimation(){
	index++;
	if(index > speed)
	{
		index = 0;
		nextFrame();
	}
}

private void nextFrame(){
	for(int i = 0; i < frames;i++)
	{
		if(count == i)
		{
			currentimg = images[i];
		}
	}
	count++;
	if(count > frames)
		count = 0;
}

/**
 * These 2 methods basically load the image necessary for the Animation.
 */
public void drawAnimation(Graphics g, int x,int y){
	g.drawImage(currentimg, x, y,null);
}


public void drawAnimation(Graphics g, int x,int y,int scaleX,int scaleY){
	g.drawImage(currentimg, x, y,scaleX,scaleY,null);
}
}
