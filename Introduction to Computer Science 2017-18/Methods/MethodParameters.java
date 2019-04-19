public class MethodParameters {
	public static void main (String[]args) {

		int num1 = 20;
		int num2 = 10;

		System.out.println(numberDivider(num1 , num2));

	}
	public static double numberDivider (double a , double b){
		double quotient = (a/b);
		return quotient;

		int num1 = 1;
		int num2 = 2;
		int num3 = 3;
		int num4 = 4;
		int num5 = 5;

		System.out.println(numberAvg(num1, num2, num3, num4, num5));

	}
	public static double numberAvg (double a, double b, double c, double d, double e) {
		double quotient = ((a + b + c + d + e)/5.0);
		return quotient;

		int num1 = 5;

		System.out.println(numberExp(num1));

	}
	public static double numberExp(double a) {
		double exp = (a * a * a * a);
		return exp;

		double num1 = 5.0;

		System.out.println(numberExp(num1));

	}
	public static double numberExp(double a) {
		double exp = (a * a * a * a);
		return exp;

	}
}