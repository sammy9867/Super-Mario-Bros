package Sprites;

import java.awt.image.BufferedImage;
import Main.ImageLoader;

/**
 * This class is responsible to load all the images into the game.
 * @author Samuel Menezes
 *
 */
public class Texture {
private SpriteSheet bs,bs2,cs,es,fs,ps,bg;
private BufferedImage block_sheet = null, character_sheet = null,enemy_sheet = null;
private BufferedImage block_sheet2 = null,fire_sheet = null, sheet = null;
private BufferedImage background = null;

/**
 * An array of BufferedImage to load multiple images for specific characters/objects in the game.
 */
public BufferedImage[] block = new BufferedImage[38];
public BufferedImage[] mario = new BufferedImage[11];
public BufferedImage[] mario_jump = new BufferedImage[3];
public BufferedImage[] goomba = new BufferedImage[3];
public BufferedImage[] koopa = new BufferedImage[5];
public BufferedImage[] beetle = new BufferedImage[5];
public BufferedImage[] plant = new BufferedImage[2];
public BufferedImage[] spiny = new BufferedImage[4];
public BufferedImage[] lavabubble = new BufferedImage[2];
public BufferedImage[] coin = new BufferedImage[1];
public BufferedImage[] fireball = new BufferedImage[4];
public BufferedImage[] bullet = new BufferedImage[4];

public Texture(){
	ImageLoader loader = new ImageLoader();
	try{
		block_sheet = loader.loadImage("Resources/Blocks.png");
		block_sheet2 = loader.loadImage("Resources/Blocks2.png");
		character_sheet = loader.loadImage("Resources/Mario.png");
		enemy_sheet = loader.loadImage("Resources/Enemies.png");
		fire_sheet = loader.loadImage("Resources/FireBall.gif");
		sheet = loader.loadImage("Resources/Characterss.png");
		background = loader.loadImage("Resources/Background.png");
	}catch(Exception e){
		e.printStackTrace();
	}
	
	bs = new SpriteSheet(block_sheet);
	bs2 = new SpriteSheet(block_sheet2);
	cs = new SpriteSheet(character_sheet);
	es = new SpriteSheet(enemy_sheet);
	fs = new SpriteSheet(fire_sheet);
	ps = new SpriteSheet(sheet);
	bg = new SpriteSheet(background);
	
	getTextures();  
}

private void getTextures(){
	
	block[0] = bs.grabImage(1, 1, 32, 32);
	
	//princess
	block[1] = ps.grabImage(16.6f,24f,31.5f,31.6f); 
	
	block[2] = bs.grabImage(3, 1, 32, 32);
	block[3] = bs.grabImage(25, 1, 32, 32);
	block[4] = bs.grabImage(1, 2, 32, 32);
	
	//level1pipe grid
	block[5] = bs.grabImage(1, 9, 32, 32);
	block[6] = bs.grabImage(1, 10, 32, 32);
	block[7] = bs.grabImage(2, 9, 32, 32);
	block[8] = bs.grabImage(2, 10, 32, 32);
	

	//level2 blocks 
	block[10] = bs.grabImage(3, 3, 32, 32);
	block[11] = bs.grabImage(1, 3, 32, 32);
	block[12] = bs.grabImage(1, 4, 32, 32);
	
	//level3 blocks
	block[13] = bs2.grabImage(3, 1, 32, 32); 
	block[14] = bs2.grabImage(1, 1, 32, 32); 
	block[15] = bs2.grabImage(1, 2, 32, 32); 
	block[16] = bs2.grabImage(18, 1, 32, 32); 
	
	//level3 pipe
	block[17] = bs2.grabImage(1, 3, 32, 32);
	block[18] = bs2.grabImage(2, 3, 32, 32);
	block[19] = bs2.grabImage(1, 4, 32, 32);
	block[20] = bs2.grabImage(2, 4, 32, 32);
		
	//water and lava base
	block[21] = bs2.grabImage(9, 8, 32, 32);
	block[22] = bs.grabImage(4, 26, 32, 32);
	
	block[29] = bs2.grabImage(9, 7, 32, 32);
	block[30] = bs.grabImage(4, 25, 32, 32);
	
	//level4 blocks
	block[23] = bs.grabImage(3, 6, 32, 32); 
	block[24] = bs.grabImage(5, 25, 32, 32); 
	block[33] = bs.grabImage(1,6, 32,32);
	
	//level4 pipe
	block[25] = bs.grabImage(1, 15, 32, 32);
	block[26] = bs.grabImage(2, 15, 32, 32);
	block[27] = bs.grabImage(1, 16, 32, 32);
	block[28] = bs.grabImage(2, 16, 32, 32);
	
	//flag
	block[31] = bg.grabImage(8.6f,21 ,33, 32);
	block[32] = bg.grabImage(8.6f,20, 33, 31);
	
	block[34] = es.grabImage(2.9f,8 ,32.8f, 32.7f);
	block[35] = es.grabImage(2.9f,9, 32.8f, 32.7f);
	
   //mario
	mario[0] = cs.grabImage2(9.7f,1,32,32); //right
	mario[1] = cs.grabImage2(10.7f,1,32,32);
	mario[2] = cs.grabImage2(11.9f,1,32,32);
	mario[3] = cs.grabImage2(13.3f,1,32,32);
	mario_jump[0] = cs.grabImage2(15.8f,1,32,32);
	

	mario[4] = cs.grabImage2(8.5f,1,32,32); //left
	mario[5] = cs.grabImage2(7.2f,1,32,32);
	mario[6] = cs.grabImage2(6.1f,1,32,32);
	mario[7] = cs.grabImage2(4.7f,1,32,32);
	mario_jump[1] = cs.grabImage2(1.9f,1,32,32);
	
	//mario dead
	mario[8] = cs.grabImage2(1f,2,32,32);
	
	//enemies
	goomba[0] = es.grabImage(1,1,47,42);
	goomba[1] = es.grabImage(2,1,47,42);
	goomba[2] = es.grabImage(3,1,54,40);
	
	koopa[0] = es.grabImage(8,1,(int)43.5f,45);
	koopa[1] = es.grabImage(9,1,(int)45.7f,45);
	koopa[2] = es.grabImage(10,1,(int)45.7f,45); 
	koopa[3] = es.grabImage(11,1,(int)47.7f,45);
	koopa[4] = es.grabImage(16,1,(int)48f,45);
	
	beetle[0] = es.grabImage(14,5,46,44);
	beetle[1] = es.grabImage(15,5,46,44);
	beetle[2] = es.grabImage(17,5,48,44);
	beetle[3] = es.grabImage(18,5,46,44);
	beetle[4] = es.grabImage(16,5,48,44);
	
	spiny[0] = es.grabImage(5,8,45,43);
	spiny[1] = es.grabImage(6,8,46,43);
	spiny[2] = es.grabImage(7,8,48,43);
	spiny[3] = es.grabImage(8,8,43,43);
	
	plant[0] = es.grabImage(17.3f,2,47,55);
	plant[1] = es.grabImage(18.57f,2,47,55);
	
	lavabubble[0] = es.grabImage(1,8,50,44);
	lavabubble[1] = es.grabImage(3,8,60,44);
	
	bullet[0] = es.grabImage(1,9,32,31f);
	bullet[1] = es.grabImage(5,9,30,31f);
	
	
	//coins
	coin[0] = bs.grabImage((int)25.7f,(int) 6.8f, (int)32.5f, (int)32.5f);
	
	//fireballs
	fireball[0] = fs.grabImage(1,1,25,25);
	fireball[1] = fs.grabImage(2,1,23,25);
	fireball[2] = fs.grabImage(3,1,24,25);
	fireball[3] = fs.grabImage(4,1,23,25);
}

}
