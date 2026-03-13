package com.fuel.project.dto;
 
public class AlertDTO {
 
    private Long alertId;
 
    private Long generatorId;
 
    private Long levelreadingId;
 
    private String alertType;
 
    public Long getAlertId() {
        return alertId;
    }
 
    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }
 
    public Long getGeneratorId() {
        return generatorId;
    }
 
    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }
 
    public Long getLevelreadingId() {
        return levelreadingId;
    }
 
    public void setLevelreadingId(Long levelreadingId) {
        this.levelreadingId = levelreadingId;
    }
 
    public String getAlertType() {
        return alertType;
    }
 
    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }
}