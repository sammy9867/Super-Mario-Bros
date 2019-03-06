package Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.lwjgl.openal.AL;

/**
 * This class represents the MouseInput for the Menu.
 * @author Samuel Menezes
 */
public class MouseInput implements MouseListener {
public void mousePressed(MouseEvent e) {
   int x = e.getX();
   int y = e.getY();
   if(x >= Main.WIDTH/2 - 100 && x <= Main.WIDTH/2){
		if(y>=360 && y <=380)
			Main.State = Main.STATE.Game;
    }
   if(x >= Main.WIDTH/2 - 100 && x <= Main.WIDTH/2 ){
		if(y>=410 && y <=430){
			AL.destroy();
			System.exit(1);
		}
	}
}

public void mouseClicked(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
}
