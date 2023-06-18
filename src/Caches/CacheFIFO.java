package Caches;

import java.util.LinkedList;

public class CacheFIFO implements ICache{
    LinkedList<Integer> queue;
    int cacheSize;

    public CacheFIFO(int size) {
        cacheSize = size;
        queue = new LinkedList<>();
    }
    @Override
    public int request(int pageId) {
        if(queue.contains(pageId)){
            return 0;
        }
        queue.addFirst(pageId);
        if(queue.size() > cacheSize){
            queue.removeLast();
        }
        return 1;
    }

    @Override
    public void setCacheSize(int size) {
        cacheSize = size;
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public String cacheType() {
        return "FIFO";
    }
}
