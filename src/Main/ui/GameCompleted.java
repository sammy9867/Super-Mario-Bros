package main.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.sprite.ImageLoader;
import main.state.GameState;

public class GameCompleted extends Canvas {
	
	private static final long serialVersionUID = 1L;

	public void render(Graphics g) {
		 g.drawImage(ImageLoader.loadImage("res/image/game_end.png"), 0, 0, this);
		 Font f1 = new Font("arial", Font.BOLD, 20);
		 g.setColor(Color.white);
		 g.setFont(f1);
		 g.drawString("CONGRATULATIONS!", 300, 300);
		 g.drawString("YOU HAVE RESCUED THE PRINCESS!", 235, 330);
		 g.drawString("YOUR QUEST IS OVER :)", 290, 360);
		 g.drawString("SCORE : " + GameState.score ,345 , 390);
		 g.drawString("PRESS ESCAPE TO QUIT", 286, 420);
	}

}
