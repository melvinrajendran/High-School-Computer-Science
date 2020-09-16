using System;
using System.Collections.Generic;

namespace Day2Homework
{
    class Program
    {
        static void Main(string[] args)
        {
            List<EquilateralTriangle> list = new List<EquilateralTriangle>();
            list.Add(new EquilateralTriangle(5));
            list.Add(new EquilateralTriangle(6));
            list.Add(new EquilateralTriangle(7));
            list.Add(new EquilateralTriangle(8));
            list.Add(new EquilateralTriangle(9));

            list.ForEach(Console.WriteLine);

            float sumOfPerimeters = 0, greatestArea = 0;
            int index = 0;

            for (int i = 0; i < list.Count; i++)
            {
                sumOfPerimeters += list[i].perimeter;
                if (list[i].area > greatestArea)
                {
                    greatestArea = list[i].area;
                    index = i;
                }
            }

            Console.WriteLine("\nSum of perimeters: {0}", sumOfPerimeters);
            Console.WriteLine("Index of Equilateral Triangle with greatest area: {0}", index);
        }
    }
}
