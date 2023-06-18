package PageAllocation;

public class Request {
    int nodeNumber;
    RequestType requestType;

    public Request(int nodeNumber, RequestType requestType) {
        this.nodeNumber = nodeNumber;
        this.requestType = requestType;
    }
}
