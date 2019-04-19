public class Dog {

	private String breed;
	private int age;

	public Dog() {
		breed = "Pug";
		age = 5;
	}

	/*public Dog (String breed, int age) {
		this.breed = breed;
		this.age = age;
	}*/

	public String toString() { //toString method converts internal variables of object into printed statement
		return "This is a " + breed + " and it is " + age + " years old.";
	}

	public String getBreed() { return breed; } //returns internal variable of object

	public void setBreed (String newBreed) { breed = newBreed; } //changes internal variable of object

	public int getAge() { return age; };

	public void setAge (int newAge) { age = newAge; };

}