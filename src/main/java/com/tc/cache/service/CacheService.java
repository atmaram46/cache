package com.tc.cache.service;

import com.tc.cache.implemnt.CreateCacheMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CacheService {

    @Autowired
    private CreateCacheMap createCacheMap;

    public void addDataInMap(int key, String value) {
        createCacheMap.put(key, value);
    }

    public String getDataForKey(int key) {
        return createCacheMap.get(key);
    }

    public int getMapSize() {
        return createCacheMap.size();
    }

    public String getAllData() {
        return createCacheMap.getAllData();
    }

}
