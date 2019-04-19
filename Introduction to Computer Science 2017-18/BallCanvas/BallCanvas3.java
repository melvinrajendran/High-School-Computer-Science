public class BallCanvas3 {
	public static void main (String[]args) {

		BallCanvas ballCanvas = new BallCanvas(0, 300);

		for(int yPos = 0; yPos < 512; yPos++) {
			ballCanvas.moveBall(0, yPos);
			ballCanvas.delay(5);
			ballCanvas.repaint();
		}
		for(int yPos = 512; yPos > 0; yPos--) {
			ballCanvas.moveBall(0, yPos);
			ballCanvas.delay(5);
			ballCanvas.repaint();
		}

	}
}