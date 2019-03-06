package AudioPlayer;

import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 * This class is responsible for the sounds used in the game by importing Slick2D library.
 * @author Samuel Menezes
 */
public class Audio {
public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
/**
 * This method will generate the required sound for a specific key.
 */
public static void init()
{
	try{
		soundMap.put("coin", new Sound("Resources/coin.WAV"));
     	soundMap.put("jump", new Sound("Resources/mariojump.WAV"));
		soundMap.put("gdead", new Sound("Resources/stomp.WAV"));
		soundMap.put("mdead", new Sound("Resources/mariodies.WAV"));
		soundMap.put("level", new Sound("Resources/bglevel1.WAV"));
		soundMap.put("level2", new Sound("Resources/mariolevel2.WAV"));
		soundMap.put("level4", new Sound("Resources/mariolevel4.WAV"));
		soundMap.put("bump", new Sound("Resources/blockbump.WAV"));
		soundMap.put("end", new Sound("Resources/WorldClear.WAV"));
		soundMap.put("fball", new Sound("Resources/fireball.WAV"));
	
	}catch(SlickException e){
		e.printStackTrace();
	}
}

/**
 * @return The key mapping to the sound.
 */
public static Sound getSound(String key){ 
	 return soundMap.get(key);
 }
}
