package BinPacking;
import RandomGenerators.IRandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    private IRandomGenerator randomGenerator;

    public RandomNumberGenerator(IRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public ArrayList<Double> generateRandomSequences(int maxElements) {
        Random random = new Random();
        ArrayList<Double> resultList = new ArrayList<>();
        int totalElements = 0;
        randomGenerator.setUpperBond(10);
        while (totalElements < maxElements) {
            double item = random.nextDouble();
            int numItems = randomGenerator.getInteger();
            for (int i = 0; i < numItems; i++) {
                totalElements++;
                resultList.add(item);
                if (totalElements >= maxElements) {
                    return resultList;
                }
            }
        }
        return resultList;
    }

}

