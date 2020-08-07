package main.ui;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import main.audio.Audio;
import main.state.GameState;

public class Window {

	public Window(String title, int width, int height, GameState gameState) {
		gameState.setPreferredSize(new Dimension(width, height));
		gameState.setMaximumSize(new Dimension(width, height));
		gameState.setMinimumSize(new Dimension(width, height));
		
		JFrame f = new JFrame(title);
		f.add(gameState);
		f.pack();
		
		f.addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent e){ 
				Audio.destory();
				GameState.stop();
				System.exit(0);
			}
		});
		
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		Audio.init();
		gameState.start();
	}
}
