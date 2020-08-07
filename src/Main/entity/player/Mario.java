package main.entity.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.audio.Audio;
import main.entity.BaseEntity;
import main.entity.BaseEntityHandler;
import main.entity.BaseEntityId;
import main.sprite.Texture;
import main.state.GameState;
import main.state.Level;
import main.util.Animation;

public class Mario extends BaseEntity{

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	private static final float MAX_SPEED = 10;
	private static final int MARIO_SPEED = 4;
	
	private BaseEntityHandler baseEntityHandler;
	private Level currentLevel;

	private Texture texture = GameState.getInstance();
	private Animation marioWalkLeft, marioWalkRight;
	
	public Mario(BaseEntityId id, int x, int y, BaseEntityHandler baseEntityHandler, Level currentLevel) {
		super(id, x, y);	
		this.baseEntityHandler = baseEntityHandler;
		this.currentLevel = currentLevel;
		marioWalkRight = new Animation(MARIO_SPEED, texture.mario[1], texture.mario[2], texture.mario[3]);
		marioWalkLeft = new Animation(MARIO_SPEED, texture.mario[6], texture.mario[7], texture.mario[8]);
	}

	@Override
	public void render(Graphics g) {
		if(jumping) { // Mario Jumping
			switch(direction) {
			case 1:
				g.drawImage(texture.mario[4], (int)x, (int)y, 38, 38, null);
				break;
			case -1:
				g.drawImage(texture.mario[9],(int)x, (int)y, 38, 38, null);
				break;
			}
		} else {
			if(velocityX != 0) { // Mario Walking
				switch(direction) {
				case 1:
					marioWalkRight.drawAnimation(g, (int)x, (int)y, 38, 38);
					break;
				case -1:
					marioWalkLeft.drawAnimation(g, (int)x, (int)y, 38, 38);
					break;
				}
			} else { // Mario Standing
				switch(direction) {
				case 1:
					g.drawImage(texture.mario[0], (int)x, (int)y, 38, 38, null);
					break;
				case -1:
					g.drawImage(texture.mario[5], (int)x, (int)y, 38, 38, null);
					break;
				}
			}
		}
		
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.red);
//		g2d.draw(getBounds());
//		g.setColor(Color.green);
//		g2d.draw(getBoundsTop());
//		g.setColor(Color.yellow);
//		g2d.draw(getBoundsLeft());
//		g.setColor(Color.black);
//		g2d.draw(getBoundsRight());
	}


	@Override
	public void movement(ArrayList<BaseEntity> baseEntities) {
		x +=  velocityX;
		y +=  velocityY;
		
		if(velocityX < 0) direction = -1;
		else if(velocityX > 0) direction = 1;
		
		if(falling || jumping) {
			velocityY += 0.5f; 
			if(velocityY > MAX_SPEED) velocityY = MAX_SPEED;
		}
		
		checkCollision();
		
		marioWalkLeft.runAnimation();
		marioWalkRight.runAnimation();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)((int)x+ (WIDTH/2) -((WIDTH/2)/2)),(int)((int)y+ (HEIGHT/2)),(int)WIDTH/2,(int)HEIGHT/2);
	}
		
	public Rectangle getBoundsTop() {
		return new Rectangle((int)((int)x+ (WIDTH/2) -((WIDTH/2)/2)),(int)y,(int)WIDTH/2,(int)HEIGHT/2);
	}
		
	public Rectangle getBoundsRight() {
		return new Rectangle((int)((int)x+ WIDTH - 5),(int)y + 5,(int)5,(int)HEIGHT -10);	
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x,(int)y + 5,(int)5,(int)HEIGHT - 10);
	}
	
	@SuppressWarnings("incomplete-switch")
	private void checkCollision() {
		for(int i = 0; i < baseEntityHandler.baseEntities.size(); i++) {
			BaseEntity baseEntity = baseEntityHandler.baseEntities.get(i);
			if(baseEntity.getId() == BaseEntityId.Block || baseEntity.getId() == BaseEntityId.Pipe) { 
				if(getBoundsTop().intersects(baseEntity.getBounds())) {
					y = baseEntity.getY() + HEIGHT;
					velocityY = 0;
					Audio.getSound("bump").play();
				}
				if(getBounds().intersects(baseEntity.getBounds())) {
					y = baseEntity.getY() - HEIGHT;
					velocityY = 0;
					falling = false;
					jumping = false;	
				} else {
					falling = true;
				}
				
				if(getBoundsRight().intersects(baseEntity.getBounds())){
					x = baseEntity.getX() - WIDTH;
				}
				
				if(getBoundsLeft().intersects(baseEntity.getBounds())){
					x = baseEntity.getX() + WIDTH;
				}
			
				
			} else if(baseEntity.getId() == BaseEntityId.Coin) {
				if(getBounds().intersects(baseEntity.getBounds())) {
					baseEntityHandler.removeEntity(baseEntity);
					Audio.getSound("coin").play();
					GameState.score += 10;
					GameState.coins++;
				}
				
			} else if(baseEntity.getId() == BaseEntityId.NextLevel) {
				if(getBounds().intersects(baseEntity.getBounds())) {
					currentLevel.switchLevel();
					GameState.getTime().restartTime();
				}
				
			} else if(baseEntity.getId() == BaseEntityId.PitLevel1 || 
					baseEntity.getId() == BaseEntityId.PitLevel2 ||
					baseEntity.getId() == BaseEntityId.Water ||
					baseEntity.getId() == BaseEntityId.Lava) {
				
				if(getBounds().intersects(baseEntity.getBounds())) {
					switch(baseEntity.getId()) {
						case PitLevel1:
							Audio.getMusicForLevel("level1").stop();
							break;
						case PitLevel2:
							Audio.getMusicForLevel("level2").stop();
							break;
						case Water:
							Audio.getMusicForLevel("level3").stop();
							break;
						case Lava:
							Audio.getMusicForLevel("level4").stop();
							break;
					}
					
					GameState.state = GameState.STATE.GameOver;
					Audio.getSound("marioDead").play();
				}
			} else if(baseEntity.getId() == BaseEntityId.Goomba || baseEntity.getId() == BaseEntityId.KoopaTroopa ||
					baseEntity.getId() == BaseEntityId.BuzzyBeetle || baseEntity.getId() == BaseEntityId.Spiny ||
					baseEntity.getId() == BaseEntityId.BulletBill || baseEntity.getId() == BaseEntityId.PiranhaPlant ||
					baseEntity.getId() == BaseEntityId.LavaBubble) {
				
				if(getBoundsLeft().intersects(baseEntity.getBounds()) ||
				getBoundsRight().intersects(baseEntity.getBounds()) ||
				getBoundsTop().intersects(baseEntity.getBounds()) ||
				getBounds().intersects(baseEntity.getBounds())) {
					Audio.getMusicForLevel("level" + GameState.level).stop();
					GameState.state = GameState.STATE.GameOver;
					Audio.getSound("marioDead").play();
				}
				
			}
		}
	}

}
