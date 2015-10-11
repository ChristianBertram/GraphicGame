//import javax.swing.SwingUtilities;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.BorderFactory;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Graphics;

public class CallPrints {

	public static void main(Graphics g) {
		Main.mainPlayer.paint(g, new Color(20,200,100));
		for (int i = 0; i < Main.bullets.size(); i++) {
			Main.bullets.get(i).paint(g, new Color(200,20,100));
		}
	}
	
}
