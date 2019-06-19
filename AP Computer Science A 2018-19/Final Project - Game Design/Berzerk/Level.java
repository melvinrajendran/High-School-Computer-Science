import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.media.AudioClip;
import java.net.URL;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import java.util.*;

public class Level {
	private int number;
	private Canvas canvas;
	private ArrayList<Rectangle2D> walls;
	private ArrayList<Robot> enemies;
	private int numEnemies;

	public Level(int number) {
		this.number = number;
		this.canvas = new Canvas(1150, 700);
		this.walls = new ArrayList<Rectangle2D>();
		this.enemies = new ArrayList<Robot>();
		this.numEnemies = 5;

		for (int i = 0; i < numEnemies; i++) {
			double randomX = (Math.random() * 1090) + 10;
			double randomY = (int)(Math.random() * 525) + 20;

			Robot test = new Robot(randomX, randomY);

			for (Rectangle2D wall : walls) {
				while (test.getHitBox().intersects(wall)) {
					randomX = (Math.random() * 1150) + 1; 
					randomY = (Math.random() * 545) + 1;

					test.setXPos(randomX);
					test.setYPos(randomY);
				}

			}

			for (Robot robot : enemies) {
				while (test.getHitBox().intersects(robot.getHitBox())) {
					randomX = (Math.random() * 1150) + 1;
					randomY = (Math.random() * 545) + 1;

					test.setXPos(randomX);
					test.setYPos(randomY);
				}
			}

			enemies.add(new Robot(randomX, randomY));
		}

		switch (number) {
			case 1:
				walls.add(new Rectangle2D(10, 10, 20, 600));
				walls.add(new Rectangle2D(1120, 10, 20, 600));
				walls.add(new Rectangle2D(10, 10, 400, 20));
				walls.add(new Rectangle2D(720, 10, 400, 20));
				walls.add(new Rectangle2D(10, 590, 400, 20));
				walls.add(new Rectangle2D(720, 590, 400, 20));
				walls.add(new Rectangle2D(390, 10, 20, 200));
				walls.add(new Rectangle2D(720, 10, 20, 200));
				walls.add(new Rectangle2D(390, 390, 20, 200));
				walls.add(new Rectangle2D(720, 390, 20, 200));
				break;

			case 2:
				walls.add(new Rectangle2D(10, 10, 20, 180));
				walls.add(new Rectangle2D(1120, 10, 20, 180));
				walls.add(new Rectangle2D(10, 440, 20, 160));
				walls.add(new Rectangle2D(1120, 440, 20, 170));
				walls.add(new Rectangle2D(10, 10, 1120, 20));
				walls.add(new Rectangle2D(10, 590, 400, 20));
				walls.add(new Rectangle2D(720, 590, 400, 20));
				walls.add(new Rectangle2D(250, 300, 630, 20));
				walls.add(new Rectangle2D(230, 200, 20, 220));
				walls.add(new Rectangle2D(880, 200, 20, 220));
				break;

			case 3:
				walls.add(new Rectangle2D(10, 10, 20, 600));
				walls.add(new Rectangle2D(1120, 10, 20, 600));
				walls.add(new Rectangle2D(10, 10, 400, 20));
				walls.add(new Rectangle2D(720, 10, 400, 20));
				walls.add(new Rectangle2D(10, 590, 400, 20));
				walls.add(new Rectangle2D(720, 590, 400, 20));
				walls.add(new Rectangle2D(10, 400, 400, 20));
				walls.add(new Rectangle2D(720, 400, 400, 20));
				walls.add(new Rectangle2D(390, 10, 20, 200));
				walls.add(new Rectangle2D(720, 10, 20, 200));
				break;

			case 4:
				walls.add(new Rectangle2D(10, 10, 20, 180));
				walls.add(new Rectangle2D(1120, 10, 20, 180));
				walls.add(new Rectangle2D(10, 440, 20, 160));
				walls.add(new Rectangle2D(1120, 440, 20, 170));
				walls.add(new Rectangle2D(10, 10, 1120, 20));
				walls.add(new Rectangle2D(10, 590, 1120, 20));
				walls.add(new Rectangle2D(230, 200, 20, 220));
				walls.add(new Rectangle2D(880, 200, 20, 220));
				break;
		}
	}

	public int getNumber() { return number; }

	public void setNumber(int newNumber) { number = newNumber; }

	public Canvas getCanvas() { return canvas; }

	public ArrayList<Rectangle2D> getWalls() { return walls; }

	public ArrayList<Robot> getEnemies() { return enemies; }

