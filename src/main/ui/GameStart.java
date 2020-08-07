package main.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import main.entity.BaseEntityHandler;
import main.state.GameState;
import main.util.Camera;
import main.util.Time;

import java.awt.image.BufferedImage;

public class GameStart extends Canvas {
	
	private static final long serialVersionUID = 1L;

	public void render(BaseEntityHandler baseEntityHandler, Graphics g, Graphics2D g2d, Camera camera) {
		
		setBackgroundColorForLevel(g, GameState.level);
		
		Font f1 = new Font("arial", Font.BOLD, 20);
		g.setColor(Color.white);
		g.setFont(f1);
		g.drawString("MARIO", 50, 20);
		g.drawString("" + GameState.score, 50, 40);
		  
		g.drawString("COINS", 150, 20);
		g.drawString("" + GameState.coins, 150, 40);
		  
		g.drawString("WORLD", 250, 20);
		g.drawString(" 1 - " + GameState.level, 260, 40);
		  
		g.drawString("TIME", 350, 20);
		g.drawString("" + Time.time, 350, 40);
		
		g2d.translate(camera.getX(),camera.getY());
		setBackgroundImagesForLevel(g, GameState.level);
		
		baseEntityHandler.render(g);
		g2d.translate(-camera.getX(),-camera.getY());
	}
	
	private void setBackgroundColorForLevel(Graphics g, int level) {
		switch(level) {
			case 1:
				g.setColor(new Color(93,148,251));
				g.fillRect(0, 0, GameState.WIDTH, GameState.HEIGHT);
				break;
			case 2:
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, GameState.WIDTH, GameState.HEIGHT);
				break;
			case 3:
				g.setColor(new Color(128,218,235));
				g.fillRect(0, 0, GameState.WIDTH, GameState.HEIGHT);
				break;
			case 4:
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, GameState.WIDTH, GameState.HEIGHT);
				break;
		}
	}
	
	private void setBackgroundImagesForLevel(Graphics g, int level) {
		BufferedImage[] images = GameState.getBackgroundImages();
		switch(level) {
			case 1:				
				for(int i = 0;i < images[0].getWidth()*80; i+= images[0].getWidth()*5) { g.drawImage(images[0],i,100,this); }//cloud1
				for(int i = 0;i < images[1].getWidth()*80; i+= images[1].getWidth()*6) { g.drawImage(images[1],i + 200,160,this);} //cloud2);
				
				for(int i = 0;i < images[2].getWidth()*500; i+= images[2].getWidth()*6) { g.drawImage(images[2],i + 20,377,this); }//hill1
				g.drawImage(images[3],600,400,this);
				g.drawImage(images[3],1000,400,this);
				g.drawImage(images[3],2000,400,this);
				g.drawImage(images[3],3800,400,this);
				  
				g.drawImage(images[4],360,450,this);
				g.drawImage(images[4],2400,450,this);
				  
				g.drawImage(images[5],1280,470,this);
				g.drawImage(images[5],2200,470,this);
				
				g.drawImage(images[7],5000,335,this);
				break;
			case 3:
				for(int i = 0;i < images[0].getWidth()*80; i+= images[0].getWidth()*5) { g.drawImage(images[0],i,80,this); }//cloud1
				for(int i = 0;i < images[1].getWidth()*80; i+= images[1].getWidth()*6) { g.drawImage(images[1],i + 200,140,this);} //cloud2);

				g.drawImage(images[6],660,470,this);
				g.drawImage(images[6],1000,470,this);
				g.drawImage(images[6],2000,470,this);
				g.drawImage(images[6],2600,470,this);
				g.drawImage(images[6],3000,470,this);
				g.drawImage(images[6],3500,470,this);
				break;
		}
	}
}
