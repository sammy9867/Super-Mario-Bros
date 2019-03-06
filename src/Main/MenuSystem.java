package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * This class represents the Menu System of the game.
 * @author Samuel Menezes
 */
public class MenuSystem {
private int selected = 0; //option to be selected.

public void tick(){
	//There are only two options in the game
	if(selected < 0)
		selected = 2;
	else if(selected > 2)
		selected = 0;
}

//Draws all the Strings on the Menu.
public void render(Graphics g){
    Font f1 = new Font("arial",Font.BOLD,30);
	Font f2 = new Font("arial",Font.BOLD,30);

	if(selected == 0){
	g.setFont(f1);
    g.drawString("Play",Main.WIDTH/2 - 100 + 19,380);
    g.setColor(Color.white);
	}else
    g.setFont(f1);
    g.drawString("Play",Main.WIDTH/2 - 100 + 19,380);
    g.setColor(Color.black);
	
    
   if(selected == 1){
	g.setFont(f2);
    g.drawString("Quit",Main.WIDTH/2 - 100 + 19,430); 
    g.setColor(Color.white);
   }
   g.setFont(f2);
   g.drawString("Quit",Main.WIDTH/2 - 100 + 19,430);
   g.setColor(Color.black);

 
}

public int getSelected() {
	return selected;
}

public void setSelected(int selected) {
	this.selected = selected;
}
}
