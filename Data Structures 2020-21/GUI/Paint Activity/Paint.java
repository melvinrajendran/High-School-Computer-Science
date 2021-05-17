import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;

import javax.imageio.*;
import javax.security.auth.kerberos.KeyTab;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
import javax.swing.event.*;

public class Paint extends JPanel implements ActionListener, ChangeListener, MouseMotionListener, MouseListener, AdjustmentListener, KeyListener {
    JFrame frame;
    JMenuBar menuBar;

    JMenu fileMenu, colorMenu;
    JMenuItem clearMenuItem, loadMenuItem, saveMenuItem, exitMenuItem;
    JMenuItem[] colorMenuItems;
    Color[] colors;
    Color currentColor, backgroundColor, oldColor;
    JColorChooser colorChooser;

    JButton lineButton, rectangleButton, ellipseButton, undoButton, redoButton, eraserButton;
    ImageIcon loadImage, saveImage, lineImage, rectangleImage, ellipseImage, undoImage, redoImage, eraserImage;
    boolean isDrawingLine = true, isDrawingRectangle = false, isDrawingEllipse = false, isErasing = false;
    int currentX, currentY, currentWidth, currentHeight;

    JScrollBar penWidthScrollBar;
    float currentPenWidth;

    BufferedImage loadedImage;
    JFileChooser fileChooser;
    
    Stack<Object> shapeStack, undoRedoStack;
    Shape currentShape;
    ArrayList<Point> currentPointList;

    boolean firstClick = true;

    public Paint() {
        frame = new JFrame("Paint Program");
        frame.add(this);

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        
        clearMenuItem = new JMenuItem("New");
        loadMenuItem = new JMenuItem("Load", KeyEvent.VK_L);
        loadMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        exitMenuItem = new JMenuItem("Exit");
        clearMenuItem.addActionListener(this);
        loadMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);

