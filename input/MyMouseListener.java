package input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
		Inputs.mouseDown = true;
		Inputs.mouseX = e.getX();
		Inputs.mouseY = e.getY();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		Inputs.mouseDown = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		Inputs.mouseX = e.getX();
		Inputs.mouseY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Inputs.mouseX = e.getX();
		Inputs.mouseY = e.getY();
	}
}
