import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

	private Inputs out;

	public MyKeyListener(Inputs out) {
		this.out = out;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		out.keys[e.getKeyCode()] = true;
		//System.out.println(e.getKeyCode());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		out.keys[e.getKeyCode()] = false;
		//System.out.println(e.getKeyCode());
	}
}
