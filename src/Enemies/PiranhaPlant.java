package Enemies;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import AudioPlayer.Audio;
import Main.Animation;
import Main.Camera;
import Main.Handler;
import Main.Main;
import Objects.ObjectId;
import Objects.Objects;
import Sprites.Texture;

/**
 * This class represents an enemy that can't be killed.
 * @author Samuel Menezes 
 */
public class PiranhaPlant extends Objects{
private int width = 32,  height = 32;
private Texture tex = Main.getInstance();
private Handler handler;
private Animation piranha;

public PiranhaPlant(float x, float y,Camera cam,Handler handler,ObjectId id) {
	super(x, y, id);
	this.handler = handler;
	velY = 1;
	piranha= new Animation(7,tex.plant[1],tex.plant[0]);  
}

//Necessary for movement
public void tick(ArrayList<Objects> obj){
	x += velX;
	y += velY;
	
	if(y <= 329 || y >= Main.HEIGHT - 170) velY *= -1;
			
	Collision(obj);
	piranha.runAnimation();
}

//Loads the Image.
public void render(Graphics g){
    if(velY < 0) g.drawImage(tex.plant[0],(int)x,(int)y ,null);
    else if(velY > 0)  piranha.drawAnimation(g,(int)x,(int)y);
}

//These methods get the Bounds of the Piranha plant.
public Rectangle getBounds(){
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)((int)y+ (height/2))-(int)1f,(int)width/2,(int)height/2 +2);
}

public Rectangle getBoundsTop(){
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)) + 10,(int)y+2,(int)width - 7,(int)height/2);
}

public Rectangle getBoundsRight(){
	return new Rectangle((int)((int)x+ width + 9),(int)y + 5,(int)5,(int)height +25);
}

public Rectangle getBoundsLeft() {
	return new Rectangle((int)x + 15,(int)y + 5,(int)5,(int)height +25);
}

//This method is responsible for Collision detection and invokes the dead state 
//when Mario collides with it.
private void Collision(ArrayList<Objects> obj){
    for(int i = 0;i < handler.obj.size();i++){
		Objects tempobj = handler.obj.get(i);
		  if(tempobj.getId() == ObjectId.Player){
			if(getBoundsTop().intersects(tempobj.getBounds())){
				if(Audio.getSound("level").playing()){
				    Audio.getSound("level").stop();
				    Main.State = Main.STATE.Dead;
				    Audio.getSound("mdead").play();
				}
						
				if(Audio.getSound("level2").playing()){
				    Audio.getSound("level2").stop();
				    Main.State = Main.STATE.Dead;
				    Audio.getSound("mdead").play();
				}
						
				if(Audio.getSound("level4").playing()){
				    Audio.getSound("level4").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
			    }
			 }
					
			if(getBounds().intersects(tempobj.getBounds())){
			    if(Audio.getSound("level").playing()){
					Audio.getSound("level").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
				}
						
				if(Audio.getSound("level2").playing()){
					Audio.getSound("level2").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
				}
						
				if(Audio.getSound("level4").playing()){
					Audio.getSound("level4").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
				}
			}
					
			if(getBoundsRight().intersects(tempobj.getBounds())){
		    	if(Audio.getSound("level").playing()){
					Audio.getSound("level").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
			    }
						
			    if(Audio.getSound("level2").playing()){
					Audio.getSound("level2").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
			   }
		 				
		     	if(Audio.getSound("level4").playing()){
					Audio.getSound("level4").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
			    }
		}
					
					
		  if(getBoundsLeft().intersects(tempobj.getBounds())){
			    if(Audio.getSound("level").playing()){
					Audio.getSound("level").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
				}
						
				if(Audio.getSound("level2").playing()){
					Audio.getSound("level2").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
				}
						
				if(Audio.getSound("level4").playing()){
					Audio.getSound("level4").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
			    }
		}
	}
  }
}
}
