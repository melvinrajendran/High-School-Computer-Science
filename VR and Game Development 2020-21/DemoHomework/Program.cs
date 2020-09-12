using System;
using System.Collections.Generic;
using System.Linq;

namespace DemoHomework
{
    class Program
    {
        static void Main(string[] args)
        {
            // Part I
            List<int> list = CreateList();
            list.ForEach(Console.WriteLine);

            Console.WriteLine("Average Value: " + ObserveList(list).Item1);
            Console.WriteLine("List Count: " + ObserveList(list).Item2);

            var result = CreateTupleList();
            Console.WriteLine(result.ElementAt(0).Item1 + " " + result.ElementAt(0).Item2);
            Console.WriteLine(result.ElementAt(1).Item1 + " " + result.ElementAt(1).Item2);

            // Part II
            Dictionary<string, string> dictionary = new Dictionary<string, string>();
            dictionary.Add("English", "Halaw");
            dictionary.Add("Social Studies", "McGinley");
            dictionary.Add("VR and Game Design", "Schiff");
            dictionary.Add("Microeconomics", "Bogert");
            dictionary.Add("Data Structures", "Dentler");
            dictionary.Add("Spanish", "Hicks");
            dictionary.Add("Math", "Dentler");
            dictionary.Add("PEER", "Scher");

            var result2 = CreateTeacherList(dictionary);
            result2.ForEach(Console.WriteLine);

        }
        
        static List<int> CreateList()
        {
            List<int> list = new List<int>();

            for (int i = 1; i <= 500; i++)
            {
                if (i % 2 == 0 && i % 3 == 0 && i % 10 != 0)
                {
                    list.Add(i);
                }
            }

            return list;
        }

        static (double, int) ObserveList(List<int> list)
        {
            int sum = 0;

            foreach (int i in list)
            {
                sum += i;
            }

            return ((double)sum / list.Count, list.Count);
        }

        static List<(string, int)> CreateTupleList()
        {
            string stringOne = "", stringTwo = "";

            for (int i = 1; i <= 4; i++)
            {
                Console.Write("Please enter String " + i + ": ");
                var temp = Console.ReadLine();

                if (i == 1)
                {
                    stringOne = temp;
                } else
                {
                    if (temp.Length > stringOne.Length)
                    {
                        stringTwo = stringOne;
                        stringOne = temp;
                    } else if (temp.Length > stringTwo.Length)
                    {
                        stringTwo = temp;
                    }
                }
            }

            List<(string, int)> returnList = new List<(string, int)>();
            returnList.Add((stringOne, stringOne.Length));
            returnList.Add((stringTwo, stringTwo.Length));

            return returnList;
        }

        static List<string> CreateTeacherList(Dictionary<string, string> dictionary)
        {
            List<string> list = new List<string>();

            foreach (KeyValuePair<string, string> kvp in dictionary)
            {
                if ((kvp.Key == "Math" || kvp.Key == "Science" || kvp.Key == "Art") && !list.Contains(kvp.Key))
                {
                    list.Add(kvp.Value);
                }
            }

            return list;
        }
    }
}
