package PageAllocation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Count {
    int numOfCopies;
    boolean isWaiting;
    Node[] nodes;
    Request[] requests;
    public double cost;
    public int maxNumOfCopies;
    int D;

    public static Request[] generateRequests(int numOfRequests, double pbbWrite, int numOfNodes){
        Request[] requests = new Request[numOfRequests];
        Random random = new Random();
        for (int i = 0; i < numOfRequests; i++) {
            RequestType type = RequestType.READ;
            if (random.nextDouble() < pbbWrite) {
                type = RequestType.WRITE;
            }
            requests[i] = new Request(random.nextInt(numOfNodes), type);
        }
        return requests;
    }
    public static Node[] generateNodes(int numOfNodes){
        Random random = new Random();
        Node[] nodes = new Node[numOfNodes];
        for (int i = 0; i < numOfNodes; i++) {
            nodes[i] = new Node(0, false);
        }
        nodes[random.nextInt(numOfNodes)].hasCopy = true;
        return nodes;
    }

    public Count(int numOfRequests, double pbbWrite, int numOfNodes, int D){
        numOfCopies = 1;
        maxNumOfCopies = 1;
        cost = 0;
        isWaiting = true;
        this.D = D;
        requests = generateRequests(numOfRequests, pbbWrite, numOfNodes);
        nodes = generateNodes(numOfNodes);
    }

    public void run(){
        for (Request r : requests) {
            Node curr = nodes[r.nodeNumber];
            if(r.requestType==RequestType.READ){
                if(!curr.hasCopy){
                    cost++;
                }
            }
            else {
                if(curr.hasCopy){
                    cost += (numOfCopies - 1);
                }
                else {
                    cost += numOfCopies;
                }

            }
            if((r.requestType==RequestType.READ && curr.cp<D && !curr.hasCopy)||(r.requestType==RequestType.WRITE && isWaiting)){
                curr.cp++;
            }
            if(!curr.hasCopy && curr.cp==D){
                curr.hasCopy=true;
                numOfCopies++;
                if (numOfCopies > 1) {
                    isWaiting = false;
                }
                if(numOfCopies>maxNumOfCopies){
                    maxNumOfCopies = numOfCopies;
                }
            }
            if(r.requestType==RequestType.WRITE){
                for(int i = 0; i<nodes.length; i++){
                    if (i != r.nodeNumber) {
                        if(nodes[i].hasCopy){
                            if(nodes[i].cp>0){
                                nodes[i].cp--;
                            }
                            if (nodes[i].cp==0){
                                if(numOfCopies>1){
                                    nodes[i].hasCopy = false;
                                    numOfCopies--;
                                }
                                else {
                                    isWaiting = true;
                                }
                            }
                        }
                    }
                }
            }

        }
    }

}
