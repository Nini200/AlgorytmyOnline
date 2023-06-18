package Caches;

import java.util.LinkedList;
import java.util.Random;

public class CacheRAND implements ICache{
    LinkedList<Integer> queue;
    int cacheSize;
    Random random;

    public CacheRAND(int cacheSize) {
        this.cacheSize = cacheSize;
        this.queue = new LinkedList<>();
        this.random = new Random();
    }

    @Override
    public int request(int pageId) {
        if(queue.contains(pageId)){
            return 0;
        }
        if(queue.size() == cacheSize){
            queue.remove(random.nextInt(cacheSize));
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
        return "RAND";
    }
}
