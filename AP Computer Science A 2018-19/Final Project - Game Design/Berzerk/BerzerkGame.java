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

public class BerzerkGame extends Application implements EventHandler<InputEvent> {
	GraphicsContext gc;
	AnimateObjects animate;
	Level level;
	int score;

	boolean lockAnimation;
	boolean lockMovement;

	StickMan stick;

	boolean upPressed;
	boolean downPressed;
	boolean leftPressed;
	boolean rightPressed;
	boolean spacePressed;
	boolean rPressed;

	String lastDirection;

	URL resource1 = getClass().getResource("Audio/robot_shoot.mp3");
	URL resource2 = getClass().getResource("Audio/robot_death.mp3");
	URL resource3 = getClass().getResource("Audio/stick_shoot.mp3");
	URL resource4 = getClass().getResource("Audio/stick_death.mp3");

	AudioClip robotShoot = new AudioClip(resource1.toString());
	AudioClip robotDeath = new AudioClip(resource2.toString());
	AudioClip stickShoot = new AudioClip(resource3.toString());
	AudioClip stickDeath = new AudioClip(resource4.toString());

	public static void main (String[] args) {
		launch();
	}

	public void start (Stage primaryStage) {
		primaryStage.setTitle("Berzerk Game");
		Group root = new Group();
		level = new Level(1);

		robotDeath.play();

		root.getChildren().add(level.getCanvas());
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		scene.addEventHandler(KeyEvent.KEY_PRESSED, this);
		scene.addEventHandler(KeyEvent.KEY_RELEASED, this);

		gc = level.getCanvas().getGraphicsContext2D();
		stick = new StickMan(550, 50);

		level.updateEnemies(stick);

		gc.drawImage(stick.getImage(), stick.getXPos(), stick.getYPos());

		score = 0;

		animate = new AnimateObjects();
		animate.start();

		primaryStage.show();

		lockAnimation = false;
		lockMovement = false;
	}

