package main.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.sprite.ImageLoader;
import main.state.GameState;

public class GameOver extends Canvas {

	private static final long serialVersionUID = 1L;

	public void render(Graphics g) {
		g.drawImage(ImageLoader.loadImage("res/image/game_end.png"), 0, 0, this);
		Font f1 = new Font("arial",Font.BOLD,20);
		g.setColor(Color.white);
		g.setFont(f1);
		g.drawString("GAME OVER", 350, 300);
		g.drawString("SCORE : " + GameState.score, 355 , 330);
		g.drawString("PRESS ESCAPE TO QUIT", 292, 360);
	}
	
}
