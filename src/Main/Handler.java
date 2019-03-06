package Main;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import AudioPlayer.Audio;
import Enemies.BulletBill;
import Enemies.BuzzyBeetle;
import Enemies.Goomba;
import Enemies.KoopaTroopa;
import Enemies.LavaBubble;
import Enemies.PiranhaPlant;
import Enemies.Spiny;
import Objects.Blocks;
import Objects.Coin;
import Objects.Mario;
import Objects.NextLevel;
import Objects.ObjectId;
import Objects.Objects;

/**
 * This class can add/delete objects, switch levels, and places the image with a given RGB value on the Level map.
 * @author Samuel Menezes
 */
public class Handler {
public ArrayList<Objects> obj = new ArrayList<>();
private Objects tempobj;
private Camera cam;
public BufferedImage level2 = null,level3 = null,level4 = null; //Images for different levels

public Handler(Camera cam){
	this.cam = cam;
	
	//Loading images for the given levels.
	ImageLoader loader = new ImageLoader();
	level2 = loader.loadImage("Resources/Level2.png"); 
	level3 = loader.loadImage("Resources/Level3.png");
	level4 = loader.loadImage("Resources/Level4.png");
}

public void tick(){
	for(int i = 0;i < obj.size();i++){
		tempobj = obj.get(i);
		tempobj.tick(obj);
	}
}

public void render(Graphics g){
	for(int i = 0;i < obj.size();i++){
		tempobj = obj.get(i);
		tempobj.render(g);
	}
}

//Adds an object
public void addObject(Objects obj){
	this.obj.add(obj);
}

//Deletes an object
public void removeObject(Objects obj){
	this.obj.remove(obj);
}

//Clears all the objects from the level.
public void clearLevel(){
	obj.clear();
}

// Switches the level and changes the sound/music for each level.
public void switchLevel(){
	clearLevel();
	cam.setX(0);
	
	switch(Main.LEVEL){
	case 1:
	Audio.getSound("level").stop();
	LoadImageLevel(level2);
	Audio.getSound("level2").loop();
	break;
		
	case 2:
	LoadImageLevel(level3);
	Audio.getSound("level2").stop();
	Audio.getSound("level").loop();
	break;
		
	case 3:
	LoadImageLevel(level4);
	Audio.getSound("level").stop();
	Audio.getSound("level4").loop();
	break; 
	
	case 4:
	Audio.getSound("level4").stop();
	Main.State = Main.STATE.GameOver;
	Audio.getSound("end").play();
	break;	
 }
	Main.LEVEL++;
}


/**
 * This method basically loads all the images into the level with the given RGB value.
 */
public void LoadImageLevel(BufferedImage image){
	  int w = image.getWidth();
	  int h = image.getHeight();
	 
	  for(int i = 0;i < h;i++){
		  for(int j = 0; j < w; j++) {
		   int pixel = image.getRGB(i,j);
		   int red = (pixel >> 16) & 0xff;
		   int green = (pixel >> 8) & 0xff;
		   int blue = (pixel)  & 0xff;
		   
		   
		   
		   if(red == 130 && green == 230 && blue == 130) addObject(new Blocks(i*32,j*32, 1, ObjectId.Block)); 
		   
		   //Switching Levels
		   if(red == 255 && green == 216 && blue == 0) addObject(new NextLevel(i*32,j*32, ObjectId.NextLevel)); 
		  
		   //Mario
		   if(red == 0 && green == 0 && blue == 255) addObject(new Mario(i*32,j*32,this,cam,ObjectId.Player));
		   
		   //Princess
		   if(red == 0 && green == 0 && blue == 100) addObject(new Blocks(i*32,j*32, 1, ObjectId.Block));
		   
		   //coins
		   if(red == 200 && green == 200 && blue == 0) addObject(new Coin(i*32,j*32,ObjectId.Coin));
		   
	       //enemies
		   if(red == 190 && green ==150 && blue == 150) addObject(new Goomba(i*32,j*32,cam,this,ObjectId.Enemy));
		   if(red == 100 && green ==100 && blue == 10) addObject(new KoopaTroopa(i*32,j*32,cam,this,ObjectId.Enemy));
	       if(red == 100 && green ==100 && blue == 20) addObject(new BuzzyBeetle(i*32,j*32,cam,this,ObjectId.Enemy2));
		   if(red == 100 && green ==100 && blue == 30) addObject(new Spiny(i*32,j*32,cam,this,ObjectId.Enemy3));
		   if(red == 100 && green ==100 && blue == 35) addObject(new PiranhaPlant(i*32,j*32,cam,this,ObjectId.Enemy4));
		   if(red == 100 && green ==100 && blue == 40) addObject(new LavaBubble(i*32,j*32,cam,this,ObjectId.Lava));
		   if(red == 100 && green ==100 && blue == 50) addObject(new BulletBill(i*32,j*32,cam,this,ObjectId.Cannon));
		 
		   //level1
		   if(red == 255 && green == 255 && blue == 255) addObject(new Blocks(i*32,j*32, 0,ObjectId.Block));
		   if(red == 0 && green == 38 && blue == 255) addObject(new Blocks(i*32,j*32, 2,ObjectId.Block)); //coin block
		   if(red == 255 && green == 5 && blue == 0) addObject(new Blocks(i*32,j*32, 3,ObjectId.Block)); //breaking block
		   if(red == 128 && green == 128 && blue == 128) addObject(new Blocks(i*32,j*32, 4,ObjectId.Block)); //brown block
		   
		   //level1 & level2 pipes
		   if(red == 120 && green == 120 && blue == 120) addObject(new Blocks(i*32,j*32, 5,ObjectId.Block)); 
		   if(red == 125 && green == 120 && blue == 120) addObject(new Blocks(i*32,j*32, 6,ObjectId.Block)); 
		   if(red == 130 && green == 120 && blue == 120) addObject(new Blocks(i*32,j*32, 7,ObjectId.Block)); 
		   if(red == 135 && green == 120 && blue == 120)addObject(new Blocks(i*32,j*32, 8,ObjectId.Block)); 
		   
		   //level2
		   if(red == 100 && green == 100 && blue == 100) addObject(new Blocks(i*32,j*32, 10, ObjectId.Block)); //l2blocks
		   if(red == 140 && green == 140 && blue == 140) addObject(new Blocks(i*32,j*32, 11,ObjectId.Block)); //base
		   if(red == 150 && green == 150 && blue == 150) addObject(new Blocks(i*32,j*32, 12,ObjectId.Block)); //otherblocks
		   
		   //level3
		   if(red == 160 && green == 160 && blue == 160) addObject(new Blocks(i*32,j*32, 13,ObjectId.Block)); //l3blocks
		   if(red == 170 && green == 170 && blue == 170) addObject(new Blocks(i*32,j*32, 14,ObjectId.Block)); //base
		   if(red == 180 && green == 180 && blue == 180) addObject(new Blocks(i*32,j*32, 15,ObjectId.Block)); //otherblocks
		   if(red == 190 && green == 190 && blue == 190) addObject(new Blocks(i*32,j*32, 16, ObjectId.Block)); //coinblocks
		   
		   //level3pipe.
		   if(red == 200 && green ==200 && blue == 200) addObject(new Blocks(i*32,j*32, 17,ObjectId.Block)); //pipe
		   if(red == 205 && green == 205 && blue == 205) addObject(new Blocks(i*32,j*32, 18,ObjectId.Block)); 
		   if(red == 210 && green == 210 && blue ==210) addObject(new Blocks(i*32,j*32, 19,ObjectId.Block)); 
		   if(red == 215 && green == 215 && blue == 215)addObject(new Blocks(i*32,j*32, 20, ObjectId.Block)); 
		   
		  //water 
		  if(red == 220 && green == 220 && blue == 220) addObject(new Blocks(i*32,j*32, 29,ObjectId.Dead3)); 
		  if(red == 225 && green == 225 && blue == 225) addObject(new Blocks(i*32,j*32, 21,ObjectId.Dead3)); //base
		   
		   //lava
		  if(red == 230 && green == 230 && blue == 230) addObject(new Blocks(i*32,j*32, 30,ObjectId.Dead4)); 
	      if(red == 235 && green == 235 && blue == 235) addObject(new Blocks(i*32,j*32,22 ,ObjectId.Dead4)); //base
		   
		   //level4
		   if(red == 240 && green == 240 && blue == 240) addObject(new Blocks(i*32,j*32, 23,ObjectId.Block)); //block
		   if(red == 245 && green == 245 && blue == 245) addObject(new Blocks(i*32,j*32, 24,ObjectId.Block)); //bridge
		   if(red == 250 && green == 245 && blue == 240) addObject(new Blocks(i*32,j*32, 33, ObjectId.Block));
		   
		   //level4pipe
	       if(red == 250 && green == 250 && blue == 250) addObject(new Blocks(i*32,j*32, 25,ObjectId.Block)); //pipe
		   if(red == 250 && green == 120 && blue == 120) addObject(new Blocks(i*32,j*32, 26,ObjectId.Block)); 
		   if(red == 250 && green == 130 && blue == 130) addObject(new Blocks(i*32,j*32, 27,ObjectId.Block)); 
		   if(red == 250 && green == 140 && blue == 140)addObject(new Blocks(i*32,j*32, 28,ObjectId.Block)); 
		   
		   
		   //flag
		   if(red == 250 && green == 40 && blue == 40) addObject(new Blocks(i*32,j*32, 31,ObjectId.Block)); 
		   if(red == 250 && green == 50 && blue == 50)addObject(new Blocks(i*32,j*32, 32,ObjectId.Block)); 
		   
		   //cannon
		   if(red == 250 && green == 70 && blue == 70) addObject(new Blocks(i*32,j*32, 34,ObjectId.Block)); 
		   if(red == 250 && green == 80 && blue == 80)addObject(new Blocks(i*32,j*32, 35,ObjectId.Block)); 
		   
		   //falling
		   if(red == 250 && green == 60 && blue == 60) addObject(new NextLevel(i*32,j*32,ObjectId.Dead1));
		   if(red == 250 && green == 65 && blue == 65) addObject(new NextLevel(i*32,j*32, ObjectId.Dead2));
		  }
	  }
}
}