	public void moveEnemies(StickMan stick) {
		for (Robot robot : enemies) {
			if (robot.getMoveDelay() > 0) {
				robot.setMoveDelay(robot.getMoveDelay() - 1);
			} else {
				if (robot.getMoveDelay() > -1 * robot.getDistance()) {
					if (robot.getDirection().equals("H")) {
						if (Math.abs(robot.getXPos() - stick.getXPos()) > 4) {
							if (robot.getXPos() < stick.getXPos()) {
								robot.setXPos(robot.getXPos() + 2);
							} else if (robot.getXPos() > stick.getXPos()) {
								robot.setXPos(robot.getXPos() - 2);
							}
						} else {
							robot.setMoveDelay(300);
						}
					} else if (robot.getDirection().equals("V")) {
						if (Math.abs(robot.getYPos() - stick.getYPos()) > 4) {
							if (robot.getYPos() < stick.getYPos()) {
								robot.setYPos(robot.getYPos() + 2);
							} else if (robot.getYPos() > stick.getYPos()) {
								robot.setYPos(robot.getYPos() - 2);
							}
						} else {
							robot.setMoveDelay(300);
						}
					}
					robot.setMoveDelay(robot.getMoveDelay() - 1);
				}
			}
		}
	}

	public void shootEnemies(StickMan stick) {
		for (Robot robot : enemies) {
			robot.shoot(stick);
		}
	}

	public void updateEnemies(StickMan stick) {
		for (Robot robot : enemies) {
			while (robot.getHitBox().intersects(stick.getHitBox())) {
				double randomX = (Math.random() * 1150) + 1; 
				double randomY = (Math.random() * 545) + 1;

				robot.setXPos(randomX);
				robot.setYPos(randomY);
			}
		}
	}

	public int getNumEnemies() { return numEnemies; }

	public void setNumEnemies(int newNum) { numEnemies = newNum; }

	public void increaseNumEnemies(int numAdded) {
		numEnemies += numAdded;
	}

	public void changeTo(int number) {
		walls.clear();
		enemies.clear();

		switch (number) {
			case 1:
				walls.add(new Rectangle2D(10, 10, 20, 600));
				walls.add(new Rectangle2D(1120, 10, 20, 600));
				walls.add(new Rectangle2D(10, 10, 400, 20));
				walls.add(new Rectangle2D(720, 10, 400, 20));
				walls.add(new Rectangle2D(10, 590, 400, 20));
				walls.add(new Rectangle2D(720, 590, 400, 20));
				walls.add(new Rectangle2D(390, 10, 20, 200));
				walls.add(new Rectangle2D(720, 10, 20, 200));
				walls.add(new Rectangle2D(390, 390, 20, 200));
				walls.add(new Rectangle2D(720, 390, 20, 200));
				break;

			case 2:
				walls.add(new Rectangle2D(10, 10, 20, 180));
				walls.add(new Rectangle2D(1120, 10, 20, 180));
				walls.add(new Rectangle2D(10, 440, 20, 160));
				walls.add(new Rectangle2D(1120, 440, 20, 170));
				walls.add(new Rectangle2D(10, 10, 1120, 20));
				walls.add(new Rectangle2D(10, 590, 400, 20));
				walls.add(new Rectangle2D(720, 590, 400, 20));
				walls.add(new Rectangle2D(250, 300, 630, 20));
				walls.add(new Rectangle2D(230, 200, 20, 220));
				walls.add(new Rectangle2D(880, 200, 20, 220));
				break;

			case 3:
				walls.add(new Rectangle2D(10, 10, 20, 600));
				walls.add(new Rectangle2D(1120, 10, 20, 600));
				walls.add(new Rectangle2D(10, 10, 400, 20));
				walls.add(new Rectangle2D(720, 10, 400, 20));
				walls.add(new Rectangle2D(10, 590, 400, 20));
				walls.add(new Rectangle2D(720, 590, 400, 20));
				walls.add(new Rectangle2D(10, 400, 400, 20));
				walls.add(new Rectangle2D(720, 400, 400, 20));
				walls.add(new Rectangle2D(390, 10, 20, 200));
				walls.add(new Rectangle2D(720, 10, 20, 200));
				break;

			case 4:
				walls.add(new Rectangle2D(10, 10, 20, 180));
				walls.add(new Rectangle2D(1120, 10, 20, 180));
				walls.add(new Rectangle2D(10, 440, 20, 160));
				walls.add(new Rectangle2D(1120, 440, 20, 170));
				walls.add(new Rectangle2D(10, 10, 1120, 20));
				walls.add(new Rectangle2D(10, 590, 1120, 20));
				walls.add(new Rectangle2D(230, 200, 20, 220));
				walls.add(new Rectangle2D(880, 200, 20, 220));
				break;
		}

		for (int i = 0; i < numEnemies; i++) {
			double randomX = (Math.random() * 1090) + 10;
			double randomY = (int)(Math.random() * 525) + 20; //positions should be within bounds of level

			Robot test = new Robot(randomX, randomY);

			for (Rectangle2D wall : walls) {
				while (test.getHitBox().intersects(wall)) {
					randomX = (Math.random() * 1150) + 1; 
					randomY = (Math.random() * 545) + 1;

					test.setXPos(randomX);
					test.setYPos(randomY);
				}
			}

			for (Robot robot : enemies) {
				while (test.getHitBox().intersects(robot.getHitBox())) {
					randomX = (Math.random() * 1150) + 1;
					randomY = (Math.random() * 545) + 1;

					test.setXPos(randomX);
					test.setYPos(randomY);
				}
			}

			enemies.add(new Robot(randomX, randomY));
		}
	}
}