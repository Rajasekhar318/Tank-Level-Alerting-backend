package com.fuel.project.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.fuel.project.entity.Generator;
 
public interface GeneratorRepository extends JpaRepository<Generator, Long> {
}