import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Mouse extends JPanel implements MouseListener, MouseMotionListener {

	double distance;
	double initial;

	public Mouse() {
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setVisible(true);
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
	 	distance = 0;
		initial = 0;
	}

	public static void main (String[] args) {
		Mouse mouse = new Mouse();
	}

	public void mouseClicked(MouseEvent e) { System.out.println(e.getPoint()); }

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {
		if (initial == 0) {
			initial = e.getX();
		} else {
			distance += Math.abs(e.getX() - initial);
			initial = e.getX();
		}

		if  (distance % (227 * 6)  == 0) {
			System.out.println("The mouse has moved " + (double)(distance / (227 * 12)) + " feet.");
		 	distance += 1;
		}
	}
}