	public void handle(final InputEvent event) {
		//KeyEvent handling
		if (event.getEventType().toString().equals("KEY_PRESSED")) {
			if (((KeyEvent)event).getCode() == KeyCode.LEFT) {
				leftPressed = true; 
			} else if (((KeyEvent)event).getCode() == KeyCode.RIGHT) {
				rightPressed = true;
			} else if (((KeyEvent)event).getCode() == KeyCode.UP) {
				upPressed = true;
			} else if (((KeyEvent)event).getCode() == KeyCode.DOWN) {
				downPressed = true;
			} else if (((KeyEvent)event).getCode() == KeyCode.SPACE) {
				spacePressed = true;
			} else if (((KeyEvent)event).getCode() == KeyCode.R) {
				rPressed = true;
			}
		} else if (event.getEventType().toString().equals("KEY_RELEASED")) {
			if (((KeyEvent)event).getCode() == KeyCode.LEFT) {
				leftPressed = false;
			} else if (((KeyEvent)event).getCode() == KeyCode.RIGHT) {
				rightPressed = false;
			} else if (((KeyEvent)event).getCode() == KeyCode.UP) {
				upPressed = false;
			} else if (((KeyEvent)event).getCode() == KeyCode.DOWN) {
				downPressed = false;
			} else if (((KeyEvent)event).getCode() == KeyCode.SPACE) {
				spacePressed = false;
			} else if (((KeyEvent)event).getCode() == KeyCode.R) {
				rPressed = false;
			}
		}

		if (upPressed && rightPressed) {
			lastDirection = "NE";
		} else if (rightPressed && downPressed) {
			lastDirection = "SE";
		} else if (downPressed && leftPressed) {
			lastDirection = "SW";
		} else if (leftPressed && upPressed) {
			lastDirection = "NW";
		} else if (upPressed) {
			lastDirection = "N";
		} else if (rightPressed) {
			lastDirection = "E";
		} else if (downPressed) {
			lastDirection = "S";
		} else if (leftPressed) {
			lastDirection = "W";
		}

		if (!(lockMovement)) {
			//horizontal movement
			if (leftPressed) {
				stick.setXSpeed(-2);
			} else if (rightPressed) {
				stick.setXSpeed(2);
			} else {
				stick.setXSpeed(0);

				if (lastDirection != null) {
					if (lastDirection.equals("N") || lastDirection.equals("NE") || lastDirection.equals("E") || lastDirection.equals("SE") || lastDirection.equals("S")) {
						stick.setImage(new Image("Sprites/s_face_right.jpg", 35, 70, true, false));
					} else {
						stick.setImage(new Image("Sprites/s_face_left.jpg", 35, 70, true, false));
					}
				}
			}

			//vertical movement
			if (upPressed) {
				stick.setYSpeed(-2);
			} else if (downPressed) {
				stick.setYSpeed(2);
			} else {
				stick.setYSpeed(0);

				if (lastDirection != null) {
					if (lastDirection.equals("N") || lastDirection.equals("NE") || lastDirection.equals("E") || lastDirection.equals("SE") || lastDirection.equals("S")) {
						stick.setImage(new Image("Sprites/s_face_right.jpg", 35, 70, true, false));
					} else {
						stick.setImage(new Image("Sprites/s_face_left.jpg", 35, 70, true, false));
					}
				}
			}

			//shooting
			if (spacePressed) {
				stick.setXSpeed(0);
				stick.setYSpeed(0);

				if (lastDirection!= null) {
					if (lastDirection.equals("N")) {
						stick.setImage(new Image("Sprites/s_shoot_n.jpg", 35, 70, true, false));
					} else if (lastDirection.equals("NE")) {
						stick.setImage(new Image("Sprites/s_shoot_ne.jpg", 35, 70, true, false));
					} else if (lastDirection.equals("E")) {
						stick.setImage(new Image("Sprites/s_shoot_e.jpg", 35, 70, true, false));
					} else if (lastDirection.equals("SE")) {
						stick.setImage(new Image("Sprites/s_shoot_se.jpg", 35, 70, true, false));
					} else if (lastDirection.equals("S")) {
						stick.setImage(new Image("Sprites/s_shoot_s.jpg", 35, 70, true, false));
					} else if (lastDirection.equals("SW")) {
						stick.setImage(new Image("Sprites/s_shoot_sw.jpg", 35, 70, true, false));
					} else if (lastDirection.equals("W")) {
						stick.setImage(new Image("Sprites/s_shoot_w.jpg", 35, 70, true, false));
					} else if (lastDirection.equals("NW")) {
						stick.setImage(new Image("Sprites/s_shoot_nw.jpg", 35, 70, true, false));
					}
				} else {
					stick.setImage(new Image("Sprites/s_shoot_e.jpg", 35, 70, true, false));
				}

				stick.shoot(lastDirection);

				if (stick.getShootDelay() == 40) {
					stickShoot.play();
				}
			} else {
				if (lastDirection != null) {
					if (lastDirection.equals("N") || lastDirection.equals("NE") || lastDirection.equals("E") || lastDirection.equals("SE") || lastDirection.equals("S")) {
						stick.setImage(new Image("Sprites/s_face_right.jpg", 35, 70, true, false));
					} else {
						stick.setImage(new Image("Sprites/s_face_left.jpg", 35, 70, true, false));
					}
				}
			}
		}

		//resetting game
		if (rPressed) {
			level = new Level(1);
			level.updateEnemies(stick);
			robotDeath.play();

			stick.setLives(3);
			stick.setPos(550, 50);
			stick.resetTimer();
			stick.setLockAudio(false);

			score = 0;

			lockAnimation = false;
			lockMovement = false;
		}

		gc.clearRect(0, 0, level.getCanvas().getWidth(), level.getCanvas().getHeight());

	}

