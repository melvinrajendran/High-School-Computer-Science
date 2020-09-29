using System;
using System.Collections.Generic;

namespace DelegatesApplication
{
    class Program
    {
        public delegate bool DelegateMethod(int num);

        static void Main(string[] args)
        {
            // Part 1

            List<int> list = new List<int>();
            for (int i = 0; i < 10; i++)
            {
                list.Add(new Random().Next(1, 100));
            }

            DelegateMethod method = CheckEven;

            Console.WriteLine(CountEvenNums(list, method) + "\n");

            // Part 2

            List<(string fName, string lName)> nameList = new List<(string fName, string lName)>();

            for (int i = 1; i <= 5; i++)
            {
                Console.Write("Enter Full Name {0}: ", i);
                string currentName = Console.ReadLine();
                while (!currentName.Contains(" "))
                {
                    Console.Write("Invalid Input. Enter Full Name {0}: ", i);
                    currentName = Console.ReadLine();
                }
                string[] nameSegments = currentName.Split(" ");
                nameList.Add((nameSegments[0], nameSegments[1]));
            }

            Dictionary<int, string> dictionary = new Dictionary<int, string>();

            for (int i = 0; i < nameList.Count; i++)
            {
                dictionary.Add(i, (nameList[i].fName));
            }

            foreach (KeyValuePair<int, string> kvp in dictionary)
            {
                Console.WriteLine("{0}: {1}", kvp.Key, kvp.Value);
            }

        }

        public static bool CheckEven(int num)
        {
            return (num % 2 == 0);
        }

        public static int CountEvenNums(List<int> list, DelegateMethod method)
        {
            int count = 0;

            foreach (int i in list)
            {
                if (method(i))
                {
                    count++;
                }
                Console.WriteLine("{0}: {1}", i, method(i));
            }

            return count;
        }
    }
}
