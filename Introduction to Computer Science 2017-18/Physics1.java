public class Physics1 {
	public static void main (String[]args) {

		double so = 12.0;
		double vo = 3.5;
		double a = 9.8;
		double t = 10;
		double s = so + (vo * t) + (1.0 / 2.0) * a * t * t;

		System.out.println(s);

}
}