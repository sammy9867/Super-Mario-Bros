package main.entity.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.entity.BaseEntity;
import main.sprite.Texture;
import main.state.GameState;
import main.util.Animation;
import main.entity.BaseEntityId;

public class PiranhaPlant extends BaseEntity {

	private static final int WIDTH = 40;
	private static final int HEIGHT = 35;
	private static final int PIRANHA_PLANT_SPEED = 7;
	
	
	private Texture texture = GameState.getInstance();
	private Animation piranhaPlantAnim;
	
	public PiranhaPlant(BaseEntityId id, int x, int y) {
		super(id, x, y);	
		piranhaPlantAnim = new Animation(PIRANHA_PLANT_SPEED, texture.piranhaPlant[1], texture.piranhaPlant[0]);
		velocityY = 1;
	}


	@Override
	public void render(Graphics g) {	
		if(velocityY < 0) g.drawImage(texture.piranhaPlant[0], (int)x, (int)y , null);
		else if(velocityY > 0) piranhaPlantAnim.drawAnimation(g, (int)x, (int)y);
	}


	@Override
	public void movement(ArrayList<BaseEntity> baseEntities) {
		x += velocityX;
		y += velocityY;
		
		if(y <= 329 || y >= GameState.HEIGHT - 170) velocityY *= -1;
		piranhaPlantAnim.runAnimation();
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)((int)x+ (WIDTH/2) -((WIDTH/2)/2)),(int)((int)y+ (HEIGHT/2)),(int)WIDTH/2,(int)HEIGHT/2);
	}

}
