package Enemies;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import Main.Animation;
import Main.Camera;
import Main.Handler;
import Main.Main;
import Objects.ObjectId;
import Objects.Objects;
import Sprites.Texture;

/**
 * This class represents an enemy who can be killed only by a fireball. 
 * @author Samuel Menezes 
 */
public class BuzzyBeetle extends Objects {

private int width = 40,height = 35; 
private float gravity = 0.5f;
private final float MAX_SPEED = 3;
private Handler handler;
private Texture tex2 = Main.getInstance();
private Animation beetlewalk_right,beetlewalk_left;
	
public BuzzyBeetle(int x, int y,Camera cam,Handler handler,ObjectId id) {
	super(x, y, id);
	this.handler = handler;
	beetlewalk_right= new Animation(12,tex2.beetle[2],tex2.beetle[3]);  
	beetlewalk_left = new Animation(12,tex2.beetle[0],tex2.beetle[1]);
	velX = 1;
}

//Responsible for Movement.
public void tick(ArrayList<Objects> obj) {
	 x += velX;
	 y += velY;
	 
if(falling || jumping){
	 velY += gravity;
		    	  
	 if(velY > MAX_SPEED)
          velY = MAX_SPEED;
} 

     Collision(obj);
	    	     
	 beetlewalk_right.runAnimation();
	 beetlewalk_left.runAnimation();
}
	    
//Loads the Image.
public void render(Graphics g) {
if(velX != 0){
	if(direction == 1)
	 beetlewalk_right.drawAnimation(g,(int)x,(int)y,(int)width,(int)height);
	else
	 beetlewalk_left.drawAnimation(g,(int)x,(int)y,(int)width,(int)height);
} 
}
 
//This method gets the bounds of BuzzyBeetle.
public Rectangle getBounds() {
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)((int)y+ (height/2))-3,(int)width/2,(int)height/2 + 2);
}

public Rectangle getBoundsTop() {
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)y+2,(int)width/2,(int)height/2);
}

public Rectangle getBoundsRight() {
	return new Rectangle((int)((int)x+ width - 5),(int)y + 5,(int)5,(int)height -10);
	
}

public Rectangle getBoundsLeft() {
		return new Rectangle((int)x,(int)y + 5,(int)5,(int)height - 10);
}

//This method is responsible for Collision with specific enemies and the block.
//It changes it's direction when encountered with it.
private void Collision(ArrayList<Objects> obj)
{
	for(int i = 0;i < handler.obj.size();i++){
		Objects tempobj = handler.obj.get(i);
		if(tempobj.getId() == ObjectId.Block){
			if(getBoundsTop().intersects(tempobj.getBounds())){
				y = tempobj.getY() + 32;
				velY = 0;
			}
			
			if(getBounds().intersects(tempobj.getBounds())){
				y = tempobj.getY() - height;
				velY = 0;
				falling = false;
				jumping  = false;
			}else
				falling = true; 
			
			if(getBoundsRight().intersects(tempobj.getBounds())){
				velX *= -1;
				setDirection(-1);
			}
			
			if(getBoundsLeft().intersects(tempobj.getBounds())){
				velX *= -1;
				setDirection(1);
			}
				
		}
		
		else  if(tempobj.getId() == ObjectId.Enemy ||  tempobj.getId() == ObjectId.Enemy2 ||tempobj.getId() == ObjectId.Enemy3)
		{
	        if(getBoundsRight().intersects(tempobj.getBounds())){
				 setDirection(-1);
					velX *= -1;
			}
			
			if(getBoundsLeft().intersects(tempobj.getBounds())){
				 setDirection(1);
					velX *= -1;
			}		
		 }  
	   }
    }

}
