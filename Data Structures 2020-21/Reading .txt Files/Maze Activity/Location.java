public class Location {
    private int row, col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }

    public void changeRowBy(int row) { this.row += row; }

    public int getCol() { return col; }

    public void changeColBy(int col) { this.col += col; }
}