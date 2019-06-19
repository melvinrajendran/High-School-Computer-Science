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

public class Robot extends GameObject {
	private String direction;
	private int moveDelay;
	private double distance;
	private ArrayList<Laser> lasers;
	private int shootDelay;

	URL resource1 = getClass().getResource("Audio/robot_shoot.mp3");
	AudioClip robotShoot = new AudioClip(resource1.toString());

	public Robot() {
		super(0, 0, 0, 0, new Image("Sprites/r_stand.jpg", 45, 90, true, false));

		int random = (int)(Math.random() * 2);
		if (random == 0)
			this.direction = "H";
		else
			this.direction = "V";

		this.moveDelay = (int)(Math.random() * 1000) + 120;
		this.distance = (Math.random() * 350) + 1;
		this.lasers = new ArrayList<Laser>();
		this.shootDelay = (int)(Math.random() * 150) + 1;

	}

	public Robot(double xPos, double yPos) {
		super(xPos, yPos, 0, 0, new Image("Sprites/r_stand.jpg", 45, 90, true, false));

		int random = (int)(Math.random() * 2);
		if (random == 0)
			this.direction = "H";
		else
			this.direction = "V";

		this.moveDelay = (int)(Math.random() * 1000) + 120;
		this.distance = (Math.random() * 350) + 1;
		this.lasers = new ArrayList<Laser>();
		this.shootDelay = (int)(Math.random() * 150) + 1;
	}

	public void shoot(StickMan stick) {
		if (shootDelay <= 0) {
			if (Math.abs(getXPos() - stick.getXPos()) < 20) {
				if (getYPos() < stick.getYPos()) {
					lasers.add(new Laser("S", xPos + 25, yPos + 20, 3, 3));
					robotShoot.play();
				} else {
					lasers.add(new Laser("N", xPos + 25, yPos + 20, 3, 3));
					robotShoot.play();
				}
			}
			
			if (Math.abs(getYPos() - stick.getYPos()) < 20) {
				if (getXPos() < stick.getXPos()) {
					lasers.add(new Laser("E", xPos + 25, yPos + 20, 3, 3));
					robotShoot.play();
				} else {
					lasers.add(new Laser("W", xPos + 25, yPos + 20, 3, 3));
					robotShoot.play();
				}
			}
			
			if (Math.abs(Math.abs(getXPos() - stick.getXPos()) - Math.abs(getYPos() - stick.getYPos())) < 20) {
				int random = (int)(Math.random()*2);

				if (random == 0) {
					if (getXPos() < stick.getXPos()) {
						lasers.add(new Laser("E", xPos + 25, yPos + 20, 3, 3));
						robotShoot.play();
					} else {
						lasers.add(new Laser("W", xPos + 25, yPos + 20, 3, 3));
						robotShoot.play();
					}
				} else {
					if (getYPos() < stick.getYPos()) {
						lasers.add(new Laser("S", xPos + 25, yPos + 20, 3, 3));
						robotShoot.play();
					} else {
						lasers.add(new Laser("N", xPos + 25, yPos + 20, 3, 3));
						robotShoot.play();
					}
				}
			}

			if (lasers.size() > 0) {
				lasers.get(lasers.size() - 1).updateImage();
			}

			for (Laser laser : lasers) {
				laser.setXSpeed(4);
				laser.setYSpeed(4);
			}

			shootDelay = 150;
		}
	}

	public String getDirection() { return direction; }

	public void setDirection(String newDirection ) { direction = newDirection; }

	public int getMoveDelay() { return moveDelay; }

	public void setMoveDelay(int newDelay) { moveDelay = newDelay; }

	public double getDistance() { return distance; }

	public void setDistance(double newDistance) { distance = newDistance; }

	public ArrayList<Laser> getLasers() { return lasers; }

	public int getShootDelay() { return shootDelay; }

	public void setShootDelay(int newDelay) { shootDelay = newDelay; }
}