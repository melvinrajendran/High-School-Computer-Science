using System;
namespace Day2Homework
{
    class EquilateralPolygon
    {
        public int numSides { get; set; }
        public float sideLength { get; set; }

        public EquilateralPolygon(int numSides, float sideLength)
        {
            this.numSides = numSides;
            this.sideLength = sideLength;
        }

        public override string ToString()
        {
            return "Equilateral Polygon\n\tNumber of Sides: " + numSides + "\n\tSide Length: " + sideLength;
        }
    }
}
