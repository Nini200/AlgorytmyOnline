import RandomGenerators.*;

import java.io.IOException;

import static TestSets.PageAllocationTests.runTests;

public class Testing {
    public static void main(String[] args) {
        IRandomGenerator[] generators = new IRandomGenerator[]{
                new RandomGeneratorUniform(10),
                new RandomGeneratorHarmonic(10),
                new RandomGeneratorDoubleHarmonic(10),
                new RandomGeneratorGeometric(10)
        };
        /*for (IRandomGenerator generator : generators) {
            TestSets.SimpleListTests(generator);
            TestSets.MTFListTests(generator);
            TestSets.TransposeListTests(generator);
            TestSets.CounterListTests(generator);
        }
        try {
            CacheTests.run();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.print(nextFit(new RandomNumberGenerator(new RandomGeneratorHarmonic(10)).generateRandomSequences(100)));
        for (IRandomGenerator generator : generators) {
            int nf=0, rf=0, ff=0, bf=0, wf = 0;
            int opt = 0;
            RandomNumberGenerator g = new RandomNumberGenerator(generator);
            for(int i = 0; i< 10000; i++){
                ArrayList<Double> items = g.generateRandomSequences(100);
                nf += nextFit(items);
                rf += randomFit(items);
                ff += firstFit(items);
                bf += bestFit(items);
                wf += worstFit(items);
                opt += Math.ceil(items.stream().mapToDouble(Double::doubleValue).sum());
            }
            System.out.println();
            System.out.println("Generator " + generator.generatorType());
            System.out.println("Next Fit: " + (nf*1.0)/opt);
            System.out.println("Random Fit: " + (rf*1.0)/opt);
            System.out.println("First Fit: " + (ff*1.0)/opt);
            System.out.println("Best Fit: " + (bf*1.0)/opt);
            System.out.println("Worst Fit: " + (wf*1.0)/opt);
        }
        try {
            runTest(32, 0, 1024, 10000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        try {
            runTests(9999,"PA");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
