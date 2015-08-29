package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		Inputs.keys[e.getKeyCode()] = true;
		//System.out.println(e.getKeyCode());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		Inputs.keys[e.getKeyCode()] = false;
		//System.out.println(e.getKeyCode());
	}
}
