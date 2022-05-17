package com.tc.cache.controller;

import com.tc.cache.model.CacheData;
import com.tc.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PutMapping("/cache")
    public ResponseEntity<?> updateCache(@RequestBody CacheData value) {
        System.out.println("Inside Put!!");
        cacheService.addDataInMap(value.getId(), (String) value.getData());
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PutMapping("/updateKey")
//    public ResponseEntity<?> updateCacheKey(@RequestParam("key") int key, @RequestParam("value") String value) {
//        cacheService.addDataInMap(key, value);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/cache/{id}")
    public ResponseEntity<?> getCacheKey(@PathVariable int id) {
        String data = cacheService.getDataForKey(id);
        if(data == null) {
            data = "Error, Key Not Found!!!";
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

//    @GetMapping("/getSize")
//    public ResponseEntity<?> getCacheSize() {
//        int data = cacheService.getMapSize();
//        return new ResponseEntity<>(data, HttpStatus.OK);
//    }
//
//    @GetMapping("/allData")
//    public ResponseEntity<?> getAllData() {
//        String data = cacheService.getAllData();
//        return new ResponseEntity<>(data, HttpStatus.OK);
//    }
}
