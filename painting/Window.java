package painting;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.BorderFactory;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Window {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	
	private static void createAndShowGUI() {
        JFrame f = new JFrame("Graphics Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }

}

class MyPanel extends JPanel {

	public MyPanel() {
		
    }

    public Dimension getPreferredSize() {
        return new Dimension(700, 500);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //What's called on repaint()
        CallPrints.main(g);
    }
}