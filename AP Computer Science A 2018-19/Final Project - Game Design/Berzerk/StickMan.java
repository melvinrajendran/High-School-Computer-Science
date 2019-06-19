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

public class StickMan extends GameObject {
	private int lives;
	private ArrayList<Laser> lasers;
	private int shootDelay;
	private int timer;
	private int movementTimer;
	private boolean lockAudio;

	private URL resource4 = getClass().getResource("Audio/stick_death.mp3");
	private AudioClip stickDeath = new AudioClip(resource4.toString());

	public StickMan() {
		super(0, 0, 0, 0, new Image("Sprites/s_face_right.jpg", 35, 70, true, false));
		this.lives = 3;
		this.lasers = new ArrayList<Laser>();
		this.shootDelay = 40;
		this.timer = 0;
		this.movementTimer = 0;
		this.lockAudio = false;
	}

	public StickMan(double xPos, double yPos) {
		super(xPos, yPos, 0, 0, new Image("Sprites/s_face_right.jpg", 35, 70, true, false));
		this.lives = 3;
		this.lasers = new ArrayList<Laser>();
		this.shootDelay = 40;
		this.timer = 0;
		this.movementTimer = 0;
		this.lockAudio = false;
	}

	public void shoot(String direction) {
		if (shootDelay <= 0) {
			if (direction.equals("N")) {
				lasers.add(new Laser("N", xPos + 27, yPos - 10, 10, 10));
			} else if (direction.equals("NE")) {
				lasers.add(new Laser("NE", xPos + 20, yPos- 10, 10, 10));
			} else if (direction.equals("E")) {
				lasers.add(new Laser("E", xPos + 20, yPos + 17, 10, 10));
			} else if (direction.equals("SE")) {
				lasers.add(new Laser("SE", xPos + 15, yPos + 20, 10, 10));
			} else if (direction.equals("S")) {
				lasers.add(new Laser("S", xPos + 27, yPos + 30, 10, 10));
			} else if (direction.equals("SW")) {
				lasers.add(new Laser("SW", xPos - 10, yPos + 20, 10, 10));
			} else if (direction.equals("W")) {
				lasers.add(new Laser("W", xPos - 25, yPos + 17, 10, 10));
			} else if (direction.equals("NW")) {
				lasers.add(new Laser("NW", xPos - 10, yPos - 10, 10, 10));
			}

			if (lasers.size() > 0) {
				lasers.get(lasers.size() - 1).updateImage();
			}

			for (Laser laser : lasers) {
				laser.setXSpeed(10);
				laser.setYSpeed(10); 
			}

			shootDelay = 40;
		}

	}

	public int getLives() { return lives; }

	public void setLives(int newLives) { lives = newLives; }

	public ArrayList<Laser> getLasers() { return lasers; }

	public int getShootDelay() { return shootDelay; }

	public void setShootDelay(int newDelay) { shootDelay = newDelay; }

	public int getTimer() { return timer; }

	public void setTimer(int newTimer) { timer = newTimer; }

	public void resetTimer() { timer = 0; }

	public int getMovementTimer() { return movementTimer; }

	public void setMovementTimer(int newTimer) { movementTimer = newTimer; }

	public boolean getLockAudio() { return lockAudio; }

	public void setLockAudio(boolean newLockAudio) { lockAudio = newLockAudio; } 

	public void animateDeath(String lastDirection) {
		if (lastDirection != null) {
			if (timer == 0 && lockAudio == false) {
				stickDeath.play();
				lockAudio = true;
			}

			if ((timer % 4 == 0 || timer % 4 == 1) && timer <= 160) {
				if (lastDirection.equals("N") || lastDirection.equals("NE") || lastDirection.equals("E") || lastDirection.equals("SE") || lastDirection.equals("S")) {
					setImage(new Image("Sprites/s_face_right.jpg", 35, 70, true, false));
				} else {
					setImage(new Image("Sprites/s_face_left.jpg", 35, 70, true, false));
				}
			} else if ((timer % 4 == 2 || timer % 4 == 3) && timer <= 160) {
				setImage(new Image("Sprites/s_death.jpg", 38, 76, true, false));
			}
		} else {
			if ((timer % 4 == 0 || timer % 4 == 1) && timer <= 160) {
				setImage(new Image("Sprites/s_face_right.jpg", 35, 70, true, false));
			} else if ((timer % 4 == 2 || timer % 4 == 3) && timer <= 160) {
				setImage(new Image("Sprites/s_death.jpg", 38, 76, true, false));
			}
		}

		timer++;
	}

	public void animateWalking(String lastDirection) {
		if (xSpeed != 0 || ySpeed != 0) {
			if (lastDirection != null) {
				if (lastDirection.equals("N") || lastDirection.equals("NE") || lastDirection.equals("E") || lastDirection.equals("SE") || lastDirection.equals("S")) {
					if (movementTimer % 20 >= 0 && movementTimer % 20 <= 4) {
						setImage(new Image("Sprites/s_run_right_2.jpg", 35, 70, true, false));
					} else if (movementTimer % 20 >= 5 && movementTimer % 20 <= 9) {
						setImage(new Image("Sprites/s_run_right_1.jpg", 35, 70, true, false));
					} else if (movementTimer % 20 >= 10 && movementTimer % 20 <= 14) {
						setImage(new Image("Sprites/s_face_right.jpg", 35, 70, true, false));
					} else if (movementTimer % 20 >= 15 && movementTimer % 20 <= 19) {
						setImage(new Image("Sprites/s_run_right_1.jpg", 35, 70, true, false));
					}
				} else {
					if (movementTimer % 20 >= 0 && movementTimer % 20 <= 4) {
						setImage(new Image("Sprites/s_run_left_2.jpg", 35, 70, true, false));
					} else if (movementTimer % 20 >= 5 && movementTimer % 20 <= 9) {
						setImage(new Image("Sprites/s_run_left_1.jpg", 35, 70, true, false));
					} else if (movementTimer % 20 >= 10 && movementTimer % 20 <= 14) {
						setImage(new Image("Sprites/s_face_left.jpg", 35, 70, true, false));
					} else if (movementTimer % 20 >= 15 && movementTimer % 20 <= 19) {
						setImage(new Image("Sprites/s_run_left_1.jpg", 35, 70, true, false));
					}
				}

				movementTimer++;
			}
		}
	}
}