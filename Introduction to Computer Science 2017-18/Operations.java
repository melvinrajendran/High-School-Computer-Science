public class Operations{
	public static void main (String[]args){

		int i = 2;
		int j = 11;
		double k = 4.1;
		double m = 6.0;

		System.out.println(i-j);
		System.out.println(k+m);
		System.out.println(k+j);
		//the double overrides the int operation.
		System.out.println(j%i);
		System.out.println((double)i+j);
		System.out.println((int)6.7);
		//this will not round.  only drops the decimal character.
		System.out.println(j/i);
		System.out.println((double)j/i);
		System.out.println(j/(double)i);
		System.out.println((double)(j/i));

		i = j - 3;
		System.out.println(k);
		k = i + 3;
		System.out.println(k);
		//j = k + 3; This will not work.  (saving a double t an int variable)
		//System.out.println(j);
		double sum = k + i;
		double avg = sum/2;

}
}