package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import Main.Animation;
import Main.Handler;
import Main.Main;
import Sprites.Texture;

/**
 * This class represents Mario's fireball.
 * @author Samuel Menezes
 */
public class MarioFireBall extends Objects {
private int width = 32;
private int height = 32;
private Texture tex2 = Main.getInstance();
private Animation fire;
private Handler handler;

public MarioFireBall(float x, float y, ObjectId id,int velX,Handler handler) {
	super(x, y, id);
		
	this.id = ObjectId.MFireBall;
	this.velX = velX;
	this.handler = handler;
	fire= new Animation(3,tex2.fireball[0],tex2.fireball[1],tex2.fireball[2],tex2.fireball[3]); //loads 4 fireball Images and create an Animation.
}

public void tick(ArrayList<Objects> obj) {
	x += velX;
	fire.runAnimation();
	Collision(obj);
}

public void render(Graphics g) {
	fire.drawAnimation(g,(int)x,(int)y,(int)30f,(int)30f);
}


//Rectangular Bounds for the fireball necessary for Collision Detection.
public Rectangle getBounds() {
	return new Rectangle((int)((int)x+ (width/2) -((width/2)/2)),(int)((int)y+ (height/2))-(int)1f,(int)width/2,(int)height/2 - 4);
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
	
//Responsible for Collision
private void Collision(ArrayList<Objects> obj){
	for(int i = 0;i < handler.obj.size();i++){
      Objects tempobj = handler.obj.get(i);
      
      //If the fireball intersects with the Goomba/KoopaTroopa [Enemies],whose ObjectId is Enemy,
      //it will remove the enemy and add 20 points to the score.
		 if(tempobj.getId() == ObjectId.Enemy){
			if(getBoundsTop().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
					score += 20;	
				}
								
				if(getBounds().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
					score += 20;	
				}
											
				if(getBoundsRight().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
				    score += 20;	
				}
								
											
				if(getBoundsLeft().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
					score += 20;	
				}
		 }
		 
		  //If the fireball intersects with BuzzyBeetle [Enemy],whose ObjectId is Enemy2,
	      //it will remove the enemy and add 30 points to the score.
		    if(tempobj.getId() == ObjectId.Enemy2){
				if(getBoundsTop().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
					score += 30;	
				}
								
				if(getBounds().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
					score += 30;	
				}
								
							
				if(getBoundsRight().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
				    score += 30;	
				}
								
								
							
				if(getBoundsLeft().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
					score += 30;	
				}
		 }
		 
		    //If the fireball intersects with Spiny [Enemy] ,whose ObjectId is Enemy3,
		     //it will remove the enemy and add 40 points to the score.
		   if(tempobj.getId() == ObjectId.Enemy3){
				if(getBoundsTop().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
					score += 40;	
				}
								
			    if(getBounds().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
					score += 40;
				}
										
				if(getBoundsRight().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
				    score += 40;	
				}
								
								
							
				if(getBoundsLeft().intersects(tempobj.getBounds())){
					handler.removeObject(tempobj);
					score += 40;	
				}
		 }
		 
		   //If the fireball intersects with the an object [Pipe/Blocks],whose ObjectId is Block,
		    //the fireball will disappear from that given location. 
		 if(tempobj.getId() == ObjectId.Block ){
				if(getBoundsTop().intersects(tempobj.getBounds())){
					x = tempobj.getX() - 10000;
				}
								
				if(getBounds().intersects(tempobj.getBounds())){
					x = tempobj.getX() - 10000;	
				}
								
							
				if(getBoundsRight().intersects(tempobj.getBounds())){
					x = tempobj.getX() - 10000;	
				}
								
								
				if(getBoundsLeft().intersects(tempobj.getBounds())){
					x = tempobj.getX()  -10000;	
				}
		 }
		 
	 }	
}


}
