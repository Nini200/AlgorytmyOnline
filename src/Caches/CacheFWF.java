package Caches;

import java.util.LinkedList;

public class CacheFWF implements ICache{
    LinkedList<Integer> queue;
    int cacheSize;

    public CacheFWF(int cacheSize) {
        this.cacheSize = cacheSize;
        this.queue = new LinkedList<>();
    }

    @Override
    public int request(int pageId) {
        if(queue.contains(pageId)){
            return 0;
        }
        if(queue.size() == cacheSize){
            queue.clear();
        }
        queue.addFirst(pageId);
        return 1;
    }

    @Override
    public void setCacheSize(int size) {
        this.cacheSize = size;
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public String cacheType() {
        return "FWF";
    }
}
