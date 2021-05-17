import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SideScroller extends JPanel implements KeyListener, Runnable {
    JFrame frame;
    BufferedImage aladdinSheet, sunset, clouds, bigCity, smallCity, boxImage;
    BufferedImage[] aladdin = new BufferedImage[13], aladdinJump = new BufferedImage[12];
	HashMap<Integer, ArrayList<Block>> boxMap = new HashMap<Integer, ArrayList<Block>>();
	Hero hero;
	
    Thread timer;

    int count = 0, cloudsCount = 0, bcCount = 0, scCount = 0, size = 2, currentColumn;
	boolean isMoving = false, leftIsDown = false, rightIsDown = false;

    public SideScroller() {
        frame = new JFrame("Aladdin's Adventure");
        frame.add(this);

		int[][] locsAndDims = new int[][] {
			{337,  3, 23, 55}, // Standing Sprites
			{  4, 64, 31, 53}, // Running Sprites
			{ 34, 64, 31, 53},
			{ 62, 64, 31, 51},
			{ 92, 64, 31, 51},
			{127, 64, 37, 51},
			{166, 64, 31, 51},
			{205, 64, 31, 51},
			{233, 64, 30, 51},
			{263, 61, 30, 56},
			{292, 61, 34, 56},
			{325, 60, 41, 56},
			{367, 60, 36, 56}
		};

		int[][] jumpLocsAndDims = new int[][] {
			{  4, 294, 31, 59}, // Jumping Sprites
			{ 35, 300, 29, 58},
			{ 62, 301, 38, 56},
			{100, 301, 36, 56},
			{140, 303, 41, 50},
			{183, 304, 49, 47},
			{230, 303, 42, 50}, // Falling Sprites
			{278, 302, 37, 54},
			{321, 303, 33, 56},
			{  4, 363, 35, 64},
			{ 42, 365, 36, 63},
			{168, 361, 25, 55}
		};

        try {
            aladdinSheet = ImageIO.read(new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Side Scroller Activity/Images/Aladdin.png"));
            sunset = ImageIO.read(new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Side Scroller Activity/Images/sunset.png"));
            clouds = ImageIO.read(new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Side Scroller Activity/Images/clouds.png"));
            bigCity = ImageIO.read(new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Side Scroller Activity/Images/bigCity.png"));
            smallCity = ImageIO.read(new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Side Scroller Activity/Images/smallCity.png"));
            boxImage = ImageIO.read(new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Side Scroller Activity/Images/box.png"));
            boxImage = resize(boxImage, 50, 50);

            File file = new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/GUI/Side Scroller Activity/map.txt");
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;
            int row = 0;
            while ((text = input.readLine()) != null) {
                String[] pieces = text.split("");
                for (int x = 0; x < pieces.length; x++) {
					if (pieces[x].equals("H")) {
						currentColumn = x;
						hero = new Hero(currentColumn * 50, 0, 440, locsAndDims, jumpLocsAndDims);
					}
                    if (pieces[x].equals("B")) {
						if (!boxMap.containsKey(x))
							boxMap.put(x, new ArrayList<Block>());
						boxMap.get(x).add(new Block(50 * x, 50 * row, 50, 50, 'B'));
					}
					if (pieces[x].equals("b")) {
						if (!boxMap.containsKey(x))
							boxMap.put(x, new ArrayList<Block>());
						boxMap.get(x).add(new Block(50 * x, 50 * row, 50, 50, 'b'));
					}
                }
                row++;
            }
            input.close();

        } catch (IOException e) {}

        for (int x = 0; x < locsAndDims.length; x++) {
            aladdin[x] = aladdinSheet.getSubimage(locsAndDims[x][0], locsAndDims[x][1], locsAndDims[x][2], locsAndDims[x][3]);
            aladdin[x] = resize(aladdin[x], aladdin[x].getWidth() * size, aladdin[x].getHeight() * size);
        }

        for (int x = 0; x < jumpLocsAndDims.length; x++) {
            aladdinJump[x] = aladdinSheet.getSubimage(jumpLocsAndDims[x][0], jumpLocsAndDims[x][1], jumpLocsAndDims[x][2], jumpLocsAndDims[x][3]);
            aladdinJump[x] = resize(aladdinJump[x], aladdinJump[x].getWidth() * size, aladdinJump[x].getHeight() * size);
        }

        frame.addKeyListener(this);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        timer = new Thread(this);
        timer.start();
    }

    public BufferedImage resize(BufferedImage image, int width, int height) {
		Image temp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage scaledVersion = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = scaledVersion.createGraphics();
		g2.drawImage(temp, 0, 0, null);
		g2.dispose();
		return scaledVersion;
	}

	public BufferedImage horizontalFlip(BufferedImage image) {
		int w = image.getWidth(), h = image.getHeight();
		BufferedImage dimg = new BufferedImage(w, h, image.getType());
		Graphics2D g = dimg.createGraphics();
		g.drawImage(image, 0, 0, w, h, w, 0, 0, h, null);
		g.dispose();
		return dimg;
	}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sunset, 0, 0, this);
        g.drawImage(clouds, cloudsCount + 960, -28, this);
        g.drawImage(clouds, cloudsCount - 960, -28, this);
        g.drawImage(bigCity, bcCount + 960, -28, this);
        g.drawImage(bigCity, bcCount - 960, -28, this);
        g.drawImage(smallCity, scCount + 960, -28, this);
        g.drawImage(smallCity, scCount - 960, -28, this);

        Graphics2D g2 = (Graphics2D) g;

        for (int i = currentColumn - 15; i < currentColumn + 15; i++) {
			try {
				ArrayList<Block> boxList = boxMap.get(i);
				for (Block b : boxList) {
					g.drawImage(boxImage, b.getX(), b.getY(), this);
		// 			g2.draw(b.getCollisionBox());
				}
			} catch (NullPointerException npe) {}
		}

		if (!hero.isRight()) {
			if (hero.isJumping() || hero.isFalling()) {
				g.drawImage(horizontalFlip(aladdinJump[hero.getJumpCount()]), hero.getX(), hero.getY(), this);
				g2.draw(hero.collisionBelow());
			} else {
				g.drawImage(horizontalFlip(aladdin[hero.getAladdinCount()]), hero.getX(), hero.getY(), this);
				g2.draw(hero.getCollisionBox());
			}
		} else {
			if (hero.isJumping() || hero.isFalling()) {
				g.drawImage(aladdinJump[hero.getJumpCount()], hero.getX(), hero.getY(), this);
				g2.draw(hero.collisionBelow());
			} else {
				g.drawImage(aladdin[hero.getAladdinCount()], hero.getX(), hero.getY(), this);
				g2.draw(hero.getCollisionBox());
			}
		}
        
    }

    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37 || e.getKeyCode() == 65) { // Left Arrow or A
			isMoving = true;
			leftIsDown = true;
			hero.setRight(false);
		}

		if (e.getKeyCode() == 39 || e.getKeyCode() == 68) { // Right Arrow or D
			isMoving = true;
			rightIsDown = true;
			hero.setRight(true);
		}

		if (e.getKeyCode() == 38 || e.getKeyCode() == 87) { // Up Arrow or W
			if (!hero.isJumping() && !hero.isFalling()) {
				hero.setJumping(true);
				hero.setOnBox(false);
			}
			repaint();
		}
	}
	public void keyReleased(KeyEvent e) {
		if ((e.getKeyCode() == 37 || e.getKeyCode() == 65)) {
			if (rightIsDown)
				hero.setRight(true);
			else
				isMoving = false;

			leftIsDown = false;
			hero.setAladdinCount(0);
			repaint();
		}

		if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
			if (leftIsDown)
				hero.setRight(false);
			else
				isMoving = false;
			
			rightIsDown = false;
			hero.setAladdinCount(0);
			repaint();
		}
	}

    public void keyTyped(KeyEvent e) {}

    public void run() {
		while (true) {
			if (hero.isJumping()) {
				hero.updateJumping();
			} else if (hero.isFalling()) {
					boolean hitBlock = isCollidingBelow();
					if (!hitBlock && hero.getY() != hero.getOriginalY()) {
						hero.updateFalling();
					} else {
						hero.setFalling(false);
						if (hitBlock)
							hero.setOnBox(true);
						hero.resetJumpCount();
					}
			} else if (hero.isOnBox()) {
                boolean hitBlock = isCollidingBelow();
				if (!hitBlock) {
					hero.setFalling(true);
					hero.setOnBox(false);
				}
			}

			if (isMoving) {
				if (!hero.isRight()) {
					count--;
					if (count % 25 == 0)
						hero.setAladdinCount(hero.getAladdinCount() + 1);

					boolean hitBlock = isColliding();
					if (!hitBlock) {
						for (ArrayList<Block> bList : boxMap.values())
							for (Block b : bList)
								b.updateX(1);

						if (count % 50 == 0)
							currentColumn--;
						if (count % 10 == 0)
							cloudsCount++;
						if (cloudsCount > 0)
							cloudsCount -= 1920;
						if (count % 3 == 0)
							bcCount++;
						if (bcCount > 0)
							bcCount -= 1920;
						scCount++;
						if (scCount > 0)
							scCount -= 1920;
					}
				} else {
					count++;
					if (count % 25 == 0)
						hero.setAladdinCount(hero.getAladdinCount() + 1);

					boolean hitBlock = isColliding();
					if (!hitBlock) {
						for (ArrayList<Block> bList : boxMap.values())
							for (Block b : bList)
								b.updateX(-1);

						if (count % 50 == 0)
							currentColumn++;
						if (count % 10 == 0)
							cloudsCount--;
						if (cloudsCount < -1920)
							cloudsCount += 1920;
						if (count % 3 == 0)
							bcCount--;
						if (bcCount < -1920)
							bcCount += 1920;
						scCount--;
						if (scCount < -1920)
							scCount += 1920;
					}
				}
			}

			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {}
			repaint();
		}
	}

	public boolean isColliding() {
		for (int c = currentColumn - 1; c <= currentColumn + 1; c++) {
			try {
				ArrayList<Block> boxList = boxMap.get(c);
				for (Block b : boxList) {
					// if ((hero.isJumping() || hero.isFalling()) && hero.collisionBelow().intersects(b.getCollisionBox()) && b.getType() == 'B')
					// 	return true;
					if (!(hero.isJumping() || hero.isFalling()) && hero.getCollisionBox().intersects(b.getCollisionBox()) && b.getType() == 'B' && hero.getY() + hero.getCollisionBox().getHeight() == b.getY() + b.getCollisionBox().getHeight())
						return true;
				}
			} catch (NullPointerException npe) {}
		}

		return false;
	}

	public boolean isCollidingBelow() {
       for (int c = currentColumn - 1; c <= currentColumn + 1; c++) {
			try {
				ArrayList<Block> boxList = boxMap.get(c);
				for (Block b : boxList)
					if (hero.collisionBelow().intersects(b.getCollisionBox()) && hero.isAbove(b) && b.getType() == 'B')
						return true;
			} catch (NullPointerException npe) {}
		}
					
		return false;
    }

    public static void main(String[] args) {
        new SideScroller();
    }
}