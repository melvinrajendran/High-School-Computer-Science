public class Converter {

	public static void main (String[]args) {

//Part I
		int degrF = 88;
		double degrC = ((5.0 *(degrF - 32))/9);

		System.out.println(degrC + "\n");

//Part II
		double T = 2.8;
		double g = 9.8;
		double Pi = 3.1416;
		double L = (g * T * T) / (4 * Pi * Pi);

		System.out.println(L + "\n");

//Part III
		double fl = 20.2;
		double v = 68.5;
		double u = ((fl * v) / (v - fl));

		System.out.println(u + "\n");

	}
}