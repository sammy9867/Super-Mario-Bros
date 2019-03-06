package Enemies;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import Main.*;
import Objects.ObjectId;
import Objects.Objects;
import Sprites.Texture;

/**
 * This class represents an enemy who moves vertically across a level.
 * It can't be killed.
 * @author Samuel Menezes 
 */
public class LavaBubble extends Objects{
private int width = 32,  height = 32;
private Texture tex = Main.getInstance();


public LavaBubble(float x, float y,Camera cam,Handler handler,ObjectId id) {
	super(x, y, id);
    velY = 7;
}

//Responsible for Movement.
public void tick(ArrayList<Objects> obj) {
	x += velX;
	y += velY;
		
	if(y <= 185 || y >= Main.HEIGHT - 32) velY *= -1;
}

//Loading the Image.
public void render(Graphics g){
	if(velY < 0) g.drawImage(tex.lavabubble[1],(int)x,(int)y ,null);
	else if(velY > 0)  g.drawImage(tex.lavabubble[0],(int)x,(int)y,null);
}

//These methods get the Bounds of the LavaBubble.
public Rectangle getBounds(){
    return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)((int)y+ (height/2))-(int)1f,(int)width/2,(int)height/2 +2);
}

public Rectangle getBoundsTop(){
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)y+2,(int)width/2,(int)height/2);
}

public Rectangle getBoundsRight() {
	return new Rectangle((int)((int)x+ width - 5),(int)y + 5,(int)5,(int)height -10);	
}

public Rectangle getBoundsLeft() {
	return new Rectangle((int)x,(int)y + 5,(int)5,(int)height - 10);
}

}
