import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Create player class with Location direction size and color

public class MazeActivity extends JPanel implements KeyListener {
    JFrame frame;
    int c = 500, r = 300, dir = 0;

    public MazeActivity() {
        frame = new JFrame("Maze Program");
        frame.setSize(1000, 600);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // erases anything drawn
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());

        g2.setColor(new Color(190, 0, 200));
        g2.fillOval(c, r, 50, 50); // column, row, width, height

        g2.setColor(Color.YELLOW);
        g2.setStroke(new BasicStroke(10));
        g2.drawOval(c, r, 50, 50);
    }

    // Use KeyAdapter to shorten code and only use the methods we want to
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 38) {
            // 0 = up, 1 == 
        }

        repaint();
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args) {
        MazeActivity app = new MazeActivity();
    }
}
