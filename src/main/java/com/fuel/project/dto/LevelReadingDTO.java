package com.fuel.project.dto;
 
public class LevelReadingDTO {
 
    private Long generatorId;
 
    private float currentFuellevel;
 
    public Long getGeneratorId() {
        return generatorId;
    }
 
    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }
 
    public float getCurrentFuellevel() {
        return currentFuellevel;
    }
 
    public void setCurrentFuellevel(float currentFuellevel) {
        this.currentFuellevel = currentFuellevel;
    }
}