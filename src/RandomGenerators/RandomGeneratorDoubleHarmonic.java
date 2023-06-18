package RandomGenerators;

import java.util.Random;

public class RandomGeneratorDoubleHarmonic implements IRandomGenerator{
    Random r = new Random();
    int n;
    double[] upperBounds;
    public RandomGeneratorDoubleHarmonic(int n){
        this.n = n;
        upperBounds = new double[n];
        upperBounds[0] = 1.0;
        for(int i = 1; i<n; i++){
            upperBounds[i] = upperBounds[i - 1] + 1.0/((i+1)*(i+1));
        }
    }

    @Override
    public void setUpperBond(int n) {
        this.n = n;
        this.upperBounds = new double[n];
        upperBounds[0] = 1.0;
        for(int i = 1; i<n; i++){
            upperBounds[i] = upperBounds[i - 1] + 1.0/((i+1)*(i+1));
        }
    }

    @Override
    public int getInteger() {
        double randD = r.nextDouble(upperBounds[n-1]);
        if(randD< upperBounds[0]){
            return 1;
        }
        for (int i = 1; i<100; i++){
            if (upperBounds[i - 1] <= randD && randD < upperBounds[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override
    public String generatorType() {
        return "Double Harmonic Generator";
    }
}
