package com.pawan.LLD.lld.cache;

/**
 * @author Pawan Saini
 * Created on 19/02/25.
 */
public class LFUEvictionPolicy<Key> implements IEvictionPolicy<Key> {

    @Override
    public void accessedKey(Key key) {

    }

    @Override
    public Key evictKey() {
        return null;
    }
}
