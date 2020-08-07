package main.entity.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.entity.BaseEntity;
import main.sprite.Texture;
import main.state.GameState;
import main.entity.BaseEntityId;

public class LavaBubble extends BaseEntity {

	private static final int WIDTH = 40;
	private static final int HEIGHT = 35;

	private Texture texture = GameState.getInstance();
	
	public LavaBubble(BaseEntityId id, int x, int y) {
		super(id, x, y);	
		velocityY = 7;
	}

	@Override
	public void render(Graphics g) {	
		if(velocityY < 0) g.drawImage(texture.lavaBubble[1],(int)x,(int)y ,null);
		else if(velocityY > 0)  g.drawImage(texture.lavaBubble[0],(int)x,(int)y,null);
	}

	@Override
	public void movement(ArrayList<BaseEntity> baseEntities) {
		x += velocityX;
		y += velocityY;
		
		if(y <= 185 || y >= GameState.HEIGHT - 32) velocityY *= -1;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)((int)x+ (WIDTH/2) -((WIDTH/2)/2)),(int)((int)y+ (HEIGHT/2)),(int)WIDTH/2,(int)HEIGHT/2);
	}

}
