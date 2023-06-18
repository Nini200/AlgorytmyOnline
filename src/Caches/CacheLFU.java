package Caches;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class CacheLFU implements ICache{
    HashMap<Integer,Integer> pageIds;
    ArrayList<Integer> cache;
    int cacheSize;

    public CacheLFU(int cacheSize) {
        this.cacheSize = cacheSize;
        this.pageIds = new HashMap<>();
        this.cache = new ArrayList<>();
    }
    @Override
    public int request(int pageId) {
        if(!pageIds.containsKey(pageId)){
            pageIds.put(pageId, 0);
        }
        pageIds.replace(pageId, pageIds.get(pageId) + 1);
        if (cache.contains(pageId)) {
            return 0;
        }
        if(cache.size() == cacheSize){
            int minUsed = Integer.MAX_VALUE;
            int pageToRemove = 0;
            for (int pId : cache) {
                int currentUsed = pageIds.get(pId);
                if (currentUsed < minUsed) {
                    minUsed = currentUsed;
                    pageToRemove = pId;
                }
            }
            cache.remove(cache.indexOf(pageToRemove));
        }
        cache.add(pageId);

        return 1;

    }

    @Override
    public void setCacheSize(int size) {
        this.cacheSize = size;
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public String cacheType() {
        return "LFU";
    }
}