        saveImage = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Paint Activity/Images/saveImg.png");
        saveImage = new ImageIcon(saveImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        loadImage = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Paint Activity/Images/loadImg.png");
        loadImage = new ImageIcon(loadImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        saveMenuItem.setIcon(saveImage);
        loadMenuItem.setIcon(loadImage);

        fileMenu.add(clearMenuItem);
        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        String currentDir = System.getProperty("user.dir");
        fileChooser = new JFileChooser(currentDir);

        colorMenu = new JMenu("Color Options");

        colors = new Color[] { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA };
        colorMenuItems = new JMenuItem[colors.length];
        colorMenu.setLayout(new GridLayout(7, 1));
        for (int x = 0; x < colorMenuItems.length; x++) {
            colorMenuItems[x] = new JMenuItem();
            colorMenuItems[x].putClientProperty("colorIndex", x);
            colorMenuItems[x].setBackground(colors[x]);
            colorMenuItems[x].setPreferredSize(new Dimension(50, 30));
            colorMenuItems[x].addActionListener(this);
            colorMenuItems[x].setFocusable(false);

            colorMenu.add(colorMenuItems[x]);
        }
        currentColor = colors[0];
        oldColor = currentColor;

        colorChooser = new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(this);

        colorMenu.add(colorChooser);

        backgroundColor = Color.WHITE;

        lineImage = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Paint Activity/Images/freeLineImg.png");
        lineImage = new ImageIcon(lineImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        lineButton = new JButton();
        lineButton.setIcon(lineImage);
        lineButton.setFocusPainted(false);
        lineButton.setBackground(Color.LIGHT_GRAY);
        lineButton.setOpaque(true);
        lineButton.setBorderPainted(false);
        lineButton.addActionListener(this);
        lineButton.setFocusable(false);

        rectangleImage = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Paint Activity/Images/rectImg.png");
        rectangleImage = new ImageIcon(rectangleImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        rectangleButton = new JButton();
        rectangleButton.setIcon(rectangleImage);
        rectangleButton.setFocusPainted(false);
        rectangleButton.setOpaque(true);
        rectangleButton.setBorderPainted(false);
        rectangleButton.addActionListener(this);
        rectangleButton.setFocusable(false);

        ellipseImage = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Paint Activity/Images/ovalImg.png");
        ellipseImage = new ImageIcon(ellipseImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ellipseButton = new JButton();
        ellipseButton.setIcon(ellipseImage);
        ellipseButton.setFocusPainted(false);
        ellipseButton.setOpaque(true);
        ellipseButton.setBorderPainted(false);
        ellipseButton.addActionListener(this);
        ellipseButton.setFocusable(false);
        
        eraserImage = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Paint Activity/Images/eraserImg.png");
        eraserImage = new ImageIcon(eraserImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        eraserButton = new JButton();
        eraserButton.setIcon(eraserImage);
        eraserButton.setFocusPainted(false);
        eraserButton.setOpaque(true);
        eraserButton.setBorderPainted(false);
        eraserButton.addActionListener(this);
        eraserButton.setFocusable(false);

        undoImage = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Paint Activity/Images/undoImg.png");
        undoImage = new ImageIcon(undoImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        undoButton = new JButton();
        undoButton.setIcon(undoImage);
        undoButton.setFocusPainted(false);
        undoButton.setOpaque(true);
        undoButton.setBorderPainted(false);
        undoButton.addActionListener(this);
        undoButton.setFocusable(false);

        redoImage = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Paint Activity/Images/redoImg.png");
        redoImage = new ImageIcon(redoImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        redoButton = new JButton();
        redoButton.setIcon(redoImage);
        redoButton.setFocusPainted(false);
        redoButton.setOpaque(true);
        redoButton.setBorderPainted(false);
        redoButton.addActionListener(this);
        redoButton.setFocusable(false);

        penWidthScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 1, 0, 1, 100);
        penWidthScrollBar.addAdjustmentListener(this);
        penWidthScrollBar.setFocusable(false);
        currentPenWidth = penWidthScrollBar.getValue();
        
        menuBar.add(fileMenu);
        menuBar.add(colorMenu);
        menuBar.add(lineButton);
        menuBar.add(rectangleButton);
        menuBar.add(ellipseButton);
        menuBar.add(eraserButton);
        menuBar.add(undoButton);
        menuBar.add(redoButton);
        menuBar.add(penWidthScrollBar, BorderLayout.EAST);

        shapeStack = new Stack<Object>();
        undoRedoStack = new Stack<Object>();
        currentPointList = new ArrayList<Point>();

        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        
        frame.add(menuBar, BorderLayout.NORTH);
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, frame.getWidth(), frame.getHeight());

        if (loadedImage != null) {
            g2.drawImage(loadedImage, 0, 0, null);
        }

        Iterator iterator = shapeStack.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();

            if (next instanceof Rectangle) {
                Rectangle temp = (Rectangle)next;
                g2.setColor(temp.getColor());
                g2.setStroke(new BasicStroke(temp.getPenWidth()));
                g2.draw(temp.getShape());
            } else if (next instanceof Ellipse) {
                Ellipse temp = (Ellipse)next;
                g2.setColor(temp.getColor());
                g2.setStroke(new BasicStroke(temp.getPenWidth()));
                g2.draw(temp.getShape());
            } else {
                ArrayList<?> tempPointList = (ArrayList<?>)next;
                if (tempPointList.size() > 0) {
                    g2.setStroke(new BasicStroke(((Point) tempPointList.get(0)).getPenWidth()));
                    g2.setColor(((Point) tempPointList.get(0)).getColor());
                    for (int x = 0; x < tempPointList.size() - 1; x++) {
                        Point p1 = (Point) tempPointList.get(x), p2 = (Point) tempPointList.get(x + 1);
                        g2.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                    }
                }
            }
        }

        if (isDrawingLine && currentPointList.size() > 0) {
            g2.setStroke(new BasicStroke(currentPointList.get(0).getPenWidth()));
            g2.setColor(currentPointList.get(0).getColor());
            for (int x = 0; x < currentPointList.size() - 1; x++) {
                Point p1 = currentPointList.get(x), p2 = currentPointList.get(x + 1);
                g2.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            }
        }

        repaint();
    }

    public BufferedImage createImage() {
        int width = this.getWidth();
        int height = this.getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();
        this.paint(g2);
        g2.dispose();
        return img;
    }

    public void loadImage() {
        int result = fileChooser.showOpenDialog(null);
        if (result == JOptionPane.OK_OPTION) {
            File imgFile = fileChooser.getSelectedFile();
            if (imgFile != null && imgFile.toString().indexOf(".png") >= 0) {
                try {
                    loadedImage = ImageIO.read(imgFile);
                } catch (IOException ioe) {}

                shapeStack = new Stack<Object>();
                repaint();
            } else {
                if (imgFile != null)
                    JOptionPane.showMessageDialog(null, "Wrong file type. Please load a PNG file.");
            }
        }
    }

    public void saveImage() {
        FileFilter filter = new FileNameExtensionFilter("*.png", "png");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                String str = file.getAbsolutePath();
                if (str.indexOf(".png") >= 0)
                    str = str.substring(0, str.length() - 4);
                ImageIO.write(createImage(), "png", new File(str + ".png"));
            } catch (IOException ioe) {}
        }
    }

    public void undo() {
        if (!shapeStack.isEmpty()) {
            undoRedoStack.push(shapeStack.pop());
            repaint();
        }
    }

    public void redo() {
        if (!undoRedoStack.isEmpty()) {
            shapeStack.push(undoRedoStack.pop());
            repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearMenuItem) {
            if (shapeStack.size() > 0) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to create a new drawing?");
                if (result == JOptionPane.YES_OPTION) {
                    shapeStack = new Stack<Object>();
                    loadedImage = null;
                    repaint();
                }
            }
        } else if (e.getSource() == loadMenuItem) {
            loadImage();
        } else if (e.getSource() == saveMenuItem) {
            saveImage();
        } else if (e.getSource() == exitMenuItem) {
            if (shapeStack.size() > 0) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
                if (result == JOptionPane.YES_OPTION)
                    System.exit(0);
            } else {
                System.exit(0);
            }
        } else if (e.getSource() == lineButton) {
            isDrawingLine = true;
            isDrawingRectangle = false;
            isDrawingEllipse = false;
            isErasing = false;

            lineButton.setBackground(Color.LIGHT_GRAY);
            rectangleButton.setBackground(null);
            ellipseButton.setBackground(null);
            eraserButton.setBackground(null);

            currentColor = oldColor;
        } else if (e.getSource() == rectangleButton) {
            isDrawingLine = false;
            isDrawingRectangle = true;
            isDrawingEllipse = false;
            isErasing = false;

            lineButton.setBackground(null);
            rectangleButton.setBackground(Color.LIGHT_GRAY);
            ellipseButton.setBackground(null);
            eraserButton.setBackground(null);

            currentColor = oldColor;
        } else if (e.getSource() == ellipseButton) {
            isDrawingLine = false;
            isDrawingRectangle = false;
            isDrawingEllipse = true;
            isErasing = false;

            lineButton.setBackground(null);
            rectangleButton.setBackground(null);
            ellipseButton.setBackground(Color.LIGHT_GRAY);
            eraserButton.setBackground(null);

            currentColor = oldColor;
        } else if (e.getSource() == eraserButton) {
            isDrawingLine = true;
            isDrawingRectangle = false;
            isDrawingEllipse = false;
            isErasing = true;

            lineButton.setBackground(null);
            rectangleButton.setBackground(null);
            ellipseButton.setBackground(null);
            eraserButton.setBackground(Color.LIGHT_GRAY);

            if (currentColor != backgroundColor)
                oldColor = currentColor;
            currentColor = backgroundColor;
        } else if (e.getSource() == undoButton) {
            undo();
        } else if (e.getSource() == redoButton) {
            redo();
        } else {
            if (isErasing) {
                isDrawingLine = true;
                isDrawingRectangle = false;
                isDrawingEllipse = false;
                isErasing = false;

                lineButton.setBackground(Color.LIGHT_GRAY);
                rectangleButton.setBackground(null);
                ellipseButton.setBackground(null);
                eraserButton.setBackground(null);
            }

            int index = (int)((JMenuItem)e.getSource()).getClientProperty("colorIndex");
            currentColor = colors[index];
        }
    }

