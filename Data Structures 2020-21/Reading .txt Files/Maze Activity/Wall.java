import java.awt.*;

public class Wall {
    private int[] rows, cols;
    private Color color;
    private int size;
    private String type;

    public Wall(int[] rows, int[] cols, Color color, int size, String type) {
        this.rows = rows;
        this.cols = cols;
        this.color = color;
        this.size = size;
        this.type = type;
    }

    public Wall(int[] rows, int[] cols, int R, int G, int B, int size, String type) {
        this.rows = rows;
        this.cols = cols;
        this.color = new Color(R, G, B);
        this.size = size;
        this.type = type;
    }

    public int[] getRows() {
        return rows;
    }

    public int[] getCols() {
        return cols;
    }

    public Color getColor() {
        return color;
    }

    public GradientPaint getPaint() {
        int r = color.getRed(), g = color.getGreen(), b = color.getBlue();
        int newR, newG, newB;

        if (r >= 50)
            newR = r - 50;
        else
            newR = 0;
        if (g >= 50)
            newG = g - 50;
        else
            newG = 0;
        if (b >= 50)
            newB = b - 50;
        else
            newB = 0;

        switch (type) {
            case "LC":
                return new GradientPaint(rows[0], cols[0], new Color(r, g, b), rows[0], cols[2], new Color(newR, newG, newB));
            case "LP":
                return new GradientPaint(rows[1], cols[1], new Color(r, g, b), rows[0], cols[0], new Color(newR, newG, newB));
            case "LF":
                return new GradientPaint(rows[2], cols[2], new Color(r, g, b), rows[2], cols[0], new Color(newR, newG, newB));
            case "RC":
                return new GradientPaint(rows[1], cols[1], new Color(r, g, b), rows[1], cols[2], new Color(newR, newG, newB));
            case "RP":
                return new GradientPaint(rows[0], cols[0], new Color(r, g, b), rows[1], cols[1], new Color(newR, newG, newB));
            case "RF":
                return new GradientPaint(rows[2], cols[2], new Color(r, g, b), rows[2], cols[0], new Color(newR, newG, newB));
            case "LW":
                return new GradientPaint(rows[0], cols[0], new Color(r, g, b), rows[1], cols[0], new Color(newR, newG, newB));
            case "RW":
                return new GradientPaint(rows[1], cols[1], new Color(r, g, b), rows[0], cols[1], new Color(newR, newG, newB));
            case "C":
                return new GradientPaint(rows[1], cols[1], new Color(r, g, b), rows[1], cols[0], new Color(newR, newG, newB));
            case "F":
                return new GradientPaint(rows[0], cols[0], new Color(r, g, b), rows[0], cols[1], new Color(newR, newG, newB));
            default:
                return null;
        }
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
}
