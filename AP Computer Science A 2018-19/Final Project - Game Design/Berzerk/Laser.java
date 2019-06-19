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

public class Laser extends GameObject {
	private String direction;

	public Laser(String direction) {
		super(0, 0, 0, 0, new Image("Sprites/l_horizontal.jpg", 40, 80, true, false));
		this.direction = direction;
	}

	public Laser(String direction, double xPos, double yPos, double xSpeed, double ySpeed) {
		super(xPos, yPos, xSpeed, ySpeed, new Image("Sprites/l_horizontal.jpg", 40, 80, true ,false));
		this.direction = direction;
	}

	public void increment() {
		if (direction.equals("N")) {
			setYPos(getYPos() - getYSpeed());
		} else if (direction.equals("NE")) {
			setXPos(getXPos() + getXSpeed());
			setYPos(getYPos() - getYSpeed());
		} else if (direction.equals("E")) {
			setXPos(getXPos() + getXSpeed());
		} else if (direction.equals("SE")) {
			setXPos(getXPos() + getXSpeed());
			setYPos(getYPos() + getYSpeed());
		} else if (direction.equals("S")) {
			setYPos(getYPos() + getYSpeed());
		} else if (direction.equals("SW")) {
			setXPos(getXPos() - getXSpeed());
			setYPos(getYPos() + getYSpeed());
		} else if (direction.equals("W")) {
			setXPos(getXPos() - getXSpeed());
		} else if (direction.equals("NW")) {
			setXPos(getXPos() - getXSpeed());
			setYPos(getYPos() - getYSpeed());
		}
	}

	public void updateImage() {
		if (direction.equals("N") || direction.equals("S")) {
			setImage(new Image("Sprites/l_vertical.jpg", 80, 40, true ,false));
		} else if (direction.equals("E") || direction.equals("W")) {
			setImage(new Image("Sprites/l_horizontal.jpg", 40, 80, true ,false));
		} else if (direction.equals("NE") || direction.equals("SW")) {
			setImage(new Image("Sprites/l_diagonal_ur.jpg", 30, 30, true ,false));
		} else if (direction.equals("SE") || direction.equals("NW")) {
			setImage(new Image("Sprites/l_diagonal_ul.jpg", 30, 30, true ,false));
		}
	}
}