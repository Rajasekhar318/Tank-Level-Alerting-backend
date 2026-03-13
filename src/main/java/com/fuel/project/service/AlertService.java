package com.fuel.project.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.fuel.project.entity.Alert;
import com.fuel.project.repository.AlertRepository;
 
@Service
public class AlertService {
 
    @Autowired
    private AlertRepository alertRepository;
 
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }
    
    public Alert getAlertById(Long id) {
    	return alertRepository.findById(id)
    			.orElseThrow(() -> new RuntimeException("Reading not found for id " + id));
    }
}