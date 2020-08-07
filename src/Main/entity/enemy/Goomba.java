package main.entity.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.entity.BaseEntity;
import main.entity.BaseEntityHandler;
import main.sprite.Texture;
import main.state.GameState;
import main.util.Animation;
import main.entity.BaseEntityId;

public class Goomba extends BaseEntity {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	private static final float MAX_SPEED = 3f;
	private static final int GOOMBA_SPEED = 10;
	
	private BaseEntityHandler baseEntityHandler;
	
	private Texture texture = GameState.getInstance();
	private Animation goombaWalkLeft, goombaWalkRight;
	
	public Goomba(BaseEntityId id, int x, int y, BaseEntityHandler baseEntityHandler) {
		super(id, x, y);	
		this.baseEntityHandler = baseEntityHandler;	
		goombaWalkLeft = new Animation(GOOMBA_SPEED, texture.goomba[0], texture.goomba[1]);
		goombaWalkRight = new Animation(GOOMBA_SPEED, texture.goomba[1], texture.goomba[0]);
		velocityX = 1;
	}


	@Override
	public void render(Graphics g) {	
		if(velocityX != 0) {
			if(direction == 1) {
				goombaWalkRight.drawAnimation(g,(int)x, (int)y, 38, 38);
			} else {
				goombaWalkLeft.drawAnimation(g, (int)x, (int)y, 38, 38);
			}
		}
	}


	@Override
	public void movement(ArrayList<BaseEntity> baseEntities) {
		x += velocityX;
		y += velocityY;
		
		// WHAT?
		if(falling || jumping) {
			velocityY += 0.5f; 
			if(velocityY > MAX_SPEED) velocityY = MAX_SPEED;
		}
		
		checkCollision();
		
		goombaWalkLeft.runAnimation();
		goombaWalkRight.runAnimation();
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
	
	private void checkCollision() {
		for(int i = 0; i < baseEntityHandler.baseEntities.size(); i++) {
			BaseEntity baseEntity = baseEntityHandler.baseEntities.get(i);
			if(baseEntity.getId() == BaseEntityId.Block || baseEntity.getId() == BaseEntityId.Pipe) { 
				
				if(getBounds().intersects(baseEntity.getBounds())) {
					y = baseEntity.getY() - HEIGHT;
					velocityY = 0;
					falling = false;
					jumping = false;	
				} else {
					falling = true;
				}
				
				if(getBoundsRight().intersects(baseEntity.getBounds())){
			        setDirection(-1);
					velocityX *= -1; 
				}
							
			    if(getBoundsLeft().intersects(baseEntity.getBounds())){
					setDirection(1);
					velocityX *= -1;
				}
				
			} else if(baseEntity.getId() == BaseEntityId.Goomba || baseEntity.getId() == BaseEntityId.KoopaTroopa ||
					baseEntity.getId() == BaseEntityId.BuzzyBeetle || baseEntity.getId() == BaseEntityId.Spiny) {
				if(getBoundsRight().intersects(baseEntity.getBounds())){
			        setDirection(-1);
					velocityX *= -1; 
				}
							
			    if(getBoundsLeft().intersects(baseEntity.getBounds())){
					setDirection(1);
					velocityX *= -1;
				}
			}  else if(baseEntity.getId() == BaseEntityId.PitLevel1 || 
					baseEntity.getId() == BaseEntityId.PitLevel2 ||
					baseEntity.getId() == BaseEntityId.Water ||
					baseEntity.getId() == BaseEntityId.Lava) {
				
				if(getBounds().intersects(baseEntity.getBounds())) {
					baseEntityHandler.removeEntity(this);
				}
			}
		}
		
	}

}
