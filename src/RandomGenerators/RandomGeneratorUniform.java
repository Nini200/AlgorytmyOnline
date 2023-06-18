package RandomGenerators;

import java.util.Random;

public class RandomGeneratorUniform implements IRandomGenerator {
    Random r = new Random();
    int minValue = 1;
    int maxValue;

    public RandomGeneratorUniform(int maxValue){
        this.maxValue = maxValue;
    }
    @Override
    public void setUpperBond(int n) {
        maxValue = n;
    }

    @Override
    public int getInteger() {
        return r.nextInt(minValue, maxValue+1);
    }
    @Override
    public String generatorType() {
        return "Uniform Generator";
    }
}
