package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import AudioPlayer.Audio;
import Objects.KeyInput;
import Objects.Mario;
import Objects.ObjectId;
import Sprites.Texture;

/**
 * This is the Main method of the game.
 * @author Samuel Menezes
 */
public class Main extends Canvas implements Runnable {
private static final long serialVersionUID = 1L;
private boolean running = false;
public static int  WIDTH,HEIGHT;
private Thread t;
private Handler handler;
private Camera cam;
public static Time time;
static Texture tex;
private MenuSystem menu;
public BufferedImage level1 = null;

 //To load Background images
private BufferedImage cloud1 = null,cloud2 = null;
private BufferedImage hill1 = null,hill2 = null;
private BufferedImage grass1 = null,grass2 = null,grass3 = null;
private BufferedImage castle = null;
private BufferedImage menupic = null;

private BufferedImage gameover = null;
public static int LEVEL = 1;

//The Game State
public static enum STATE {
	 Menu(),
	 Game(),
	 Dead(),
	 GameOver();
};

public static STATE State = STATE.Menu; //The game is in the Menu state at first
 
//Initalizes the images and objects of other classes
public void init(){
	 WIDTH = getWidth();
	 HEIGHT = getHeight();
	 
	 tex = new Texture();
	 time = new Time();
	 
	 ImageLoader loader = new ImageLoader();
	 level1 = loader.loadImage("Resources/Level1.png");
	 cloud1 = loader.loadImage("Resources/Cloud1.png");
	 cloud2 = loader.loadImage("Resources/Cloud2.png");
	 castle = loader.loadImage("Resources/Castle.png");
	 hill1 = loader.loadImage("Resources/Hill1.png");
	 hill2 = loader.loadImage("Resources/Hill2.png");
	 grass1 = loader.loadImage("Resources/Grass1.png");
	 grass2 = loader.loadImage("Resources/Grass2.png");
	 grass3 = loader.loadImage("Resources/Grass3.png");
	 menupic = loader.loadImage("Resources/Menu.jpg");
	 gameover = loader.loadImage("Resources/GameOver.png");

	 Audio.init(); //Audio Initializer from Audio.java
	 cam = new Camera(0,0);
	 handler = new Handler(cam);
	 menu = new MenuSystem();
	 
	 handler.LoadImageLevel(level1); //loads the first level.
	 Audio.getSound("level").loop();
	 
	 this.addKeyListener(new KeyInput(handler,menu));
	 this.addMouseListener(new MouseInput()); 
}

//The game loop
public void run() {
	init();
	this.requestFocus();
	long previous = System.nanoTime();
	double ticks = 75.0; 
	double ns = 1000000000/ticks;
	double delta = 0;
	long timer = System.currentTimeMillis();
	while(running){
		long current = System.nanoTime();
		delta += (current - previous)/ns;
	    previous = current;
		while(delta >= 1){
			tick();
			delta--;
		}
		render();
		
		if(System.currentTimeMillis() - timer > 1000){
			timer += 1000;
		}
	}
 }
  
//Responsible for movement
private void tick(){
	 if(State == STATE.Game){  
	 handler.tick();
	 }
	
	 for(int i = 0;i < handler.obj.size();i++){
	   if(handler.obj.get(i).getId() == ObjectId.Player){
			 cam.tick(handler.obj.get(i));
	   }
	 }
}
 
//To load Images
private void render(){
	  BufferStrategy bs = this.getBufferStrategy();
	  if(bs == null){
		  this.createBufferStrategy(3);
		  return;
	  }
	  
	  Graphics g = bs.getDrawGraphics();
	  Graphics2D g2d = (Graphics2D)g;
	  
	  if(State == STATE.Game){
		  Color color = new Color(93,148,251);	 
		  Color color2 = new Color(128,218,235);
		  
	switch(LEVEL){
	case 1:
	  g.setColor(color);
	  g.fillRect(0, 0, getWidth(),getHeight());
    

	  break;
	case 2:
	
		  g.setColor(Color.BLACK);
		  g.fillRect(0, 0, getWidth(),getHeight());
		  break;
	case 3:
		  g.setColor(color2);
		  g.fillRect(0, 0, getWidth(),getHeight());
		  break;
	case 4:
		  g.setColor(Color.BLACK);
		  g.fillRect(0, 0, getWidth(),getHeight());
		  break;
	}
	
	  Font f1 = new Font("arial",Font.BOLD,20);
	  g.setColor(Color.white);
	  g.setFont(f1);
	  g.drawString("MARIO", 50, 20);
	  g.drawString("" + Mario.score , 50, 40);
	  
	  g.drawString("COINS", 150, 20);
	  g.drawString("" + Mario.noOfCoins , 150, 40);
	  
	  g.drawString("WORLD", 250, 20);
	  g.drawString(" 1 - " + Mario.level , 260, 40);
	  
	  g.drawString("TIME", 350, 20);
	  g.drawString("" + Time.time , 350, 40);
		  
	  g2d.translate(cam.getX(),cam.getY());
	  
	switch(LEVEL){
	
	case 1:
	  for(int i = 0;i < cloud1.getWidth()*80; i+= cloud1.getWidth()*5) { g.drawImage(cloud1,i,100,this); }//cloud1
	  for(int i = 0;i < cloud2.getWidth()*80; i+= cloud2.getWidth()*6) { g.drawImage(cloud2,i + 200,160,this);} //cloud2);
	  g.drawImage(castle,5000,335,this);
	  for(int i = 0;i < hill1.getWidth()*500; i+= hill1.getWidth()*6) { g.drawImage(hill1,i + 20,377,this); }//hill1
	  g.drawImage(hill2,600,400,this);
	  g.drawImage(hill2,1000,400,this);
	  g.drawImage(hill2,2000,400,this);
	  g.drawImage(hill2,3800,400,this);
	  
	  g.drawImage(grass1,360,450,this);
	  g.drawImage(grass1,2400,450,this);
	  
	  g.drawImage(grass2,1280,470,this);
	  g.drawImage(grass2,2200,470,this);
	  break;
	 
	case 3: 
	 for(int i = 0;i < cloud1.getWidth()*80; i+= cloud1.getWidth()*5) { g.drawImage(cloud1,i,80,this); }//cloud1
	 for(int i = 0;i < cloud2.getWidth()*80; i+= cloud2.getWidth()*6) { g.drawImage(cloud2,i + 200,140,this);} //cloud2);

	 g.drawImage(grass3,660,470,this);
	 g.drawImage(grass3,1000,470,this);
     g.drawImage(grass3,2000,470,this);
	 g.drawImage(grass3,2600,470,this);
	 g.drawImage(grass3,3000,470,this);
     g.drawImage(grass3,3500,470,this);
	 break;
    }
	  handler.render(g);
	  
	  g2d.translate(-cam.getX(),-cam.getY());
	  }
	  
	  else if(State == STATE.Menu){
		 g.drawImage(menupic, 0,0,this);
		 menu.render(g);
	  }
	  
	  else if(State == STATE.Dead){
		  g.setColor(Color.black);
		  
		  g.drawImage(gameover, 0,0,this);
		  Font f1 = new Font("arial",Font.BOLD,20);
		  g.setColor(Color.white);
		  g.setFont(f1);
		  g.drawString("GAME OVER", 350, 300);
		 
		  g.drawString("SCORE : " + Mario.score,355 , 330);
		  g.drawString("PRESS ESCAPE TO QUIT",292, 360);
		  
		  
	  } 
	  
	  else if(State == STATE.GameOver){
		  g.setColor(Color.black);
		  
		  g.drawImage(gameover, 0,0,this);
		  Font f1 = new Font("arial",Font.BOLD,20);
		  g.setColor(Color.white);
		  g.setFont(f1);
		  g.drawString("CONGRATULATIONS!", 300, 300);
		  g.drawString("YOU HAVE RESCUED THE PRINCESS!", 235, 330);
		  g.drawString("YOUR QUEST IS OVER :)", 290, 360);
		  g.drawString("SCORE : " + Mario.score ,345 , 390);
		  g.drawString("PRESS ESCAPE TO QUIT",286, 420);
		  
	  }
	
	  g.dispose();
	  bs.show();  
  }
  
  
  
//Game thread
public synchronized void start(){
	 if(running)return;
	  
	  running = true;
	  t = new Thread(this);
	  t.start();
}
  
//Gets the instance of the Texture
public static Texture getInstance(){
	  return tex;
}

public static void main(String[] args){
	 new Window(800,600,"Super Mario Bros",new Main());
  }
}
