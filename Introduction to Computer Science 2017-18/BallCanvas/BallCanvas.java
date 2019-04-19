import javax.swing.*;
import java.awt.*;

public class BallCanvas{
	Ball ball1;
	Ball ball2;
	JFrame frame;

	public BallCanvas(int x,int y){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		ball1 = new Ball(x,y,Color.RED);
		frame.add(ball1);
		frame.setVisible(true);


	}

	public void moveBall(int x,int y){
		ball1.changePosition(x,y);
	}



	public void repaint(){
		frame.repaint();

	}

	public void changeBallColor(Color c){
		ball1.setColor(c);
	}

	public void delay(int x){
		try{
			Thread.sleep(x);
		}catch(Exception e){}
	}


	public class Ball extends JPanel{
		int xPos,yPos;
		Color c;

		public Ball(int x,int y,Color color){
			xPos=x;
			yPos=y;
			c=color;
		}

		public void changePosition(int x,int y){
			xPos=x;
			yPos=y;
		}

		public void setColor(Color color){
			c=color;
		}

		 @Override
		 public void paintComponent(Graphics g) {
		 	super.paintComponent(g);
		    g.setColor(c);
		    g.fillOval(xPos,yPos, 50, 50);
		    g.setColor(Color.BLUE);
			g.drawLine(300,1,300,600);
    	}
	}


}