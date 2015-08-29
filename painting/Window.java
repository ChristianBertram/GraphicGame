package painting;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import input.MyKeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window {
	
	public static JFrame f = null;

	public static void main() {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	
	private static void createAndShowGUI() {
        f = new JFrame("Graphics Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }
	
	public static void repaint() {
		if (f != null)
			f.repaint();
	}
	
	public static void repaint(int x, int y, int w, int h) {
		if (f != null)
			f.repaint(x, y, w, h);
	}

}

class MyPanel extends JPanel {

	public MyPanel() {
		KeyListener myKeyListener = new input.MyKeyListener();
		addKeyListener(myKeyListener);
		setFocusable(true);
    }
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(700, 500);
    }
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //What's called on repaint()
        CallPrints.main(g);
    }
}