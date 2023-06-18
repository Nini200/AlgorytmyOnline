package RandomGenerators;

import java.util.Random;

public class RandomGeneratorGeometric implements IRandomGenerator {
    Random r = new Random();
    int n;
    public RandomGeneratorGeometric(int n){
        this.n = n;
    }
    @Override
    public void setUpperBond(int n) {
        this.n = n;
    }

    @Override
    public int getInteger() {
        int integer = 1;
        for(int i = 0; i< n-1; i++){
            if(r.nextBoolean()){
                return integer;
            }
            integer++;
        }
        return integer;
    }
    @Override
    public String generatorType() {
        return "Geometric Generator";
    }
}
