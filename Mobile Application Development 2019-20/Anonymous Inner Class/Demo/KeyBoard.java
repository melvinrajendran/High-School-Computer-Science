import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class KeyBoard extends JPanel implements KeyListener {

	public KeyBoard() {
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setVisible(true);
		setFocusable(true);
		addKeyListener(this);
	}

	public static void main (String[] args) {
		KeyBoard demo = new KeyBoard();
	}

	public void keyPressed(KeyEvent e) { System.out.println(e.getKeyChar()); }

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
}