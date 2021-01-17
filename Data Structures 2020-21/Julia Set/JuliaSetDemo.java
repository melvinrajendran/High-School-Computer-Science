import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;

public class JuliaSetDemo extends JPanel implements AdjustmentListener {
    JFrame frame;
    JScrollBar redScroller, greenScroller, blueScroller;
    JPanel scrollPanel, labelPanel, bigPanel;
    JLabel redLabel, greenLabel, blueLabel;

    int red, green, blue;

    public JuliaSetDemo() {
        frame = new JFrame("Julia Set Program");
        frame.add(this);
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        redScroller = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
        greenScroller = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
        blueScroller = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 255);
        redScroller.addAdjustmentListener(this);
        greenScroller.addAdjustmentListener(this);
        blueScroller.addAdjustmentListener(this);

        red = redScroller.getValue();
        green = greenScroller.getValue();
        blue = blueScroller.getValue();

        GridLayout grid = new GridLayout(3, 1);

        redLabel = new JLabel("Red");
        greenLabel = new JLabel("Green");
        blueLabel = new JLabel("Blue");

        labelPanel = new JPanel();
        labelPanel.setLayout(grid);
        labelPanel.add(redLabel);
        labelPanel.add(greenLabel);
        labelPanel.add(blueLabel);

        scrollPanel = new JPanel();
        scrollPanel.setLayout(grid);
        scrollPanel.add(redScroller);
        scrollPanel.add(greenScroller);
        scrollPanel.add(blueScroller);

        bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());
        bigPanel.add(labelPanel, BorderLayout.WEST);
        bigPanel.add(scrollPanel, BorderLayout.CENTER);

        frame.add(bigPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        red = redScroller.getValue();
        green = greenScroller.getValue();
        blue = blueScroller.getValue();

        g.setColor(new Color(red, green, blue));
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
    }

    public BufferedImage drawJulia(Graphics g) {


        return null;
    }

    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource() == redScroller)
            red = redScroller.getValue();
        if (e.getSource() == greenScroller)
            green = greenScroller.getValue();
        if (e.getSource() == blueScroller)
            blue = blueScroller.getValue();

        repaint();
    }

    public static void main (String[] args) {
        JuliaSetDemo app = new JuliaSetDemo();
    }
}