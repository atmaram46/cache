package com.tc.cache.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Properties;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropConfigTest {

    @InjectMocks
    private PropConfig propConfig;

    @Test
    public void getCacheSize1Test() {
        String size = propConfig.getCacheSize1();
        Assert.assertEquals("10", size);
    }

//    @Test
//    public void getCacheSizeTest() {
//        String size = propConfig.getCacheSize();
//        Assert.assertEquals("10", size);
//    }
}
