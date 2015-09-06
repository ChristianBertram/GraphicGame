package startup;

import gameLoop.GameLoop;
import painting.Window;
import player.Player;

public class Startup {
	
	public static Player mainPlayer = null;
	
	public static void main(String[] args) {
		mainPlayer = new Player(50, 70);
		
		Window.main();
		
		GameLoop loop = new GameLoop();
		
		loop.runGameLoop();
	}

}
