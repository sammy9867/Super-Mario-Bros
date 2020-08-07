package main.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.sprite.ImageLoader;
import main.state.GameState;

public class MainMenu extends Canvas{

	private static final long serialVersionUID = 1L;
	public int selected = 0;
	
	public void render(Graphics g) {
		g.drawImage(ImageLoader.loadImage("res/image/menu.jpg"), 0, 0, this);
		
		Font f1 = new Font("arial",Font.BOLD, 30);
		Font f2 = new Font("arial",Font.BOLD, 30);
		
		if(selected == 0) {
			g.setFont(f1);
		    g.drawString("Play", GameState.WIDTH/2 - 100 + 19, 380);
		    g.setColor(Color.white);
		}
		
		g.setFont(f1);
		g.drawString("Play", GameState.WIDTH/2 - 100 + 19, 380);
		g.setColor(Color.black);
		
		
		if(selected == 1) {
			g.setFont(f2);
		    g.drawString("Quit", GameState.WIDTH/2 - 100 + 19, 430); 
		    g.setColor(Color.white);
		} 
		
		g.setFont(f2);
		g.drawString("Quit", GameState.WIDTH/2 - 100 + 19, 430);
		g.setColor(Color.black);
	}
}
