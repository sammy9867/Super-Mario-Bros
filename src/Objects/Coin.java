package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import Main.Main;
import Sprites.Texture;

/**
 * This class represents the coins in the game.
 * @author Samuel Menezes
 */
public class Coin extends Objects{
private Texture tex = Main.getInstance();

public Coin(float x, float y, ObjectId id){
	super(x, y, id);	
}

public void tick(ArrayList<Objects> obj){}

public void render(Graphics g){
	g.drawImage(tex.coin[0],(int)x,(int)y,null);
}

public Rectangle getBounds(){
	return new Rectangle((int)x,(int)y,32,32);
}
}