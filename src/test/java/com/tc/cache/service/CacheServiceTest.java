package com.tc.cache.service;

import com.tc.cache.implemnt.CreateCacheMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CacheServiceTest {

    @InjectMocks
    private CacheService cacheService;

    @Mock
    private CreateCacheMap createCacheMap;

    @Before
    public void setUp() {
        when(createCacheMap.get(anyInt())).thenReturn("Data");
        when(createCacheMap.getAllData()).thenReturn("1,2");
        when(createCacheMap.size()).thenReturn(1);
    }

    @Test
    public void addDataTest() {
        cacheService.addDataInMap(1, "A");
        Mockito.verify(createCacheMap, Mockito.times(1)).put(1, "A");
    }

    @Test
    public void getDataForKeyTest() {
        Assert.assertNotNull(cacheService.getDataForKey(1));
    }

    @Test
    public void getMapSize() {
        Assert.assertNotNull(cacheService.getMapSize());
    }

    @Test
    public void getAllDataTest() {
        Assert.assertNotNull(cacheService.getAllData());
    }
}
