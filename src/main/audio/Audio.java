package main.audio;

import java.util.HashMap;
import java.util.Map;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.Music;
import kuusisto.tinysound.TinySound;

public class Audio {
	
	private static Map<String, Music> levels = new HashMap<>();
	private static Map<String, Sound> sounds = new HashMap<>();

	
	// Method to initialize music and sound
	public static void init() {
		TinySound.init();
		try{
			levels.put("level1", TinySound.loadMusic("audio/level1.wav"));
			levels.put("level2", TinySound.loadMusic("audio/level2.wav"));
			levels.put("level3", TinySound.loadMusic("audio/level3.wav"));
			levels.put("level4", TinySound.loadMusic("audio/level4.wav"));
			
			sounds.put("coin", TinySound.loadSound("audio/coin.wav"));
			sounds.put("bump", TinySound.loadSound("audio/block_bump.wav"));
			sounds.put("stomp", TinySound.loadSound("audio/stomp.wav"));
			sounds.put("marioJump", TinySound.loadSound("audio/mario_jump.wav"));
			sounds.put("marioFireBall", TinySound.loadSound("audio/mario_fireball.wav"));
			sounds.put("marioDead", TinySound.loadSound("audio/mario_dead.wav"));
			sounds.put("gameCompleted", TinySound.loadSound("audio/game_completed.wav"));
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Music getMusicForLevel(String key) {
		return levels.get(key);
	}
	
	public static Sound getSound(String key) {
		return sounds.get(key);
	}
	
	public static void destory() {
		TinySound.shutdown();
	}
}
