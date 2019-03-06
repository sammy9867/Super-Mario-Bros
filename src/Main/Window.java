package Main;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.lwjgl.openal.AL;

/**
 * This class represents the Window Frame of the game.
 * @author Samuel Menezes
 */
public class Window{
public Window(int w,int h,String title,Main game) {
	game.setPreferredSize(new Dimension(w,h));
	game.setMaximumSize(new Dimension(w,h));
	game.setMinimumSize(new Dimension(w,h));
	
	JFrame f = new JFrame(title);
	f.add(game);
	f.pack();
	
	//When the window is going, it has to first destroy all the Audio files
	//and then exit.
	f.addWindowListener(new WindowAdapter(){ 
	public void windowClosing(WindowEvent e){ 
		AL.destroy();
		System.exit(0);
	}
});
	f.setResizable(false);
	f.setLocationRelativeTo(null);
	f.setVisible(true);
	
	game.start();
}
}
