package com.pawan.LLD.lld.cache;

/**
 * @author Pawan Saini
 * Created on 18/02/25.
 */
public interface IEvictionPolicy<Key> {
    
    void accessedKey(Key key);

    Key evictKey();
}
