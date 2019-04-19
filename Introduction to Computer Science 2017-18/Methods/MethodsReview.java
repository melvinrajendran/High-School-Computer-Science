public class MethodsReview {
	public static void main (String[]args) {

	/*double pi = Math.PI;
	System.out.println(pi);
	System.out.println(Round(pi));

	}
	public static double Round (double a) {

	double val = (double)Math.round(a*100)/100;
	return val;

//Practice I

	System.out.println(numSum1(2, 3));
	System.out.println(numSum2(2, 3, 4));
	System.out.println(numSum3(2, 3, 4, 5));
	System.out.println(numQuot(2, 4.0));

	}
	public static int numSum1 (int a, int b) {

	int sum1 = a + b;
	return sum1;

	}
	public static int numSum2 (int a, int b, int c) {

	int sum2 = a + b + c;
	return sum2;

	}
	public static int numSum3 (int a, int b, int c, int d) {

	int sum3 = a + b + c + d;
	return sum3;

	}
	public static double numQuot (int a, double b) {

	double quotient = a /(double) b;
	return quotient;

//Practice II

	double pi = Math.PI;
	double pii = Round(pi);



	System.out.println(Round(rectanglearea(5, 10)));
	System.out.println(Round(perimeter(5)));
	System.out.println(Round(trianglearea(5, 10)));
	System.out.println(Round(diametercircum(10, pii)));
	System.out.println(Round(radiuscircum(5, pii)));

	}
	public static double Round (double a) {

	double val = (double)Math.round(a*100)/100;
	return val;

	}
	public static int rectanglearea (int a, int b) {

	int rectarea = a * b;
	return rectarea;

	}
	public static int perimeter (int a) {

	int perim = 4 * a;
	return perim;

	}
	public static double trianglearea (int a, int b) {

	double triarea = 0.5 * a * b;
	return triarea;

	}
	public static double diametercircum (int a, double pii) {

	double diamcircum = a * pii;
	return diamcircum;

	}
	public static double radiuscircum (int a, double pii) {

	double radicircum = 2 * a * pii;
	return radicircum;*/

//Practice III

	System.out.println(height(2, 100));
	System.out.println(velocity(100, 5));
	System.out.println(avgvelocity(0, 5, 0, 20));

	}
	public static double height (double t1, double b) {

	double pennyheight = (-4.9 * t1 * t1) + b;
	return pennyheight;

	}
	public static double velocity (double vo, double t2) {

	double velo = vo - (9.8 * t2);
	return velo;

	}
	public static double avgvelocity (double a, double b, double x1, double x2) {

	double avgvelo = ((x2 - x1) / (double)(b - a));
	return avgvelo;

	}
}