package Objects;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import AudioPlayer.Audio;
import Main.Handler;
import Main.Main;
import Main.Main.STATE;
import Main.MenuSystem;
import org.lwjgl.openal.AL;

/**
 * This class is responsible for all the KeyInputs required when one is in the Menu, for moving mario, and to leave the game.
 * @author Samuel Menezes
 */
public class KeyInput extends KeyAdapter {
private Handler handler;
private MenuSystem menu;

public KeyInput(Handler handler,MenuSystem menu){
    this.handler = handler;
	this.menu = menu;
}
	
public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();
	 for(int i = 0; i < handler.obj.size(); i++){
		Objects tempobj = handler.obj.get(i);
		if(tempobj.getId() == ObjectId.Player && Main.State == STATE.Game){
	            if(key == KeyEvent.VK_RIGHT) tempobj.setVelX(5); //Moving Mario to the right.
				if(key == KeyEvent.VK_LEFT) tempobj.setVelX(-5); //Moving Mario to the left.
				if((key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP)&& !tempobj.isJumping()){ // For Mario to jump.
					Audio.getSound("jump").play();
					tempobj.setJumping(true); 
					tempobj.setVelY(-11);
				}
				if(key == KeyEvent.VK_DOWN){ //Mario throws a fireball.
					Audio.getSound("fball").play();
					handler.addObject(new MarioFireBall(tempobj.getX(),tempobj.getY() + 5,ObjectId.MFireBall,tempobj.getDirection()*7,handler));
				}	
		}

		if(Main.State == STATE.Menu){ //To select an option on the Menu.
				if(key == KeyEvent.VK_DOWN) menu.setSelected(1);
				if(key == KeyEvent.VK_UP)   menu.setSelected(0);
				
				if(key == KeyEvent.VK_ENTER && menu.getSelected() == 0) Main.State = Main.STATE.Game;
				if(key == KeyEvent.VK_ENTER && menu.getSelected() == 1){
					AL.destroy();
					System.exit(1);
				}
		}
	}
			
		//Press escape if you died in the game inorder to leave it.
		if(Main.State == STATE.Dead){
				if(key == KeyEvent.VK_ESCAPE){
					AL.destroy();
					System.exit(1);
					}
        }
			
		//Press escape if you finish the game inorder to leave it.
        if(Main.State == STATE.GameOver){
				if(key == KeyEvent.VK_ESCAPE){
					AL.destroy();
					System.exit(1);
					}
	     }
}
	
public void keyReleased(KeyEvent e){
      int key = e.getKeyCode();
		for(int i = 0; i < handler.obj.size(); i++){
			Objects tempobj = handler.obj.get(i);
			if(tempobj.getId() == ObjectId.Player){
				if(key == KeyEvent.VK_RIGHT) tempobj.setVelX(0);
				if(key == KeyEvent.VK_LEFT) tempobj.setVelX(0);	
			}
	     }
	}
	
}



