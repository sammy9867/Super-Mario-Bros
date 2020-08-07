package main.entity.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.entity.BaseEntity;
import main.sprite.Texture;
import main.state.GameState;
import main.entity.BaseEntityId;

public class Coin extends BaseEntity {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	
	private Texture texture = GameState.getInstance();

	public Coin(BaseEntityId id, int x, int y) {
		super(id, x, y);
	}

	@Override
	public void render(Graphics g) {	
		g.drawImage(texture.coin[0], (int) x, (int) y, null);
	}

	@Override
	public void movement(ArrayList<BaseEntity> baseEntities) {}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, WIDTH, HEIGHT);
	}
}
