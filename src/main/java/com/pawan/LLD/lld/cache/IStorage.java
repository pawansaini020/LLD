package com.pawan.LLD.lld.cache;

/**
 * @author Pawan Saini
 * Created on 18/02/25.
 */
public interface IStorage<Key, Value> {
    
    Value get(Key key);

    void put(Key key, Value value);

    int size();

    void remove(Key evictKey);
}