    public void stateChanged(ChangeEvent e) {
        currentColor = colorChooser.getColor();
    }

    public void mouseDragged(MouseEvent e) {
        if (isDrawingRectangle || isDrawingEllipse) {
            if (firstClick) {
                currentX = e.getX();
                currentY = e.getY();
                if (isDrawingRectangle)
                    currentShape = new Rectangle(currentX, currentY, 0, 0, currentPenWidth, currentColor);
                else
                    currentShape = new Ellipse(currentX, currentY, 0, 0, currentPenWidth, currentColor);
                firstClick = false;
                shapeStack.push(currentShape);
            } else {
                currentWidth = Math.abs(e.getX() - currentX);
                currentHeight = Math.abs(e.getY() - currentY);
                currentShape.setWidth(currentWidth);
                currentShape.setHeight(currentHeight);
                if (currentX <= e.getX() && currentY >= e.getY()) {
                    currentShape.setY(e.getY());
                } else if (currentX >= e.getX() && currentY <= e.getY()) {
                    currentShape.setX(e.getX());
                } else if (currentX >= e.getX() && currentY >= e.getY()) {
                    currentShape.setX(e.getX());
                    currentShape.setY(e.getY());
                }
            }
        } else {
            currentPointList.add(new Point(e.getX(), e.getY(), currentPenWidth, currentColor));
        }

        repaint();
    }

