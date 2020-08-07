package main.entity.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.entity.BaseEntity;
import main.entity.BaseEntityHandler;
import main.sprite.Texture;
import main.state.GameState;
import main.util.Animation;
import main.entity.BaseEntityId;

public class MarioFireBall extends BaseEntity {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	
	private static final int SPEED = 3;
	private BaseEntityHandler baseEntityHandler;
	private Texture texture = GameState.getInstance();
	private Animation fireBallAnimation;
	

	public MarioFireBall(BaseEntityId id, int x, int y, int velocityX, BaseEntityHandler baseEntityHandler) {
		super(id, x, y);
		this.baseEntityHandler = baseEntityHandler;
		this.velocityX = velocityX;
		fireBallAnimation = new Animation(SPEED, texture.marioFireBall[0], texture.marioFireBall[1], 
				texture.marioFireBall[2], texture.marioFireBall[3]);
	}

	@Override
	public void render(Graphics g) {	
		fireBallAnimation.drawAnimation(g, (int)x, (int)y, (int)30f, (int)30f);
	}

	@Override
	public void movement(ArrayList<BaseEntity> baseEntities) {
		x += velocityX;
		fireBallAnimation.runAnimation();
		checkCollision();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)((int)x+ (WIDTH/2) -((WIDTH/2)/2)), (int)((int)y+ (HEIGHT/2))-(int)1f, (int)WIDTH/2, (int)HEIGHT/2 - 4);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int)((int)x+ (WIDTH/2) -((WIDTH/2)/2)), (int)y+2,(int)WIDTH/2, (int)HEIGHT/2);
	}
	
	@SuppressWarnings("incomplete-switch")
	private void checkCollision() {
		for(int i = 0; i < baseEntityHandler.baseEntities.size(); i++) {
			BaseEntity baseEntity = baseEntityHandler.baseEntities.get(i);
			if(baseEntity.getId() == BaseEntityId.Block || baseEntity.getId() == BaseEntityId.Pipe
		|| baseEntity.getId() == BaseEntityId.BulletBill || baseEntity.getId() == BaseEntityId.LavaBubble) { 
				if(getBounds().intersects(baseEntity.getBounds())
			|| getBoundsTop().intersects(baseEntity.getBounds())) {
					baseEntityHandler.removeEntity(this);
				}
				
			}else if(baseEntity.getId() == BaseEntityId.Goomba || baseEntity.getId() == BaseEntityId.KoopaTroopa ||
					baseEntity.getId() == BaseEntityId.BuzzyBeetle || baseEntity.getId() == BaseEntityId.Spiny ||
					baseEntity.getId() == BaseEntityId.PiranhaPlant) {
				if(getBounds().intersects(baseEntity.getBounds())
						|| getBoundsTop().intersects(baseEntity.getBounds())) {
					baseEntityHandler.removeEntity(baseEntity);
					baseEntityHandler.removeEntity(this);
					switch(baseEntity.getId()) {
						case Goomba:
							GameState.score += 10;
							break;
						case KoopaTroopa:
							GameState.score += 15;
							break;
						case BuzzyBeetle:
							GameState.score += 20;
							break;
						case Spiny:
							GameState.score += 25;
							break;
						case PiranhaPlant:
							GameState.score += 25;
							break;
					}
				}
					
			}
		}
	}
}
