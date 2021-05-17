import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

public class Minesweeper extends JFrame implements ActionListener, MouseListener {
    JMenuBar menuBar;
    JMenu difficultyMenu;
    JMenuItem beginner, intermediate, expert;
    JButton resetButton;
    ImageIcon mineIcon, flagIcon, loseIcon, smileIcon, waitIcon, winIcon;
    JTextField timeField;

    JPanel boardPanel;
    JToggleButton[][] board;
    ImageIcon[] numIcons;

    Timer timer;
    Font numFont = new Font("Digital-7", Font.PLAIN, 32), textFont = new Font("MINE-SWEEPER", Font.PLAIN, 10);
    Color[] colorArr = new Color[]{Color.BLUE, new Color(0, 128, 0), Color.RED, new Color(128, 0, 128), Color.BLACK, Color.GRAY, new Color(128, 0, 0), new Color(64, 224, 208)};
    
    boolean firstClick = true, gameOn = true;
    int numMines, dimR, dimC, timePassed, count = 0;

    public Minesweeper() {
        mineIcon = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Minesweeper Activity/Images/mine.png");
        mineIcon = new ImageIcon(mineIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        flagIcon = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Minesweeper Activity/Images/flag.png");
        flagIcon = new ImageIcon(flagIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        loseIcon = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Minesweeper Activity/Images/lose0.png");
        loseIcon = new ImageIcon(loseIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        smileIcon = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Minesweeper Activity/Images/smile0.png");
        smileIcon = new ImageIcon(smileIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        waitIcon = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Minesweeper Activity/Images/wait0.png");
        waitIcon = new ImageIcon(waitIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        winIcon = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Minesweeper Activity/Images/win0.png");
        winIcon = new ImageIcon(winIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        numIcons = new ImageIcon[8];
        for (int x = 0; x < 8; x++) {
            numIcons[x] = new ImageIcon("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Minesweeper Activity/Images/" + (x + 1) + ".png");
            numIcons[x] = new ImageIcon(numIcons[x].getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        }

        numMines = 10;
        dimR = 9;
        dimC = 9;

        difficultyMenu = new JMenu("Difficulty");
        beginner = new JMenuItem("Beginner");
        intermediate = new JMenuItem("Intermediate");
        expert = new JMenuItem("Expert");
        difficultyMenu.setFont(textFont);
        beginner.setFont(textFont);
        intermediate.setFont(textFont);
        expert.setFont(textFont);
        beginner.addActionListener(this);
        intermediate.addActionListener(this);
        expert.addActionListener(this);
        difficultyMenu.add(beginner);
        difficultyMenu.add(intermediate);
        difficultyMenu.add(expert);

        resetButton = new JButton();
        resetButton.addActionListener(this);
        resetButton.setIcon(smileIcon);

        timeField = new JTextField("0");
        timeField.setFont(numFont);
        timeField.setBackground(Color.BLACK);
        timeField.setForeground(Color.RED);
        timeField.setEditable(false);

        menuBar = new JMenuBar();
        menuBar.setLayout(new GridLayout(1, 3));
        menuBar.add(difficultyMenu);
        menuBar.add(resetButton);
        menuBar.add(timeField);

        this.add(menuBar, BorderLayout.NORTH);

        createBoard(dimR, dimC);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void createBoard(int row, int col) {
        if (boardPanel != null)
            this.remove(boardPanel);
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(row, col));

        board = new JToggleButton[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                board[r][c] = new JToggleButton();
                board[r][c].addMouseListener(this);
                board[r][c].setBorder(BorderFactory.createBevelBorder(1));
                board[r][c].setFocusPainted(false);
                board[r][c].putClientProperty("row", r);
                board[r][c].putClientProperty("col", c);
                board[r][c].putClientProperty("state", 0);

                boardPanel.add(board[r][c]);
            }
        }
        
        this.add(boardPanel, BorderLayout.CENTER);
        this.setSize(col * 40, row * 40 + 60);
        this.revalidate();
    }

    public void setMinesAndCounts(int row, int col) {
        int tempCount = numMines;
        while (tempCount > 0) {
            int randR = (int)(Math.random() * dimR), randC = (int)(Math.random() * dimC), state = (int)board[randR][randC].getClientProperty("state");
            if (state == 0 && (Math.abs(row - randR) > 1 || Math.abs(col - randC) > 1)) {
                board[randR][randC].putClientProperty("state", 9);
                tempCount--;
            }
        }

        for (int r = 0; r < dimR; r++) {
            for (int c = 0; c < dimC; c++) {
                if ((int)(board[r][c].getClientProperty("state")) != 9) {
                    int mineCount = 0;
                    for (int rr = r - 1; rr <= r + 1; rr++) {
                        for (int cc = c - 1; cc <= c + 1; cc++) {
                            try {
                                if ((int)(board[rr][cc].getClientProperty("state")) == 9)
                                    mineCount++;
                            } catch (ArrayIndexOutOfBoundsException e) {}
                        }
                    }

                    board[r][c].putClientProperty("state", mineCount);
                }
            }
        }
    }

    public void revealMines() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                int state = (int)(board[r][c].getClientProperty("state"));
                if (state == 9) {
                    board[r][c].setIcon(mineIcon);
                    board[r][c].setDisabledIcon(mineIcon);
                    board[r][c].setSelected(true);
                }
                board[r][c].setEnabled(false);
            }
        }
    }

    public void expand(int row, int col) {
        if (!board[row][col].isSelected()) {
            board[row][col].setBackground(Color.LIGHT_GRAY);
            board[row][col].setEnabled(false);
            board[row][col].setOpaque(true);
            board[row][col].setSelected(true);
            
            count++;
        }

        int state = (int)(board[row][col].getClientProperty("state"));
        if (state > 0) {
            writeText(row, col, state);
        } else {
            for (int rr = row - 1; rr <= row + 1; rr++) {
                for (int cc = col - 1; cc <= col + 1; cc++) {
                    try {
                        if (!board[rr][cc].isSelected() && board[rr][cc].getIcon() == null)
                            expand(rr, cc);
                    } catch (ArrayIndexOutOfBoundsException e) {}
                }
            }
        }
    }

    public void writeText(int row, int col, int state) {
        if (state > 0) {
            board[row][col].setIcon(numIcons[state - 1]);
            board[row][col].setDisabledIcon(numIcons[state - 1]);
        }
    }

    public boolean checkWin() {
        return numMines == dimR * dimC - count;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == beginner) {
            numMines = 10;
            dimR = 9;
            dimC = 9;
        }
        if (e.getSource() == intermediate) {
            numMines = 40;
            dimR = 16;
            dimC = 16;
        }
        if (e.getSource() == expert) {
            numMines = 99;
            dimR = 16;
            dimC = 30;
        }
        if (e.getSource() == resetButton) {}

        resetButton.setIcon(smileIcon);
        if (!firstClick)
            timer.cancel();
        timePassed = 0;
        timeField.setText(timePassed + "");
        count = 0;

        createBoard(dimR, dimC);
        firstClick = true;
        gameOn = true;
    }

    public void mousePressed(MouseEvent e) {
        int row = (int)(((JToggleButton)e.getComponent()).getClientProperty("row"));
        int col = (int)(((JToggleButton)e.getComponent()).getClientProperty("col"));

        if (gameOn)
            if (e.getButton() == MouseEvent.BUTTON1 && board[row][col].isEnabled())
                resetButton.setIcon(waitIcon);
    }

    public void mouseReleased(MouseEvent e) {
        int row = (int)(((JToggleButton)e.getComponent()).getClientProperty("row"));
        int col = (int)(((JToggleButton)e.getComponent()).getClientProperty("col"));

        if (gameOn) {
            if (e.getButton() == MouseEvent.BUTTON1 && board[row][col].isEnabled()) {
                board[row][col].setBackground(Color.LIGHT_GRAY);
                board[row][col].setOpaque(true);
                if (firstClick) {
                    setMinesAndCounts(row, col);
                    timer = new Timer();
                    timer.schedule(new UpdateTimer(), 0, 1000);
                    firstClick = false;
                }
                resetButton.setIcon(smileIcon);
    
                int state = (int)board[row][col].getClientProperty("state");
                if (state == 9) {
                    board[row][col].setBackground(Color.RED);
                    board[row][col].setContentAreaFilled(true);
                    board[row][col].setIcon(mineIcon);
                    board[row][col].setOpaque(true);
                    
                    revealMines();
                    resetButton.setIcon(loseIcon);
                    timer.cancel();
                    gameOn = false;
                    
                } else {
                    expand(row, col);
                    count++;
                }

                if (checkWin()) {
                    gameOn = false;
                    resetButton.setIcon(winIcon);
                    timer.cancel();

                    for (int r = 0; r < dimR; r++) {
                        for (int c = 0; c < dimC; c++) {
                            if ((int)(board[r][c].getClientProperty("state")) == 9) {
                                board[r][c].setIcon(flagIcon);
                                board[r][c].setDisabledIcon(flagIcon);
                            }
                            board[r][c].setEnabled(false);
                        }
                    }
                }
            }
            if (e.getButton() == MouseEvent.BUTTON3) {
                if (!board[row][col].isSelected()) {
                    if (board[row][col].getIcon() == null) {
                        board[row][col].setIcon(flagIcon);
                        board[row][col].setDisabledIcon(flagIcon);
                        board[row][col].setEnabled(false);
                    } else {
                        board[row][col].setIcon(null);
                        board[row][col].setDisabledIcon(null);
                        board[row][col].setEnabled(true);
                    } 
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new Minesweeper();
    }

    public class UpdateTimer extends TimerTask {
        public void run() {
            if (gameOn) {
                timePassed++;
                timeField.setText(timePassed + "");
            }
        }
    }
}