import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RacerCanvas {
	DrawRacers racers;
	JFrame frame;
	boolean showText=false;
	String racerPlaces="";
	int textX,textY,textSize;

	public RacerCanvas(int x,int y){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(x, y);

	}

	public void moveRacer1(int x,int y){
		racers.changeRacer1Position(x,y);
	}

	public void moveRacer2(int x,int y){
		racers.changeRacer2Position(x,y);
	}

	public void moveRacer3(int x,int y){
		racers.changeRacer3Position(x,y);
	}

	public void setFiles(String path1,String path2,String path3){
		racers= new DrawRacers(path1,path2,path3);
		frame.add(racers);
		frame.setVisible(true);
	}


	public void repaint(){
		frame.repaint();
	}


	public void delay(int x){
		try{
			Thread.sleep(x);
		}catch(Exception e){}
	}

	public void showText(boolean b){
		showText=b;
	}

	public void setPlaces(String s,int x,int y,int size){
		racerPlaces=s;
		textX=x;
		textY=y;
		textSize=size;
	}


	public class DrawRacers extends JPanel{
		BufferedImage image1,image2,image3;
		int racerOnex,racerOney,racerTwox,racerTwoy,racerThreex,racerThreey;

		public DrawRacers(String racerPathOne,String racerPathTwo,String racerPathThree){
			setBackground(Color.BLACK);
			try{
			image1=ImageIO.read(new File(racerPathOne));
			image2=ImageIO.read(new File(racerPathTwo));
			image3=ImageIO.read(new File(racerPathThree));
			}catch(IOException e){}

		}


		public void changeRacer1Position(int x,int y){
			racerOnex=x;
			racerOney=y;
		}

		public void changeRacer2Position(int x,int y){
			racerTwox=x;
			racerTwoy=y;
		}

		public void changeRacer3Position(int x,int y){
			racerThreex=x;
			racerThreey=y;
		}



		 @Override
		 public void paintComponent(Graphics g) {
		 	super.paintComponent(g);
			g.drawImage(image1,racerOnex,racerOney,null,null);
			g.drawImage(image2,racerTwox,racerTwoy,null,null);
			g.drawImage(image3,racerThreex,racerThreey,null,null);
			g.setColor(Color.WHITE);
			if (showText==true){
				g.setFont(new Font("TimesRoman", Font.PLAIN, textSize));
				g.drawString(racerPlaces,textX,textY);
			}
    	}
	}


}