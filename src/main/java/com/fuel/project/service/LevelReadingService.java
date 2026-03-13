package com.fuel.project.service;
 
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.fuel.project.alertlogic.FuelAlertDetector;
import com.fuel.project.entity.Alert;
import com.fuel.project.entity.Generator;
import com.fuel.project.entity.LevelReading;
import com.fuel.project.repository.AlertRepository;
import com.fuel.project.repository.GeneratorRepository;
import com.fuel.project.repository.LevelReadingRepository;
 
@Service
public class LevelReadingService {
 
    @Autowired
    private LevelReadingRepository levelReadingRepository;
 
    @Autowired
    private GeneratorRepository generatorRepository;
 
    @Autowired
    private AlertRepository alertRepository;
 
    @Autowired
    private FuelAlertDetector fuelAlertDetector;
 
    public LevelReading saveReading(LevelReading reading) {
    	 
        reading.setCurrentTimestamp(LocalDateTime.now());
     
        // get previous reading
        Optional<LevelReading> previousReading =
                levelReadingRepository.findTopByGeneratorIdOrderByCurrentTimestampDesc(reading.getGeneratorId());
     
        LevelReading savedReading = levelReadingRepository.save(reading);
     
        Generator generator = generatorRepository
                .findById(reading.getGeneratorId())
                .orElseThrow();
     
        float currentLevel = reading.getCurrentFuellevel();
     
        String alertType = fuelAlertDetector.detectAlert(
                currentLevel,
                generator.getGeneratorHighLevelpoint(),
                generator.getGeneratorLowLevelpoint());
     
        // LOW / HIGH alert
        if (!alertType.equals("NORMAL")) {
     
            Alert alert = new Alert();
            alert.setGeneratorId(generator.getGeneratorId());
            alert.setLevelreadingId(savedReading.getLevelreadingId());
            alert.setAlertType(alertType);
     
            alertRepository.save(alert);
        }
     
        // SUDDEN DROP LOGIC
        if (previousReading.isPresent()) {
     
            float previousLevel = previousReading.get().getCurrentFuellevel();
     
            float drop = previousLevel - currentLevel;
     
            if (drop >= 100) {   // threshold
     
                Alert alert = new Alert();
                alert.setGeneratorId(generator.getGeneratorId());
                alert.setLevelreadingId(savedReading.getLevelreadingId());
                alert.setAlertType("SUDDEN_DROP_ALERT");
     
                alertRepository.save(alert);
            }
        }
     
        return savedReading;
    }
    
    public List<LevelReading> getAllLevelReadings() {
        return levelReadingRepository.findAll();
    }
    
    public LevelReading getLevelReadingById(Long id) {
        return levelReadingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reading not found for id " + id));
    }
}