package player;

import java.awt.Graphics;
import java.awt.Color;
import painting.Window;
import vector.Vector;

public class Player {
	private Vector vector;
	private int speed = 4;
	
	public Player(int startX, int startY) {
		this.vector = new Vector(startX, startY, 20, 0, true);
	}
	
	private void moveRelative(int x, int y) {
		vector.translateRelative(x, y);
	}
	
	public void update(double delta) {
		//Update angle (direction) to where mouse is relative to the player.
		Vector playerToMouse = new Vector(vector.getXPos(), vector.getYPos(), Window.inputs.mouseX - vector.getXPos(), Window.inputs.mouseY - vector.getYPos(), false);
		vector.rotate(playerToMouse.getTheta());
		
		//UP
		if (Window.inputs.keys[87] || Window.inputs.keys[38])
			moveRelative(0, (int)(-1 * speed * delta));
		//DOWN
		if (Window.inputs.keys[83] || Window.inputs.keys[40])
			moveRelative(0, (int)(speed * delta));
		//RIGHT
		if (Window.inputs.keys[68] || Window.inputs.keys[39])
			moveRelative((int)(speed * delta), 0);
		//LEFT
		if (Window.inputs.keys[65] || Window.inputs.keys[37])
			moveRelative((int)(-1 * speed * delta), 0);
	}
	
	public void paint(Graphics g, Color color) {
		g.setColor(color);
		paint(g);
	}
	
	public void paint(Graphics g) {
		vector.paint(g);
	}
}
