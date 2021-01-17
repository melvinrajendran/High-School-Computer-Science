import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.*;
import java.util.*;

public class JuliaSetProgram extends JPanel implements AdjustmentListener, ActionListener {
    JFrame frame;
    JPanel scrollPanel, labelPanel, buttonPanel, bigPanel;
    JScrollBar AScroller, BScroller, hueScroller, saturationScroller, brightnessScroller, eyeHueScroller, eyeSaturationScroller, eyeBrightnessScroller, zoomScroller, multiplierScroller;
    JLabel ALabel, BLabel, hueLabel, saturationLabel, brightnessLabel, eyeHueLabel, eyeSaturationLabel, eyeBrightnessLabel, zoomLabel, multiplierLabel;
    JButton resetButton, saveButton;
    JFileChooser fileChooser;

    int width, height, visibleHeight;

    double A, B, zoom, multiplier;
    float hue, saturation, brightness, eyeHue, eyeSaturation, eyeBrightness;

    BufferedImage juliaImage;

    public JuliaSetProgram() {
        width = 800;
        height = 800;
        visibleHeight = height - 200;

        // Instantiating the JFrame on which to place the JPanel
        frame = new JFrame("Julia Set Program");
        frame.add(this);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Instantiating JScrollBars for modifying the Julia Set
        AScroller = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, -2000, 2000);
        BScroller = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, -2000, 2000);
        hueScroller = new JScrollBar(JScrollBar.HORIZONTAL, 1000, 0, 0, 1000);
        saturationScroller = new JScrollBar(JScrollBar.HORIZONTAL, 1000, 0, 0, 1000);
        brightnessScroller = new JScrollBar(JScrollBar.HORIZONTAL, 1000, 0, 0, 1000);
        eyeHueScroller = new JScrollBar(JScrollBar.HORIZONTAL, 1000, 0, 0, 1000);
        eyeSaturationScroller = new JScrollBar(JScrollBar.HORIZONTAL, 1000, 0, 0, 1000);
        eyeBrightnessScroller = new JScrollBar(JScrollBar.HORIZONTAL, 0, 0, 0, 1000);
        zoomScroller = new JScrollBar(JScrollBar.HORIZONTAL, 750, 0, 0, 10000);
        multiplierScroller = new JScrollBar(JScrollBar.HORIZONTAL, 2000, 0, 0, 10000);

        AScroller.addAdjustmentListener(this);
        BScroller.addAdjustmentListener(this);
        hueScroller.addAdjustmentListener(this);
        saturationScroller.addAdjustmentListener(this);
        brightnessScroller.addAdjustmentListener(this);
        eyeHueScroller.addAdjustmentListener(this);
        eyeSaturationScroller.addAdjustmentListener(this);
        eyeBrightnessScroller.addAdjustmentListener(this);
        zoomScroller.addAdjustmentListener(this);
        multiplierScroller.addAdjustmentListener(this);

        // Instantiating variables for holding JScrollBar values
        A = AScroller.getValue() / 1000.0;
        B = BScroller.getValue() / 1000.0;
        hue = hueScroller.getValue() / 1000f;
        saturation = saturationScroller.getValue() / 1000f;
        brightness = brightnessScroller.getValue() / 1000f;
        eyeHue = eyeHueScroller.getValue() / 1000f;
        eyeSaturation = eyeSaturationScroller.getValue() / 1000f;
        eyeBrightness = eyeBrightnessScroller.getValue() / 1000f;
        zoom = zoomScroller.getValue() / 1000.0;
        multiplier = multiplierScroller.getValue() / 1000.0;

        // Instantiating a JLabel for each JScrollBar
        ALabel = new JLabel(String.format("  A: %.3f  ", A), SwingConstants.RIGHT);
        BLabel = new JLabel(String.format("  B: %.3f  ", B), SwingConstants.RIGHT);
        hueLabel = new JLabel(String.format("  Hue: %.3f  ", hue), SwingConstants.RIGHT);
        saturationLabel = new JLabel(String.format("  Saturation: %.3f  ", saturation), SwingConstants.RIGHT);
        brightnessLabel = new JLabel(String.format("  Brightness: %.3f  ", brightness), SwingConstants.RIGHT);
        eyeHueLabel = new JLabel(String.format("  Eye Hue: %.3f  ", eyeHue), SwingConstants.RIGHT);
        eyeSaturationLabel = new JLabel(String.format("  Eye Saturation: %.3f  ", eyeSaturation), SwingConstants.RIGHT);
        eyeBrightnessLabel = new JLabel(String.format("  Eye Brightness: %.3f  ", eyeBrightness), SwingConstants.RIGHT);
        zoomLabel = new JLabel(String.format("  Zoom: %.3f  ", zoom), SwingConstants.RIGHT);
        multiplierLabel = new JLabel(String.format("  Multiplier: %.3f  ", multiplier), SwingConstants.RIGHT);

        //Instantiating JButtons for saving and resetting the image
        resetButton = new JButton("Reset Image");
        saveButton = new JButton("Save Image");

        resetButton.addActionListener(this);
        saveButton.addActionListener(this);

        // Setting the current directory and instantiating a FileChooser
        String currDir = System.getProperty("user.dir");
		fileChooser = new JFileChooser(currDir);

        // Creating JPanels to house JLabels, JScrollBars, and JButtons
        GridLayout grid = new GridLayout(10, 1);
        grid.setVgap(2);

        scrollPanel = new JPanel();
        scrollPanel.setLayout(grid);
        scrollPanel.add(AScroller);
        scrollPanel.add(BScroller);
        scrollPanel.add(hueScroller);
        scrollPanel.add(saturationScroller);
        scrollPanel.add(brightnessScroller);
        scrollPanel.add(eyeHueScroller);
        scrollPanel.add(eyeSaturationScroller);
        scrollPanel.add(eyeBrightnessScroller);
        scrollPanel.add(zoomScroller);
        scrollPanel.add(multiplierScroller);

        labelPanel = new JPanel();
        labelPanel.setLayout(grid);
        labelPanel.add(ALabel);
        labelPanel.add(BLabel);
        labelPanel.add(hueLabel);
        labelPanel.add(saturationLabel);
        labelPanel.add(brightnessLabel);
        labelPanel.add(eyeHueLabel);
        labelPanel.add(eyeSaturationLabel);
        labelPanel.add(eyeBrightnessLabel);
        labelPanel.add(zoomLabel);
        labelPanel.add(multiplierLabel);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        buttonPanel.add(resetButton);
        buttonPanel.add(saveButton);

        bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());
        bigPanel.add(scrollPanel, BorderLayout.CENTER);
        bigPanel.add(labelPanel, BorderLayout.WEST);

        // Adding JPanels to the JFrame
        frame.add(bigPanel, BorderLayout.SOUTH);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    // Method to paint the Julia Set onto the JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(drawJulia(), 0, 0, null);
    }

    // Method that returns a BufferedImage of a Julia Set
    public BufferedImage drawJulia() {
        BufferedImage image = new BufferedImage(width, visibleHeight, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < visibleHeight; y++) {
                float maxIter = 300, iter = maxIter;
                double zx = 1.5 * ((x - 0.5 * width) / (0.5 * zoom * width)), zy = (y - 0.5 * visibleHeight) / (0.5 * zoom * visibleHeight);

                while (Math.pow(zx, 2) + Math.pow(zy, 2) < 6 && iter > 0) {
                    double result = Math.pow(zx, 2) - Math.pow(zy, 2) + A;
                    zy = multiplier * zx * zy + B;
                    zx = result;
                    iter--;
                }

                int z;
                if(iter > 0)
                    z = Color.HSBtoRGB(hue * (iter / maxIter) % 1, saturation, brightness);
                else
                    z = Color.HSBtoRGB(eyeHue, eyeSaturation, eyeBrightness);
                image.setRGB(x, y, z);
            }
        }

        juliaImage = image;
        return image;
    }

    // Method to update JScrollBar variables when an adjustment is detected
    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource() == AScroller) {
            A = AScroller.getValue() / 1000.0;
            ALabel.setText(String.format("  A: %.3f  ", A));
        }
        if (e.getSource() == BScroller) {
            B = BScroller.getValue() / 1000.0;
            BLabel.setText(String.format("  B: %.3f  ", B));
        }
        if (e.getSource() == hueScroller) {
            hue = hueScroller.getValue() / 1000f;
            hueLabel.setText(String.format("  Hue: %.3f  ", hue));
        }
        if (e.getSource() == saturationScroller) {
            saturation = saturationScroller.getValue() / 1000f;
            saturationLabel.setText(String.format("  Saturation: %.3f  ", saturation));
        }
        if (e.getSource() == brightnessScroller) {
            brightness = brightnessScroller.getValue() / 1000f;
            brightnessLabel.setText(String.format("  Brightness: %.3f  ", brightness));
        }
        if (e.getSource() == eyeHueScroller) {
            eyeHue = eyeHueScroller.getValue() / 1000f;
            eyeHueLabel.setText(String.format("  Eye Hue: %.3f  ", eyeHue));
        }
        if (e.getSource() == eyeSaturationScroller) {
            eyeSaturation = eyeSaturationScroller.getValue() / 1000f;
            eyeSaturationLabel.setText(String.format("  Eye Saturation: %.3f  ", eyeSaturation));
        }
        if (e.getSource() == eyeBrightnessScroller) {
            eyeBrightness = eyeBrightnessScroller.getValue() / 1000f;
            eyeBrightnessLabel.setText(String.format("  Eye Brightness: %.3f  ", eyeBrightness));
        }
        if (e.getSource() == zoomScroller) {
            zoom = zoomScroller.getValue() / 1000.0;
            zoomLabel.setText(String.format("  Zoom: %.3f  ", zoom));
        }
        if (e.getSource() == multiplierScroller) {
            multiplier = multiplierScroller.getValue() / 1000.0;
            multiplierLabel.setText(String.format("  Multiplier: %.3f  ", multiplier));
        }
        repaint();
    }

    // Methods to enable JButton functionality
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            resetVariables();
            repaint();
        }
        if (e.getSource() == saveButton) {
            saveImage();
        }
    }

    public void resetVariables() {
        AScroller.setValue(0);
        AScroller.updateUI();
        BScroller.setValue(0);
        hueScroller.setValue(1000);
        saturationScroller.setValue(1000);
        brightnessScroller.setValue(1000);
        eyeHueScroller.setValue(1000);
        eyeSaturationScroller.setValue(1000);
        eyeBrightnessScroller.setValue(0);
        zoomScroller.setValue(750);
        multiplierScroller.setValue(2000);

        A = 0;
        B = 0;
        hue = 1f;
        saturation = 1f;
        brightness = 1f;
        eyeHue = 1f;
        eyeSaturation = 1f;
        eyeBrightness = 0f;
        zoom = 0.750;
        multiplier = 2;

        ALabel.setText(String.format("  A: %.3f  ", A));
        BLabel.setText(String.format("  B: %.3f  ", B));
        hueLabel.setText(String.format("  Hue: %.3f  ", hue));
        saturationLabel.setText(String.format("  Saturation: %.3f  ", saturation));
        brightnessLabel.setText(String.format("  Brightness: %.3f  ", brightness));
        eyeHueLabel.setText(String.format("  Eye Hue: %.3f  ", eyeHue));
        eyeSaturationLabel.setText(String.format("  Eye Saturation: %.3f  ", eyeSaturation));
        eyeBrightnessLabel.setText(String.format("  Eye Brightness: %.3f  ", eyeBrightness));
        zoomLabel.setText(String.format("  Zoom: %.3f  ", zoom));
        multiplierLabel.setText(String.format("  Multiplier: %.3f  ", multiplier));
    }

    public void saveImage() {
		if (juliaImage != null) {
            FileFilter filter = new FileNameExtensionFilter("*.png", "png");
            fileChooser.setFileFilter(filter);
			if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					String st = file.getAbsolutePath();
					if(st.indexOf(".png") >= 0)
						st = st.substring(0, st.length() - 4);
					ImageIO.write(juliaImage, "png", new File(st + ".png"));
				} catch (IOException e) {}
			}
		}
	}

    public static void main (String[] args) {
        JuliaSetProgram app = new JuliaSetProgram();
    }
}