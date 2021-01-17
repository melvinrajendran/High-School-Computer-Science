import java.io.*;
import java.util.*;

public class CarActivity {
    public static void main(String[] args) {
        Queue<Car> queue = new LinkedList<>();
        Stack<Car> stack = new Stack<>();
        PriorityQueue<Car> pQueue = new PriorityQueue<>();

        try {
            BufferedReader input = new BufferedReader(new FileReader("/Users/melvinrajendran/Documents/Data Structures 2020-21/Queues/Car Activity/CarData.txt"));
            String text;

            while ((text = input.readLine()) != null) {
                if (!text.startsWith("C")) {
                    String[] instanceVars = text.split("\\s+");
                    int[] intVars = new int[instanceVars.length];
                    for (int i = 0; i < instanceVars.length; i++)
                        intVars[i] = Integer.parseInt(instanceVars[i]);
                    queue.add(new Car(intVars[0], intVars[1], intVars[2], intVars[3], intVars[4], intVars[5], intVars[6], intVars[7]));
                }
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Queue:");
        while (!queue.isEmpty()) {
            Car current = queue.poll();
            System.out.println(current);
            stack.add(current);
        }

        System.out.println("\nStack:");
        while (!stack.isEmpty()) {
            Car current = stack.pop();
            System.out.println(current);
            pQueue.add(current);
        }

        System.out.println("\nPriority Queue:");
        while (!pQueue.isEmpty())
            System.out.println(pQueue.poll());
    }

    public static class Car implements Comparable<Car> {
        private int id, milesPerGal, engineSize, horsePower, weight, acceleration, originCountry, numCylinders;

        public Car(int id, int milesPerGal, int engineSize, int horsePower, int weight, int acceleration, int originCounty, int numCylinders) {
            this.id = id;
            this.milesPerGal = milesPerGal;
            this.engineSize = engineSize;
            this.horsePower = horsePower;
            this.weight = weight;
            this.acceleration = acceleration;
            this.originCountry = originCounty;
            this.numCylinders = numCylinders;
        }

        public int getID() { return id; }

        public int getMilesPerGal() { return milesPerGal; }

        public int getEngineSize() { return engineSize; }

        public int getHorsePower() { return horsePower; }

        public int getWeight() { return weight; }

        public int getAcceleration() { return acceleration; }

        public int getOriginCountry() { return originCountry; }

        public int getNumCylinders() { return numCylinders; }

        public int compareTo(Car other) {
            if (acceleration < other.getAcceleration()) {
                return -1;
            } else if (acceleration > other.getAcceleration()) {
                return 1;
            } else {
                if (milesPerGal < other.getMilesPerGal()) {
                    return -1;
                } else if (milesPerGal > other.getMilesPerGal()) {
                    return 1;
                } else {
                    if (horsePower < other.getHorsePower()) {
                        return -1;
                    } else if (horsePower > other.getHorsePower()) {
                        return 1;
                    } else {
                        if (engineSize < other.getEngineSize()) {
                            return -1;
                        } else if (engineSize > other.getEngineSize()) {
                            return 1;
                        } else {
                            if (weight < other.getWeight()) {
                                return -1;
                            } else if (weight > other.getWeight()) {
                                return 1;
                            } else {
                                if (numCylinders < other.getNumCylinders()) {
                                    return -1;
                                } else if (numCylinders > other.getNumCylinders()) {
                                    return 1;
                                } else {
                                    if (id < other.getID()) {
                                        return -1;
                                    } else if (id > other.getID()) {
                                        return 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return 0;
        }

        public String toString() { return String.format("%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s", id, milesPerGal, engineSize, horsePower, weight, acceleration, originCountry, numCylinders); }
    }
}