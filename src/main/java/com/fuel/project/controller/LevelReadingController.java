package com.fuel.project.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.fuel.project.entity.LevelReading;
import com.fuel.project.service.LevelReadingService;
 
@RestController
@RequestMapping("/readings")
public class LevelReadingController {
 
    @Autowired
    private LevelReadingService levelReadingService;
 
    @PostMapping
    public LevelReading createReading(@RequestBody LevelReading reading) {
        return levelReadingService.saveReading(reading);
    }
    
    @GetMapping
    public List<LevelReading> getAllReadings() {
        return levelReadingService.getAllLevelReadings();
    }
    
    @GetMapping("/{id}")
    public LevelReading getReadingById(@PathVariable Long id) {
        return levelReadingService.getLevelReadingById(id);
    }
}