package main.entity.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import main.entity.BaseEntity;
import main.sprite.Texture;
import main.state.GameState;
import main.entity.BaseEntityId;

public class Block extends BaseEntity {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	
	private String type;
	private Texture texture = GameState.getInstance();

	public Block(BaseEntityId id, int x, int y, String type) {
		super(id, x, y);	
		this.type = type;
	}

	@Override
	public void render(Graphics g) {	
		switch(type) {
			case "groundLevel1":
				g.drawImage(texture.block[0], (int) x, (int)y, null);
				break;
			case "brickLevel1":
				g.drawImage(texture.block[1], (int) x, (int)y, null);
				break;
			case "solidLevel1":
				g.drawImage(texture.block[2], (int) x, (int)y, null);
				break;
			case "groundLevel2":
				g.drawImage(texture.block[3], (int) x, (int)y, null);
				break;
			case "brickLevel2":
				g.drawImage(texture.block[4], (int) x, (int)y, null);
				break;
			case "solidLevel2":
				g.drawImage(texture.block[5], (int) x, (int)y, null);
				break;
			case "groundLevel3":
				g.drawImage(texture.block[6], (int) x, (int)y, null);
				break;
			case "brickLevel3":
				g.drawImage(texture.block[7], (int) x, (int)y, null);
				break;
			case "solidLevel3":
				g.drawImage(texture.block[8], (int) x, (int)y, null);
				break;
			case "groundLevel4":
				g.drawImage(texture.block[9], (int) x, (int)y, null);
				break;
			case "solidLevel4":
				g.drawImage(texture.block[10], (int) x, (int)y, null);
				break;
			case "bridgeLevel4":
				g.drawImage(texture.block[11], (int) x, (int)y, null);
				break;
			case "question":
				g.drawImage(texture.block[12], (int) x, (int)y, null);
				break;
			case "bulletBillCannonTop":
				g.drawImage(texture.block[13], (int) x, (int)y, null);
				break;
			case "bulletBillCannonBottom":
				g.drawImage(texture.block[14], (int) x, (int)y, null);
				break;
			case "flagTop":
				g.drawImage(texture.block[15], (int) x, (int)y, null);
				break;
			case "flagBottom":
				g.drawImage(texture.block[16], (int) x, (int)y, null);
				break;
			case "princess":
				g.drawImage(texture.block[17], (int) x, (int)y, null);
				break;
			case "waterTop":
				g.drawImage(texture.block[18], (int) x, (int)y, null);
				break;
			case "waterBottom":
				g.drawImage(texture.block[19], (int) x, (int)y, null);
				break;
			case "lavaTop":
				g.drawImage(texture.block[20], (int) x, (int)y, null);
				break;
			case "lavaBottom":
				g.drawImage(texture.block[21], (int) x, (int)y, null);
				break;
		}
	}
		
	@Override
	public void movement(ArrayList<BaseEntity> baseEntities) {}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
	}
}
