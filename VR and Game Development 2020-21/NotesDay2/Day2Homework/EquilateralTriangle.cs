using System;
namespace Day2Homework
{
    class EquilateralTriangle : EquilateralPolygon
    {
        public float area
        {
            get
            {
                return (float)(Math.Sqrt(3) / 4 * Math.Pow(sideLength, 2));
            }
        }
        public float perimeter
        {
            get
            {
                return numSides * sideLength;
            }
        }

        public EquilateralTriangle(float sideLength) : base(3, sideLength)
        {
        }

        public override string ToString()
        {
            return "Equilateral Triangle\n\tNumber of Sides: " + numSides + "\n\tSide Length: " + sideLength + "\n\tArea: " + area + "\n\tPerimeter: " + perimeter;
        }
    }
}
