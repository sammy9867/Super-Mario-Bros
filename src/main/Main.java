package main;

import main.state.GameState;
import main.ui.*;
	
public class Main {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public static void main(String[] args) {
		new Window("Super Mario Bros", WIDTH, HEIGHT, new GameState());
	}
}
