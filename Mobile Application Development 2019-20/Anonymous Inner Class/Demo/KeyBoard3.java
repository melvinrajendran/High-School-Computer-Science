import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class KeyBoard3 extends JPanel {

	public KeyBoard3() {
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setVisible(true);
		setFocusable(true);
		addKeyListener(new KeyBoardInterface());
	}

	public static void main (String[] args) {
		KeyBoard3 demo = new KeyBoard3();
	}

	public class KeyBoardInterface implements KeyListener {
		public void keyPressed(KeyEvent e) { System.out.println(e.getKeyChar()); }

		public void keyReleased(KeyEvent e) {}

		public void keyTyped(KeyEvent e) {}
	}
}