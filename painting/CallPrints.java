package painting;
import startup.Startup;

//import javax.swing.SwingUtilities;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.BorderFactory;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Graphics;

public class CallPrints {

	public static void main(Graphics g) {
		Startup.mainPlayer.paint(g, new Color(20,200,100));
	}
	
}
