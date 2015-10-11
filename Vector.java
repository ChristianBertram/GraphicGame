

import java.awt.Graphics;
import java.awt.Color;

public class Vector {
	private int xPos;
	private int yPos;
	private double length;
	private double theta; //in degrees
	
	public Vector(int xPos, int yPos, double lengthOrX, double thetaOrY, boolean polar) {
		this.xPos = xPos;
		this.yPos = yPos;
		
		//if polar == true, then lengthOrX is treated as length, and thetaOrY is treated as theta.
		//if polar == false, then lengthOrX is treated as xLength, and thetaOrY is treated as yLength.
		if (polar) {
			this.length = lengthOrX;
			this.theta = thetaOrY;
		}else {		
			//convert cartesian/rectangular to polar
			this.length = Math.sqrt((lengthOrX*lengthOrX)+(thetaOrY*thetaOrY));
			double absTheta;
			if (lengthOrX != 0) {
				absTheta = Math.toDegrees(Math.atan(Math.abs(thetaOrY/lengthOrX)));
				
				if (lengthOrX >= 0 && thetaOrY >= 0) {
					this.theta = absTheta;
				}
				else if (lengthOrX < 0 && thetaOrY >= 0) {
					this.theta = 180 - absTheta;
				}
				else if (lengthOrX < 0 && thetaOrY < 0) {
					this.theta = 180 + absTheta;
				}
				else {
					this.theta = 360 - absTheta;
				}
			}else if (thetaOrY > 0) {
				this.theta = 90;
			}else {
				this.theta = 270;
			}
 		}
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getTheta() {
		return theta;
	}
	
	public int getXLength() {
		return (int)(length * Math.cos(Math.toRadians(theta)));
	}
	
	public int getYLength() {
		return (int)(length * Math.sin(Math.toRadians(theta)));
	}
	
	public void translateRelative(double x, double y) {
		xPos = (int)(x+xPos);
		yPos = (int)(y+yPos);
	}
	
	public void translate(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public double simplifyAngle(double angle) {
		//Keep angle between 0 and 360
		if (angle < 360 && theta + angle >= 0) {
			return angle;
		}
		else if (angle > 0) {
			return angle % 360;
		}
		else {
			return 360 - ((-1 * angle) % 360);
		}
	}
	
	public void rotateRelative(double rotation) {
		theta = simplifyAngle(theta+rotation);
	}
	
	public void rotate(double rotation) {
		theta = simplifyAngle(rotation);
	}
	
	public void scaleRelative(double extension) {
		length += extension;
	}
	
	public void scale(double extension) {
		length = extension;
	}
	
	public Vector sub(Vector v) {
		return new Vector(this.xPos, this.yPos, this.getXLength() - v.getXLength(), this.getYLength() - v.getYLength(), false);
	}
	
	public Vector add(Vector v) {
		return new Vector(this.xPos, this.yPos, this.getXLength() + v.getXLength(), this.getYLength() + v.getYLength(), false);
	}
	
	public void paint(Graphics g, Color color) {
		g.setColor(color);
		paint(g);
	}
	
	public void paint(Graphics g) {
		g.drawLine(xPos, yPos, getXLength()+xPos, getYLength()+yPos);
	}
}
