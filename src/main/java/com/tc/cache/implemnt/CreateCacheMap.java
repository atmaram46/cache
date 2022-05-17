package com.tc.cache.implemnt;

import com.tc.cache.config.PropConfig;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.map.LRUMap;
import org.springframework.stereotype.Component;

@Component
public class CreateCacheMap {
    // LRUMap: A Map implementation with a fixed maximum size which removes the least recently used entry if an entry is added when full.
    // The least recently used algorithm works on the get and put operations only.
    // Iteration of any kind, including setting the value by iteration, does not change the order.
    // Queries such as containsKey and containsValue or access via views also do not change the order.
    private final LRUMap crunchifyCacheMap;

    protected class CrunchifyCacheObject {

        // currentTimeMillis(): Returns the current time in milliseconds.
        // Note that while the unit of time of the return value is a millisecond,
        // the granularity of the value depends on the underlying operating system and may be larger.
        // For example, many operating systems measure time in units of tens of milliseconds.
        public long lastAccessed = System.currentTimeMillis();
        public String value;

        protected CrunchifyCacheObject(String value) {
            this.value = value;
        }
    }

    public CreateCacheMap() {
        PropConfig propConfig = new PropConfig();
//        System.out.println("Size is:" + propConfig.getCacheSize());
        crunchifyCacheMap = new LRUMap(Integer.parseInt(propConfig.getCacheSize1()));
    }

    public void put(int key, String value) {
        synchronized (crunchifyCacheMap) {
            crunchifyCacheMap.put(key, new CrunchifyCacheObject(value));
        }
    }

    public String get(int key) {
        synchronized (crunchifyCacheMap) {
            CrunchifyCacheObject c;
            c = (CrunchifyCacheObject) crunchifyCacheMap.get(key);
            if (c == null)
                return null;
            else {
                c.lastAccessed = System.currentTimeMillis();
                return c.value;
            }
        }
    }

    public String getAllData() {
        StringBuilder dataInMap = new StringBuilder();
        MapIterator it = crunchifyCacheMap.mapIterator();
        while (it.hasNext()) {
            Object key = it.next();
            CrunchifyCacheObject c = (CrunchifyCacheObject) it.getValue();
            dataInMap.append(key + ", " + c.value);
            dataInMap.append("\n");
        }
       return dataInMap.toString();
    }

    public void remove(int key) {
        synchronized (crunchifyCacheMap) {
            crunchifyCacheMap.remove(key);
        }
    }

    public int size() {
        synchronized (crunchifyCacheMap) {
            return crunchifyCacheMap.size();
        }
    }
}
