package Caches;

import java.util.LinkedList;

public class CacheLRU implements ICache {
    LinkedList<Integer> queue;
    int cacheSize;

    public CacheLRU(int cacheSize){
        this.cacheSize = cacheSize;
        this.queue = new LinkedList<>();
    }
    @Override
    public int request(int pageId) {
        if (queue.contains(pageId)) {
            queue.remove(queue.indexOf(pageId));
            queue.addFirst(pageId);
            return 0;
        }
        queue.addFirst(pageId);
        if (queue.size() > cacheSize) {
            queue.removeLast();
        }
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
        return "LRU";
    }
}