	public class AnimateObjects extends AnimationTimer {
		public void handle(long now) {
			Rectangle2D background = new Rectangle2D(0, 0, 1150, 700);
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, level.getCanvas().getWidth(), level.getCanvas().getHeight());

			stick.setShootDelay(stick.getShootDelay() - 1);

			for (Robot robot : level.getEnemies()) {
				robot.setShootDelay(robot.getShootDelay() - 1);
			}

			//x-boundary handling
			if (stick.getXPos() + stick.getXSpeed() > 0 && stick.getXPos() + stick.getXSpeed() < 1150 - stick.getImage().getWidth()) {
				stick.setXPos(stick.getXPos() + stick.getXSpeed());
			} else {
				if (stick.getXPos() + stick.getXSpeed() < 0) {
					stick.setXPos(0);
				} else if (stick.getXPos() + stick.getXSpeed() > 1150 - stick.getImage().getWidth()) {
					stick.setXPos(1150 - stick.getImage().getWidth());
				}
				stick.setXSpeed(0);
			}

			//y-boundary handling
			if (stick.getYPos() + stick.getYSpeed() > 10 && stick.getYPos() + stick.getYSpeed() < 610 - stick.getImage().getHeight()) {
				stick.setYPos(stick.getYPos() + stick.getYSpeed());
			} else {
				if (stick.getYPos() + stick.getYSpeed() < 10) {
					stick.setYPos(10);
				} else if (stick.getYPos() + stick.getYSpeed() > 610 - stick.getImage().getHeight()) {
					stick.setYPos(610 - stick.getImage().getHeight());
				}
				stick.setYSpeed(0);
			}

			//interaction handling

			//stick - wall
			for (Rectangle2D wall : level.getWalls()) {
				if (stick.getHitBox().intersects(wall)) {
					lockAnimation = true;
					lockMovement = true;

					stick.setXSpeed(0);
					stick.setYSpeed(0);
					stick.animateDeath(lastDirection);
					stick.setLockAudio(true);

					if (stick.getTimer() > 160) {
						int temp = level.getNumEnemies();
						level = new Level(level.getNumber());
						level.setNumEnemies(temp);
						level.updateEnemies(stick);

						robotDeath.play();

						stick.setLockAudio(false);
						stick.setLives(stick.getLives() - 1);
						stick.setPos(550, 50);
						stick.resetTimer();

						lockAnimation = false;
						lockMovement = false;
					}
					break;
				}
			}

			//robot - wall
			for (int i = 0; i < level.getWalls().size(); i++) {
				for (int j = 0; j < level.getEnemies().size(); j++) {
					if (level.getWalls().get(i).intersects(level.getEnemies().get(j).getHitBox())) {
						level.getEnemies().remove(j);
						j--;

						robotDeath.play();

						score += 50;

						break;
					}
				}
			}

			//robot - robot
			for (int i = level.getEnemies().size() - 1; i > 0; i--) {
				for (int j = i - 1; j>= 0; j--) {
					if (level.getEnemies().get(i).getHitBox().intersects(level.getEnemies().get(j).getHitBox())) {
						level.getEnemies().remove(i);
						level.getEnemies().remove(j);

						i--;

						robotDeath.play();

						score += 100;

						break;

					}
				}
			}

			//stick - robot
			for (Robot robot : level.getEnemies()) {
				if (stick.getHitBox().intersects(robot.getHitBox())) {
					lockAnimation = true;
					lockMovement = true;

					stick.setXSpeed(0);
					stick.setYSpeed(0);
					stick.animateDeath(lastDirection);
					stick.setLockAudio(true);

					if (stick.getTimer() > 160) {
						int temp = level.getNumEnemies();
						level = new Level(level.getNumber());
						level.setNumEnemies(temp);
						level.updateEnemies(stick);

						robotDeath.play();

						stick.setLockAudio(false);
						stick.setLives(stick.getLives() - 1);
						stick.setPos(550, 50);
						stick.resetTimer();

						lockAnimation = false;
						lockMovement = false;
					}
					break;
				}
			}

