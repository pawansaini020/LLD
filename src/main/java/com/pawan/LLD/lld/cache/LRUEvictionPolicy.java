package com.pawan.LLD.lld.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 19/02/25.
 */
public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key> {

    private Map<Key, DLLNode<Key>> DLL_NODE_MAP = new HashMap<>();
    private DLLNode<Key> head;
    private DLLNode<Key> tail;

    public LRUEvictionPolicy() {
        head = new DLLNode<>(null);
        tail = new DLLNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void accessedKey(Key key) {
        if (DLL_NODE_MAP.containsKey(key)) {
            DLLNode<Key> node = DLL_NODE_MAP.get(key);
            removeNode(node);
            addOnNode(node);
        } else {
            DLLNode<Key> node = new DLLNode<>(key);
            DLL_NODE_MAP.put(key, node);
            addOnNode(node);
        }
    }

    @Override
    public Key evictKey() {
        DLLNode<Key> evictNode = tail.prev;
        removeNode(evictNode);
        DLL_NODE_MAP.remove(evictNode.key);
        return evictNode.key;
    }

    private void addOnNode(DLLNode<Key> node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DLLNode<Key> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}
