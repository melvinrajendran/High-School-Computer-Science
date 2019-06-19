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

public class GameObject {

	double xPos;
	double yPos;
	double xSpeed;
	double ySpeed;
	Image image;
	Rectangle2D hitBox;
	int timer;

	public GameObject(Image image) {
		this.xPos = 0;
		this.yPos = 0;
		this.xSpeed = 0;
		this.ySpeed = 0;
		this.image = image;
		this.hitBox = new Rectangle2D(0, 0, image.getWidth(), image.getHeight());
		this.timer = 0;
	}

	public GameObject(double xPos, double yPos, double xSpeed, double ySpeed, Image image) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSpeed = xSpeed;
		this.xSpeed = ySpeed;
		this.image = image;
		this.hitBox = new Rectangle2D(xPos, yPos, image.getWidth(), image.getHeight());
		this.timer = 0;
	}

	public double getXPos() { return xPos; }

	public double getYPos() { return yPos; }

	public double getXSpeed() { return xSpeed; }

	public double getYSpeed() { return ySpeed; }

	public Image getImage() { return image; }

	public Rectangle2D getHitBox() { return hitBox; }

	public int getTimer() { return timer; }

	public void setXPos(double newX) {
		xPos = newX;
		hitBox = new Rectangle2D(newX, yPos, image.getWidth(), image.getHeight());
	}

	public void setYPos(double newY) {
		yPos = newY;
		hitBox = new Rectangle2D(xPos, newY, image.getWidth(), image.getHeight());
	}

	public void setPos(double newX, double newY) {
		xPos = newX;
		yPos = newY;
		hitBox = new Rectangle2D(newX, newY, image.getWidth(), image.getHeight());
	}

	public void setXSpeed(double newXSpeed) { xSpeed = newXSpeed; }

	public void setYSpeed(double newYSpeed) { ySpeed = newYSpeed; }

	public void setImage(Image newImage) {
		image = newImage;
		hitBox = new Rectangle2D(xPos, yPos, newImage.getWidth(), newImage.getHeight());
	}

	public void incrementTimer() { timer++; }
}