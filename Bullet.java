import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private Vector posVector; //describing current position and direction and speed of movement
	double speed = 5;
	
	public Bullet(int startX, int startY, double theta) {
		this.posVector = new Vector(startX, startY, this.speed, theta, true);
	}
	
	public void update(double delta) {
		move(delta);
	}
	
	private void move(double delta) {
		posVector.translateRelative(posVector.getXLength() * delta, posVector.getYLength() * delta);
	}
	
	public boolean outsideBarrier() {
		return posVector.getXPos() < 0 || posVector.getYPos() < 0 || posVector.getXPos() > Window.f.getContentPane().getSize().getWidth() || posVector.getYPos() > Window.f.getContentPane().getSize().getHeight();
	}
	
	public void paint(Graphics g, Color color) {
		g.setColor(color);
		paint(g);
	}
	
	public void paint(Graphics g) {
		posVector.paint(g);
	}
}
