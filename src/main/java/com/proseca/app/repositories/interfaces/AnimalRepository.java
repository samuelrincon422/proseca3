package com.proseca.app.repositories.interfaces;

import com.proseca.app.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {}
