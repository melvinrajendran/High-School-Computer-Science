public class DTOPractice {
	public static void main (String[]args) {


//Practice I
		/*int x = 11;
		int y = 8;
		int z = 3;
		int counter = 0;

		System.out.println(x - y);
		counter++;
		System.out.println(y % z);
		counter++;
		System.out.println(z * x);
		counter++;
		System.out.println(x / y);
		counter++;
		System.out.println(x - (y / 3));
		counter++;
		System.out.println(counter);

//Practice II
		int x = 0;

		System.out.print("number\tsquare\tcube\n");
		x++;
		System.out.print(x + "\t" + x + "\t" + x + "\n");
		x++;
		System.out.print(x + "\t" + (x * x) + "\t" + (x * x * x) + "\n");
		x++;
		System.out.print(x + "\t" + (x * x) + "\t" + (x * x * x) + "\n");
		x++;
		System.out.print(x + "\t" + (x * x) + "\t" + (x * x * x) + "\n");
		x++;
		System.out.print(x + "\t" + (x * x) + "\t" + (x * x * x) + "\n");
		x++;
		System.out.print(x + "\t" + (x * x) + "\t" + (x * x * x) + "\n");
		x++;
		System.out.print(x + "\t" + (x * x) + "\t" + (x * x * x) + "\n");
		x++;
		System.out.print(x + "\t" + (x * x) + "\t" + (x * x * x) + "\n");
		x++;
		System.out.print(x + "\t" + (x * x) + "\t" + (x * x * x) + "\n");
		x++;
		System.out.print(x + "\t" + (x * x) + "\t" + (x * x * x) + "\n");*/

//Practice III
		int comp = 296;
		int att = 495;
		int touch = 35;
		int inter = 10;
		int yards = 3837;

		double a = ((((double)(comp)/(double)(att) * 100.0) - 30.0) / 20.0) ;
		double b = (((double)(touch)/(double)(att) * 100.0) / 5.0) ;
		double c = ((9.5 - ((double)(inter)/(double)(att) * 100.0)) / 4.0) ;
		double d = (((double)(yards)/(double)(att) - 3.0) / 4.0) ;
		double r = ((double)(a + b + c + d) / .06) ;

		System.out.println("Rank:\tQuarterback\tTeam\tRating");
		System.out.println("8\tCam Newton\tCAR\t" + r);



}
}