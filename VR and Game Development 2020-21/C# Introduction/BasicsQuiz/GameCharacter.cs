using System;
namespace BasicsQuiz
{
    public class GameCharacter
    {
        private string name;
        private string subclass;
        private int experience;
        private string weapon;

        public int Level
        {
            get
            {
                return experience / 1000 + 1;
            }
        }

        public GameCharacter(Tuple<string, string> attributes)
        {
            this.name = attributes.Item1;
            this.subclass = attributes.Item2;
            this.experience = 0;
        }

        public GameCharacter(Tuple<string, string> attributes, string weapon)
            : this(attributes)
        {
            this.weapon = weapon;
        }

        public void AddExperience(int num)
        {
            this.experience += num;
        }

        public bool BoostExperience()
        {
            if (this.Level < 10)
            {
                this.experience += 5000;
                return true;
            } else
            {
                return false;
            }
        }

        public override string ToString()
        {
            return name + " - " + subclass + "\nLevel " + Level;
        }
    }
}
