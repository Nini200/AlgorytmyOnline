package Caches;

public interface ICache {
    int request(int pageId);
    void setCacheSize(int size);
    void clear();
    String cacheType();
}
