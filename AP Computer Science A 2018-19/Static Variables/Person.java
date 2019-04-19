public class Person
{
	public int personCounter = 0;
	public static int staticPersonCounter = 0;

	public void add()
	{
		personCounter++;
		staticPersonCounter++;
	}

	public String toString()
	{
		return "Person Counter = " + personCounter + "\n" +
			   "Static Counter = " + staticPersonCounter;
	}
}