import java.util.ArrayList;

public class PassByValue {

	public static void changeValues(ArrayList<Integer> l1,ArrayList<Integer> l2,int [] arr1, int[] arr2,String str1,String str2,int num){
		l1 = new ArrayList<Integer>();
		l2.set(1,0);
		arr1 = new int[3];
		arr2[1]=0;
		str1 = str1.substring(0,6);
		str2 = new String("StringThree");
		num = 0;
	}

	public static void main (String[] args){

		ArrayList<Integer> listOne = new ArrayList<>();
		listOne.add(2);
		listOne.add(4);
		listOne.add(6);
		ArrayList<Integer> listTwo = new ArrayList<>();
		listTwo.add(2);
		listTwo.add(4);
		listTwo.add(6);
		int [] arrOne = {1,2,3};
		int [] arrTwo = {4,5,6};
		String strOne = "StringOne";
		String strTwo = "StringTwo";
		int i = 5;

		//changeValues(listOne,listTwo,arrOne,arrTwo,strOne,strTwo,i);

		System.out.println(listOne);
		System.out.println(listTwo);
		for (int j: arrOne)
			System.out.print(j);
		System.out.println();
		for (int j: arrTwo)
			System.out.print(j);
		System.out.println();
		System.out.println(strOne);
		System.out.println(strTwo);
		System.out.println(i);
	}

}