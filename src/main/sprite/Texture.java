package main.sprite;

import java.awt.image.BufferedImage;

public class Texture {

	public BufferedImage[] mario = new BufferedImage[12];
	public BufferedImage[] marioFireBall = new BufferedImage[4];
	public BufferedImage[] goomba = new BufferedImage[3];
	public BufferedImage[] koopaTroopa = new BufferedImage[5];
	public BufferedImage[] buzzyBeetle = new BufferedImage[5];
	public BufferedImage[] spiny = new BufferedImage[4];
	public BufferedImage[] piranhaPlant = new BufferedImage[2];
	public BufferedImage[] lavaBubble = new BufferedImage[2];
	public BufferedImage[] bulletBill = new BufferedImage[2];
	public BufferedImage[] block =  new BufferedImage[30];
	public BufferedImage[] pipe =  new BufferedImage[12];
	public BufferedImage[] coin = new BufferedImage[1];
	
	public Texture() {
		getCharacters();
		getObjects(33, 28, 32, 32);
	}
	
	private void getCharacters(){
		Sprite cs = new Sprite(ImageLoader.loadImage("res/image/sprite_mario.png"));
		Sprite es = new Sprite(ImageLoader.loadImage("res/image/sprite_enemy.png"));
		Sprite fs = new Sprite(ImageLoader.loadImage("res/image/sprite_fireball.gif"));

	   //mario
		mario[0] = cs.grabImage2(9.7f,1,32,32); //right
		mario[1] = cs.grabImage2(10.7f,1,32,32);
		mario[2] = cs.grabImage2(11.9f,1,32,32);
		mario[3] = cs.grabImage2(13.3f,1,32,32);
		mario[4] = cs.grabImage2(15.8f,1,32,32); // jump
		

		mario[5] = cs.grabImage2(8.5f,1,32,32); //left
		mario[6] = cs.grabImage2(7.2f,1,32,32);
		mario[7] = cs.grabImage2(6.1f,1,32,32);
		mario[8] = cs.grabImage2(4.7f,1,32,32);
		mario[9] = cs.grabImage2(1.9f,1,32,32); //jump
		
		//mario dead
		mario[10] = cs.grabImage2(1f,2,32,32);
		
		//enemies
		goomba[0] = es.grabImage(1,1,47,42);
		goomba[1] = es.grabImage(2,1,47,42);
		goomba[2] = es.grabImage(3,1,54,40);
		
		koopaTroopa[0] = es.grabImage(8,1,(int)43.5f,45);
		koopaTroopa[1] = es.grabImage(9,1,(int)45.7f,45);
		koopaTroopa[2] = es.grabImage(10,1,(int)45.7f,45); 
		koopaTroopa[3] = es.grabImage(11,1,(int)47.7f,45);
		koopaTroopa[4] = es.grabImage(16,1,(int)48f,45);
		
		buzzyBeetle[0] = es.grabImage(14,5,46,44);
		buzzyBeetle[1] = es.grabImage(15,5,46,44);
		buzzyBeetle[2] = es.grabImage(17,5,48,44);
		buzzyBeetle[3] = es.grabImage(18,5,46,44);
		buzzyBeetle[4] = es.grabImage(16,5,48,44);
		
		spiny[0] = es.grabImage(5,8,45,43);
		spiny[1] = es.grabImage(6,8,46,43);
		spiny[2] = es.grabImage(7,8,48,43);
		spiny[3] = es.grabImage(8,8,43,43);
		
		piranhaPlant[0] = es.grabImage(17.3f,2,47,55);
		piranhaPlant[1] = es.grabImage(18.57f,2,47,55);
		
		lavaBubble[0] = es.grabImage(1,8,50,44);
		lavaBubble[1] = es.grabImage(3,8,60,44);
		
		bulletBill[0] = es.grabImage(1,9,32,31f);
		bulletBill[1] = es.grabImage(5,9,30,31f);
		
		
		//fireballs
		marioFireBall[0] = fs.grabImage(1,1,25,25);
		marioFireBall[1] = fs.grabImage(2,1,23,25);
		marioFireBall[2] = fs.grabImage(3,1,24,25);
		marioFireBall[3] = fs.grabImage(4,1,23,25);
	}
//	
//	private void getPlayer(int columns, int rows, int width, int height) {
//		Sprite spriteCharacters = new Sprite(ImageLoader.loadImage("res/image/sprite_mario.png"));
//		BufferedImage[] imageList = spriteCharacters.buildSprite(columns, rows, width, height);
//		
//		/** Mario **/
//		// Facing Right
//		mario[0] = imageList[columns*0 + 1];
//		
//		// Facing Left
//		mario[1] = imageList[columns*0 + 2];
//		mario[2] = imageList[columns*0 + 3];
//		mario[3] = imageList[columns*0 + 4];
//		mario[4] = imageList[columns*0 + 5];
//		mario[5] = imageList[columns*0 + 6];
//		mario[6] = imageList[columns*0 + 7];
//		mario[7] = imageList[columns*0 + 8];
//		mario[8] = imageList[columns*0 + 9];
//		mario[9] = imageList[columns*0 + 10];
//		mario[10] = imageList[columns*0 + 11];
//		mario[11] = imageList[columns*0 + 12];
//		
//		// Mario dead
//	}
//	
//	private void getEnemies(int columns, int rows, int width, int height) {
//		Sprite spriteCharacters = new Sprite(ImageLoader.loadImage("res/image/sprite_enemy.png"));
//		BufferedImage[] imageList = spriteCharacters.buildSprite(columns, rows, width, height);
//		
//		/** Goomba **/
//		goomba[0] = imageList[columns*0];
//		goomba[1] = imageList[columns*0 + 1];
//		goomba[2] = imageList[columns*0 + 2];
//		
//		/** KoopaTroopa **/
//		koopaTroopa[0] = imageList[columns*0];
//		koopaTroopa[1] = imageList[columns*0];
//		koopaTroopa[2] = imageList[columns*0];
//		koopaTroopa[3] = imageList[columns*0];
//		koopaTroopa[4] = imageList[columns*0];
//		
//		/** BuzzyBeetle **/
//		buzzyBeetle[0] = imageList[columns*0];
//		buzzyBeetle[1] = imageList[columns*0];
//		buzzyBeetle[2] = imageList[columns*0];
//		buzzyBeetle[3] = imageList[columns*0];
//		buzzyBeetle[4] = imageList[columns*0];
//		
//		/** Spiny **/
//		spiny[0] = imageList[columns*0];
//		spiny[1] = imageList[columns*0 + 1];
//		spiny[2] = imageList[columns*0 + 2];
//		spiny[3] = imageList[columns*0 + 2];
//		
//		/** PiranhaPlant **/
//		piranhaPlant[0] = imageList[columns*0];
//		piranhaPlant[0] = imageList[columns*0];
//		
//		/** LavaBubble **/
//		lavaBubble[0] = imageList[columns*0];
//		lavaBubble[1] = imageList[columns*0 + 1];
//
//		/** BulletBill **/
//		bulletBill[0] = imageList[columns*0];
//		bulletBill[1] = imageList[columns*0 + 1];		
//	}
//
	private void getObjects(int columns, int rows, int width, int height) {
		Sprite s1 = new Sprite(ImageLoader.loadImage("res/image/sprite_level1-2-4.png"));
		Sprite s2 = new Sprite(ImageLoader.loadImage("res/image/sprite_level3.png"));
		int columnLevel3 = 23;
		int rowLevel3 = 8;
		Sprite princess = new Sprite(ImageLoader.loadImage("res/image/sprite_characters.png"));
		BufferedImage[] imageListForS1 = s1.buildSprite(columns, rows, width, height);
		BufferedImage[] imageListForS2 = s2.buildSprite(columnLevel3, rowLevel3, width, height);
		
		/** Blocks **/
		// Level 1
		block[0] = imageListForS1[columns*0];
		block[1] = imageListForS1[columns*0 + 1]; 
		block[2] = imageListForS1[columns*1]; 

		// Level 2
		block[3] = imageListForS1[columns*2];
		block[4] = imageListForS1[columns*2 + 1]; 
		block[5] = imageListForS1[columns*3]; 
		
		// Level 3
		block[6] = imageListForS2[columnLevel3*0];
		block[7] = imageListForS2[columnLevel3*0 + 1];
		block[8] = imageListForS2[columnLevel3*1]; 
		
		// Level 4
		block[9] = imageListForS1[columns*5 + 2];
		block[10] = imageListForS1[columns*5]; 
		
		/** Bridge **/
		block[11] = imageListForS1[columns*24 + 4]; 
		
		/** Question **/
		block[12] = imageListForS1[columns*0 + 24]; 
		
		/** BulletBill Cannon */
		block[13] = imageListForS1[columns*0 + 9];
		block[14] = imageListForS1[columns*1 + 9];
		
		/** Flag **/
		block[15] = imageListForS1[columns*9 + 16];
		block[16] = imageListForS1[columns*7 + 14];
		
		/** Princess **/
		block[17] =  princess.grabImage(16.6f,24f,31.5f,31.6f); 

		/** Water **/
		block[18] = imageListForS2[columnLevel3*6 + 8];
		block[19] = imageListForS2[columnLevel3*7 + 8];
		
		/** Lava **/
		block[20] = imageListForS1[columns*24 + 3];
		block[21] = imageListForS1[columns*25 + 3];
	
				
		/** Pipes **/
		// Level 1 & 2 pipes
		pipe[0] = imageListForS1[columns*8];
		pipe[1] = imageListForS1[columns*8 + 1];
		pipe[2] = imageListForS1[columns*9];
		pipe[3] = imageListForS1[columns*9 + 1];
		
		// Level 3 pipes
		pipe[4] = imageListForS2[columnLevel3*4];
		pipe[5] = imageListForS2[columnLevel3*4 + 1];
		pipe[6] = imageListForS2[columnLevel3*5];
		pipe[7] = imageListForS2[columnLevel3*5 + 1];
		
		// Level 4 pipes
		pipe[8] = imageListForS1[columns*14];
		pipe[9] = imageListForS1[columns*14 + 1];
		pipe[10] = imageListForS1[columns*15];
		pipe[11] = imageListForS1[columns*15 + 1];
		
		/** Coin **/
		coin[0] = imageListForS1[columns*1 + 24];
	}
//	
//	private void getMarioFireBall(int columns, int rows, int width, int height) {
//		Sprite spriteCharacters = new Sprite(ImageLoader.loadImage("res/image/sprite_fireball.gif"));
//		BufferedImage[] imageList = spriteCharacters.buildSprite(columns, rows, width, height);
//		
//		
//	}
//	
	
}
