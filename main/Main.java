package main;

import gameLoop.GameLoop;
import painting.Window;
import player.Player;

public class Main {
	
	public static Player mainPlayer = new Player(50, 70);;
	public static GameLoop loop = new GameLoop();
	
	public static void main(String[] args) {		
		Window.main();
		
		loop.runGameLoop();
	}

}
