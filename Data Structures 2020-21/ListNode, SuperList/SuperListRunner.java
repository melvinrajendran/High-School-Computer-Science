public class SuperListRunner {
	public static void main(String[] args) {
		System.out.println("\"ArrayList\" Values");
		SuperList<Integer> arrayList = new SuperList<>();
		for (int i = 0; i < 30; i++)
			arrayList.add((int)(Math.random() * 1000) + 1);
		System.out.println(arrayList);
		System.out.println(arrayList.size());

		System.out.println("\n\"Stack\" Values");
		SuperList<Integer> stackList = new SuperList<>();
		while (!arrayList.isEmpty())
			stackList.push(arrayList.remove(0));
		System.out.println(stackList);

		System.out.println("\n\"Queue\" Values");
		SuperList<Integer> queueList = new SuperList<>();
		while (!stackList.isEmpty())
			queueList.add(stackList.pop());
		System.out.println(queueList);

		System.out.println("\nRandomized \"ArrayList\" Values");
		while (!queueList.isEmpty()) {
			int random = (int)(Math.random() * (arrayList.size() + 1));
			arrayList.add(random, queueList.poll());
		}
		System.out.println(arrayList);

		int sum = 0, evenSum = 0, oddSum = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			sum += arrayList.get(i);
			if (i % 2 == 0)
				evenSum += arrayList.get(i);
			else
				oddSum += arrayList.get(i);
		}
		System.out.println("\nSum: " + sum + "\nEven Indexed Value Sum: " + evenSum + "\nOdd Indexed Value Sum: " + oddSum);

		System.out.println("\nDuplicating Even Values");
		int initialSize = arrayList.size();
		for (int i = 0; i < initialSize; i++)
			if (arrayList.get(i) % 2 == 0)
				arrayList.add(arrayList.get(i));
		System.out.println(arrayList);

		System.out.println("\nRemoving Values Divisible by 3");
		for (int i = 0; i < arrayList.size();) {
			if (arrayList.get(i) % 3 == 0)
				arrayList.remove(i);
			else
				i++;
		}
		System.out.println(arrayList);

		System.out.println("\nInserting the Value 55555 into Position 4");
		arrayList.add(4, 55555);
		System.out.println(arrayList);

		System.out.println("\nSelection Sorting in Ascending Order");
		int minIndex;
		for (int i = 0; i < arrayList.size() - 1; i++) {
			minIndex = i;

			for (int j = i + 1; j < arrayList.size(); j++)
				if (arrayList.get(j) < arrayList.get(minIndex))
					minIndex = j;
			
			int temp = arrayList.get(i);
			arrayList.add(i, arrayList.get(minIndex));
			arrayList.remove(i + 1);
			arrayList.add(minIndex, temp);
			arrayList.remove(minIndex + 1);
		}
		System.out.println(arrayList);

		double medianValue;
		if (arrayList.size() % 2 == 1)
			medianValue = arrayList.get(arrayList.size() / 2);
		else
			medianValue = (arrayList.get(arrayList.size() / 2 - 1) + arrayList.get(arrayList.size() / 2)) / 2.0;
		System.out.println("\nMedian Value: " + medianValue);
		SuperList<Integer> beforeList = new SuperList<>(), afterList = new SuperList<>();
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) > medianValue)
				afterList.add(arrayList.get(i));
			else if (arrayList.get(i) < medianValue)
				beforeList.add(arrayList.get(i));
		}
		System.out.println("Values Before Median: " + beforeList + "\nValues After Median: " + afterList);
		
		System.out.println("\nString SuperList");
		SuperList<String> stringList = new SuperList<>();
		String sentence = "My name is Melvin Rajendran and I am eighteen years old.";
		String[] words = sentence.split("[\\p{Punct}\\s]+");
		for (String word : words)
			stringList.add(word);
		System.out.println(stringList);

		System.out.println("\nRemoving Values of Length Less Than or Equal to 3");
		for (int i = 0; i < stringList.size();) {
			if (stringList.get(i).length() <= 3)
				stringList.remove(i);
			else
				i++;
		}
		System.out.println(stringList);

		System.out.println("\nInsertion Sorting in Ascending Order");
		int n = stringList.size();
		for (int j = 1; j < n; j++) {
			String key = stringList.get(j);
			int i = j - 1;
			while ((i >= 0) && (stringList.get(i).length() > key.length())) {
				stringList.add(i + 1, stringList.get(i));
				stringList.remove(i + 2);
				i--;
			}
			stringList.add(i + 1, key);
			stringList.remove(i + 2);
		}
		System.out.println(stringList);

		double lengthSum = 0;
		for (int i = 0; i < stringList.size(); i++)
			lengthSum += stringList.get(i).length();
		System.out.println("\nAverage Word Length: " + lengthSum / stringList.size());
	}
}