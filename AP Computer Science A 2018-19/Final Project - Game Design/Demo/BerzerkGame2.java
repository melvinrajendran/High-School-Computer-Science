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

public class Example extends Application implements EventHandler<InputEvent>
{
	GraphicsContext gc;
	Image trooper;
	int x;
	int dx;
	AnimateObjects animate;

	public static void main(String[] args)
	{
		launch();
	}
	public void start(Stage stage)
	{
		stage.setTitle("Final Project Title");
		Group root = new Group();
		Canvas canvas = new Canvas(800, 400);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		stage.setScene(scene);

		scene.addEventHandler(KeyEvent.KEY_PRESSED,this);
		scene.addEventHandler(KeyEvent.KEY_RELEASED,this);
		scene.addEventHandler(MouseEvent.MOUSE_CLICKED, this);

		gc = canvas.getGraphicsContext2D();
		trooper = new Image("trooper.jpg");
		gc.drawImage(trooper, 180, 100);

		x = 0;
		dx = 1;

		animate = new AnimateObjects();
		animate.start();

		stage.show();

		URL resource = getClass().getResource("test.wav");
		AudioClip clip = new AudioClip(resource.toString());
		clip.play();

	}
	public void handle(final InputEvent event) {
		//if (((KeyEvent)event).getCode() == KeyCode.LEFT)
		//	x -= 1;

		if (event instanceof KeyEvent){
			if (((KeyEvent)event).getCode() == KeyCode.LEFT )
				x-=1;
		}

		if (event instanceof MouseEvent){
			System.out.println( ((MouseEvent)event).getX() );
			System.out.println( ((MouseEvent)event).getY() );
		}
		if(event.getEventType().toString().equals("KEY_PRESSED") )
			System.out.println("PRESS");
		if(event.getEventType().toString().equals("KEY_RELEASED") )
			System.out.println("RELEASE");


	}

	public class AnimateObjects extends AnimationTimer
	{
		public void handle(long now) {
			//x += dx;
			if (x + dx == 400 || x + dx == -200)
				dx = -dx;

			gc.drawImage(trooper, 180 + x, 100);

			Rectangle2D rect1 = new Rectangle2D( 400,100,100,100 );
			gc.fillRect(400,100,100,100);
			Rectangle2D rect2 = new Rectangle2D( 180+x,100,trooper.getWidth(),trooper.getHeight() );

			if (rect1.intersects(rect2))
				System.out.println("HIT");

			if (x>-50) {
				//all the code for drawing your image on the screen goes here
			}

			else {
				// we are going to display Game over if the user moves 50 pixels to the left
				gc.setFill( Color.YELLOW);		//Fills the text in yellow
				gc.setStroke( Color.BLACK );		//Changes the outline the black
				gc.setLineWidth(1);			//How big the black lines will be
				Font font = Font.font( "Arial", FontWeight.NORMAL, 48 );
				gc.setFont( font );
			   	gc.fillText( "Game Over", 100, 50 );	//draws the yellow part of the text
			   	gc.strokeText( "Game Over", 100, 50 );	//draws the outline part of the text
			}

		}
	}
}