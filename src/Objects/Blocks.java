package Objects;

import java.awt.Graphics;

import java.awt.Rectangle;
import java.util.ArrayList;


import Main.Main;
import Sprites.Texture;

/**
 * This class represent the all the blocks and pipes in the game.
 * @author Samuel Menezes
 */
public class Blocks extends Objects{
private Texture tex = Main.getInstance();
private int type;

public Blocks(float x, float y,int type ,ObjectId id) {
   super(x, y, id);
   this.type = type;
}

public void tick(ArrayList<Objects> obj){}

//Loads a specific image according to the type of the Block.
public void render(Graphics g){
		
    if(type == 0) 	g.drawImage(tex.block[0],(int)x,(int) y, null);
	
	if(type == 1) 	g.drawImage(tex.block[1],(int)x,(int) y,30,30, null);
	if(type == 2) 	g.drawImage(tex.block[2],(int)x,(int) y, null);
	if(type == 3) 	g.drawImage(tex.block[3],(int)x,(int) y, null);
	if(type == 4) 	g.drawImage(tex.block[4],(int)x,(int) y, null);
	
	//pip grid
	if(type == 5) 	g.drawImage(tex.block[5],(int)x,(int)y,null);
	if(type == 6) 	g.drawImage(tex.block[6],(int)x,(int)y,null);
	if(type == 7) 	g.drawImage(tex.block[7],(int)x,(int)y,null);
	if(type == 8) 	g.drawImage(tex.block[8],(int)x,(int)y,null);
	
	//level2
	if(type == 10) 	g.drawImage(tex.block[10],(int)x,(int)y,null);
	if(type == 11) 	g.drawImage(tex.block[11],(int)x,(int)y,null);
	if(type == 12) 	g.drawImage(tex.block[12],(int)x,(int)y,null);
	
	//level3
	if(type == 13) 	g.drawImage(tex.block[13],(int)x,(int)y,null);
	if(type == 14) 	g.drawImage(tex.block[14],(int)x,(int)y,null);
	if(type == 15) 	g.drawImage(tex.block[15],(int)x,(int)y,null);
	if(type == 16) 	g.drawImage(tex.block[16],(int)x,(int)y,null);
	
    //level3 pipe
	if(type == 17) 	g.drawImage(tex.block[17],(int)x,(int)y,null);
    if(type == 18) 	g.drawImage(tex.block[18],(int)x,(int)y,null);
	if(type == 19) 	g.drawImage(tex.block[19],(int)x,(int)y,null);
	if(type == 20) 	g.drawImage(tex.block[20],(int)x,(int)y,null);
	
	//water and lava base
	if(type == 21) 	g.drawImage(tex.block[21],(int)x,(int)y,null); 
	if(type == 22) 	g.drawImage(tex.block[22],(int)x,(int)y,null);
	
	//level4
	if(type == 23) 	g.drawImage(tex.block[23],(int)x,(int)y,null); //blocks
	if(type == 24) 	g.drawImage(tex.block[24],(int)x,(int)y,null); //bridge
		
	
    //level4 pipe
	if(type == 25) 	g.drawImage(tex.block[25],(int)x,(int)y,null);
    if(type == 26) 	g.drawImage(tex.block[26],(int)x,(int)y,null);
	if(type == 27) 	g.drawImage(tex.block[27],(int)x,(int)y,null);
	if(type == 28) 	g.drawImage(tex.block[28],(int)x,(int)y,null);
	
	if(type == 29) 	g.drawImage(tex.block[29],(int)x,(int)y,null);
	if(type == 30) 	g.drawImage(tex.block[30],(int)x,(int)y,null);
	
	if(type == 31) 	g.drawImage(tex.block[31],(int)x,(int)y,60,60,null);
	if(type == 32) 	g.drawImage(tex.block[32],(int)x,(int)y,60,60,null);
	
	if(type == 33) 	g.drawImage(tex.block[33],(int)x,(int)y,null); 
	
	if(type == 34) 	g.drawImage(tex.block[34],(int)x,(int)y,null); 
	if(type == 35) 	g.drawImage(tex.block[35],(int)x,(int)y,null); 
}

public Rectangle getBounds(){
    return new Rectangle((int)x,(int)y,32,32);
}
}
