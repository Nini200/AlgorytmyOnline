package BinPacking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinPacking {
    public static int nextFit(List<Double> items) {
        int binNumber = 0;
        double binState = 0;
        for (Double item : items) {
            if (binState + item <= 1) { // Check if the item can be added to the current bin
                    binState += item; // Add the item to the current bin
            }
            else{
                binState = item;
                binNumber ++;
            }
        }
        return binNumber;
    }
    public static int firstFit(List<Double> items) {
        List<List<Double>> bins = new ArrayList<List<Double>>();
        for (Double item : items) {
            boolean fitted = false;
            for (List<Double> bin : bins) {
                if (bin.stream().mapToDouble(Double::doubleValue).sum() + item <= 1) {
                    bin.add(item);
                    fitted = true;
                    break;
                }
            }
            if (!fitted) {
                List<Double> newBin = new ArrayList<Double>();
                newBin.add(item);
                bins.add(newBin);
            }
        }
        return bins.size();
    }
    public static int randomFit(List<Double> items) {
        List<List<Double>> bins = new ArrayList<List<Double>>();
        Random random = new Random();
        for (Double item : items) {
            boolean fitted = false;
            List<Integer> fittingBins = new ArrayList<Integer>();
            for (int i = 0; i < bins.size(); i++) {
                List<Double> bin = bins.get(i);
                double capacity = 1 - bin.stream().mapToDouble(Double::doubleValue).sum();
                if (item <= capacity) {
                    fittingBins.add(i);
                }
            }
            if (!fittingBins.isEmpty()) {
                int randomBinIndex = fittingBins.get(random.nextInt(fittingBins.size()));
                bins.get(randomBinIndex).add(item);
                fitted = true;
            }
            if (!fitted) {
                List<Double> newBin = new ArrayList<Double>();
                newBin.add(item);
                bins.add(newBin);
            }
        }
        return bins.size();
    }
    public static int bestFit(List<Double> items) {
        List<List<Double>> bins = new ArrayList<List<Double>>();
        for (Double item : items) {
            boolean fitted = false;
            int bestBinIndex = -1;
            double remainingCapacity = Double.MAX_VALUE;
            for (int i = 0; i < bins.size(); i++) {
                List<Double> bin = bins.get(i);
                double capacity = 1 - bin.stream().mapToDouble(Double::doubleValue).sum();
                if (item <= capacity && capacity < remainingCapacity) {
                    bestBinIndex = i;
                    remainingCapacity = capacity;
                }
            }
            if (bestBinIndex != -1) {
                bins.get(bestBinIndex).add(item);
                fitted = true;
            }
            if (!fitted) {
                List<Double> newBin = new ArrayList<Double>();
                newBin.add(item);
                bins.add(newBin);
            }
        }
        return bins.size();
    }
    public static int worstFit(List<Double> items) {
        List<List<Double>> bins = new ArrayList<List<Double>>();
        for (Double item : items) {
            boolean fitted = false;
            int worstBinIndex = -1;
            double remainingCapacity = -1.0;
            for (int i = 0; i < bins.size(); i++) {
                List<Double> bin = bins.get(i);
                double capacity = 1 - bin.stream().mapToDouble(Double::doubleValue).sum();
                if (item <= capacity && capacity > remainingCapacity) {
                    worstBinIndex = i;
                    remainingCapacity = capacity;
                }
            }
            if (worstBinIndex != -1) {
                bins.get(worstBinIndex).add(item);
                fitted = true;
            }
            if (!fitted) {
                List<Double> newBin = new ArrayList<Double>();
                newBin.add(item);
                bins.add(newBin);
            }
        }
        return bins.size();
    }
}
