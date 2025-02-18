package com.pawan.LLD.lld.cache;

/**
 * @author Pawan Saini
 * Created on 19/02/25.
 */
public class EvictFactory {

    public static <Key> IEvictionPolicy<Key> getEvictionPolicy(String evictionPolicy) {
        switch (evictionPolicy) {
            case "LRU":
                return new LRUEvictionPolicy<Key>();
            case "LFU":
                return new LFUEvictionPolicy<Key>();
            default:
                return new LRUEvictionPolicy<Key>();
        }
    }
}
