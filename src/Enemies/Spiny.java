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
public class Spiny extends Objects {
private int width = 38,height = 35;    
private Handler handler;
private Texture tex = Main.getInstance();
private Animation spinywalk_right,spinywalk_left;
private float gravity = 0.5f;
private final float MAX_SPEED = 3;
	
public Spiny(int x, int y,Camera cam,Handler handler,ObjectId id) {
	super(x, y, id);
	this.handler = handler;
	spinywalk_right= new Animation(12,tex.spiny[2],tex.spiny[3]);  
	spinywalk_left = new Animation(12,tex.spiny[0],tex.spiny[1]);
	velX = 1;
}

public void tick(ArrayList<Objects> obj) {
	 x += velX;
     y += velY;
     
	if(falling || jumping){
	  velY += gravity;
	    if(velY > MAX_SPEED)
		     velY = MAX_SPEED;
	}
	  Collision(obj); //calling the Collision method.
	   
	  //Runs the animation.
      spinywalk_right.runAnimation();
	  spinywalk_left.runAnimation();
}
	    
//Loads the image whenever the direction changes.
public void render(Graphics g) {
	if(velX != 0){
		if(direction == 1)
		spinywalk_right.drawAnimation(g,(int)x,(int)y,(int)width,(int)height);
		else
		spinywalk_left.drawAnimation(g,(int)x,(int)y,(int)width,(int)height);
	}
    else{
		if(direction == 1)
	     g.drawImage(tex.spiny[0],(int)x,(int)y,(int)width,(int)height,null);
		else if(direction == -1)
			g.drawImage(tex.spiny[2],(int)x,(int)y,(int)width,(int)height,null);
    }  
}

//These methods are responsible for the Rectangular bounds of Spiny.
public Rectangle getBounds() {
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)((int)y+ (height/2))-3,(int)width/2,(int)height/2 +2);
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

//Responsible for Collision Detection.
private void Collision(ArrayList<Objects> obj){
	for(int i = 0;i < handler.obj.size();i++){
		Objects tempobj = handler.obj.get(i);
		
		//If Spiny intersects with a block,whose ObjectId is Block,
	    //it will change direction or stay over that block.
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
				setDirection(-1);
				velX *= -1;
			}
			
			if(getBoundsLeft().intersects(tempobj.getBounds())){
				setDirection(1);
				velX *= -1;
			}
		 }	
		 
		//If Spiny intersects other enemies,
		//it will change direction.
		else  if(tempobj.getId() == ObjectId.Enemy ||  tempobj.getId() == ObjectId.Enemy2 ||tempobj.getId() == ObjectId.Enemy3){
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