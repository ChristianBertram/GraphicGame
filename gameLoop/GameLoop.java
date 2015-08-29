package gameLoop;

import painting.Window;
import startup.Startup;
import java.awt.Graphics;

public class GameLoop {
	
	boolean stopLoop = false;
	
	public void runGameLoop() {
		
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		long lastFpsTime = 0;
		int fps = 0;
		double delta = 1;
		
		while (!stopLoop) {
			long currentTime = System.nanoTime();
			long updateLength = currentTime - lastLoopTime;
			lastLoopTime = currentTime;
			delta = ((double)updateLength)/OPTIMAL_TIME;

			//FPS counter:
			lastFpsTime += updateLength;
			fps++;
			if (lastFpsTime >= 1000000000) {
				System.out.println("FPS: " + fps);
				lastFpsTime = 0;
				fps = 0;
			}
			
			Startup.mySquare.update(delta);
			painting.Window.repaint();
			
			System.out.println(delta);
			//If loop executed under the OPTIMAL_TIME, the Thread sleeps, so that it doesn't 100% the CPU.
			//Thread.sleep() is not accurate but that's OK since the loop uses a variable timestep.
			try{
				Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
			} catch (InterruptedException e) {}
		}
		
	}
}