import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class TicTacToeBoard{
	DrawTicTacToeBoard DrawTicTacToeBoard;
	JFrame frame;
	boolean showText=false;
	String racerPlaces="";
	int textX,textY,textSize;
	int[][] board;
	char[][] pieces;



	public TicTacToeBoard(int x,int y){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(x, y);

	}

	public void defineBoard(int [][]b){
		board=b;
	}

	public void setBoard(char[][]b){
		pieces=b;
	}



	public void setFiles(String path1,String path2){
		DrawTicTacToeBoard= new DrawTicTacToeBoard(path1,path2);
		frame.add(DrawTicTacToeBoard);
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

	public void setWinner(String s,int x,int y,int size){
		racerPlaces=s;
		textX=x;
		textY=y;
		textSize=size;
	}


	public class DrawTicTacToeBoard extends JPanel{
		BufferedImage image1,image2,image3;
		int racerOnex,racerOney,racerTwox,racerTwoy,racerThreex,racerThreey;

		public DrawTicTacToeBoard(String racerPathOne,String racerPathTwo){
			setBackground(Color.BLACK);
			try{
			image1=ImageIO.read(new File(racerPathOne));
			image2=ImageIO.read(new File(racerPathTwo));
			}catch(IOException e){}
		}


		 @Override
		 public void paintComponent(Graphics g) {
		 	super.paintComponent(g);

		 	for (int i=0;i<3;i++){
				for (int j=0;j<3;j++){
					if (pieces[i][j]=='x'){
						g.drawImage(image1,j*200+25,i*200+25,null,null);
					}
					if (pieces[i][j]=='o'){
						g.drawImage(image2,j*200+25,i*200+25,null,null);
					}
				}
			}

			g.setColor(Color.WHITE);

			for (int i=0;i<6;i++){
				g.drawLine(board[0][0],board[0][1]+i,board[0][2],board[0][3]+i);
				g.drawLine(board[1][0],board[1][1]+i,board[1][2],board[1][3]+i);
				g.drawLine(board[2][0]+i,board[2][1],board[2][2]+i,board[2][3]);
				g.drawLine(board[3][0]+i,board[3][1],board[3][2]+i,board[3][3]);
		}

			if (showText==true){
				g.setFont(new Font("TimesRoman", Font.PLAIN, textSize));
				g.drawString(racerPlaces,textX,textY);
			}
    	}
	}


}