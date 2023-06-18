package TestSets;

import PageAllocation.Count;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PageAllocationTests {
    static int[] dValues = new int[]{16, 32, 64, 128, 256};
    static double[] pValues = new double[]{0.01, 0.02, 0.05, 0.1, 0.2, 0.5};
    public static void runTests(int iterationNum, String file) throws IOException {
        String costFileName = file + "Cost.csv";
        FileWriter costFW = new FileWriter(costFileName, true);
        BufferedWriter costBW = new BufferedWriter(costFW);
        String copiesFileName = file + "Copies.csv";
        FileWriter copiesFW = new FileWriter(copiesFileName, true);
        BufferedWriter copiesBW = new BufferedWriter(copiesFW);
        costBW.write(",0.01, 0.02, 0.05, 0.1, 0.2, 0.5");
        for (int D : dValues) {
            costBW.newLine();
            costBW.write(String.valueOf(D));
            copiesBW.newLine();
            copiesBW.write(String.valueOf(D));
            for (double pbb : pValues) {
                double cost = 0;
                int maxNumOfCopies = 0;
                for(int i = 0; i<iterationNum; i++){
                    Count count = new Count(65536,pbb,64, D);
                    count.run();
                    cost += count.cost;
                    maxNumOfCopies += count.maxNumOfCopies;
                }
                costBW.write(","+(cost/iterationNum));
                copiesBW.write(","+(maxNumOfCopies/iterationNum));
            }
        }
        costBW.close();
        copiesBW.close();
    }
}
