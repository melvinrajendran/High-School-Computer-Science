public class BallCanvas2 {
	public static void main (String[]args) {

		BallCanvas ballCanvas = new BallCanvas(0, 300);

		for(int yPos = 0; yPos < 512; yPos+=10) { //increasing the increment for the loop makes the ball faster
			ballCanvas.moveBall(0, yPos);
			ballCanvas.delay(1); //lowering the delay makes the ball faster
			ballCanvas.repaint();
		}

	}
}