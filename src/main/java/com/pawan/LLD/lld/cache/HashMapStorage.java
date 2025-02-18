package com.pawan.LLD.lld.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 18/02/25.
 */
public class HashMapStorage<Key, Value> implements IStorage<Key, Value> {

    private final Map<Key, Value> HASH_MAP_STORAGE = new HashMap<>();

    @Override
    public Value get(Key key) {
        return HASH_MAP_STORAGE.get(key);
    }

    @Override
    public void put(Key key, Value value) {
        HASH_MAP_STORAGE.put(key, value);
    }

    @Override
    public int size() {
        return HASH_MAP_STORAGE.size();
    }

    @Override
    public void remove(Key evictKey) {
        HASH_MAP_STORAGE.remove(evictKey);
    }
}
