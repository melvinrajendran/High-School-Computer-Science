using System;
namespace NotesDay2
{
    class Person
    {
        private string firstName;
        private string eyeColor;
        private int daysAlive;

        public string LastName { get; set; }

        public float YearsAlive
        {
            get
            {
                return (float)(daysAlive / 365.0);
            }

            set
            {
                daysAlive = (int)(value * 365);
            }
        }

        public Person(string firstName, int daysAlive)
        {
            this.firstName = firstName;
            this.daysAlive = daysAlive;
        }

        // Constructor Chaining
        public Person(string firstName, string eyeColor, int daysAlive)
            :this(firstName, daysAlive)
        {
            this.eyeColor = eyeColor;
        }

        public override string ToString()
        {
            return firstName + " " + LastName + " has " + eyeColor + " eyes and has been alive for " + YearsAlive + " years.";
        }
    }

}
