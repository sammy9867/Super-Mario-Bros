package main.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import main.audio.Audio;
import main.state.GameState;

public class Time implements ActionListener {

	private Timer timer;
	public static int time = 60;
	
	public Time() {
		timer = new Timer(1000, this);
	}
	
	public void startTime() {
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(GameState.state == GameState.STATE.GameStart) {
			if(time > 0) time--;
			else {
				timer.stop();
				Audio.getMusicForLevel("level" + GameState.level).stop();
				GameState.state = GameState.STATE.GameOver;
				Audio.getSound("marioDead").play();
			}	
		}
	}
	
	public void restartTime() {
		if(time < 60) time = 60;
	}
	
}
