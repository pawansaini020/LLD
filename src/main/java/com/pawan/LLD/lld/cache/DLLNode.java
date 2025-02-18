package com.pawan.LLD.lld.cache;

import lombok.Data;

/**
 * @author Pawan Saini
 * Created on 19/02/25.
 */
public class DLLNode<Key> {

        public Key key;
        public DLLNode next;
        public DLLNode prev;

        public DLLNode(Key key) {
            this.key = key;
        }
}
