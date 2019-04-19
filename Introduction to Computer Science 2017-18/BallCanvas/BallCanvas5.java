public class BallCanvas5 {
	public static void main (String[]args) {

		BallCanvas ballCanvas = new BallCanvas(0, 300);

		int ypos = 1024;
		for(int yPos = 0; yPos < 1024; yPos++) {
			ypos--;
			if (yPos < 512) {
				ballCanvas.moveBall(0, yPos);
				ballCanvas.delay(5);
				ballCanvas.repaint();
			}
			else if (yPos >= 512) {
				ballCanvas.moveBall(0, ypos);
				ballCanvas.delay(5);
				ballCanvas.repaint();
			}
		}
	}
}