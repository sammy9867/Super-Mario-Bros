package Enemies;

import AudioPlayer.Audio;
import Main.Camera;
import Main.Handler;
import Main.Main;
import Objects.ObjectId;
import Objects.Objects;
import Sprites.Texture;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * This class represents an enemy Bullet that moves horizontally across a level.
 * It can't be killed.
 * @author Samuel Menezes 
 */
public class BulletBill extends Objects{
private int width = 32,  height = 32;
private Texture tex = Main.getInstance();
private Handler handler;

public BulletBill(float x, float y,Camera cam,Handler handler,ObjectId id){
	super(x, y, id);
	this.handler = handler;
	velX = -6; //The horizontal velocity of the bullet.
}

public void tick(ArrayList<Objects> obj) {
	x += velX;
	y += velY;
		
    if(x <= 500)velX = 6; //Changes it's direction.
	if(x >= Main.WIDTH*8)velX = -6; //Changes it's direction.
	  
    Collision(obj); //It is responsible for it's collision.
}

/**
 * This method is responsible to generate the image depending on it's velocity.	
 */
public void render(Graphics g){
	if(velX < 0) g.drawImage(tex.bullet[0],(int)x,(int)y ,null);
	if(velX > 0)g.drawImage(tex.bullet[1],(int)x,(int)y ,null);
}

/**
 * The next four methods represent the four bounds of the Bullet.
 */
public Rectangle getBounds(){
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)((int)y+ (height/2))-(int)1f,(int)width/2,(int)height/2);
}

public Rectangle getBoundsTop(){
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)y+2,(int)width/2,(int)height/2 );
}

public Rectangle getBoundsRight(){
	return new Rectangle((int)((int)x+ width - 5),(int)y + 5,(int)5,(int)height -10);	
}

public Rectangle getBoundsLeft(){
    return new Rectangle((int)x,(int)y + 5,(int)5,(int)height - 10);
}

/**
 * This methods detects collision.
 */
private void Collision(ArrayList<Objects> obj){
	for(int i = 0;i < handler.obj.size();i++){
		Objects tempobj = handler.obj.get(i);
		if(tempobj.getId() == ObjectId.Player){ //If it's id will be equal to Mario's id.
			
			//If each of the given bounds intersect with Mario then Mario is dead.
			//The Dead State is then invoked generating a sound according to the level.
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
				
				if(getBoundsLeft().intersects(tempobj.getBounds()))
				{
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
