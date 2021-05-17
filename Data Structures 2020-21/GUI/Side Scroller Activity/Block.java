import java.awt.geom.*;

public class Block {
    int blockX, blockY, width, height;
    char type;

    public Block(int blockX, int blockY, int width, int height, char type) {
        this.blockX = blockX;
        this.blockY = blockY;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public int getX() {
        return blockX;
    }

    public void updateX(int blockX) {
        this.blockX += blockX;
    }

    public int getY() {
        return blockY;
    }

    public void updateY(int blockY) {
        this.blockY += blockY;
    }

    public char getType() {
        return this.type;
    }

    public Rectangle2D getCollisionBox() {
        return new Rectangle2D.Double(blockX, blockY, width, height);
    }
}
