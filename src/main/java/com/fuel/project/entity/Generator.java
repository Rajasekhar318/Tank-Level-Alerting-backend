package com.fuel.project.entity;
 
import jakarta.persistence.*;
 
@Entity
@Table(name = "generator_table")
public class Generator {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long generatorId;
 
    private float generatorTotalCapacity;
    private float generatorHighLevelpoint;
    private float generatorLowLevelpoint;
 
    public Long getGeneratorId() {
        return generatorId;
    }
 
    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }
 
    public float getGeneratorTotalCapacity() {
        return generatorTotalCapacity;
    }
 
    public void setGeneratorTotalCapacity(float generatorTotalCapacity) {
        this.generatorTotalCapacity = generatorTotalCapacity;
    }
 
    public float getGeneratorHighLevelpoint() {
        return generatorHighLevelpoint;
    }
 
    public void setGeneratorHighLevelpoint(float generatorHighLevelpoint) {
        this.generatorHighLevelpoint = generatorHighLevelpoint;
    }
 
    public float getGeneratorLowLevelpoint() {
        return generatorLowLevelpoint;
    }
 
    public void setGeneratorLowLevelpoint(float generatorLowLevelpoint) {
        this.generatorLowLevelpoint = generatorLowLevelpoint;
    }
}