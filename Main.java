import java.util.ArrayList;

public class Main {
	
	public static GameLoop loop = new GameLoop();
	public static Player mainPlayer = new Player(50, 70);;
	public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	public static void main(String[] args) {		
		Window.main();
		
		loop.runGameLoop();
	}

}
