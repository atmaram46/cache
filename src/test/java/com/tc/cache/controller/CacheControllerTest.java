package com.tc.cache.controller;

import com.tc.cache.service.CacheService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CacheControllerTest {

    @InjectMocks
    private CacheController cacheController;

    @Mock
    private CacheService cacheService;

    @Before
    public void setUp() {
        when(cacheService.getAllData()).thenReturn("1,A");
        when(cacheService.getDataForKey(anyInt())).thenReturn("A");
        when(cacheService.getMapSize()).thenReturn(3);
    }

    @Test
    public void getAllDataTest() {
        ResponseEntity<?> result = cacheController.getAllData();
        Assert.assertEquals("1,A", result.getBody());
    }

    @Test
    public void getCacheSizeTest() {
        ResponseEntity<?> result = cacheController.getCacheSize();
        Assert.assertEquals(3, result.getBody());
    }

    @Test
    public void getCacheKeyTest() {
        ResponseEntity<?> result = cacheController.getCacheKey(1);
        Assert.assertEquals("A", result.getBody());
    }

    @Test
    public void updateCacheKeyTest() {
        ResponseEntity<?> result = cacheController.updateCache(1, "A");
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void updateCacheTest() {
        ResponseEntity<?> result = cacheController.updateCache(1, "A");
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
