import java.util.ArrayList;
public class ArrayListReviewDTO{

	public static void main(String [] args){

    	ArrayList<Character> list = new ArrayList<>();
    	list.add('A');
    	System.out.println(list);

    	list.add('B');
    	System.out.println(list);

    	list.add('B');
    	System.out.println(list);

    	list.add('C');
    	System.out.println(list);

    	list.add(2,'D');
    	System.out.println(list);

    	list.add(2,list.remove(0));
    	System.out.println(list);

    	list.set(0,'Z');
    	System.out.println(list);

    	System.out.println(list.set(1,'Q'));
    	System.out.println(list);

    	list.add(2,'A');
    	for (int i = 0; i< list.size(); i++){
    		if (list.get(i) == 'A'){
    			list.add(0,'A');
    			list.remove(list.size()-1);
			}
		}
		System.out.println(list);
    }
}