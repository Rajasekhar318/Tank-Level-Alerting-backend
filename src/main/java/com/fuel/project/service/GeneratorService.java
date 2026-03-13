package com.fuel.project.service;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.fuel.project.entity.Generator;
import com.fuel.project.repository.GeneratorRepository;

@Service
public class GeneratorService {
 
    @Autowired
    private GeneratorRepository generatorRepository;
 
    public Generator saveGenerator(Generator generator) {
        return generatorRepository.save(generator);
    }
 
    public List<Generator> getAllGenerators() {
        return generatorRepository.findAll();
    }
    
    public Generator getGeneratorById(Long id) {
        return generatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reading not found for id " + id));
    }
}