    public void mouseMoved(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {
        if (isDrawingRectangle || isDrawingEllipse) {
            firstClick = true;
        } else {
            shapeStack.push(currentPointList);
            currentPointList = new ArrayList<Point>();
        }

        undoRedoStack = new Stack<Object>();
        repaint();
    }

    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource() == penWidthScrollBar) {
            currentPenWidth = penWidthScrollBar.getValue();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.isMetaDown()) {
            if (e.getKeyCode() == KeyEvent.VK_Z) {
                undo();
            }
            if (e.getKeyCode() == KeyEvent.VK_Y || (e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Z)) {
                redo();
            }
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        new Paint();
    }

    public class Point {
        private int x, y;
        private float penWidth;
        private Color color;

        public Point(int x, int y, float penWidth, Color color) {
            this.x = x;
            this.y = y;
            this.penWidth = penWidth;
            this.color = color;
        }
        
        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public float getPenWidth() {
            return penWidth;
        }
        
        public Color getColor() {
            return color;
        }
    }

    public class Shape extends Point {
        private int width, height;

        public Shape(int x, int y, int width, int height, float penWidth, Color color) {
            super(x, y, penWidth, color);
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public class Rectangle extends Shape {
        public Rectangle(int x, int y, int width, int height, float penWidth, Color color) {
            super(x, y, width, height, penWidth, color);
        }

        public Rectangle2D.Double getShape() {
            return new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
        }
    }

    public class Ellipse extends Shape {
        public Ellipse(int x, int y, int width, int height, float penWidth, Color color) {
            super(x, y, width, height, penWidth, color);
        }

        public Ellipse2D.Double getShape() {
            return new Ellipse2D.Double(getX(), getY(), getWidth(), getHeight());
        }
    }
}
