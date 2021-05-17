import java.awt.geom.*;

public class Hero {
    int heroX, heroY, originalY, aladdinCount = 0, jumpCount = 0, count = 0;
    int[][] locsAndDims, jumpLocsAndDims;
    boolean jumping = false, falling = true, onBox = false, isRight = true;

    public Hero(int heroX, int heroY, int originalY, int[][] locsAndDims, int[][] jumpLocsAndDims) {
        this.heroX = heroX;
        this.heroY = heroY;
        this.originalY = originalY;
        this.locsAndDims = locsAndDims;
        this.jumpLocsAndDims = jumpLocsAndDims;
    }

    public int getX() {
        return heroX;
    }

    public int getY() {
        return heroY;
    }

    public int getOriginalY() {
        return originalY;
    }

    public int getAladdinCount() {
        return aladdinCount;
    }

    public void setAladdinCount(int aladdinCount) {
        this.aladdinCount = aladdinCount;
        if (aladdinCount == 13)
            this.aladdinCount = 1;
    }

    public void updateJumping() {
        heroY--;
        count++;
        if (count % 25 == 0) {
            jumpCount++;
            if (jumpCount == 6) {
                setJumping(false);
                setFalling(true);
            }
        }
    }

    public void updateFalling() {
        heroY++;
        count++;
        if (count % 25 == 0) {
            jumpCount++;
            if (jumpCount == 12) {
                jumpCount = 0;
            }
        }
    }

    public int getJumpCount() {
        return jumpCount;
    }

    public void resetJumpCount() {
        jumpCount = 0;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public boolean isOnBox() {
        return onBox;
    }

    public void setOnBox(boolean onBox) {
        this.onBox = onBox;
    }

    public boolean isRight() {
        return this.isRight;
    }

    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }

    public Rectangle2D getCollisionBox() {
        return new Rectangle2D.Double(heroX, heroY, locsAndDims[0][2] * 2, locsAndDims[0][3] * 2);
    }

    public Rectangle2D collisionBelow() {
        return new Rectangle2D.Double(heroX, heroY + 1, jumpLocsAndDims[jumpCount][2] * 2, locsAndDims[0][3] * 2);
    }

    public boolean isAbove(Block b) {
        return getY() + getCollisionBox().getHeight() <= b.getY();
    }
}