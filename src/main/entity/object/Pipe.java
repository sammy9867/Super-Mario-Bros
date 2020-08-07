package main.entity.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.entity.BaseEntity;
import main.sprite.Texture;
import main.state.GameState;
import main.entity.BaseEntityId;

public class Pipe extends BaseEntity {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	
	private String type;
	private Texture texture = GameState.getInstance();

	public Pipe(BaseEntityId id, int x, int y, String type) {
		super(id, x, y);	
		this.type = type;
	}

	@Override
	public void render(Graphics g) {	
		if(type.equals("topLevel1-2Left")) g.drawImage(texture.pipe[0], (int) x, (int)y, null);
		if(type.equals("topLevel1-2Right")) g.drawImage(texture.pipe[1], (int) x, (int)y, null);
		if(type.equals("bottomLevel1-2Left")) g.drawImage(texture.pipe[2], (int) x, (int)y, null);
		if(type.equals("bottomLevel1-2Right")) g.drawImage(texture.pipe[3], (int) x, (int)y, null);
		if(type.equals("topLevel3Left")) g.drawImage(texture.pipe[4], (int) x, (int)y, null);
		if(type.equals("topLevel3Right")) g.drawImage(texture.pipe[5], (int) x, (int)y, null);
		if(type.equals("bottomLevel3Left")) g.drawImage(texture.pipe[6], (int) x, (int)y, null);
		if(type.equals("bottomLevel3Right")) g.drawImage(texture.pipe[7], (int) x, (int)y, null);
		if(type.equals("topLevel4Left")) g.drawImage(texture.pipe[8], (int) x, (int)y, null);
		if(type.equals("topLevel4Right")) g.drawImage(texture.pipe[9], (int) x, (int)y, null);
		if(type.equals("bottomLevel4Left")) g.drawImage(texture.pipe[10], (int) x, (int)y, null);
		if(type.equals("bottomLevel4Right")) g.drawImage(texture.pipe[11], (int) x, (int)y, null);
	}

	@Override
	public void movement(ArrayList<BaseEntity> baseEntities) {}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
	}
}
