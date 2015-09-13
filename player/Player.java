package player;

import java.awt.Graphics;
import java.awt.Color;
import painting.Window;
import vector.Vector;
import main.Main;

public class Player {
	private Vector posVector; //describing current position and direction and speed of movement
	private Vector accelVector; //describing direction and speed of acceleration
	private Vector pointVector; //describing where to player is pointing (at mouse)
	double accelSpeed = 3;
	double topSpeed = 15;
	long lastFireTime = System.nanoTime();
	int fireDelay = 100000000;
	
	public Player(int startX, int startY) {
		this.posVector = new Vector(startX, startY, 0, 0, true);
		this.pointVector = new Vector(startX, startY, 20, 0, true);
	}
	
	public void update(double delta) {
		move(delta);
		pointVector.translate(posVector.getXPos(), posVector.getYPos());
		
		//Update angle (direction) to where mouse is relative to the player.
		Vector playerToMouse = new Vector(posVector.getXPos(), posVector.getYPos(), Window.inputs.mouseX - posVector.getXPos(), Window.inputs.mouseY - posVector.getYPos(), false);
		pointVector.rotate(playerToMouse.getTheta());
		
		fire();
	}
	
	private void move(double delta) {
		
		double xMove = 0;
		double yMove = 0;
		
		
		//UP
		if (Window.inputs.keys[87] || Window.inputs.keys[38]) {
			yMove -= 1;
		}
		//DOWN
		if (Window.inputs.keys[83] || Window.inputs.keys[40]) {
			yMove += 1;
		}
		//RIGHT
		if (Window.inputs.keys[68] || Window.inputs.keys[39]) {
			xMove += 1;
		}
		//LEFT
		if (Window.inputs.keys[65] || Window.inputs.keys[37]) {
			xMove -= 1;
		}
		
		accelVector = new Vector(0, 0, xMove, yMove, false);
		if (xMove != 0 || yMove != 0) {
			accelVector.size(accelSpeed);
		}else {
			accelVector.size(0);
		}
		
		posVector = posVector.add(accelVector);
		
		if (posVector.getLength()-0.1 >= 0) {
			posVector.size(posVector.getLength()-0.1);
		}
		
		if (posVector.getLength() > topSpeed) {
			posVector.size(topSpeed);
		}
		
		posVector.translateRelative(posVector.getXLength() * delta, posVector.getYLength() * delta);
	}
	
	private void fire() {
		if (Window.inputs.mouseDown && System.nanoTime() - lastFireTime > fireDelay) {
			lastFireTime = System.nanoTime();
			Main.bullets.add(new bullet.Bullet(posVector.getXPos(), posVector.getYPos(), pointVector.getTheta()));
		}
	}
	
	public void paint(Graphics g, Color color) {
		g.setColor(color);
		paint(g);
	}
	
	public void paint(Graphics g) {
		pointVector.paint(g);
	}
}
