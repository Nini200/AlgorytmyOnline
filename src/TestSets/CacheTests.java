package TestSets;

import Caches.*;
import RandomGenerators.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CacheTests {
    static int repetitions = 100;
    static ICache [] caches = {new CacheFIFO(0),
                                new CacheFWF(0),
                                new CacheLFU(0),
                                new CacheLRU(0),
                                new CacheRAND(0),
                                new CacheRMA(0)};
    static IRandomGenerator[] generators = new IRandomGenerator[]{
            new RandomGeneratorUniform(1),
            new RandomGeneratorHarmonic(1),
            new RandomGeneratorDoubleHarmonic(1),
            new RandomGeneratorGeometric(1)
    };
    static int[] ns = {20, 30, 40, 50, 60, 70, 80, 90, 100};

    public static void run() throws IOException {
        for (ICache cache : caches) {
            for(IRandomGenerator randomGenerator : generators){
                String fileName = randomGenerator.generatorType() + "_" + cache.cacheType() + ".csv";
                FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter bw = new BufferedWriter(fw);
                System.out.println("Staring " + fileName);
                for (int n : ns) {
                    double avg;
                    for(int k = n/10; k< n/5; k++){
                        avg = runSingleTest(cache, randomGenerator, n, k, repetitions);
                        bw.write( avg + ",");
                    }
                    avg = runSingleTest(cache, randomGenerator, n, n/5, repetitions);
                    bw.write(Double.toString(avg));
                    bw.newLine();
                    System.out.println("Done: n=" + n);
                }
                bw.close();
            }
        }
    }

    private static double runSingleTest(ICache cache, IRandomGenerator randomGenerator, int n, int k, int repetitions) {
        cache.setCacheSize(k);
        randomGenerator.setUpperBond(n);
        int sum = 0;
        for (int i = 0; i < repetitions; i++) {
            cache.clear();
            for (int j = 0; j < n; j++) {
                sum += cache.request(randomGenerator.getInteger());
            }
        }
        return (1.0*sum/n)/repetitions;
    }
}
