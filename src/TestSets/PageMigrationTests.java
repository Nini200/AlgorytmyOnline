package TestSets;

import Graphs.Hypercube;
import Graphs.IGraph;
import Graphs.Torus;
import PageMigration.Flip;
import PageMigration.IMigration;
import PageMigration.MoveToMin;
import RandomGenerators.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PageMigrationTests {
    public static void runTest(int D, int serverLocation, int requestNumber, int iterations) throws IOException {
        IGraph[] graphs = new IGraph[]{new Hypercube(), new Torus()};
        IRandomGenerator [] randomGenerators =new IRandomGenerator[]{
                new RandomGeneratorUniform(64),
                new RandomGeneratorHarmonic(64),
                new RandomGeneratorDoubleHarmonic(64),
                new RandomGeneratorGeometric(64)
        };

        for (IGraph graph : graphs) {
            System.out.println(graph.getName());
            String fileName = graph.getName() + ".csv";
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (IRandomGenerator randomGenerator : randomGenerators) {
                System.out.println("\t" + randomGenerator.generatorType());
                int mtmSum = 0;
                int flipSum = 0;
                for( int j = 0; j<iterations; j++) {
                    IMigration moveToMin = new MoveToMin(D, serverLocation, graph);
                    IMigration flip = new Flip(D, serverLocation, graph);
                    for (int i = 0; i < requestNumber; i++) {
                        int request = randomGenerator.getInteger() - 1;// Because generators starts from 1
                        moveToMin.processRequest(request);
                        flip.processRequest(request);
                    }
                    mtmSum += moveToMin.getCost();
                    flipSum += flip.getCost();
                }
                System.out.println("\t\t"+(int)(mtmSum/iterations));
                System.out.println("\t\t"+(int)(flipSum/iterations));
                bw.write((int)(mtmSum/iterations)+ "," + (int)(flipSum/iterations));
                bw.newLine();

            }
            bw.close();
        }

    }
}
