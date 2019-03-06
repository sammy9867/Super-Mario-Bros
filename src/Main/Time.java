package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import AudioPlayer.Audio;

/**
 * This class represents the Timer of the game.
 * Mario will have only 60 seconds to complete each level.
 * @author Samuel Menezes
 */
public class Time implements ActionListener{
public Timer t;
public static int time = 60;

public Time(){ 
  t = new Timer(1000,this);
  t.start();
}

public void actionPerformed(ActionEvent e){
if(Main.State == Main.STATE.Game){
	if(time > 0)
		time --;
}
	
if(time == 0){
	Audio.getSound("level").stop();
	t.stop();
	Main.State = Main.STATE.Dead;
	Audio.getSound("mdead").play();
}
	
if(time == 0 && Audio.getSound("level2").playing()){
    Audio.getSound("level2").stop();
	t.stop();
	Main.State = Main.STATE.Dead;
    Audio.getSound("mdead").play();
}
	
if(time == 0 && Audio.getSound("level4").playing()){
	Audio.getSound("level4").stop();
	t.stop();
	Main.State = Main.STATE.Dead;
	Audio.getSound("mdead").play();
}
}

//Once the level is switched, the timer is restarted.
public void restart(){
	if(time < 60)
		time = 60;
}
}
