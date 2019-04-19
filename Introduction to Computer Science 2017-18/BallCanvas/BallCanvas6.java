public class BallCanvas6 {
	public static void main (String[]args) {

		BallCanvas ballCanvas = new BallCanvas(0, 300);

			int xPos = 0;
			int xpos = 1;
			int ypos = 1;

		for (int yPos = 1; yPos < 1024; yPos+=ypos) {
			xPos += xpos;
			ballCanvas.moveBall(xPos, yPos);
			ballCanvas.delay(5);
			ballCanvas.repaint();

		if (yPos == 512)
			ypos *= -1;
		else if (yPos == 0)
			ypos *= -1;
		else if (xPos == 537)
			xpos *= -1;
		else if (xPos == 0)
			xpos *= -1;

		}
	}
}