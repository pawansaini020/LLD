package com.pawan.LLD.lld.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 19/02/25.
 */
public class CacheManager<Key, Value> {

    private Map<String, Cache<Key, Value>> CACHE_MAP = new HashMap<>();

    public Value get(String cacheName, Key key) {
        if(!CACHE_MAP.containsKey(cacheName)) {
            return null;
        }
        return CACHE_MAP.get(cacheName).get(key);
    }

    public void put(String cacheName, Key key, Value value) {
        if(!CACHE_MAP.containsKey(cacheName)) {
            IEvictionPolicy<Key> storage = EvictFactory.getEvictionPolicy("LRU");
            CACHE_MAP.put(cacheName, new Cache(cacheName, 10, new HashMapStorage(), storage));
        }
        CACHE_MAP.get(cacheName).put(key, value);
    }
}
