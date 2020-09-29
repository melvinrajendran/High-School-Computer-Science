using System;

namespace BasicsQuiz
{
    class Program
    {
        public delegate bool DelegateMethod();

        static void Main(string[] args)
        {
            // Part I
            GameCharacter gameCharacter = new GameCharacter(new Tuple<string, string> ("Lord Shaxx", "Titan"));
            Console.WriteLine(gameCharacter);

            gameCharacter.AddExperience(6000);
            Console.WriteLine(gameCharacter);

            // Part II
            DelegateMethod method = gameCharacter.BoostExperience;
            method();
            Console.WriteLine(gameCharacter);
            method();
            Console.WriteLine(gameCharacter);
        }
    }
}
