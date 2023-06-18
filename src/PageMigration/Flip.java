package PageMigration;

import Graphs.IGraph;

import java.util.Random;

public class Flip implements IMigration{
    int cost;
    int D;
    int serverLocation;
    IGraph graph;
    Random random;

    public Flip(int D, int serverLocation, IGraph graph){
        this.D = D;
        this.serverLocation = serverLocation;
        this.graph = graph;
        this.cost = 0;
        this.random = new Random();
    }
    @Override
    public void processRequest(int request) {
        if(random.nextDouble()<1/(2*D)){
            cost += D * graph.distance(request, serverLocation);
            serverLocation = request;
        }
        else {
            cost += graph.distance(serverLocation,request);
        }
    }

    @Override
    public int getCost() {
        return this.cost;
    }
}
