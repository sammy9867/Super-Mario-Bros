package Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * This class represents an invisible block which is placed before a flag at the end every level.
 * When Mario encounters this block, it switches the level.
 * @author Samuel Menezes
 */
public class NextLevel extends Objects{

public NextLevel(float x,float y,ObjectId id){
	super(x,y,id);
}

public void tick(ArrayList<Objects> obj){}
public void render(Graphics g){}

public Rectangle getBounds(){
   return new Rectangle((int)x,(int)y,32,32);
}
}
