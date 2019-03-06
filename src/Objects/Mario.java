package Objects;

import Main.Camera;
import Main.Handler;
import Main.Main;
import Main.Time;
import Sprites.Texture;
import AudioPlayer.Audio;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import Main.Animation;

/**
 * This class represents Mario.
 * @author Samuel Menezes
 */
public class Mario extends Objects{
public static int width = 32;
public static int height = 32;
private float gravity = 0.5f; 
private final float MAX_SPEED = 10;
private Handler handler;
private Animation walk_right,walk_left;
private Texture tex = Main.getInstance();

public Mario(float x, float y, Handler handler,Camera cam,ObjectId id) {
	super(x, y, id);
	this.handler = handler;
	walk_right= new Animation(4,tex.mario[1],tex.mario[2],tex.mario[3]); 
	walk_left = new Animation(4,tex.mario[5],tex.mario[6],tex.mario[7]); 
}
	
public void tick(ArrayList<Objects> obj){
      x += velX;
      y += velY;
      
      //the direction of Mario.
      if(velX < 0) direction = -1;
      else if(velX > 0) direction = 1;

      if(falling || jumping){
    	  velY += gravity;
    	  
    	  if(velY > MAX_SPEED)
    		  velY = MAX_SPEED;
      }
      
		Collision(obj); //Calling the Collision Method for Mario.
		walk_right.runAnimation();
		walk_left.runAnimation();
}

//Responsible for Collision
private void Collision(ArrayList<Objects> obj){
	for(int i = 0;i < handler.obj.size();i++){
		Objects tempobj = handler.obj.get(i);
		
		//If Mario intersects with the Objects [Pipes/Blocks],whose ObjectId is Block, it will stop.
			if(tempobj.getId() == ObjectId.Block){
				if(getBoundsTop().intersects(tempobj.getBounds())){
					y = tempobj.getY() + 32;
					velY = 0;
					Audio.getSound("bump").play(); //Creating a bump sound when the upper part of Mario intersects a block.
				}
				
				if(getBounds().intersects(tempobj.getBounds())){
					y = tempobj.getY() - height;
					velY = 0;
					falling = false;
					jumping  = false;
				}else
					falling = true;
				
				if(getBoundsRight().intersects(tempobj.getBounds())){
					x = tempobj.getX() - width;
				}
				
				if(getBoundsLeft ().intersects(tempobj.getBounds())){
					x = tempobj.getX() + 29;
				}
			}
			
			//If Mario intersects with the invinsible block just before the flag at the very end,whose ObjectId is NextLevel,
		    //it will switch the level and restart the timer.
			else if(tempobj.getId() == ObjectId.NextLevel){
				if(getBounds().intersects(tempobj.getBounds())){
				score *= Math.sqrt(Time.time); //This the formula that is used when Mario completes a level
				handler.switchLevel();
				Main.time.restart();
				level++;
				}
			} 
			
			//If Mario intersects with a coin,whose ObjectId is Coin,
		    //it will remove the coin and add 10 points to the score.
			else if(tempobj.getId() == ObjectId.Coin){
				if(getBounds().intersects(tempobj.getBounds())){
			       handler.removeObject(tempobj);
			        Audio.getSound("coin").play(); //Generates a sound
                   score +=10;
                   noOfCoins++;
                 }
			}
			
			//If Mario falls in a pit/water/lava at specific levels,whose ObjectId's are given below[Dead1,2,3,4]
		    //it will invoke the Dead state and you will lose the game.
			
			else if(tempobj.getId() == ObjectId.Dead1){
				if(getBounds().intersects(tempobj.getBounds())){
					Audio.getSound("level").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
				}  
			}
			
			else if(tempobj.getId() == ObjectId.Dead2){
				if(getBounds().intersects(tempobj.getBounds())){
					Audio.getSound("level2").stop();
					Main.State = Main.STATE.Dead;
				    Audio.getSound("mdead").play();
				 }
		    }
			
			else if(tempobj.getId() == ObjectId.Dead3){
				if(getBounds().intersects(tempobj.getBounds())){
					Audio.getSound("level").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();

				 }
			}
			
			else if(tempobj.getId() == ObjectId.Dead4){
				if(getBounds().intersects(tempobj.getBounds())){
					Audio.getSound("level4").stop();
					Main.State = Main.STATE.Dead;
					Audio.getSound("mdead").play();
				 }
			}
			
			//If Mario intersects with the following enemies, you will lose the game.
			else if(tempobj.getId() == ObjectId.Enemy3 || tempobj.getId() == ObjectId.Enemy || tempobj.getId() == ObjectId.Enemy2
						|| tempobj.getId() == ObjectId.Lava){
				if(getBounds().intersects(tempobj.getBounds())){
				//The following statements will stop the sound at a given level that is being played and invoke the dead state.
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
	
//Loads the image for the required movements.
public void render(Graphics g) {	
	if(jumping){
		if(direction == 1)
			g.drawImage(tex.mario_jump[0],(int)x,(int)y,(int)38.5f,(int)38.5f,null);
		else if(direction == -1)
		g.drawImage(tex.mario_jump[1],(int)x,(int)y,(int)38.5f,(int)38.5f,null);
	}
	else{
	if(velX != 0){
		if(direction == 1)
		walk_right.drawAnimation(g,(int)x,(int)y,(int)38.5f,(int)38.5f);
		else
		walk_left.drawAnimation(g,(int)x,(int)y,(int)38.5f,(int)38.5f);
	}
	else{
		if(direction == 1)
	     g.drawImage(tex.mario[0],(int)x,(int)y,(int)38.5f,(int)38.5f,null);
		else if(direction == -1)
			g.drawImage(tex.mario[4],(int)x,(int)y,(int)38.5f,(int)38.5f,null); 
	
	  }
}
//By importing java.awt.Graphics2D and java.awt.Colors, one can check the bounds of Mario.
/*	Graphics2D g2d = (Graphics2D) g;
	g.setColor(Color.red);
	g2d.draw(getBounds());
	g2d.draw(getBoundsRight());
	g2d.draw(getBoundsLeft());
	g2d.draw(getBoundsTop()); 
	*/
}

//Rectangular Bounds for Mario necessary for Collision Detection.
public Rectangle getBounds() {
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)((int)y+ (height/2)),(int)width/2,(int)height/2);
}
	
public Rectangle getBoundsTop() {
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)y,(int)width/2,(int)height/2);
}
	
public Rectangle getBoundsRight() {
	return new Rectangle((int)((int)x+ width - 5),(int)y + 5,(int)5,(int)height -10);	
}

public Rectangle getBoundsLeft() {
	return new Rectangle((int)x,(int)y + 5,(int)5,(int)height - 10);
}
}
