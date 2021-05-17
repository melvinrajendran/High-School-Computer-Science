import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.InsetsUIResource;

import java.awt.event.*;
import java.awt.*;

public class GUI extends JPanel implements ActionListener {
    JFrame frame;
    JPanel buttonPanel, bigPanel;
    JMenuBar menuBar;
    GridLayout buttonLayout, menuLayout, bigLayout;
    JButton nButton, eButton, sButton, wButton, resetButton;
    JMenu fontMenu, fontSizeMenu, textColorMenu, bgColorMenu, outlineColorMenu;
    JMenuItem[] fontOptions, fontSizeOptions, textColorOptions, bgColorOptions, outlineColorOptions;
    String[] fontNames, textColorNames, bgColorNames, outlineColorNames;
    JTextArea textArea;
    Font[] fonts;
    Font currentFont;
    Color[] textColors, bgColors, outlineColors;
    Color currentTextColor, currentBGColor, currentOutlineColor;
    
    int[] fontSizes;
    int currentFontSize;

    public GUI() {
        frame = new JFrame("GUI Program");
        frame.add(this);
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        menuBar = new JMenuBar();

        fontMenu = new JMenu("Font");
        fontOptions = new JMenuItem[8];

        fontSizeMenu = new JMenu("Font Size");
        fontSizeOptions = new JMenuItem[8];

        textColorMenu = new JMenu("Text Color");
        textColorOptions = new JMenuItem[9];

        bgColorMenu = new JMenu("BG Color");
        bgColorOptions = new JMenuItem[9];

        outlineColorMenu = new JMenu("O Color");
        outlineColorOptions = new JMenuItem[10];

        menuBar.setLayout(new GridLayout(1, 6));
        menuBar.add(fontMenu);
        menuBar.add(fontSizeMenu);
        menuBar.add(textColorMenu);
        menuBar.add(bgColorMenu);
        menuBar.add(outlineColorMenu);

        fontNames = new String[]{"Arial", "Avant Garde", "Calibri", "Comic Sans MS", "Courier", "Courier New", "Helvetica", "Times New Roman"};
        fontSizes = new int[]{16, 18, 20, 22, 24, 26, 28, 30};
        fonts = new Font[fontNames.length];
        for (int x = 0; x < fontNames.length; x++) {
            fonts[x] = new Font(fontNames[x], Font.PLAIN, fontSizes[0]);

            fontOptions[x] = new JMenuItem(fontNames[x]);
            fontOptions[x].setFont(fonts[x]);
            fontOptions[x].addActionListener(this);
            fontMenu.add(fontOptions[x]);
        }
        currentFont = fonts[0];

        for (int x = 0; x < fontSizes.length; x++) {
            fontSizeOptions[x] = new JMenuItem(fontSizes[x] + "px");
            fontSizeOptions[x].setFont(currentFont);
            fontSizeOptions[x].addActionListener(this);
            fontSizeMenu.add(fontSizeOptions[x]);
        }
        currentFontSize = fontSizes[0];

        textColorNames = new String[]{"Black", "Gray", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta", "Random"};
        textColors = new Color[]{Color.BLACK, Color.GRAY, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, getRandomColor()};
        for (int x = 0; x < textColorNames.length; x++) {
            textColorOptions[x] = new JMenuItem(textColorNames[x]);
            textColorOptions[x].setFont(currentFont);
            textColorOptions[x].setForeground(textColors[x]);
            textColorOptions[x].addActionListener(this);
            textColorMenu.add(textColorOptions[x]);
        }
        currentTextColor = textColors[0];

        bgColorNames = new String[]{"White", "Gray", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta", "Random"};
        bgColors = new Color[]{Color.WHITE, Color.GRAY, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, getRandomColor()};
        for (int x = 0; x < bgColorNames.length; x++) {
            bgColorOptions[x] = new JMenuItem(bgColorNames[x]);
            bgColorOptions[x].setFont(currentFont);
            bgColorOptions[x].setForeground(bgColors[x]);
            bgColorOptions[x].addActionListener(this);
            bgColorMenu.add(bgColorOptions[x]);
        }
        currentBGColor = bgColors[0];

        outlineColorNames = new String[]{"None", "Black", "Gray", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta", "Random"};
        outlineColors = new Color[]{null, Color.BLACK, Color.GRAY, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, getRandomColor()}; 
        for (int x = 0; x < outlineColorNames.length; x++) {
            outlineColorOptions[x] = new JMenuItem(outlineColorNames[x]);
            outlineColorOptions[x].setFont(currentFont);
            outlineColorOptions[x].setForeground(outlineColors[x]);
            outlineColorOptions[x].addActionListener(this);
            outlineColorMenu.add(outlineColorOptions[x]);
        }
        currentOutlineColor = outlineColors[0];

        nButton = new JButton("North");
        eButton = new JButton("East");
        sButton = new JButton("South");
        wButton = new JButton("West");
        resetButton = new JButton("Reset");
        nButton.addActionListener(this);
        eButton.addActionListener(this);
        sButton.addActionListener(this);
        wButton.addActionListener(this);
        resetButton.addActionListener(this);
        nButton.setBorder(new LineBorder(outlineColors[0], 2));
        eButton.setBorder(new LineBorder(outlineColors[0], 2));
        sButton.setBorder(new LineBorder(outlineColors[0], 2));
        wButton.setBorder(new LineBorder(outlineColors[0], 2));
        resetButton.setBorder(new LineBorder(outlineColors[0], 2));

        menuBar.add(resetButton);

        buttonLayout = new GridLayout(1, 4);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(buttonLayout);
        buttonPanel.add(nButton);
        buttonPanel.add(eButton);
        buttonPanel.add(sButton);
        buttonPanel.add(wButton);

        textArea = new JTextArea();
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        textArea.setFont(fonts[0]);
        textArea.setMargin(new InsetsUIResource(30, 30, 30, 30));
        textArea.setLineWrap(true);

        bigLayout = new GridLayout(1, 2);
        bigPanel = new JPanel();
        bigPanel.setLayout(bigLayout);
        bigPanel.add(buttonPanel);
        bigPanel.add(menuBar);

        frame.add(bigPanel, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nButton) {
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(1, 4);
            buttonPanel.setLayout(buttonLayout);

            bigLayout = new GridLayout(1, 2);
            bigPanel.setLayout(bigLayout);
            bigPanel.remove(menuBar);
            bigPanel.remove(buttonPanel);
            bigPanel.add(buttonPanel);
            bigPanel.add(menuBar);
            
            menuBar.setLayout(new GridLayout(1, 6));
            menuBar.remove(fontMenu);
            menuBar.remove(fontSizeMenu);
            menuBar.remove(textColorMenu);
            menuBar.remove(bgColorMenu);
            menuBar.remove(outlineColorMenu);
            menuBar.remove(resetButton);
            menuBar.add(fontMenu);
            menuBar.add(fontSizeMenu);
            menuBar.add(textColorMenu);
            menuBar.add(bgColorMenu);
            menuBar.add(outlineColorMenu);
            menuBar.add(resetButton);

            frame.add(bigPanel, BorderLayout.NORTH);
        }
        if (e.getSource() == eButton) {
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(4, 1);
            buttonPanel.setLayout(buttonLayout);

            bigLayout = new GridLayout(2, 1);
            bigPanel.setLayout(bigLayout);
            bigPanel.remove(menuBar);
            bigPanel.remove(buttonPanel);
            bigPanel.add(buttonPanel);
            bigPanel.add(menuBar);
            
            menuBar.setLayout(new GridLayout(6, 1));
            menuBar.remove(fontMenu);
            menuBar.remove(fontSizeMenu);
            menuBar.remove(textColorMenu);
            menuBar.remove(bgColorMenu);
            menuBar.remove(outlineColorMenu);
            menuBar.remove(resetButton);
            menuBar.add(fontMenu);
            menuBar.add(fontSizeMenu);
            menuBar.add(textColorMenu);
            menuBar.add(bgColorMenu);
            menuBar.add(outlineColorMenu);
            menuBar.add(resetButton);

            frame.add(bigPanel, BorderLayout.EAST);
        }
        if (e.getSource() == sButton) {
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(1, 4);
            buttonPanel.setLayout(buttonLayout);

            bigLayout = new GridLayout(1, 2);
            bigPanel.setLayout(bigLayout);
            bigPanel.remove(menuBar);
            bigPanel.remove(buttonPanel);
            bigPanel.add(buttonPanel);
            bigPanel.add(menuBar);
            
            menuBar.setLayout(new GridLayout(1, 6));
            menuBar.remove(fontMenu);
            menuBar.remove(fontSizeMenu);
            menuBar.remove(textColorMenu);
            menuBar.remove(bgColorMenu);
            menuBar.remove(outlineColorMenu);
            menuBar.remove(resetButton);
            menuBar.add(fontMenu);
            menuBar.add(fontSizeMenu);
            menuBar.add(textColorMenu);
            menuBar.add(bgColorMenu);
            menuBar.add(outlineColorMenu);
            menuBar.add(resetButton);

            frame.add(bigPanel, BorderLayout.SOUTH);
        }
        if (e.getSource() == wButton) {
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(4, 1);
            buttonPanel.setLayout(buttonLayout);

            bigLayout = new GridLayout(2, 1);
            bigPanel.setLayout(bigLayout);
            bigPanel.remove(menuBar);
            bigPanel.remove(buttonPanel);
            bigPanel.add(buttonPanel);
            bigPanel.add(menuBar);
            
            menuBar.setLayout(new GridLayout(6, 1));
            menuBar.remove(fontMenu);
            menuBar.remove(fontSizeMenu);
            menuBar.remove(textColorMenu);
            menuBar.remove(bgColorMenu);
            menuBar.remove(outlineColorMenu);
            menuBar.remove(resetButton);
            menuBar.add(fontMenu);
            menuBar.add(fontSizeMenu);
            menuBar.add(textColorMenu);
            menuBar.add(bgColorMenu);
            menuBar.add(outlineColorMenu);
            menuBar.add(resetButton);

            frame.add(bigPanel, BorderLayout.WEST);
        }
        if (e.getSource() == resetButton) {
            frame.remove(bigPanel);

            buttonLayout = new GridLayout(1, 4);
            buttonPanel.setLayout(buttonLayout);

            bigLayout = new GridLayout(1, 2);
            bigPanel.setLayout(bigLayout);
            bigPanel.remove(menuBar);
            bigPanel.remove(buttonPanel);
            bigPanel.add(buttonPanel);
            bigPanel.add(menuBar);
            
            menuBar.setLayout(new GridLayout(1, 6));
            menuBar.remove(fontMenu);
            menuBar.remove(fontSizeMenu);
            menuBar.remove(textColorMenu);
            menuBar.remove(bgColorMenu);
            menuBar.remove(outlineColorMenu);
            menuBar.remove(resetButton);
            menuBar.add(fontMenu);
            menuBar.add(fontSizeMenu);
            menuBar.add(textColorMenu);
            menuBar.add(bgColorMenu);
            menuBar.add(outlineColorMenu);
            menuBar.add(resetButton);

            frame.add(bigPanel, BorderLayout.NORTH);

            currentFontSize = fontSizes[0];
            currentFont = fonts[0];

            for (Component c : buttonPanel.getComponents())
                if (c instanceof JButton)
                   ((JButton)c).setFont(currentFont);

            for (int i = 0; i < menuBar.getComponents().length; i++) {
                Component c = menuBar.getComponents()[i];
                c.setFont(currentFont);
                if (c instanceof JMenu && i != 0)
                    for (Component d : ((JMenu)c).getMenuComponents())
                        d.setFont(currentFont);
            }

            textArea.setText(null);
            textArea.setBackground(bgColors[0]);
            textArea.setForeground(textColors[0]);
            textArea.setFont(new Font(fontNames[0], Font.PLAIN, fontSizes[0]));
            textArea.setMargin(new InsetsUIResource(30, 30, 30, 30));
            textArea.setLineWrap(true);

            nButton.setBorder(new LineBorder(outlineColors[0], 2));
            eButton.setBorder(new LineBorder(outlineColors[0], 2));
            sButton.setBorder(new LineBorder(outlineColors[0], 2));
            wButton.setBorder(new LineBorder(outlineColors[0], 2));
            resetButton.setBorder(new LineBorder(outlineColors[0], 2));
        }

        for (int x = 0; x < fontOptions.length; x++) {
            if (e.getSource() == fontOptions[x]) {
                currentFont = new Font(fontNames[x], Font.PLAIN, currentFontSize);

                for (Component c : buttonPanel.getComponents())
                    if (c instanceof JButton)
                       ((JButton)c).setFont(new Font(currentFont.getName(), Font.PLAIN, fontSizes[0]));

                for (int i = 0; i < menuBar.getComponents().length; i++) {
                    Component c = menuBar.getComponents()[i];
                    c.setFont(new Font(currentFont.getName(), Font.PLAIN, fontSizes[0]));
                    if (c instanceof JMenu && i != 0)
                        for (Component d : ((JMenu)c).getMenuComponents())
                            d.setFont(new Font(currentFont.getName(), Font.PLAIN, fontSizes[0]));
                }
                textArea.setFont(currentFont);
            }
        }

        for (int x = 0; x < fontSizeOptions.length; x++) {
            if (e.getSource() == fontSizeOptions[x]) {
                currentFontSize = fontSizes[x];
                currentFont = new Font(currentFont.getName(), Font.PLAIN, currentFontSize);
                textArea.setFont(currentFont);
            }
        }

        for (int x = 0; x < textColorOptions.length; x++) {
            if (e.getSource() == textColorOptions[x]) {
                currentTextColor = textColors[x];
                textArea.setForeground(textColors[x]);
                if (x == textColorOptions.length - 1) {
                    textColors[x] = getRandomColor();
                    textColorOptions[x].setForeground(textColors[x]);
                }
            }
        }

        for (int x = 0; x < bgColorOptions.length; x++) {
            if (e.getSource() == bgColorOptions[x]) {
                currentBGColor = bgColors[x];
                textArea.setBackground(bgColors[x]);
                if (x == bgColorOptions.length - 1) {
                    bgColors[x] = getRandomColor();
                    bgColorOptions[x].setForeground(bgColors[x]);
                }
            }
        }

        for (int x = 0; x < outlineColorOptions.length; x++) {
            if (e.getSource() == outlineColorOptions[x]) {
                currentOutlineColor = outlineColors[x];
                nButton.setBorder(new LineBorder(outlineColors[x], 2));
                eButton.setBorder(new LineBorder(outlineColors[x], 2));
                sButton.setBorder(new LineBorder(outlineColors[x], 2));
                wButton.setBorder(new LineBorder(outlineColors[x], 2));
                resetButton.setBorder(new LineBorder(outlineColors[x], 2));
                if (x == outlineColorOptions.length - 1) {
                    outlineColors[x] = getRandomColor();
                    outlineColorOptions[x].setForeground(outlineColors[x]);
                }
            }
        }

        frame.revalidate();
    }

    public static void main(String[] args) {
        GUI app = new GUI();
    }

    public Color getRandomColor() {
        return new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
    }
}
