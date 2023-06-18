package PageMigration;

import Graphs.IGraph;

public class MoveToMin implements IMigration{
    int D;
    int requestCounter;
    int cost;
    int[] pastRequests;
    int serverLocation;
    IGraph graph;

    public MoveToMin(int D, int serverLocation, IGraph graph){
        this.D = D;
        this.pastRequests = new int[D];
        this.serverLocation = serverLocation;
        this.graph = graph;
        this.cost = 0;
    }
    public void processRequest(int request){
        if (requestCounter < D) {
            pastRequests[requestCounter] = request;
            cost += graph.distance(serverLocation, request);
            requestCounter++;
        }
        else {
            int bestLocation = 0;
            int smallestDistance = Integer.MAX_VALUE;
            for(int i=0; i<64; i++) {
                int distance = 0;
                for (int r : pastRequests) {
                    distance += graph.distance(i, r);
                }
                if (distance < smallestDistance) {
                    smallestDistance = distance;
                    bestLocation = i;
                }
            }
            cost += graph.distance(serverLocation,bestLocation)*D;
            serverLocation = bestLocation;
            requestCounter = 0;
        }
    }

    public int getCost(){
        return this.cost;
    }
}
