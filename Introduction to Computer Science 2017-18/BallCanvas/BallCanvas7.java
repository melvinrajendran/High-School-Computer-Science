public class BallCanvas7 {
	public static void main (String[]args) {

		BallCanvas ballCanvas = new BallCanvas(0, 300);

		int xPos = 0;

		for (xPos = 19; xPos <= 518; xPos++) {
			double yPos = (0.008192 * ((xPos - 269) * (xPos - 269)));
			ballCanvas.moveBall(xPos, (int) yPos);
			ballCanvas.delay(5);
			ballCanvas.repaint();
		}
	}
}