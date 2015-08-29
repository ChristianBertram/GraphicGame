package startup;

import gameLoop.GameLoop;
import painting.Window;
import square.Square;

public class Startup {
	
	public static Square mySquare = null;
	
	public static void main(String[] args) {
		mySquare = new Square(50, 70, 10, 20);
		
		painting.Window.main();
		
		gameLoop.GameLoop loop = new gameLoop.GameLoop();
		
		loop.runGameLoop();
	}

}
