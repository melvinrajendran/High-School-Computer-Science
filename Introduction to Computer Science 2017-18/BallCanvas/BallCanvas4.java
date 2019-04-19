public class BallCanvas4 {
	public static void main (String[]args) {

		BallCanvas ballCanvas = new BallCanvas(0, 300);

		for(int yPos = 0; yPos < 512; yPos++) {
			ballCanvas.moveBall(250, yPos);
			ballCanvas.delay(5);
			ballCanvas.repaint();
		}
		for(int xPos = 250; xPos < 300; xPos++) {
			ballCanvas.moveBall(xPos, 507);
			ballCanvas.delay(5);
			ballCanvas.repaint();
		}
		for(int yPos = 512; yPos > 0; yPos--) {
			ballCanvas.moveBall(300, yPos);
			ballCanvas.delay(5);
			ballCanvas.repaint();
		}

	}
}