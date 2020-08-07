package main.state;

import java.awt.image.BufferedImage;

import main.audio.Audio;
import main.sprite.ImageLoader;
import main.util.Camera;
import main.entity.*;
import main.entity.enemy.*;
import main.entity.object.Block;
import main.entity.object.Coin;
import main.entity.object.Pipe;
import main.entity.player.*;

public class Level {

	private BaseEntityHandler baseEntityHandler;
	private Camera camera;
	private EntityMapper entityMapper = new EntityMapper();
	
	public Level(BaseEntityHandler baseEntityHandler, Camera camera) {
		this.baseEntityHandler = baseEntityHandler;
		this.camera = camera;
		
		entityMapper.init();
	}


	public void switchLevel() {
		baseEntityHandler.clearEntities(); 
		camera.setX(0);
		GameState.level++;
		switch(GameState.level) {
			case 2:
				Audio.getMusicForLevel("level1").stop();
				loadEntitiesForLevel(ImageLoader.loadImage("res/image/level2.png"));
				Audio.getMusicForLevel("level2").play(true);
				break;
			case 3:
				Audio.getMusicForLevel("level2").stop();
				loadEntitiesForLevel(ImageLoader.loadImage("res/image/level3.png"));
				Audio.getMusicForLevel("level3").play(true);
				break;
			case 4:
				Audio.getMusicForLevel("level3").stop();
				loadEntitiesForLevel(ImageLoader.loadImage("res/image/level4.png"));
				Audio.getMusicForLevel("level4").play(true);
				break;
			case 5:
				Audio.getMusicForLevel("level4").stop();
				GameState.state = GameState.STATE.GameCompleted;
				Audio.getSound("gameCompleted").play();
				break;
		}	
	}
	
	public void loadEntitiesForLevel(BufferedImage image) {
		int height = image.getHeight();
		int width = image.getWidth();
		
		EntityID entityID = EntityID.Mario;
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++) {
				int pixel = image.getRGB(i,j);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel)  & 0xff;
				
				int rgb = entityMapper.rgbToInt(red, green, blue);
				entityID = entityMapper.entityMap.get(rgb);
				
				if(entityID != null) {
					switch(entityID) {
						case Mario:
							baseEntityHandler.addEntity(new Mario(BaseEntityId.Mario, i*32, j*32, baseEntityHandler, this));
							break;
						case Goomba:
							baseEntityHandler.addEntity(new Goomba(BaseEntityId.Goomba, i*32, j*32, baseEntityHandler));
							break;
						case KoopaTroopa:
							baseEntityHandler.addEntity(new KoopaTroopa(BaseEntityId.KoopaTroopa, i*32, j*32, baseEntityHandler));
							break;
						case BuzzyBeetle:
							baseEntityHandler.addEntity(new BuzzyBeetle(BaseEntityId.BuzzyBeetle, i*32, j*32, baseEntityHandler));
							break;
						case Spiny:
							baseEntityHandler.addEntity(new Spiny(BaseEntityId.Spiny, i*32, j*32, baseEntityHandler));
							break;
						case PiranhaPlant:
							baseEntityHandler.addEntity(new PiranhaPlant(BaseEntityId.PiranhaPlant, i*32, j*32));
							break;
						case LavaBubble:
							baseEntityHandler.addEntity(new LavaBubble(BaseEntityId.LavaBubble, i*32, j*32));
							break;
						case BulletBill:
							baseEntityHandler.addEntity(new BulletBill(BaseEntityId.BulletBill, i*32, j*32));
							break;
						case GroundLevel1Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "groundLevel1"));
							break;
						case BrickLevel1Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "brickLevel1"));
							break;
						case SolidLevel1Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "solidLevel1"));
							break;
						case GroundLevel2Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "groundLevel2"));
							break;
						case BrickLevel2Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "brickLevel2"));
							break;
						case SolidLevel2Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "solidLevel2"));
							break;
						case GroundLevel3Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "groundLevel3"));
							break;
						case BrickLevel3Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "brickLevel3"));
							break;
						case SolidLevel3Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "solidLevel3"));
							break;
						case GroundLevel4Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "groundLevel4"));
							break;
						case SolidLevel4Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "solidLevel4"));
							break;
						case BridgeLevel4Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "bridgeLevel4"));
							break;
						case QuestionBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "question"));
							break;
						case BBCanonTopBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "bulletBillCannonTop"));
							break;
						case BBCanonBottomBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "bulletBillCannonBottom"));
							break;
						case FlagTopBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "flagTop"));
							break;
						case FlagBottomBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "flagBottom"));
							break;
						case PrincessBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Block, i*32, j*32, "princess"));
							break;
						case PitLevel1Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.PitLevel1, i*32, j*32, "pitLevel1"));
							break;
						case PitLevel2Block:
							baseEntityHandler.addEntity(new Block(BaseEntityId.PitLevel2, i*32, j*32, "pitLevel2"));
							break;
						case WaterTopBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Water, i*32, j*32, "waterTop"));
							break;
						case WaterBottomBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Water, i*32, j*32, "waterBottom"));
							break;
						case LavaTopBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Lava, i*32, j*32, "lavaTop"));
							break;
						case LavaBottomBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.Lava, i*32, j*32, "lavaBottom"));
							break;
						case NextLevelBlock:
							baseEntityHandler.addEntity(new Block(BaseEntityId.NextLevel, i*32, j*32, "level"));
							break;
						case TopL12LeftPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "topLevel1-2Left"));
							break;
						case TopL12RightPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "topLevel1-2Right"));
							break;
						case BottomL12LeftPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "bottomLevel1-2Left"));
							break;
						case BottomL12RightPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "bottomLevel1-2Right"));
							break;
						case TopL3LeftPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "topLevel3Left"));
							break;
						case TopL3RightPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "topLevel3Right"));
							break;
						case BottomL3LeftPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "bottomLevel3Left"));
							break;
						case BottomL3RightPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "bottomLevel3Right"));
							break;
						case TopL4LeftPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "topLevel4Left"));
							break;
						case TopL4RightPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "topLevel4Right"));
							break;
						case BottomL4LeftPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "bottomLevel4Left"));
							break;
						case BottomL4RightPipe:
							baseEntityHandler.addEntity(new Pipe(BaseEntityId.Pipe, i*32, j*32, "bottomLevel4Right"));
							break;
						case Coin:
							baseEntityHandler.addEntity(new Coin(BaseEntityId.Coin, i*32, j*32));
							break;
					}	
				}
				
			}
		}
	}
	
}
