package TestSets;

import Lists.*;
import RandomGenerators.IRandomGenerator;

import java.util.ArrayList;

public class TestSets {
    static int[] testIterations = new int[]{100, 500, 1000, 5000, 10000, 50000, 100000};
    private static double SingleTest(int iterations, IList list, IRandomGenerator randomGenerator) {
        double sum = 0;
        for (int i = 0; i < iterations; i++) {
            int randInt = randomGenerator.getInteger();
            sum += list.access(randInt);
        }
        return sum/iterations;
    }

    private static double MultiSingleTest(int iterations, IList list, IRandomGenerator randomGenerator, int repetitions) {
        double sum = 0;
        for (int i = 0; i < repetitions; i++) {
            list.clear();
            sum += SingleTest(iterations, list, randomGenerator);
        }
        return sum / repetitions;
    }

    public static void SimpleListTests(IRandomGenerator randomGenerator){
        System.out.println("Results for Simple List with " + randomGenerator.generatorType() + ":");
        for (int iterations : testIterations) {
            ListSimple list = new ListSimple();
            System.out.print("(" + iterations +",\t" + MultiSingleTest(iterations, list, randomGenerator, 10)+")\n");
        }
    }

    public static void MTFListTests(IRandomGenerator randomGenerator){
        System.out.println("Results for MTF List with " + randomGenerator.generatorType() + ":");
        for (int iterations : testIterations) {
            ListMTF list = new ListMTF();
            System.out.print("(" + iterations +",\t" + MultiSingleTest(iterations, list, randomGenerator, 10)+")\n");
        }
    }
    public static void TransposeListTests(IRandomGenerator randomGenerator){
        System.out.println("Results for Transpose List with " + randomGenerator.generatorType() + ":");
        for (int iterations : testIterations) {
            ListTranspose list = new ListTranspose();
            System.out.print("(" + iterations +",\t" + MultiSingleTest(iterations, list, randomGenerator, 10)+")\n");
        }
    }
    public static void CounterListTests(IRandomGenerator randomGenerator){
        System.out.println("Results for Counter List with " + randomGenerator.generatorType() + ":");
        for (int iterations : testIterations) {
            ListWithCounter list = new ListWithCounter();
            System.out.print("(" + iterations +",\t" + MultiSingleTest(iterations, list, randomGenerator, 10)+")\n");
        }
    }
}
