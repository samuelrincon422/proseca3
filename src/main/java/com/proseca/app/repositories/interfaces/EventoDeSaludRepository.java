package com.proseca.app.repositories.interfaces;

import com.proseca.app.entities.EventoDeSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventoDeSaludRepository extends JpaRepository<EventoDeSalud, Integer> {
    List<EventoDeSalud> findByAnimalId(Integer animalId);
}