			//stick laser - robot
			for (int i = stick.getLasers().size() - 1; i >= 0; i--) {
				for (int j = level.getEnemies().size() - 1; j >= 0; j--) {
					if (stick.getLasers().get(i).getHitBox().intersects(level.getEnemies().get(j).getHitBox())) {
						stick.getLasers().remove(i);
						level.getEnemies().remove(j);
						
						robotDeath.play();

						score += 50;

						break;
					}
				}
			}

			//stick laser - wall
			for (int i = stick.getLasers().size() - 1; i >= 0; i--) {
				for (int j = level.getWalls().size() - 1; j >= 0; j--) {
					if (stick.getLasers().get(i).getHitBox().intersects(level.getWalls().get(j))) {
						stick.getLasers().remove(i);

						break;
					}
				}
			}

			loop:
			//robot laser - robot
			for (int i = level.getEnemies().size() - 1; i >= 0; i--) {
				for (int j = level.getEnemies().size() - 1; j >= 0; j--) {
					for (int k = level.getEnemies().get(j).getLasers().size() - 1; k >= 0; k--) {
						if (level.getEnemies().get(i).getHitBox().intersects(level.getEnemies().get(j).getLasers().get(k).getHitBox()) && i != j) {
							level.getEnemies().get(j).getLasers().remove(k);
							level.getEnemies().remove(i);

							robotDeath.play();

							break loop;
						}
					}
				}
			}
			

			//robot laser - stick
			for (int i = level.getEnemies().size() - 1; i >= 0; i--) {
				for (int j = level.getEnemies().get(i).getLasers().size() - 1; j >= 0; j--) {
					if (level.getEnemies().get(i).getLasers().get(j).getHitBox().intersects(stick.getHitBox())) {
						lockAnimation = true;
						lockMovement = true;

						stick.setXSpeed(0);
						stick.setYSpeed(0);
						stick.animateDeath(lastDirection);
						stick.setLockAudio(true);

						if (stick.getTimer() > 160) {
							level.getEnemies().get(i).getLasers().remove(j);
							int temp = level.getNumEnemies();
							level = new Level(level.getNumber());
							level.setNumEnemies(temp);
							level.updateEnemies(stick);

							robotDeath.play();

							stick.setLockAudio(false);
							stick.setLives(stick.getLives() - 1);
							stick.setPos(550, 50);
							stick.resetTimer();

							lockAnimation = false;
							lockMovement = false;
						}
						break;
					}
				}
			}

			//robot laser - wall
			for (int i = level.getEnemies().size() - 1; i >= 0; i--) {
				for (int j = level.getEnemies().get(i).getLasers().size() - 1; j >= 0; j--) {
					for (int k = level.getWalls().size() - 1; k >= 0; k--) {
						if (level.getEnemies().get(i).getLasers().get(j).getHitBox().intersects(level.getWalls().get(k))) {
							level.getEnemies().get(i).getLasers().remove(j);
							break;
						}
					}
				}
			}

