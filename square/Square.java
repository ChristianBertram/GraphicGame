package square;

import java.awt.Graphics;
import java.awt.Color;
import input.Inputs;

public class Square {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int speed = 2; 
	
	public Square(int x, int y, int width, int height) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.xPos, this.yPos, this.width, this.height);
	}
	
	public void moveRelative(double x, double y) {
		this.xPos += (int)x;
		this.yPos += (int)y;
	}
	
	public void moveAbsolute(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void update(double delta) {
		//UP
		if (input.Inputs.keys[87] || input.Inputs.keys[38])
			this.moveRelative(0, -1 * this.speed * delta);
		//DOWN
		if (input.Inputs.keys[83] || input.Inputs.keys[40])
			this.moveRelative(0, this.speed * delta);
		//RIGHT
		if (input.Inputs.keys[68] || input.Inputs.keys[39])
			this.moveRelative(this.speed * delta, 0);
		//LEFT
		if (input.Inputs.keys[65] || input.Inputs.keys[37])
			this.moveRelative(-1 * this.speed * delta, 0);
	}
}
