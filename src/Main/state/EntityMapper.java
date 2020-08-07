package main.state;

import java.util.HashMap;
import java.util.Map;


public class EntityMapper {

	public Map<Integer, EntityID> entityMap = new HashMap<>();
	
	public int rgbToInt(int red, int green, int blue) {
		return (red << 16) | (green << 8) | blue;
	}
		
	public void init() {
		entityMap.put(rgbToInt(0, 0, 255), EntityID.Mario);
		entityMap.put(rgbToInt(190, 150, 150), EntityID.Goomba);
		entityMap.put(rgbToInt(100, 100, 10), EntityID.KoopaTroopa);
		entityMap.put(rgbToInt(100, 100, 20), EntityID.BuzzyBeetle);
		entityMap.put(rgbToInt(100, 100, 30), EntityID.Spiny);
		entityMap.put(rgbToInt(100, 100, 35), EntityID.PiranhaPlant);
		entityMap.put(rgbToInt(100, 100, 40), EntityID.LavaBubble);
		entityMap.put(rgbToInt(100, 100, 50), EntityID.BulletBill);
		entityMap.put(rgbToInt(255, 255, 255), EntityID.GroundLevel1Block);
		entityMap.put(rgbToInt(0, 38, 255), EntityID.BrickLevel1Block);
		entityMap.put(rgbToInt(128, 128, 128), EntityID.SolidLevel1Block);
		entityMap.put(rgbToInt(140, 140, 140), EntityID.GroundLevel2Block);
		entityMap.put(rgbToInt(100, 100, 100), EntityID.BrickLevel2Block);
		entityMap.put(rgbToInt(150, 150, 150), EntityID.SolidLevel2Block);
		entityMap.put(rgbToInt(170, 170, 170), EntityID.GroundLevel3Block);
		entityMap.put(rgbToInt(160, 160, 160), EntityID.BrickLevel3Block);
		entityMap.put(rgbToInt(180, 180, 180), EntityID.SolidLevel3Block);
		entityMap.put(rgbToInt(240, 240, 240), EntityID.GroundLevel4Block);
		entityMap.put(rgbToInt(250, 245, 240), EntityID.SolidLevel4Block);
		entityMap.put(rgbToInt(245, 245, 245), EntityID.BridgeLevel4Block);
		entityMap.put(rgbToInt(255, 5, 0), EntityID.QuestionBlock);
		entityMap.put(rgbToInt(250, 70, 70), EntityID.BBCanonTopBlock);
		entityMap.put(rgbToInt(250, 80, 80), EntityID.BBCanonBottomBlock);
		entityMap.put(rgbToInt(250, 40, 40),EntityID.FlagTopBlock);
		entityMap.put(rgbToInt(250, 50, 50), EntityID.FlagBottomBlock);
		entityMap.put(rgbToInt(130, 230, 130), EntityID.PrincessBlock);
		entityMap.put(rgbToInt(250, 60, 60), EntityID.PitLevel1Block);
		entityMap.put(rgbToInt(250, 65, 65), EntityID.PitLevel2Block);
		entityMap.put(rgbToInt(220, 220, 220), EntityID.WaterTopBlock);
		entityMap.put(rgbToInt(225, 225, 225), EntityID.WaterBottomBlock);
		entityMap.put(rgbToInt(230, 230, 230), EntityID.LavaTopBlock);
		entityMap.put(rgbToInt(235, 235, 235), EntityID.LavaBottomBlock);
		entityMap.put(rgbToInt(255, 216, 0), EntityID.NextLevelBlock);
		entityMap.put(rgbToInt(120, 120, 120), EntityID.TopL12LeftPipe);
		entityMap.put(rgbToInt(130, 120, 120), EntityID.TopL12RightPipe);
		entityMap.put(rgbToInt(125, 120, 120), EntityID.BottomL12LeftPipe);
		entityMap.put(rgbToInt(135, 120, 120), EntityID.BottomL12RightPipe);
		entityMap.put(rgbToInt(200, 200, 200), EntityID.TopL3LeftPipe);
		entityMap.put(rgbToInt(205, 205, 205), EntityID.TopL3RightPipe);
		entityMap.put(rgbToInt(210, 210, 210), EntityID.BottomL3LeftPipe);
		entityMap.put(rgbToInt(215, 215, 215), EntityID.BottomL3RightPipe);
		entityMap.put(rgbToInt(250, 250, 250), EntityID.TopL4LeftPipe);
		entityMap.put(rgbToInt(250, 120, 120), EntityID.TopL4RightPipe);
		entityMap.put(rgbToInt(250, 130, 130), EntityID.BottomL4LeftPipe);
		entityMap.put(rgbToInt(250, 140, 140), EntityID.BottomL4RightPipe);
		entityMap.put(rgbToInt(200, 200, 0), EntityID.Coin);
	}

}
