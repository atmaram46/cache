package com.tc.cache.implment;

import com.tc.cache.implemnt.CreateCacheMap;
import org.junit.Before;
import org.mockito.InjectMocks;

public class CreateCacheMapTest {

    @InjectMocks
    private CreateCacheMap createCacheMap;

    @Before
    public void setUp() {
        this.createCacheMap = new CreateCacheMap();
    }

//    @Test
//    public void putTest() {
//        createCacheMap.put(1, "A");
//
//        Mockito.verify(createCacheMap, Mockito.times(1)).put(1, "A");
//    }
//
//    @Test
//    public void getTest() {
//        createCacheMap.get(1);
//        Mockito.verify(createCacheMap, Mockito.times(1)).get(1);
//    }
}