			//level exits
			if (level.getNumber() == 1) {
				if (stick.getXPos() >= 400 && stick.getXPos() <= 800) {
					if (stick.getYPos() <= 30) {
						stick.setPos(550, 500);
						changeLevel(level);
						increaseDifficulty(level);
					} else if (stick.getYPos() >= 600 - stick.getImage().getHeight()) {
						stick.setPos(550, 50);
						changeLevel(level);
						increaseDifficulty(level);
					}
				}
			} else if (level.getNumber() == 2) {
				if (stick.getXPos() >= 400 && stick.getXPos() <= 800) {
					if (stick.getYPos() >= 600 - stick.getImage().getHeight()) {
						stick.setPos(550, 50);
						changeLevel(level);
						increaseDifficulty(level);
					}
				} else if (stick.getXPos() <= 35) {
					if (stick.getYPos() >= 200 && stick.getYPos() <= 600) {
						stick.setPos(1070, 280);
						changeLevel(level);
						increaseDifficulty(level);
					}
				} else if (stick.getXPos() >= 1120 - stick.getImage().getWidth()) {
					if (stick.getYPos() >= 200 && stick.getYPos() <= 600) {
						stick.setPos(50, 280);
						changeLevel(level);
						increaseDifficulty(level);
					}
				}
			} else if (level.getNumber() == 3) {
				if (stick.getXPos() >= 400 && stick.getXPos() <= 800) {
					if (stick.getYPos() <= 30) {
						stick.setPos(550, 500);
						changeLevel(level);
						increaseDifficulty(level);
					} else if (stick.getYPos() >= 600 - stick.getImage().getHeight()) {
						stick.setPos(550, 50);
						changeLevel(level);
						increaseDifficulty(level);
					}
				}
			} else if (level.getNumber() == 4) {
				if (stick.getXPos() <= 35) {
					if (stick.getYPos() >= 200 && stick.getYPos() <= 600) {
						stick.setPos(1070, 280);
						changeLevel(level);
						increaseDifficulty(level);
					}
				} else if (stick.getXPos() >= 1120 - stick.getImage().getWidth()) {
					if (stick.getYPos() >= 200 && stick.getYPos() <= 600) {
						stick.setPos(50, 280);
						changeLevel(level);
						increaseDifficulty(level);
					}
				}
			}
			
			if (!(lockAnimation)) {
				stick.animateWalking(lastDirection);

				level.moveEnemies(stick);
				level.shootEnemies(stick);

				for (Laser laser : stick.getLasers()) {
					laser.increment();
				}

				for (Robot robot : level.getEnemies()) {
					for (Laser laser : robot.getLasers()) {
						laser.increment();
					}
				}
			}

			drawLevel(level);

			if (stick.getLives() <= 0) {
				lockAnimation = true;
				lockMovement = true;

				gc.fillText("GAME OVER", 450, 300);
				gc.fillText("PRESS [R] TO RESTART", 340, 340);
			}
		}
	}

	public void drawLevel(Level level) {
		gc.drawImage(stick.getImage(), stick.getXPos(), stick.getYPos());

		for (Laser laser : stick.getLasers()) {
				gc.drawImage(laser.getImage(), laser.getXPos(), laser.getYPos());
		}

		gc.setFill(Color.WHITE);

		for (Rectangle2D rect : level.getWalls()) {
			rect = new Rectangle2D(rect.getMinX(), rect.getMinY(), rect.getWidth(), rect.getHeight());
			gc.fillRect(rect.getMinX(), rect.getMinY(), rect.getWidth(), rect.getHeight());
		}

		for (Robot robot : level.getEnemies()) {
			gc.drawImage(robot.getImage(), robot.getXPos(), robot.getYPos());
		}

		for (Robot robot : level.getEnemies()) {
			for (Laser laser : robot.getLasers()) {
				gc.drawImage(laser.getImage(), laser.getXPos(), laser.getYPos());
			}
		}

		for (int i = 0; i < stick.getLives(); i++) {
			gc.drawImage(new Image("Sprites/s_lives.jpg", 20, 40, true, false), 300 + 40 * i, 640);
		}

		gc.setFill(Color.WHITE);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		Font font = Font.font("Arial", FontWeight.BOLD, 40);
		gc.setFont(font);

		gc.fillText(score + "", 720, 670);
		gc.strokeText(score + "", 720, 670);
	}

	public void changeLevel(Level level) {
		int random = (int)(Math.random() * 4) + 1;
		level.changeTo(random);
		level.setNumber(random);
		level.updateEnemies(stick);

		robotDeath.play();
	}

	public void increaseDifficulty(Level level) {
		level.increaseNumEnemies(1);
	}
}