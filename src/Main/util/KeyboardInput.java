package main.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.audio.Audio;
import main.entity.BaseEntity;
import main.entity.BaseEntityHandler;
import main.entity.BaseEntityId;
import main.entity.object.MarioFireBall;
import main.state.GameState;
import main.state.GameState.STATE;
import main.ui.MainMenu;

public class KeyboardInput extends KeyAdapter {

	private BaseEntityHandler baseEntityHandler;
	private MainMenu menu;
	public KeyboardInput(BaseEntityHandler baseEntityHandler, MainMenu menu) {
		this.baseEntityHandler = baseEntityHandler;
		this.menu = menu;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < baseEntityHandler.baseEntities.size(); i++) {
			BaseEntity baseEntity = baseEntityHandler.baseEntities.get(i);
			if(baseEntity.getId() == BaseEntityId.Mario && GameState.state == STATE.GameStart) { // AND MAIN STATE IS GAME RUNNING
				if(key == KeyEvent.VK_RIGHT) baseEntity.setVelocityX(5); 
				if(key == KeyEvent.VK_LEFT) baseEntity.setVelocityX(-5);
				
				if((key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) && !baseEntity.isJumping()) { 
					Audio.getSound("marioJump").play();
					baseEntity.setJumping(true); 
					baseEntity.setVelocityY(-11); // ADD THESE NUMBERS TO CONSTANT FILE
				}
			
				if(key == KeyEvent.VK_DOWN){ 
					Audio.getSound("marioFireBall").play();
					baseEntityHandler.addEntity(new MarioFireBall(BaseEntityId.MarioFireBall, (int) baseEntity.getX(), (int) baseEntity.getY(), baseEntity.getDirection()*7, baseEntityHandler));
				}	
			}
			
			
			if(GameState.state == STATE.MainMenu) {
				if(key == KeyEvent.VK_DOWN) menu.selected = 1;
				if(key == KeyEvent.VK_UP)   menu.selected = 0;
				
				if(key == KeyEvent.VK_ENTER && menu.selected == 0) GameState.state = GameState.STATE.GameStart;
				if(key == KeyEvent.VK_ENTER && menu.selected == 1){
					Audio.destory();
					GameState.stop();
					System.exit(1);
				}
			}
			
			if(GameState.state == STATE.GameOver || GameState.state == STATE.GameCompleted) {
				if(key == KeyEvent.VK_ESCAPE) {
					Audio.destory();
					GameState.stop();
					System.exit(1);
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < baseEntityHandler.baseEntities.size(); i++) {
			BaseEntity baseEntity = baseEntityHandler.baseEntities.get(i);
			if(baseEntity.getId() == BaseEntityId.Mario) {
				if(key == KeyEvent.VK_RIGHT) baseEntity.setVelocityX(0);
				if(key == KeyEvent.VK_LEFT) baseEntity.setVelocityX(0);	
			}
		}
	}

}
