package com.pawan.LLD.lld.cache;

/**
 * @author Pawan Saini
 * Created on 18/02/25.
 */
public class Cache <Key, Value> {

    private String cacheName;
    private int capacity;
    private IStorage<Key, Value> storage;
    private IEvictionPolicy<Key> evictionPolicy;

    public Cache(String cacheName, int capacity, IStorage<Key, Value> storage, IEvictionPolicy<Key> evictionPolicy) {
        this.cacheName = cacheName;
        this.capacity = capacity;
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public Value get(Key key) {
        evictionPolicy.accessedKey(key);
        return storage.get(key);
    }

    public void put(Key key, Value value) {
        if(storage.size() == capacity) {
            Key evictKey = evictionPolicy.evictKey();
            storage.remove(evictKey);
        }
        storage.put(key, value);
        evictionPolicy.accessedKey(key);
    }
}
