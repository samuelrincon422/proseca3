package com.proseca.app.repositories.interfaces;

import com.proseca.app.entities.Reproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReproduccionRepository extends JpaRepository<Reproduccion, Integer> {
    List<Reproduccion> findByAnimalId(Integer animalId);
}
