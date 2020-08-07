package main.state;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import main.audio.Audio;
import main.entity.BaseEntity;
import main.entity.BaseEntityHandler;
import main.entity.BaseEntityId;
import main.sprite.ImageLoader;
import main.sprite.Texture;
import main.ui.GameCompleted;
import main.ui.GameOver;
import main.ui.GameStart;
import main.ui.MainMenu;
import main.util.Camera;
import main.util.KeyboardInput;
import main.util.Time;

public class GameState extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private Thread gameThread;
	private static boolean running = false;
	
	private BaseEntityHandler baseEntityHandler;
	private Camera camera;
	private Level currentLevel;
	
	private MainMenu menu;

	private static Texture texture;
	private static Time time;
	
	private static BufferedImage[] images = new BufferedImage[8];
	
	public static int WIDTH, HEIGHT;
	
	public static int score = 0;
	public static int coins = 0;
	public static int level = 1;
	
	public static enum STATE {
		MainMenu(),
		GameStart(),
		GameOver(),
		GameCompleted();
	}
	
	// Initial State
	public static STATE state = STATE.MainMenu;
			
	private void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		initBackgroundImages();
		
		texture = new Texture();
		time = new Time();
		
		Audio.init();
		camera = new Camera(0, 0);
		baseEntityHandler = new BaseEntityHandler();
		currentLevel = new Level(baseEntityHandler, camera);
		menu = new MainMenu();
		
		currentLevel.loadEntitiesForLevel(ImageLoader.loadImage("res/image/level1.png"));
		Audio.getMusicForLevel("level1").play(true);
		
		this.addKeyListener(new KeyboardInput(baseEntityHandler, menu));
	}
	
	private void initBackgroundImages() {
		images[0] = ImageLoader.loadImage("res/image/cloud1.png");
		images[1] = ImageLoader.loadImage("res/image/cloud2.png");
		
		images[2] = ImageLoader.loadImage("res/image/hill1.png");
		images[3] = ImageLoader.loadImage("res/image/hill2.png");
		
		images[4] = ImageLoader.loadImage("res/image/grass1.png");
		images[5] = ImageLoader.loadImage("res/image/grass2.png");
		images[6] = ImageLoader.loadImage("res/image/grass3.png");
		
		images[7] = ImageLoader.loadImage("res/image/castle.png");
	}
	
	private void render() {
		BufferStrategy bufferStrategy = this.getBufferStrategy();
		if(bufferStrategy == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bufferStrategy.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		// g2d.translate(camera.getX(), camera.getY()); //WHAT?
		switch(state) {
			case MainMenu:
				menu.render(g);
				break;
			case GameStart:
				GameStart gameStart =new GameStart();
				gameStart.render(baseEntityHandler, g, g2d, camera);
				time.startTime();
				break;
			case GameOver:
				GameOver gameOver = new GameOver();
				gameOver.render(g);
				break;
			case GameCompleted:
				GameCompleted gameCompleted = new GameCompleted();
				gameCompleted.render(g);
				break;
		}
		
		g.dispose();
		bufferStrategy.show(); 
	}
	
	private void movement() {
		if(state ==  STATE.GameStart) baseEntityHandler.movement();

		for(int i = 0; i < baseEntityHandler.baseEntities.size(); i++) {
			BaseEntity baseEntity = baseEntityHandler.baseEntities.get(i);
			if(baseEntity.getId() == BaseEntityId.Mario) {
				camera.movement(baseEntity);
			}
		}
	}
	

	@Override
	public void run() {
		
		init();
		this.requestFocus();
		long previous = System.nanoTime();
		double ticks = 75.0; 
		double ns = 1000000000/ticks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while(running) {
			long current = System.nanoTime();
			delta += (current - previous) / ns;
		    previous = current;
			while(delta >= 1){
				movement();
				delta--;
			}
			render();
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
			}
		}	
	}
	
	// Game thread
	public synchronized void start(){
		if (running) return;
		
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	public static synchronized void stop() {
		running = false;
	}
	
	public static Texture getInstance(){
		  return texture;
	}
	
	public static Time getTime() {
		  return time;
	}
	
	public static BufferedImage[] getBackgroundImages() {
		return images;
	}
}
