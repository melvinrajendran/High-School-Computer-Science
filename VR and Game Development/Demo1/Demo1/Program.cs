using System;
using System.Collections.Generic;
using System.Linq;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {
            // Input and Output

            Console.Write("Please enter a string: ");
            string str1 = Console.ReadLine();

            Console.Write("Please enter a second string: ");
            var str2 = Console.ReadLine();

            Console.WriteLine(str1);
            Console.WriteLine(str2);

            int total = 0;

            // Do-While Loop

            do
            {
                Console.Write("Please enter a number - 0 to stop ");
                str1 = Console.ReadLine();

                try
                {
                    total += Int32.Parse(str1);
                }
                catch(FormatException f)
                {
                    Console.WriteLine("Invalid Input");
                }
            } while (!str1.Equals("0"));

            Console.WriteLine(total);

            // Lists

            List<int> list = new List<int>();
            int x = 1;

            // While Loop to fill List

            while (x <= 10)
            {
                list.Add(x);
                x++;
            }

            // Console.WriteLine(list);

            // For and For-Each Loops

            for (int i = 1; i < list.Count; i++)
                Console.WriteLine(list.ElementAt(i) + " or " + list[i]);

            foreach (int number in list)
                Console.WriteLine("Num : {0} is a number {1} is the string we used before", number, str1);


            // Tuples

            var tupleOne = (1, "apple", 2);
            var tupleTwo = (firstname:"bob", lastname:"smith");

            Console.WriteLine(tupleOne.Item1);
            Console.WriteLine(tupleTwo.firstname);

            // Dictionaries

            Dictionary<string, string> dictionary = new Dictionary<string, string>();
            dictionary.Add("E302", "Schiff");
            dictionary.Add("100", "Miller");
            dictionary.Add("205", "Hayston");

            string name = "";
            dictionary.TryGetValue("100", out name);
            Console.WriteLine(name);
        } // Main

        public static (string, string) NamePairMaker(string first, string second)
        {
            return (first, second);
        }
    } // class
} // namespace