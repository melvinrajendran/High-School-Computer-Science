import java.awt.Color;
import java.util.ArrayList;

public class Player {
    private Location location;
    private int direction, size, steps, brightness;
    private Color color;
    private boolean[][] map;

    public Player(Location location, int direction, int size, Color color) {
        this.location = location;
        this.direction = direction;
        this.size = size;
        this.color = color;
        this.steps = 0;
        this.brightness = 255;
        this.map = new boolean[30][30];
        this.map[location.getRow()][location.getCol()] = true;
    }

    public Location getLocation() { return location; }

    public int getDirection() { return direction; }

    public int getSize() { return size; }

    public int getBrightness() { return brightness; }

    public void resetBrightness() { brightness = 255; }

    public Color getColor() { return color; }

    public int getSteps() { return steps; }

    public boolean[][] getMap() { return map; }

    public void updateMap() {
        int initialC = location.getCol() - 1, finalC = initialC + 3;
        int initialR = location.getRow() - 1, finalR = initialR + 3;
        try {
            for (int c = initialC; c < finalC; c++)
                for (int r = initialR; r < finalR; r++)
                    map[r][c] = true;
        } catch (ArrayIndexOutOfBoundsException e) {}
    }

    public void move(int keyCode, char[][] mazeArr, boolean render3D) {
        if (brightness > 0) {
            int r = location.getRow(), c = location.getCol();
            ArrayList<Character> validSpaces = new ArrayList<>();
            validSpaces.add(' ');
            validSpaces.add('U');
            validSpaces.add('R');
            validSpaces.add('D');
            validSpaces.add('L');
            validSpaces.add('E');
            validSpaces.add('B');
            boolean didMove = false;
    
            if (!render3D) {
                // if ((keyCode == 38 || keyCode == 87) && r > 0 && validSpaces.contains(mazeArr[r - 1][c])) {
                //     location.changeRowBy(-1);
                //     didMove = true;
                // }
                // if ((keyCode == 39 || keyCode == 68) && c < mazeArr[0].length - 1 && validSpaces.contains(mazeArr[r][c + 1])) {
                //     location.changeColBy(1);
                //     didMove = true;
                // }
                // if ((keyCode == 40 || keyCode == 83) && r < mazeArr.length - 1 && validSpaces.contains(mazeArr[r + 1][c])) {
                //     location.changeRowBy(1);
                //     didMove = true;
                // }
                // if ((keyCode == 37  || keyCode == 65) && c > 0 && validSpaces.contains(mazeArr[r][c - 1])) {
                //     location.changeColBy(-1);
                //     didMove = true;
                // }
    
                // if (keyCode == 38 || keyCode == 87)
                //     direction = 0;
                // if (keyCode == 39 || keyCode == 68)
                //     direction = 1;
                // if (keyCode == 40 || keyCode == 83)
                //     direction = 2;
                // if (keyCode == 37  || keyCode == 65)
                //     direction = 3;
            } else {
                if (keyCode == 38 || keyCode == 87) {
                    if (direction == 0 && r > 0 && validSpaces.contains(mazeArr[r - 1][c])) {
                        location.changeRowBy(-1);
                        didMove = true;
                    }
                    if (direction == 1 && c < mazeArr[0].length - 1 && validSpaces.contains(mazeArr[r][c + 1])) {
                        location.changeColBy(1);
                        didMove = true;
                    }
                    if (direction == 2 && r < mazeArr.length - 1 && validSpaces.contains(mazeArr[r + 1][c])) {
                        location.changeRowBy(1);
                        didMove = true;
                    }
                    if (direction == 3 && c > 0 && validSpaces.contains(mazeArr[r][c - 1])) {
                        location.changeColBy(-1);
                        didMove = true;
                    }
                }
    
                if (keyCode == 37  || keyCode == 65) {
                    direction--;
                    if (direction < 0)
                        direction = 3;
                }
                if (keyCode == 39 || keyCode == 68) {
                    direction++;
                    if (direction > 3)
                        direction = 0;
                }
            }
    
            if (didMove) {
                steps++;
                if (steps % 10 == 0)
                    brightness -= 25;
    
                updateMap();
            }
        }
    }
}