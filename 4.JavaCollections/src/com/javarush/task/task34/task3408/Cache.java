package com.javarush.task.task34.task3408;

import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V value = cache.get(key);
        if (value == null) {
            return null;
        } else {

        }
        return null;
    }

    public boolean put(V obj) {
        //TODO add your code here
        return false;
    }

    public int size() {
        return cache.size();
    }
}
