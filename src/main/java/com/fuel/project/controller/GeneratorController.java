package com.fuel.project.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import com.fuel.project.entity.Generator;
import com.fuel.project.service.GeneratorService;

@RestController
@RequestMapping("/generators")
public class GeneratorController {
 
    @Autowired
    private GeneratorService generatorService;
 
    @PostMapping
    public Generator createGenerator(@RequestBody Generator generator) {
        return generatorService.saveGenerator(generator);
    }
 
    @GetMapping
    public List<Generator> getGenerators() {
        return generatorService.getAllGenerators();
    }
    
    @GetMapping("/{id}")
    public Generator getReadingById(@PathVariable Long id) {
        return generatorService.getGeneratorById(id);
    }
}