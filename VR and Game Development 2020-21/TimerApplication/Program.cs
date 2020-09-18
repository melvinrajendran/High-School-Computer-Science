using System;
using System.Diagnostics;

namespace TimerApplication
{
    class Program
    {
        static void Main(string[] args)
        {
            bool repeatTimer = true;

            while (repeatTimer == true)
            {
                Stopwatch stopwatch = new Stopwatch();
                stopwatch.Start();

                Console.Write("To stop the timer, type [S] to output elapsed seconds or [M] to output elapsed milliseconds: ");
                string outputUnits = Console.ReadLine();

                while (!(outputUnits.Equals("S") || outputUnits.Equals("s") || outputUnits.Equals("M") || outputUnits.Equals("m")))
                {
                    Console.Write("\tInvalid Response. Type [S] to output elapsed seconds or [M] to output elapsed milliseconds: ");
                    outputUnits = Console.ReadLine();
                }

                stopwatch.Stop();

                if (outputUnits.Equals("S") || outputUnits.Equals("s"))
                {
                    Console.WriteLine("\tElapsed seconds: {0}", stopwatch.Elapsed.TotalSeconds);
                }
                else if (outputUnits.Equals("M") || outputUnits.Equals("m"))
                {
                    Console.WriteLine("\tElapsed milliseconds: {0}", stopwatch.Elapsed.TotalMilliseconds);
                }

                Console.Write("\tType [Y] to repeat the timer or [N] to exit: ");
                string response = Console.ReadLine();

                while (!(response.Equals("Y") || response.Equals("y") || response.Equals("N") || response.Equals("n")))
                {
                    Console.Write("\tInvalid Response. Type [Y] to repeat the timer or [N] to exit: ");
                    response = Console.ReadLine();
                }
                if (response.Equals("N") || response.Equals("n")) {
                    repeatTimer = false;
                }

                Console.WriteLine();
            }
        }
    }
}
