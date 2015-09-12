package input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
	
	private Inputs out;
	
	public MyMouseListener(Inputs out) {
		this.out = out;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		out.mouseDown = true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		out.mouseDown = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		out.mouseX = e.getX();
		out.mouseY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		out.mouseX = e.getX();
		out.mouseY = e.getY();
	}
}
