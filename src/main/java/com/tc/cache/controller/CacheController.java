package com.tc.cache.controller;

import com.tc.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PutMapping("/add")
    public ResponseEntity<?> updateCache(@RequestParam("key") int key, @RequestParam("value") String value) {
        cacheService.addDataInMap(key, value);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateKey")
    public ResponseEntity<?> updateCacheKey(@RequestParam("key") int key, @RequestParam("value") String value) {
        cacheService.addDataInMap(key, value);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getKey")
    public ResponseEntity<?> getCacheKey(@RequestParam("key") int key) {
        String data = cacheService.getDataForKey(key);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/getSize")
    public ResponseEntity<?> getCacheSize() {
        int data = cacheService.getMapSize();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/allData")
    public ResponseEntity<?> getAllData() {
        String data = cacheService.getAllData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
