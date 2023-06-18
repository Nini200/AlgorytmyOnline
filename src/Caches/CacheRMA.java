package Caches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CacheRMA implements ICache{
    HashMap<Integer, Boolean> cache;
    int cacheSize;
    Random random;

    public CacheRMA(int cacheSize) {
        this.cacheSize = cacheSize;
        cache = new HashMap<>();
        random = new Random();
    }

    @Override
    public int request(int pageId) {
        if(cache.containsKey(pageId)){
            cache.replace(pageId, false, true);
            return 0;
        }
        if (cache.size() == cacheSize) {
            if(!cache.containsValue(false)){
                for (int pId : cache.keySet()) {
                    cache.replace(pId, false);
                }
            }
            ArrayList<Integer> toChoose = new ArrayList<>();
            for (int pId : cache.keySet()) {
                if(!cache.get(pId)){
                    toChoose.add(pId);
                }
            }
            cache.remove(toChoose.get(random.nextInt(toChoose.size())));
        }
        cache.put(pageId, true);
        return 1;

    }

    @Override
    public void setCacheSize(int size) {
        this.cacheSize = size;
    }

    @Override
    public void clear() {
        this.cache.clear();
    }

    @Override
    public String cacheType() {
        return "RMA";
    }
}
