import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Maze extends JPanel implements KeyListener {
    JFrame frame;
    boolean render3D = true, hasStarted = false, hasFinished = false;

    static char[][] mazeArr;
    static Player player;

    public Maze() {
        frame = new JFrame("Maze Program");
        frame.setSize(650, 670);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        mazeArr = new char[30][30];
        setBoard(mazeArr);

        new Maze();
    }

    public static void setBoard(char[][] arr) {
        File fileName = new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/Reading .txt Files/Maze Activity/Maze.txt");
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;

            int r = 0;
            while ((text = input.readLine()) != null) {
                for (int c = 0; c < text.length(); c++) {
                    arr[r][c] = text.charAt(c);
                    if (text.charAt(c) == 'U' || text.charAt(c) == 'R' || text.charAt(c) == 'D' || text.charAt(c) == 'L') {
                        switch (text.charAt(c)) {
                            case 'U':
                                player = new Player(new Location(r, c), 0, 20, Color.CYAN);
                                break;
                            case 'R':
                                player = new Player(new Location(r, c), 1, 20, Color.CYAN);
                                break;
                            case 'D':
                                player = new Player(new Location(r, c), 2, 20, Color.CYAN);
                                break;
                            case 'L':
                                player = new Player(new Location(r, c), 3, 20, Color.CYAN);
                                break;
                            default:
                                break;
                        }
                        player.updateMap();
                    }
                }
                r++;
            }

            input.close();
        } catch (IOException e) { System.out.println("File not found"); }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Phosphate", Font.PLAIN, 20));

        if (!render3D) {
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, 650, 650);

            for (int c = 0; c < mazeArr[0].length; c++) {
                for (int r = 0; r < mazeArr.length; r++) {
                    if (player.getMap()[r][c]) {
                        if (mazeArr[r][c] == ' ' || mazeArr[r][c] == 'U' || mazeArr[r][c] == 'R' || mazeArr[r][c] == 'D' || mazeArr[r][c] == 'L') {
                            g2.setColor(Color.LIGHT_GRAY);
                            g2.fillRect(c * player.getSize() + 25, r * player.getSize() + 25, player.getSize(), player.getSize());
                        } else if (mazeArr[r][c] == 'B') {
                            g2.setColor(Color.YELLOW);
                            g2.fillRect(c * player.getSize() + 25, r * player.getSize() + 25, player.getSize(), player.getSize());
                        } else if (mazeArr[r][c] == 'T') {
                            g2.setColor(Color.RED);
                            g2.fillRect(c * player.getSize() + 25, r * player.getSize() + 25, player.getSize(), player.getSize());
                        } else if (mazeArr[r][c] == 'E') {
                            g2.setColor(Color.GREEN);
                            g2.fillRect(c * player.getSize() + 25, r * player.getSize() + 25, player.getSize(), player.getSize());
                        } else if (mazeArr[r][c] == '#') {
                            g2.setColor(Color.LIGHT_GRAY);
                            g2.drawRect(c * player.getSize() + 25, r * player.getSize() + 25, player.getSize(), player.getSize());
                        }
                    }
                }
            }

            g2.setColor(player.getColor());
            g2.fillRect(player.getLocation().getCol() * 20 + 25, player.getLocation().getRow() * 20 + 25, player.getSize(), player.getSize());

            g2.setColor(Color.WHITE);
            g2.drawString("PRESS [SPACE] TO CLOSE MAP", 205, 620);
        } else {
            ArrayList<Wall> wallList = new ArrayList<>();
            int[] rows = {275, 375, 375, 275}, cols = {275, 275, 375, 375};
            wallList.add(new Wall(rows, cols, Color.BLACK, "W"));

            boolean isVisible = true;

            if (mazeArr[player.getLocation().getRow()][player.getLocation().getCol()] == 'B')
                player.resetBrightness();
            if (mazeArr[player.getLocation().getRow()][player.getLocation().getCol()] == 'T')
                player.decreaseBrightnessBy(100);

            for (int fov = 0; fov < 5; fov++) {
                if (isVisible) {
                    int r = player.getLocation().getRow(), c = player.getLocation().getCol(), dir = player.getDirection();
                
                    try {
                        switch (dir) {
                            case 0:
                                if (mazeArr[r - fov][c - 1] == '#') {
                                    wallList.add(getLeftWall(fov));
                                } else {
                                    wallList.add(getLeftPathway(fov));
                                    wallList.add(getLeftFloor(fov));
                                    wallList.add(getLeftCeiling(fov));
                                }
                                if (mazeArr[r - fov][c + 1] == '#') {
                                    wallList.add(getRightWall(fov));
                                } else {
                                    wallList.add(getRightPathway(fov));
                                    wallList.add(getRightFloor(fov));
                                    wallList.add(getRightCeiling(fov));
                                }
                                if (mazeArr[r - fov][c] == '#') {
                                    wallList.add(getWall(fov));
                                    isVisible = false;
                                } else {
                                    wallList.add(getFloor(fov));
                                    wallList.add(getCeiling(fov));
                                }
                                break;
                            case 1:
                                if (mazeArr[r - 1][c + fov] == '#') {
                                    wallList.add(getLeftWall(fov));
                                } else {
                                    wallList.add(getLeftPathway(fov));
                                    wallList.add(getLeftFloor(fov));
                                    wallList.add(getLeftCeiling(fov));
                                }
                                if (mazeArr[r + 1][c + fov] == '#') {
                                    wallList.add(getRightWall(fov));
                                } else {
                                    wallList.add(getRightPathway(fov));
                                    wallList.add(getRightFloor(fov));
                                    wallList.add(getRightCeiling(fov));
                                }
                                if (mazeArr[r][c + fov] == '#') {
                                    wallList.add(getWall(fov));
                                    isVisible = false;
                                } else {
                                    wallList.add(getFloor(fov));
                                    wallList.add(getCeiling(fov));
                                }
                                break;
                            case 2:
                                if (mazeArr[r + fov][c + 1] == '#') {
                                    wallList.add(getLeftWall(fov));
                                } else {
                                    wallList.add(getLeftPathway(fov));
                                    wallList.add(getLeftFloor(fov));
                                    wallList.add(getLeftCeiling(fov));
                                }
                                if (mazeArr[r + fov][c - 1] == '#') {
                                    wallList.add(getRightWall(fov));
                                } else {
                                    wallList.add(getRightPathway(fov));
                                    wallList.add(getRightFloor(fov));
                                    wallList.add(getRightCeiling(fov));
                                }
                                if (mazeArr[r + fov][c] == '#') {
                                    wallList.add(getWall(fov));
                                    isVisible = false;
                                } else {
                                    wallList.add(getFloor(fov));
                                    wallList.add(getCeiling(fov));
                                }
                                break;
                            case 3:
                                if (mazeArr[r + 1][c - fov] == '#') {
                                    wallList.add(getLeftWall(fov));
                                } else {
                                    wallList.add(getLeftPathway(fov));
                                    wallList.add(getLeftFloor(fov));
                                    wallList.add(getLeftCeiling(fov));
                                }
                                if (mazeArr[r - 1][c - fov] == '#') {
                                    wallList.add(getRightWall(fov));
                                } else {
                                    wallList.add(getRightPathway(fov));
                                    wallList.add(getRightFloor(fov));
                                    wallList.add(getRightCeiling(fov));
                                }
                                if (mazeArr[r][c - fov] == '#') {
                                    wallList.add(getWall(fov));
                                    isVisible = false;
                                } else {
                                    wallList.add(getFloor(fov));
                                    wallList.add(getCeiling(fov));
                                }
                                break;
                            default:
                                break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {}
                }
            }
            drawWalls(g2, wallList);

            if (!hasStarted) {
                g2.setColor(Color.WHITE);
                g2.drawString("TRAVERSE THE MAZE IN SEARCH OF THE END.", 145, 330);
                hasStarted = true;
            }

            g2.setColor(Color.BLACK);
            g2.drawString("PRESS [SPACE] TO OPEN MAP", 210, 620);

            if (player.getBrightness() < 125)
                g2.setColor(Color.WHITE);
            else
                g2.setColor(Color.BLACK); 

            if (player.getBrightness() <= 25)
                g2.drawString("YOUR FLASHLIGHT RAN OUT OF BATTERIES. YOU LOSE.", 95, 330);
        
            if (mazeArr[player.getLocation().getRow()][player.getLocation().getCol()] == 'E') {
                g2.drawString("YOU\'VE EMERGED FROM THE DEPTHS OF THE MAZE.", 115, 310);
                g2.drawString("IT TOOK YOU " + player.getSteps() + " STEPS.", 235, 350);
                hasFinished = true;
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 32)
            render3D = !render3D;

        if (!hasFinished)
            player.move(e.getKeyCode(), mazeArr, render3D);

        repaint();
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public void drawWalls(Graphics2D g2, ArrayList<Wall> wallList) {
        for (Wall wall : wallList) {
            if (wall.getType().equals("W"))
                g2.setColor(wall.getColor());
            else
                g2.setPaint(wall.getPaint());
            g2.fillPolygon(new Polygon(wall.getRows(), wall.getCols(), wall.getRows().length));
            g2.setColor(Color.BLACK);
            g2.drawPolygon(new Polygon(wall.getRows(), wall.getCols(), wall.getRows().length));
        }
    }

    public Wall getLeftCeiling(int fov) {
        int[] rows = {25 + 50 * fov, 75 + 50 * fov, 25 + 50 * fov};
        int[] cols = {25 + 50 * fov, 75 + 50 * fov, 75 + 50 * fov};
        int currentBrightness = player.getBrightness() - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "LC");
        else
            return new Wall(rows, cols, 0, 0, 0, "LC");
    }

    public Wall getRightCeiling(int fov) {
        int[] rows = {575 - 50 * fov, 625 - 50 * fov, 625 - 50 * fov};
        int[] cols = {75 + 50 * fov, 25 + 50 * fov, 75 + 50 * fov};
        int currentBrightness = player.getBrightness() - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "RC");
        else
            return new Wall(rows, cols, 0, 0, 0, "RC");
    }

    public Wall getCeiling(int fov) {
        int[] rows = {75 + 50 * fov, 25 + 50 * fov, 625 - 50 * fov, 575 - 50 * fov};
        int[] cols = {75 + 50 * fov, 25 + 50 * fov, 25 + 50 * fov, 75 + 50 * fov};
        int currentBrightness = player.getBrightness() - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "C");
        else
            return new Wall(rows, cols, 0, 0, 0, "C");
    }

    public Wall getLeftFloor(int fov) {
        int[] rows = {25 + 50 * fov, 75 + 50 * fov, 25 + 50 * fov};
        int[] cols = {575 - 50 * fov, 575 - 50 * fov, 625 - 50 * fov};
        int currentBrightness = player.getBrightness() - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "LF");
        else
            return new Wall(rows, cols, 0, 0, 0, "LF");
    }

    public Wall getRightFloor(int fov) {
        int[] rows = {575 - 50 * fov, 625 - 50 * fov, 625 - 50 * fov};
        int[] cols = {575 - 50 * fov, 575 - 50 * fov, 625 - 50 * fov};
        int currentBrightness = player.getBrightness() - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "RF");
        else
            return new Wall(rows, cols, 0, 0, 0, "RF");
    }

    public Wall getFloor(int fov) {
        int[] rows = {25 + 50 * fov, 75 + 50 * fov, 575 - 50 * fov, 625 - 50 * fov};
        int[] cols = {625 - 50 * fov, 575 - 50 * fov, 575 - 50 * fov, 625 - 50 * fov};
        int currentBrightness = player.getBrightness() - 50 * fov;
        int r = player.getLocation().getRow(), c = player.getLocation().getCol();
        if (currentBrightness >= 0) {
            try {
                switch (player.getDirection()) {
                    case 0:
                        if (mazeArr[r - fov][c] == 'B')
                            return new Wall(rows, cols, currentBrightness, currentBrightness, 0, "F");
                        else if (mazeArr[r - fov][c] == 'T')
                            return new Wall(rows, cols, currentBrightness, 0, 0, "F");
                        else if (mazeArr[r - fov][c] == 'E')
                            return new Wall(rows, cols, 0, currentBrightness, 0, "F");
                        else
                            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "F");
                    case 1:
                        if (mazeArr[r][c + fov] == 'B')
                            return new Wall(rows, cols, currentBrightness, currentBrightness, 0, "F");
                        else if (mazeArr[r][c + fov] == 'T')
                            return new Wall(rows, cols, currentBrightness, 0, 0, "F");
                        else if (mazeArr[r][c + fov] == 'E')
                            return new Wall(rows, cols, 0, currentBrightness, 0, "F");
                        else
                            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "F");
                    case 2:
                        if (mazeArr[r + fov][c] == 'B')
                            return new Wall(rows, cols, currentBrightness, currentBrightness, 0, "F");
                        else if (mazeArr[r + fov][c] == 'T')
                            return new Wall(rows, cols, currentBrightness, 0, 0, "F");
                        else if (mazeArr[r + fov][c] == 'E')
                            return new Wall(rows, cols, 0, currentBrightness, 0, "F");
                        else
                            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "F");
                    case 3:
                        if (mazeArr[r][c - fov] == 'B')
                            return new Wall(rows, cols, currentBrightness, currentBrightness, 0, "F");
                        else if (mazeArr[r][c - fov] == 'T')
                            return new Wall(rows, cols, currentBrightness, 0, 0, "F");
                        else if (mazeArr[r][c - fov] == 'E')
                            return new Wall(rows, cols, 0, currentBrightness, 0, "F");
                        else
                            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "F");
                    default:
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }
        
        return new Wall(rows, cols, 0, 0, 0, "F");
    }

    public Wall getLeftWall(int fov) {
        int[] rows = {25 + 50 * fov, 75 + 50 * fov, 75 + 50 * fov, 25 + 50 * fov};
        int[] cols = {25 + 50 * fov, 75 + 50 * fov, 575 - 50 * fov, 625 - 50 * fov};
        int currentBrightness = player.getBrightness() - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "LW");
        else
            return new Wall(rows, cols, 0, 0, 0, "LW");
    }

    public Wall getRightWall(int fov) {
        int[] rows = {575 - 50 * fov, 625 - 50 * fov, 625 - 50 * fov, 575 - 50 * fov};
        int[] cols = {75 + 50 * fov, 25 + 50 * fov, 625 - 50 * fov, 575 - 50 * fov};
        int currentBrightness = player.getBrightness() - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "RW");
        else
            return new Wall(rows, cols, 0, 0, 0, "RW");
    }

    public Wall getWall(int fov) {
        int[] rows = {25 + 50 * fov, 625 - 50 * fov, 625 - 50 * fov, 25 + 50 * fov};
        int[]cols = {25 + 50 * fov, 25 + 50 * fov, 625 - 50 * fov, 625 - 50 * fov};
        int currentBrightness = player.getBrightness() - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "W");
        else
            return new Wall(rows, cols, 0, 0, 0, "W");
    }

    public Wall getLeftPathway(int fov) {
        int[] rows = {25 + 50 * fov, 75 + 50 * fov, 75 + 50 * fov, 25 + 50 * fov};
        int[] cols = {75 + 50 * fov, 75 + 50 * fov, 575 - 50 * fov, 575 - 50 * fov};
        int currentBrightness = player.getBrightness() - 50 - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "LP");
        else
            return new Wall(rows, cols, 0, 0, 0, "LP");
    }

    public Wall getRightPathway(int fov) {
        int[] rows = {575 - 50 * fov, 625 - 50 * fov, 625 - 50 * fov, 575 - 50 * fov};
        int[] cols = {75 + 50 * fov, 75 + 50 * fov, 575 - 50 * fov, 575 - 50 * fov};
        int currentBrightness = player.getBrightness() - 50 - 50 * fov;
        if (currentBrightness >= 0)
            return new Wall(rows, cols, currentBrightness, currentBrightness, currentBrightness, "RP");
        else
            return new Wall(rows, cols, 0, 0, 0, "RP");
    }
}